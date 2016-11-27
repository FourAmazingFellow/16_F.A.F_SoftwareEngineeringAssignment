package businesslogic.strategybl;

import businesslogic.strategybl.updateStrategy.StrategyItem;
import businesslogic.strategybl.updateStrategy.StrategyList;
import po.StrategyType;
import vo.OrderVO;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public class StrategyInfoServiceImpl implements StrategyInfoService {

    StrategyList strategyList;
    String address;
    
    @Override
    public String getAvailblePromotionName(OrderVO order) {
        address=order.hotelAddress;
        strategyList=StrategyList.getInstance(address);
        // 把所有策略类型的列表遍历一遍，判断是否满足条件
        //判断是否满足生日折扣
        for(StrategyItem strategyItem : strategyList.getStrategyList(address, StrategyType.BirthdayPromotion)){
            
        }
        
        // 把满足条件的折扣比较折扣百分比，取最小的促销策略
        return null;
    }

    @Override
    public String getAvailbleMarketStrategyName(OrderVO order) {
        // 把所有策略类型的列表遍历一遍，判断是否满足条件
        // 把满足条件的折扣比较折扣百分比，取最小的促销策略
        return null;
    }

    @Override
    public int getBestDiscount(OrderVO order) {
        // 调用上两个方法，得到可用策略的名称
        //用策略名称得到折扣百分比
        return 0;
    }

//    @Override
//    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) {
//        // 调用DAO的方法
//        return false;
//    }

}
