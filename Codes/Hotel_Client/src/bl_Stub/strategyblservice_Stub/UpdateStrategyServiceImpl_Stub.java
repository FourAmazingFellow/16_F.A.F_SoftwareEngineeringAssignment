package bl_Stub.strategyblservice_Stub;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.strategyblservice.UpdateStrategyService;
import po.StrategyType;
import vo.StrategyVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateStrategyServiceImpl_Stub implements UpdateStrategyService{

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
    
    public UpdateStrategyServiceImpl_Stub(String address, Enum<StrategyType> strategyType, String strategyName,
            int discount, int minRoomNum, String enterpriseName, String securityCode, Date startTime, Date endTime,
            String tradeArea, int vipRank) {
        super();
        this.address = address;
        this.strategyType = strategyType;
        this.strategyName = strategyName;
        this.discount = discount;
        this.minRoomNum = minRoomNum;
        this.enterpriseName = enterpriseName;
        this.securityCode = securityCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tradeArea = tradeArea;
        this.vipRank = vipRank;
    }

    @Override
    public ArrayList<StrategyVO> getStrategyList(String address, Enum<StrategyType> strategyType) {
        StrategyVO strategyVO=null;
        if(StrategyType.BirthdayPromotion==strategyType)
            strategyVO=new StrategyVO(address, strategyType, address, discount);
        if(StrategyType.MultiRoomPromotion==strategyType)
            strategyVO=new StrategyVO(address, strategyType, address, discount, minRoomNum);
        if(StrategyType.CooperationEnterprisePromotion==strategyType)
            strategyVO=new StrategyVO(address, strategyType, address, discount, enterpriseName, securityCode);
        if(StrategyType.SpecificTimePromotion==strategyType||StrategyType.SpecificTimeMarket==strategyType)
            strategyVO=new StrategyVO(address, strategyType, address, discount, startTime, endTime);
        if(StrategyType.VipTradeAreaMarket==strategyType)
            strategyVO=new StrategyVO(address, strategyType, address, discount, vipRank, tradeArea);
        if(StrategyType.MemberRankMarket==strategyType)
            strategyVO=new StrategyVO(address, strategyType, address, discount, vipRank);
        ArrayList<StrategyVO> arrayList=new ArrayList<StrategyVO>();
        arrayList.add(strategyVO);
        return arrayList;
    }

    @Override
    public StrategyVO getStrategyInfo(String address, String name) {
        StrategyVO strategyVO=new StrategyVO(address, strategyType, name, discount);
        return strategyVO;
    }

    @Override
    public boolean add(String address, StrategyVO strategy) {
        return true;
    }

    @Override
    public boolean modify(String address, StrategyVO strategy) {
        return true;
    }

    @Override
    public boolean delete(String address, StrategyVO strategy) {
        return true;
    }

    @Override
    public boolean Valid(String address, StrategyVO strategy) {
        return true;
    }

}
