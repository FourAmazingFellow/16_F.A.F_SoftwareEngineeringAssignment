package businesslogic.strategybl;

import businesslogic.strategybl.exception.WrongInputException;
import vo.OrderVO;

/**给同层其他模块调用的Strategybl接口
 * 
 * @author 双
 * @version 
 * @see
 */
public interface StrategyInfoService {

    /**
     * 获取某订单能享受的唯一酒店促销策略折扣名称
     * @param order OrderVO型，同层调用传来的订单信息
     * @return String型，返回酒店促销策略名称，若没有，则返回null
     * @see
     */
    public String getAvailblePromotionName(OrderVO order);
    
    /**
     * 获取某订单能享受的唯一网站营销策略折扣名称
     * @param order OrderVO型，同层调用传来的订单信息
     * @return String型，返回网站营销策略名称，若没有，则返回null
     * @see
     */
    public String getAvailbleMarketStrategyName (OrderVO order);
    
    /**
     * 获取某订单的最终的折扣百分比
     * @param order OrderVO型，同层调用传来的订单信息
     * @return float型，返回某订单的最终折扣百分比
     * @see
     */
    public float getBestDiscount(OrderVO order);
    
    /**
     * 判断该名称是否正确
     * @param name String型，要验证的名称
     * @return
     * @throws WrongInputException 
     * @see
     */
    public boolean isRightName(String name) throws WrongInputException;
}
