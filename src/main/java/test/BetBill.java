package test;

import java.math.BigDecimal;

public class BetBill {
    private long id;
    private String platform;
    private String platformId;
    private String gameType;
    private String gameCode;
    private String tableCode;
    private String loginName;
    private String productId;
    private BigDecimal validBetAmount;
    private BigDecimal profitRate;
    private BigDecimal profitAmount;
    private Integer winBetCount;
    private Integer totalBetCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public BigDecimal getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(BigDecimal validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(BigDecimal profitRate) {
        this.profitRate = profitRate;
    }

    public BigDecimal getProfitAmount() {
        return profitAmount;
    }

    public void setProfitAmount(BigDecimal profitAmount) {
        this.profitAmount = profitAmount;
    }

    public Integer getWinBetCount() {
        return winBetCount;
    }

    public void setWinBetCount(Integer winBetCount) {
        this.winBetCount = winBetCount;
    }

    public Integer getTotalBetCount() {
        return totalBetCount;
    }

    public void setTotalBetCount(Integer totalBetCount) {
        this.totalBetCount = totalBetCount;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
