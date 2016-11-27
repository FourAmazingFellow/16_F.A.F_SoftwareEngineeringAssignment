package businesslogicservice.strategyblservice;

import java.util.ArrayList;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
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
     * @see
     */
    public boolean add(String address, StrategyVO strategy) throws UnableAddStrategyException;
    
    /**
     * 修改某条折扣策略
     * @param address String型， 酒店地址
     * @param strategy StrategyVO型，折扣策略信息
     * @return boolean型，返回是否修改折扣策略成功
     * @throws UnableToModifyStrategyException 
     * @see
     */
    public boolean modify(String address, StrategyVO strategy) throws UnableToModifyStrategyException;
    
    /**
     * 删除某条折扣策略
     * @param address String型， 酒店地址
     * @param strategy StrategyVO型，折扣策略信息
     * @return boolean型，返回是否删除折扣策略成功
     * @throws UnableToDeleteStrategyException 
     * @see
     */
    public boolean delete(String address, StrategyVO strategy) throws UnableToDeleteStrategyException;
    
    /**
     * 检查该策略信息是否符合规范
     * @param address String型， 酒店地址
     * @param strategy StrategyVO型，折扣策略信息
     * @return boolean型，返回该策略信息是否符合规范
     * @throws WrongInputException 
     * @see
     */
    public boolean valid(String address, StrategyVO strategy) throws WrongInputException;
    
}
