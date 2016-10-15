package dataservice.strategyDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StrategyPO;
import po.StrategyType;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public interface StrategyDAO {
    
    /**
     * 
     * @param address
     * @param StrategyType
     * @return
     * @throws RemoteException
     * @see
     */
    public ArrayList<StrategyPO> getStrategyList(String address, Enum<StrategyType> StrategyType) throws RemoteException;
    
    /**
     * 
     * @param address
     * @param strategyName
     * @return
     * @throws RemoteException
     * @see
     */
    public StrategyPO getMarketStrategyInfo(String address, String strategyName) throws RemoteException;
    
    /**
     * 
     * @param id
     * @return
     * @throws RemoteException
     * @see
     */
    public StrategyPO find(long id) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void update(StrategyPO po) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void insert(StrategyPO po) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void delete(StrategyPO po) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void init(StrategyPO po) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void finish(StrategyPO po) throws RemoteException;
    
}
