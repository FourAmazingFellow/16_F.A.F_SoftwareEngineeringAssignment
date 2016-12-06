package dataservice.strategyDAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StrategyPO;
import po.StrategyType;

/**
 * 为业务逻辑层提供所需要的折扣策略数据
 * @author 双
 * @version
 * @see
 */
public interface StrategyDAO extends Remote {
    
    /**
     * 获取某种策略类型的折扣列表
     * @param address String型，业务逻辑层传递来的酒店地址,如果是网站促销策略，address="Web"
     * @param StrategyType Enum型，策略类型
     * @return 返回折扣策略列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<StrategyPO> getStrategyList(String address, Enum<StrategyType> strategyType) throws RemoteException;
    
    /**
     * 获取对应折扣名称的策略信息
     * @param address String型，业务逻辑层传递来的酒店地址,如果是网站促销策略，address="Web"
     * @param strategyName String型，折扣名称
     * @return 返回策略信息
     * @throws RemoteException
     * @see
     */
    public StrategyPO getStrategyInfo(String address, Enum<StrategyType> strategyType, String strategyName) throws RemoteException;
    
    /**
     * 更新某条策略信息
     * @param po StrategyPO型，业务逻辑层传递来的策略信息
     * @throws RemoteException
     * @see
     */
    public boolean updateStrategy(StrategyPO po) throws RemoteException;
    
    /**
     * 
     * @param po StrategyPO型，业务逻辑层传递来的策略信息
     * @throws RemoteException
     * @see
     */
    public boolean insertStrategy(StrategyPO po) throws RemoteException;
    
    /**
     * 
     * @param po StrategyPO型，业务逻辑层传递来的策略信息
     * @throws RemoteException
     * @see
     */
    public boolean deleteStrategy(StrategyPO po) throws RemoteException;
    
    /**
     * 验证企业会员
     * @param enterpriseName String型，企业名称
     * @param securityCode Sring型，企业验证码
     * @see
     */
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) throws RemoteException;
}
