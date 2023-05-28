package obj;

/**
 * 要素
 */
public class Element {
    private Object value;
    private String name;
    private OperatorType operatorType;
    private BridgeType bridgeType;

    public Element() {
    }

    public Element( String name, OperatorType operatorType,Object value) {
        this.value = value;
        this.name = name;
        this.operatorType = operatorType;
    }

    public Element(String name, OperatorType operatorType, Object value, BridgeType bridgeType) {
        this.value = value;
        this.name = name;
        this.operatorType = operatorType;
        this.bridgeType = bridgeType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public BridgeType getBridgeType() {
        return bridgeType;
    }

    public void setBridgeType(BridgeType bridgeType) {
        this.bridgeType = bridgeType;
    }
}
