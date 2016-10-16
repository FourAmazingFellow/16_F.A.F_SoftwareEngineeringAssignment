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
    public int discount;
    public int minRoomNum;
    public String enterpriseName;
    public String securityCode;
    public Date startTime;
    public Date endTime;
    public String tradeArea;
    public int vipRank;
    
}
