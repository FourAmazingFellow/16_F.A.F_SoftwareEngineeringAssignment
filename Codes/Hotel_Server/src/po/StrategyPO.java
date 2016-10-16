package po;

import java.sql.Date;

/**
 * 酒店促销策略和网站营销策略信息PO，负责持久化数据传输
 * @author 双
 * @version 
 * @see
 */
public class StrategyPO {
    
    private String address;
    private Enum<StrategyType> strategyType;
    private String strategyName;
    private int discount;
    private int minRoomNum;
    private String enterpriseName;
    private String securityCode;
    private Date startTime;
    private Date endTime;
    private String tradeArea;
    private int vipRank;
    
    public StrategyPO(String address, Enum<StrategyType> strategyType){
        this.address=address;
        if(strategyType.equals(StrategyType.BirthdayPromotion))
            this.strategyType=strategyType;
    }
    
    public StrategyPO(String address, Enum<StrategyType> strategyType, int inputInt){
        this.address=address;
        this.strategyType=strategyType;
        if(strategyType.equals(StrategyType.MultiRoomPromotion)){
            this.minRoomNum=inputInt;
        }
        if(strategyType.equals(StrategyType.MemberRankMarket)){
            this.vipRank=inputInt;
        }
    }
    
    public StrategyPO(String address, Enum<StrategyType> strategyType, String enterpriseName, String securityCode){
        this.address=address;
        this.strategyType=strategyType;
        this.enterpriseName=enterpriseName;
        this.securityCode=securityCode;
    }
    
    public StrategyPO(String address, Enum<StrategyType> strategyType, Date startTime, Date endTime){
        this.address=address;
        this.strategyType=strategyType;
        this.startTime=startTime;
        this.endTime=endTime;
    }
    
    public StrategyPO(String address, Enum<StrategyType> strategyType, int vipRank, String tradeArea){
        this.address=address;
        this.strategyType=strategyType;
        this.vipRank=vipRank;
        this.tradeArea=tradeArea;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Enum<StrategyType> getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(Enum<StrategyType> strategyType) {
        this.strategyType = strategyType;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getMinRoomNum() {
        return minRoomNum;
    }

    public void setMinRoomNum(int minRoomNum) {
        this.minRoomNum = minRoomNum;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTradeArea() {
        return tradeArea;
    }

    public void setTradeArea(String tradeArea) {
        this.tradeArea = tradeArea;
    }

    public int getVipRank() {
        return vipRank;
    }

    public void setVipRank(int vipRank) {
        this.vipRank = vipRank;
    }
    
     
}

