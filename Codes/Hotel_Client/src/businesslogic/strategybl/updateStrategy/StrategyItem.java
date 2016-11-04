package businesslogic.strategybl.updateStrategy;

import java.sql.Date;

import po.StrategyPO;
import po.StrategyType;
import vo.StrategyVO;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public class StrategyItem {
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

    /**
     * 构造函数
     * @param strategyPO PO类，包含策略信息
     */
    public StrategyItem(StrategyPO strategyPO) {
        this.address = strategyPO.getAddress();
        this.strategyName = strategyPO.getStrategyName();
        this.discount = strategyPO.getDiscount();
        this.strategyType = strategyPO.getStrategyType();
        if (strategyType.equals(StrategyType.MultiRoomPromotion)) {
            this.minRoomNum = strategyPO.getMinRoomNum();
        } else if (strategyType.equals(StrategyType.CooperationEnterprisePromotion)) {
            this.enterpriseName = strategyPO.getEnterpriseName();
            this.securityCode = strategyPO.getSecurityCode();
        } else if (strategyType.equals(StrategyType.SpecificTimePromotion)
                || strategyType.equals(StrategyType.SpecificTimeMarket)) {
            this.startTime=strategyPO.getStartTime();
            this.endTime=strategyPO.getEndTime();
        }else if(strategyType.equals(StrategyType.VipTradeAreaMarket)){
            this.vipRank=strategyPO.getVipRank();
            this.tradeArea=strategyPO.getTradeArea();
        }else if(strategyType.equals(StrategyType.MemberRankMarket)){
            this.vipRank=strategyPO.getVipRank();
        }
    }
    
    /**
     * 构造函数
     * @param strategyVO VO类，包含策略信息
     */
    public StrategyItem(StrategyVO strategyVO) {
        this.address = strategyVO.address;
        this.strategyName = strategyVO.strategyName;
        this.discount = strategyVO.discount;
        this.strategyType = strategyVO.strategyType;
        if (strategyType.equals(StrategyType.MultiRoomPromotion)) {
            this.minRoomNum = strategyVO.minRoomNum;
        } else if (strategyType.equals(StrategyType.CooperationEnterprisePromotion)) {
            this.enterpriseName = strategyVO.enterpriseName;
            this.securityCode = strategyVO.securityCode;
        } else if (strategyType.equals(StrategyType.SpecificTimePromotion)
                || strategyType.equals(StrategyType.SpecificTimeMarket)) {
            this.startTime=strategyVO.startTime;
            this.endTime=strategyVO.endTime;
        }else if(strategyType.equals(StrategyType.VipTradeAreaMarket)){
            this.vipRank=strategyVO.vipRank;
            this.tradeArea=strategyVO.tradeArea;
        }else if(strategyType.equals(StrategyType.MemberRankMarket)){
            this.vipRank=strategyVO.vipRank;
        }
    }
    
    /**
     * 增加一个策略
     * @param address string型，酒店地址
     * @return 返回是否增加成功
     * @see
     */
    boolean add(String address){
        return false;
        
    }
    
    /**
     * 修改一个策略
     * @param address string型，酒店地址
     * @return 返回是否修改成功
     * @see
     */
    boolean modify(String address){
        return false;
        
    }
    
    /**
     * 删除一个策略
     * @param address string型，酒店地址
     * @return 返回是否删除成功
     * @see
     */
    boolean delete(String address){
        return false;
        
    }
    
    /**
     * 判断该策略信息是否有效
     * @return 返回该策略信息是否有效
     * @see
     */
    boolean valid(){
        return false;
        
    }
}
