package businesslogic.strategybl;

import vo.OrderVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class StrategyInfoServiceImpl implements StrategyInfoService{

    @Override
    public String getAvailblePromotionName(OrderVO order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAvailbleMarketStrategyName(OrderVO order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getBestDiscount(OrderVO order) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) {
        // TODO Auto-generated method stub
        return false;
    }

}
