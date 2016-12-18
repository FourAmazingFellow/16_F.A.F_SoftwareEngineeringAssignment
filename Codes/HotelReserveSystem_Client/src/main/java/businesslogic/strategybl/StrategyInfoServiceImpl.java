package businesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogic.strategybl.updateStrategy.StrategyItem;
import businesslogic.strategybl.updateStrategy.StrategyList;
import businesslogic.userbl.VipInfo;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.StrategyType;
import vo.EnterpriseVipVO;
import vo.OrderVO;
import vo.RegularVipVO;
import vo.StrategyVO;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public class StrategyInfoServiceImpl implements StrategyInfoService {

    private StrategyList strategyList;
    private String address;
    private StrategyVO bestPromotion;
    private StrategyVO bestMarketStrategy;
    private StrategyItem strategyItem;

    private VipInfo vipInfo;
    private HotelInfoService hotelInfoService;
    private FactoryService factoryService;
    
    public StrategyInfoServiceImpl() {
        factoryService=new FactoryServiceImpl();
        hotelInfoService = factoryService.createHotelInfoService();
        vipInfo = factoryService.createVipInfo();
    }
    
    @Override
    public String getAvailblePromotionName(OrderVO order) throws RemoteException {
        ArrayList<StrategyItem> availblePromotion = new ArrayList<>();
        address = order.hotelAddress;
        strategyList = StrategyList.getInstance(address);
        // 把所有策略类型的列表遍历一遍，判断是否满足条件

        // 判断是否满足生日折扣
        RegularVipVO regularVipVO = vipInfo.getRegularVipInfo(order.userID);
        if (regularVipVO != null) {
            Date birth = regularVipVO.birth;
            if (birth.compareTo(order.beginDate) >= 0&&birth.compareTo(order.finishDate)<=0) {
                availblePromotion.add(strategyList.getStrategyList(address, StrategyType.BirthdayPromotion).get(0));
            }
        }
        // 判断是否满足多房间折扣
        int orderRoomNum = order.num;
        for (StrategyItem strategyItem : strategyList.getStrategyList(address, StrategyType.MultiRoomPromotion)) {
            if (orderRoomNum >= strategyItem.toVO().minRoomNum) {
                availblePromotion.add(strategyItem);
            }
        }
        // 判断是否满足合作企业折扣
        EnterpriseVipVO enterpriseVipVO = vipInfo.getEnterpriseVipInfo(order.userID);
        if (enterpriseVipVO != null) {
            String enterpriseName = enterpriseVipVO.enterpriseID;
            String securityCode = enterpriseVipVO.enterprisePassword;
            for (StrategyItem strategyItem : strategyList.getStrategyList(address,
                    StrategyType.CooperationEnterprisePromotion)) {
                StrategyVO vo = strategyItem.toVO();
                if (vo.enterpriseName.equals(enterpriseName) && vo.securityCode.equals(securityCode)) {
                    availblePromotion.add(strategyItem);
                }
            }
        }
        // 判断是否满足特定期间折扣
        Date beginDate = order.beginDate;
        Date finishDate = order.finishDate;
        for (StrategyItem strategyItem : strategyList.getStrategyList(address, StrategyType.SpecificTimePromotion)) {
            StrategyVO vo = strategyItem.toVO();
            if (beginDate.compareTo(vo.startTime) >= 0 && beginDate.compareTo(vo.endTime) <= 0) {
                availblePromotion.add(strategyItem);
            } else if (finishDate.compareTo(vo.startTime) >= 0 && finishDate.compareTo(vo.endTime) <= 0) {
                availblePromotion.add(strategyItem);
            }
        }
        // 把满足条件的折扣比较折扣百分比，取最优的促销策略
        if(availblePromotion.size()==0){
            return null;
        }
        bestPromotion = availblePromotion.get(0).toVO();
        for (StrategyItem strategyItem : availblePromotion) {
            StrategyVO vo = strategyItem.toVO();
            if (bestPromotion.discount > vo.discount) {
                bestPromotion = vo;
            }
        }
        return bestPromotion.strategyName;
    }

    @Override
    public String getAvailbleMarketStrategyName(OrderVO order) throws RemoteException {
        ArrayList<StrategyItem> availableMarketStrategy = new ArrayList<>();
        address = "Web";
        strategyList = StrategyList.getInstance(address);
        // 把所有策略类型的列表遍历一遍，判断是否满足条件

        // 判断是否满足特定期间折扣
        Date beginDate = order.beginDate;
        Date finishDate = order.finishDate;
        for (StrategyItem strategyItem : strategyList.getStrategyList(address, StrategyType.SpecificTimeMarket)) {
            StrategyVO vo = strategyItem.toVO();
            if (beginDate.compareTo(vo.startTime) >= 0 && beginDate.compareTo(vo.endTime) <= 0) {
                availableMarketStrategy.add(strategyItem);
            } else if (finishDate.compareTo(vo.startTime) >= 0 && finishDate.compareTo(vo.endTime) <= 0) {
                availableMarketStrategy.add(strategyItem);
            }
        }

        // 判断是否满足会员等级折扣
        RegularVipVO regularVipVO = vipInfo.getRegularVipInfo(order.userID);
        if (regularVipVO != null) {
            int vipRank = regularVipVO.vipRank;
            for (StrategyItem strategyItem : strategyList.getStrategyList(address, StrategyType.MemberRankMarket)) {
                if (vipRank >= strategyItem.toVO().vipRank) {
                    availableMarketStrategy.add(strategyItem);
                }
            }
        }

        // 判断是否满足特定商圈专属折扣
        if (regularVipVO != null) {
            int vipRank = regularVipVO.vipRank;
            
            String tradeArea = hotelInfoService.getHotelBriefInfo(order.hotelAddress).tradeArea;
            for (StrategyItem strategyItem : strategyList.getStrategyList(address, StrategyType.VipTradeAreaMarket)) {
                if (tradeArea.equals(strategyItem.toVO().tradeArea) && vipRank >= strategyItem.toVO().vipRank) {
                    availableMarketStrategy.add(strategyItem);
                }
            }
        }

        // 把满足条件的折扣比较折扣百分比，取最小的促销策略
        if(availableMarketStrategy.size()==0){
            return null;
        }
        bestMarketStrategy = availableMarketStrategy.get(0).toVO();
        for (StrategyItem strategyItem : availableMarketStrategy) {
            StrategyVO vo = strategyItem.toVO();
            if (bestMarketStrategy.discount > vo.discount) {
                bestMarketStrategy = vo;
            }
        }
        return bestMarketStrategy.strategyName;
    }

    @Override
    public float getBestDiscount(OrderVO order) throws RemoteException {
        // 调用上两个方法，得到最好的酒店促销策略和网站营销策略
        if (bestPromotion == null)
            getAvailblePromotionName(order);
        if (bestMarketStrategy == null)
            getAvailbleMarketStrategyName(order);
        // 用策略名称得到折扣百分比
        float bestDiscount=1;
        float bestDiscountOfPromotion=1;
        float bestDiscountOfMarket=1;
        if(bestPromotion!=null){
            bestDiscountOfPromotion=bestPromotion.discount;
        }
        if(bestMarketStrategy!=null){
            bestDiscountOfMarket=bestMarketStrategy.discount;
        }
        if (bestDiscountOfPromotion >= bestDiscountOfMarket) {
            bestDiscount = bestDiscountOfMarket;
        } else {
            bestDiscount = bestDiscountOfMarket;
        }
        return bestDiscount;
    }

    @Override
    public boolean isRightName(String name) throws WrongInputException {
        strategyItem=new StrategyItem();
        return strategyItem.isRightName(name);
    }

}
