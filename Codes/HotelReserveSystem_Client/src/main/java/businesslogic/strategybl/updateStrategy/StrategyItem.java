package businesslogic.strategybl.updateStrategy;

import java.rmi.RemoteException;
import java.util.Date;

import dataservice.strategyDAO.StrategyDAO;
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

    public StrategyItem(){
        
    }
    
    /**
     * 构造函数
     * 
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
            this.startTime = strategyPO.getStartTime();
            this.endTime = strategyPO.getEndTime();
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            this.vipRank = strategyPO.getVipRank();
            this.tradeArea = strategyPO.getTradeArea();
        } else if (strategyType.equals(StrategyType.MemberRankMarket)) {
            this.vipRank = strategyPO.getVipRank();
        }
    }

    /**
     * 构造函数
     * 
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
            this.startTime = strategyVO.startTime;
            this.endTime = strategyVO.endTime;
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            this.vipRank = strategyVO.vipRank;
            this.tradeArea = strategyVO.tradeArea;
        } else if (strategyType.equals(StrategyType.MemberRankMarket)) {
            this.vipRank = strategyVO.vipRank;
        }
    }

    /**
     * 增加一个策略
     * 
     * @param address string型，酒店地址
     * @return 返回是否增加成功
     * @see
     */
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
            strategyDAO.insertStrategy(strategyPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 修改一个策略
     * 
     * @param address string型，酒店地址
     * @return 返回是否修改成功
     * @see
     */
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
            strategyDAO.updateStrategy(strategyPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除一个策略
     * 
     * @param address string型，酒店地址
     * @return 返回是否删除成功
     * @see
     */
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
            strategyDAO.deleteStrategy(strategyPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断该策略信息是否有效
     * 
     * @return 返回该策略信息是否有效
     * @see
     */
    public boolean valid() {
        return false;

    }

    /**
     * 转成StrategyVO型的策略信息
     * @return 返回StrategyVO，包含策略信息
     * @see
     */
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
