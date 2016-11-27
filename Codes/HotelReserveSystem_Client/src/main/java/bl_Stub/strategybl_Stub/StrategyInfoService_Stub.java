package bl_Stub.strategybl_Stub;

import businesslogic.strategybl.StrategyInfoService;
import vo.OrderVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class StrategyInfoService_Stub implements StrategyInfoService{

    @Override
    public String getAvailblePromotionName(OrderVO order) {
        System.out.println("获取可享受的酒店促销策略成功");
        return null;
    }

    @Override
    public String getAvailbleMarketStrategyName(OrderVO order) {
        System.out.println("获取可享受的网站营销策略成功");
        return null;
    }

    @Override
    public float getBestDiscount(OrderVO order) {
        System.out.println("获取订单的最优折扣成功");
        return 0;
    }

}
