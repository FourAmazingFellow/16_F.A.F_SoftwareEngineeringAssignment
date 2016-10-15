package businesslogicservice.strategyblservice;

import java.util.ArrayList;

import po.StrategyType;
import vo.StrategyVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public interface UpdateStrategyService {

    /**
     * 
     * @param address
     * @param StrategyType
     * @return
     * @see
     */
    public ArrayList<StrategyVO> getStrategyList(String address, Enum<StrategyType> StrategyType);
    
    /**
     * 
     * @param address
     * @param name
     * @return
     * @see
     */
    public StrategyVO getStrategyInfo(String address, String name);
    
    /**
     * 
     * @param address
     * @param strategy
     * @return
     * @see
     */
    public boolean add(String address, StrategyVO strategy);
    
    /**
     * 
     * @param address
     * @param strategy
     * @return
     * @see
     */
    public boolean modify(String address, StrategyVO strategy);
    
    /**
     * 
     * @param address
     * @param strategy
     * @return
     * @see
     */
    public boolean delete(String address, StrategyVO strategy);
    
    /**
     * 
     * @param address
     * @param strategy
     * @return
     * @see
     */
    public boolean Valid(String address, StrategyVO strategy);
    
}
