package businesslogic.strategybl;

import vo.OrderVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public interface StrategyInfoService {

    /**
     * 
     * @param order
     * @return
     * @see
     */
    public String getAvailblePromotionName(OrderVO order);
    
    /**
     * 
     * @param order
     * @return
     * @see
     */
    public String getAvailbleMarketStrategyName (OrderVO order);
    
    /**
     * 
     * @param order
     * @return
     * @see
     */
    public int getBestDiscount(OrderVO order);
}
