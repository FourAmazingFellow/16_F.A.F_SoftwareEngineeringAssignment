package vo;

import java.sql.Date;

import po.StrategyType;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class StrategyVO {
    
    public String address;
    public Enum<StrategyType> strategyType;
    public String strategyName;
    public float discount;
    public int minRoomNum;
    public String enterpriseName;
    public String securityCode;
    public Date startTime;
    public Date endTime;
    public String tradeArea;
    public int vipRank;
    
    public StrategyVO(String address, Enum<StrategyType> strategyType, String strategyName, float discount){
        this.address=address;
        this.strategyName=strategyName;
        this.discount=discount;
        if(strategyType.equals(StrategyType.BirthdayPromotion))
            this.strategyType=strategyType;
    }
    
    public StrategyVO(String address, Enum<StrategyType> strategyType, String strategyName, float discount, int inputInt){
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
    
    public StrategyVO(String address, Enum<StrategyType> strategyType, String strategyName, float discount, String enterpriseName, String securityCode){
        this.address=address;
        this.strategyType=strategyType;
        
        this.enterpriseName=enterpriseName;
        this.securityCode=securityCode;
    }
    
    public StrategyVO(String address, Enum<StrategyType> strategyType, String strategyName, float discount, Date startTime, Date endTime){
        this.address=address;
        this.strategyType=strategyType;
        this.startTime=startTime;
        this.endTime=endTime;
    }
    
    public StrategyVO(String address, Enum<StrategyType> strategyType, String strategyName, float discount, int vipRank, String tradeArea){
        this.address=address;
        this.strategyType=strategyType;
        this.vipRank=vipRank;
        this.tradeArea=tradeArea;
    }
    
}
