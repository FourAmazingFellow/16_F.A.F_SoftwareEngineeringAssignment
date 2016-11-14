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
     * @param address String型，业务逻辑层传递来的酒店地址
     * @param StrategyType Enum型，策略类型
     * @return 返回折扣策略列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<StrategyPO> getStrategyList(String address, Enum<StrategyType> strategyType) throws RemoteException;
    
    /**
     * 获取对应折扣名称的策略信息
     * @param address String型，业务逻辑层传递来的酒店地址
     * @param strategyName String型，折扣名称
     * @return 返回策略信息
     * @throws RemoteException
     * @see
     */
    public StrategyPO getMarketStrategyInfo(String address, String strategyName) throws RemoteException;
    
    /**
     * 更新某条策略信息
     * @param po StrategyPO型，业务逻辑层传递来的策略信息
     * @throws RemoteException
     * @see
     */
    public void update(StrategyPO po) throws RemoteException;
    
    /**
     * 
     * @param po StrategyPO型，业务逻辑层传递来的策略信息
     * @throws RemoteException
     * @see
     */
    public void insert(StrategyPO po) throws RemoteException;
    
    /**
     * 
     * @param po StrategyPO型，业务逻辑层传递来的策略信息
     * @throws RemoteException
     * @see
     */
    public void delete(StrategyPO po) throws RemoteException;
    
    /**
     * 初始化持久化数据存储
     * @throws RemoteException
     * @see
     */
    public void init() throws RemoteException;
    
    /**
     * 结束持久化数据存储的使用
     * @throws RemoteException
     * @see
     */
    public void finish() throws RemoteException;
    
}
