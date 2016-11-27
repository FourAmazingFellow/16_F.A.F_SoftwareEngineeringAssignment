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
        //该折扣名称是否已存在，存在则无法添加
        StrategyPO strategyPO;
        if(strategyType.equals(StrategyType.BirthdayPromotion)){
            //是否已存在生日折扣，生日折扣只能有一种
            strategyPO=new StrategyPO(address, strategyType, address, discount); 
        }else if (strategyType.equals(StrategyType.MultiRoomPromotion)) {
            //该房间数是否已存在
            strategyPO=new StrategyPO(address, strategyType, address, discount, minRoomNum);
        } else if (strategyType.equals(StrategyType.CooperationEnterprisePromotion)) {
            //合作企业折扣，该合作企业是否已存在
            strategyPO=new StrategyPO(address, strategyType, address, discount, enterpriseName, securityCode);
        } else if (strategyType.equals(StrategyType.SpecificTimePromotion)
                || strategyType.equals(StrategyType.SpecificTimeMarket)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, startTime, endTime);
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
            //对应vip和商圈的折扣是否已存在
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank, tradeArea);
        } else{
            //对应vip等级是否已存在
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
      //该折扣名称是否已存在，不存在则无法修改
        StrategyPO strategyPO;
        if(strategyType.equals(StrategyType.BirthdayPromotion)){
            strategyPO=new StrategyPO(address, strategyType, address, discount); 
        }else if (strategyType.equals(StrategyType.MultiRoomPromotion)) {
          //该房间数是否已存在
            strategyPO=new StrategyPO(address, strategyType, address, discount, minRoomNum);
        } else if (strategyType.equals(StrategyType.CooperationEnterprisePromotion)) {
          //合作企业折扣，该合作企业是否已存在
            strategyPO=new StrategyPO(address, strategyType, address, discount, enterpriseName, securityCode);
        } else if (strategyType.equals(StrategyType.SpecificTimePromotion)
                || strategyType.equals(StrategyType.SpecificTimeMarket)) {
            strategyPO=new StrategyPO(address, strategyType, address, discount, startTime, endTime);
        } else if (strategyType.equals(StrategyType.VipTradeAreaMarket)) {
          //对应vip和商圈的折扣是否已存在
            strategyPO=new StrategyPO(address, strategyType, address, discount, vipRank, address);
        } else{
          //对应vip等级是否已存在
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
        //判断该折扣名称是否存在，不存在无法删除
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
        //格式验证
        //验证折扣名称是否含非法字符
        //验证折扣百分比是否0<x<100
        //若是企业折扣，企业名称是否合理，验证码是否是8位
        //如果是商圈折扣，商圈名称正确，vip为正整数
        //如果是特殊期间折扣，时间格式是否正确，起始时间是否小于结束时间
        //非格式验证
        //如果是房间数折扣，最少房间数是否小于可用客房数量大于0
        //如果是商圈折扣，商圈是否存在,minVIP<vip<maxVIP
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
