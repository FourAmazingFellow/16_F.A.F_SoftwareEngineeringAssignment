package businesslogic.strategybl.updateStrategy;

import java.rmi.RemoteException;
import java.util.Date;

import data_Stub.StrategyDAOImpl_Stub;
import dataservice.strategyDAO.StrategyDAO;
import po.StrategyPO;
import po.StrategyType;
import vo.StrategyVO;

public class MockStrategyItem extends StrategyItem{

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
    
    private StrategyDAO strategyDAO;
    
    public MockStrategyItem(){
        strategyDAO=new StrategyDAOImpl_Stub("江苏省南京市栖霞区仙林大道163号", "仙林大酒店", StrategyType.SpecificTimePromotion, "双十一折扣", 80, 0, null, null, new Date(2016,11,10,00,00,00), new Date(2016,11,12,00,00,00), null, 0);
    }
    
    public MockStrategyItem(StrategyPO strategyPO) {
        this();
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
            this.startTime = strategyPO.getStartTime();
            this.endTime = strategyPO.getEndTime();
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            this.vipRank = strategyPO.getVipRank();
            this.tradeArea = strategyPO.getTradeArea();
        } else if (strategyType.equals(StrategyType.MemberRankMarket)) {
            this.vipRank = strategyPO.getVipRank();
        }
    }

    public MockStrategyItem(StrategyVO strategyVO) {
        this();
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
            this.startTime = strategyVO.startTime;
            this.endTime = strategyVO.endTime;
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            this.vipRank = strategyVO.vipRank;
            this.tradeArea = strategyVO.tradeArea;
        } else if (strategyType.equals(StrategyType.MemberRankMarket)) {
            this.vipRank = strategyVO.vipRank;
        }
    }

    @Override
    public boolean add(String address) {
        StrategyPO strategyPO;
        if(strategyType.equals(StrategyType.MultiRoomPromotion)){
            strategyPO=new StrategyPO(address, strategyType, address, discount); 
        }else if (strategyType.equals(StrategyType.MultiRoomPromotion)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, minRoomNum);
        } else if (strategyType.equals(StrategyType.CooperationEnterprisePromotion)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, address, address);
        } else if (strategyType.equals(StrategyType.SpecificTimePromotion)
                || strategyType.equals(StrategyType.SpecificTimeMarket)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, startTime, endTime);
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank, address);
        } else{
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank);
        }
        try {
            strategyDAO.insert(strategyPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean modify(String address) {
        StrategyPO strategyPO;
        if(strategyType.equals(StrategyType.MultiRoomPromotion)){
            strategyPO=new StrategyPO(address, strategyType, address, discount); 
        }else if (strategyType.equals(StrategyType.MultiRoomPromotion)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, minRoomNum);
        } else if (strategyType.equals(StrategyType.CooperationEnterprisePromotion)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, address, address);
        } else if (strategyType.equals(StrategyType.SpecificTimePromotion)
                || strategyType.equals(StrategyType.SpecificTimeMarket)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, startTime, endTime);
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank, address);
        } else{
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank);
        }
        try {
            strategyDAO.update(strategyPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String address) {
        StrategyPO strategyPO;
        if(strategyType.equals(StrategyType.MultiRoomPromotion)){
            strategyPO=new StrategyPO(address, strategyType, address, discount); 
        }else if (strategyType.equals(StrategyType.MultiRoomPromotion)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, minRoomNum);
        } else if (strategyType.equals(StrategyType.CooperationEnterprisePromotion)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, address, address);
        } else if (strategyType.equals(StrategyType.SpecificTimePromotion)
                || strategyType.equals(StrategyType.SpecificTimeMarket)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, startTime, endTime);
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank, address);
        } else{
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank);
        }
        try {
            strategyDAO.delete(strategyPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean valid() {
        return true;

    }

    @Override
    public StrategyVO toVO() {
        if (strategyType.equals(StrategyType.BirthdayPromotion)) {
            return new StrategyVO(address, strategyType, strategyName, discount);
        } else if (strategyType.equals(StrategyType.MultiRoomPromotion)) {
            return new StrategyVO(address, strategyType, strategyName, discount, minRoomNum);
        } else if (strategyType.equals(StrategyType.CooperationEnterprisePromotion)) {
            return new StrategyVO(address, strategyType, strategyName, discount, enterpriseName, securityCode);
        } else if (strategyType.equals(StrategyType.SpecificTimePromotion)
                || strategyType.equals(StrategyType.SpecificTimeMarket)) {
            return new StrategyVO(address, strategyType, strategyName, discount, startTime, endTime);
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            return new StrategyVO(address, strategyType, strategyName, discount, vipRank, tradeArea);
        } else if (strategyType.equals(StrategyType.MemberRankMarket)) {
            return new StrategyVO(address, strategyType, strategyName, discount, vipRank);
        }
        return null;
    }
}
