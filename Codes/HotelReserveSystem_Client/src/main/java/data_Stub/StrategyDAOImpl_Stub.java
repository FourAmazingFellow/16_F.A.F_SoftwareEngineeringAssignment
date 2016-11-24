package data_Stub;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;

import dataservice.strategyDAO.StrategyDAO;
import po.StrategyPO;
import po.StrategyType;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class StrategyDAOImpl_Stub implements StrategyDAO{
    
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
    
    public StrategyDAOImpl_Stub(String address, String hotelName, Enum<StrategyType> strategyType, String strategyName, int discount,
            int minRoomNum, String enterpriseName, String securityCode, Date startTime, Date endTime, String tradeArea,
            int vipRank) {
        super();
        this.address = address;
        this.hotelName = hotelName;
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
    public ArrayList<StrategyPO> getStrategyList(String address, Enum<StrategyType> strategyType)
            throws RemoteException {
        StrategyPO strategyPO=null;
        if(StrategyType.BirthdayPromotion==strategyType)
            strategyPO=new StrategyPO(address, strategyType, strategyName, discount);
        if(StrategyType.MultiRoomPromotion==strategyType)
            strategyPO=new StrategyPO(address, strategyType, strategyName, discount, minRoomNum);
        if(StrategyType.CooperationEnterprisePromotion==strategyType)
            strategyPO=new StrategyPO(hotelName, strategyType, strategyName, discount, enterpriseName, securityCode);
        if(StrategyType.SpecificTimePromotion==strategyType||StrategyType.SpecificTimeMarket==strategyType)
            strategyPO=new StrategyPO(address, strategyType, strategyName, discount, startTime, endTime);
        if(StrategyType.VipTradeAreaMarket==strategyType)
            strategyPO=new StrategyPO(address, strategyType, strategyName, discount, vipRank, tradeArea);
        if(StrategyType.MemberRankMarket==strategyType)
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank);
        ArrayList<StrategyPO> arrayList=new ArrayList<StrategyPO>();
        arrayList.add(strategyPO);
        return arrayList;
    }

    @Override
    public StrategyPO getStrategyInfo(String address, Enum<StrategyType> strategyType, String strategyName) throws RemoteException {
        StrategyPO strategyPO=new StrategyPO(address, strategyType, strategyName, discount, startTime, endTime);
        return strategyPO;
    }

    @Override
    public StrategyPO findStrategy(String userID) throws RemoteException {
        StrategyPO strategyPO=new StrategyPO(address, strategyType, strategyName, discount);
        return strategyPO;
    }

    @Override
    public void updateStrategy(StrategyPO po) throws RemoteException {
        System.out.println("更新该策略信息成功");
        
    }

    @Override
    public void insertStrategy(StrategyPO po) throws RemoteException {
        System.out.println("插入该策略信息成功");
        
    }

    @Override
    public void deleteStrategy(StrategyPO po) throws RemoteException {
        System.out.println("删除该策略信息成功");
        
    }
}
