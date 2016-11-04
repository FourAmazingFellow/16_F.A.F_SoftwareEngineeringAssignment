package businesslogic.strategybl.updateStrategy;

import java.util.ArrayList;

import po.StrategyType;
import vo.StrategyVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateStrategy {
    
    /**
     * 得到某种策略类型的列表
     * @param address string型，酒店地址
     * @param StrategyType 枚举类，策略类型
     * @return 返回策略列表
     * @see
     */
    ArrayList<StrategyVO> getStrategyList(String address, Enum<StrategyType> StrategyType){
        return null;
        
    }
    
    /**
     * 得到对应策略名称的策略
     * @param address string型，酒店地址
     * @param name string型，策略名称
     * @return 返回策略信息
     * @see
     */
    StrategyVO getStrategyInfo(String address, String name){
        return null;
        
    }
    
    /**
     * 增加一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否增加成功
     * @see
     */
    boolean add(String address, StrategyVO strategy){
        return false;
        
    }
    
    /**
     * 修改一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否修改成功
     * @see
     */
    boolean modify(String address, StrategyVO strategy){
        return false;
        
    }
    
    /**
     * 删除一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否删除成功
     * @see
     */
    boolean delete(String address, StrategyVO strategy){
        return false;
        
    }
    
    /**
     * 判断该策略信息是否有效
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回该策略信息是否有效
     * @see
     */
    boolean valid(String address, StrategyVO strategy){
        return false;
        
    }
}
