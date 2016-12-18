package businesslogicservice.strategyblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import po.BusinessDistrictPO;
import po.StrategyType;
import vo.StrategyVO;

/**
 * 给view层的制定酒店促销策略和网站营销策略任务提供roombl接口
 * @author 双
 * @version 
 * @see
 */
public interface UpdateStrategyService {

    /**
     * 获取某种策略类型的折扣列表
     * @param address String型， 酒店地址
     * @param StrategyType Enum型，策略类型
     * @return ArrayList<StrategyVO>，返回某种策略类型的折扣列表
     * @see
     */
    public ArrayList<StrategyVO> getStrategyList(String address, Enum<StrategyType> strategyType);
    
    /**
     * 返回某个折扣名称的折扣信息
     * @param address String型， 酒店地址
     * @param name String型，折扣策略名称
     * @return StrategyVO型，返回折扣信息
     * @see
     */
    public StrategyVO getStrategyInfo(String address, Enum<StrategyType> strategyType, String name);
    
    /**
     * 制定折扣策略
     * @param address String型， 酒店地址
     * @param strategy StrategyVO型，折扣策略信息
     * @return boolean型，返回是否制定折扣策略成功
     * @throws UnableAddStrategyException 
     * @throws WrongInputException 
     * @throws RemoteException 
     * @see
     */
    public boolean add(String address, StrategyVO strategy) throws UnableAddStrategyException, WrongInputException, RemoteException;
    
    /**
     * 修改某条折扣策略
     * @param address String型， 酒店地址
     * @param strategy StrategyVO型，折扣策略信息
     * @return boolean型，返回是否修改折扣策略成功
     * @throws UnableToModifyStrategyException 
     * @throws WrongInputException 
     * @throws RemoteException 
     * @see
     */
    public boolean modify(String address, StrategyVO strategy) throws UnableToModifyStrategyException, WrongInputException, RemoteException;
    
    /**
     * 删除某条折扣策略
     * @param address String型， 酒店地址
     * @param strategy StrategyVO型，折扣策略信息
     * @return boolean型，返回是否删除折扣策略成功
     * @throws UnableToDeleteStrategyException 
     * @throws WrongInputException 
     * @throws RemoteException 
     * @see
     */
    public boolean delete(String address, StrategyVO strategy) throws UnableToDeleteStrategyException, WrongInputException, RemoteException;
    
    /**
     * 检查该策略信息是否符合规范
     * @param address String型， 酒店地址
     * @param strategy StrategyVO型，折扣策略信息
     * @return boolean型，返回该策略信息是否符合规范
     * @throws WrongInputException 
     * @throws RemoteException 
     * @see
     */
    public boolean valid(String address, StrategyVO strategy) throws WrongInputException, RemoteException;
    
    /**
     * 验证特定商圈会员专属折扣的商圈名称在某城市是否存在
     * @param city String型，城市名称
     * @param strategyVO 策略信息
     * @return 返回商圈是否存在
     * @throws WrongInputException 
     * @throws RemoteException 
     * @see
     */
    public boolean verifyTradeArea(String city, StrategyVO strategyVO) throws WrongInputException, RemoteException;
    
    /**
     * 获得商圈列表
     * @return 返回商圈列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<BusinessDistrictPO> getBusinessDistrictList(String city) throws RemoteException;
}
