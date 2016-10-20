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
    private String hotelName;
	private Enum<StrategyType> strategyType;
    private String strategyName;
    private float discount;
    private int minRoomNum;
    private String enterpriseName;
    private String securityCode;
    private Date startTime;
    private Date endTime;
    private String tradeArea;
    private int vipRank;
    
    public StrategyPO(String address, Enum<StrategyType> strategyType, String strategyName, float discount){
        this.address=address;
        this.strategyName=strategyName;
        this.discount=discount;
        if(strategyType.equals(StrategyType.BirthdayPromotion))
            this.strategyType=strategyType;
    }
    
    public StrategyPO(String address, Enum<StrategyType> strategyType, String strategyName, float discount, int inputInt){
        this.address=address;
        this.strategyType=strategyType;
        this.strategyName=strategyName;
        this.discount=discount;
        if(strategyType.equals(StrategyType.MultiRoomPromotion)){
            this.minRoomNum=inputInt;
        }
        if(strategyType.equals(StrategyType.MemberRankMarket)){
            this.vipRank=inputInt;
        }
    }
    
    public StrategyPO(String hotelName, Enum<StrategyType> strategyType, String strategyName, float discount, String enterpriseName, String securityCode){
        this.hotelName=hotelName;
        this.strategyType=strategyType;
        this.strategyName = strategyName;
        this.discount = discount;
        this.enterpriseName=enterpriseName;
        this.securityCode=securityCode;
    }
    
    public StrategyPO(String address, Enum<StrategyType> strategyType, String strategyName, float discount, Date startTime, Date endTime){
        this.address=address;
        this.strategyType=strategyType;
        this.strategyName = strategyName;
        this.startTime=startTime;
        this.endTime=endTime;
        this.discount = discount;
    }
    
    public StrategyPO(String address, Enum<StrategyType> strategyType, String strategyName, float discount, int vipRank, String tradeArea){
        this.address=address;
        this.strategyType=strategyType;
        this.strategyName = strategyName;
        this.vipRank=vipRank;
        this.tradeArea=tradeArea;
        this.discount = discount;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
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
    
    public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
    
     
}
