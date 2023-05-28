package obj;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 錨點
 */
public class AnchorPoint<R> {
    private long id;
    private String desc;
    private final List<Element> refAnchorPoints = new CopyOnWriteArrayList<Element>();
    private final List<List<Element>> divideElePoints = new CopyOnWriteArrayList<List<Element>>();
    private R related;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Element> getRefAnchorPoints() {
        return refAnchorPoints;
    }

    public void addRefAnchorPoints(Element refAnchorPoint) {
        this.refAnchorPoints.add(refAnchorPoint);
    }

    public R getRelated() {
        return related;
    }

    public void setRelated(R related) {
        this.related = related;
    }

    public boolean doCheck() {
        if (divideElePoints.isEmpty()) {
            initAnchorPoint();
        }

        for (List<Element> innerList : divideElePoints) {
            for (Element innerE : innerList) {
                Method method = null;
                try {
                    method = related.getClass().getMethod("get" + upperCaseFirst(innerE.getName()));
                } catch (NoSuchMethodException noSuchMethodException) {
                    noSuchMethodException.printStackTrace();
                }
                Object invoke = null;
                try {
                    assert method != null;
                    invoke = method.invoke(related);
                } catch (IllegalAccessException | InvocationTargetException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
                if (invoke != null) {
                    if (invoke instanceof String) {
                        if (!innerE.getValue().equals(invoke)) {
                            return false;
                        }
                    }
                    if (invoke instanceof BigDecimal) {
                        switch (innerE.getOperatorType()) {
                            case EQUAL:
                                if (Double.parseDouble(innerE.getValue().toString()) == ((BigDecimal) invoke).doubleValue()) {
                                    return false;
                                }
                                break;
                            case GREATER_THAN:
                                if (Double.parseDouble(innerE.getValue().toString()) > ((BigDecimal) invoke).doubleValue()) {
                                    return false;
                                }
                                break;
                            case LESS_THAN:
                                if (Double.parseDouble(innerE.getValue().toString()) < ((BigDecimal) invoke).doubleValue()) {
                                    return false;
                                }
                        }
                    }
                }
            }
        }

        return true;
    }

    private void initAnchorPoint() {
        List<Element> blockConditionList = new CopyOnWriteArrayList<>();
        for (Element e : refAnchorPoints) {
            if (e.getBridgeType() == null || !e.getBridgeType().equals(BridgeType.OR)) {
                blockConditionList.add(e);
            } else {
                divideElePoints.add(blockConditionList);
                blockConditionList = new CopyOnWriteArrayList<>();
            }
        }

        if (blockConditionList.size() > 0)
            divideElePoints.add(blockConditionList);
    }

    private String upperCaseFirst(String val) {
        char[] arr = val.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }
}
