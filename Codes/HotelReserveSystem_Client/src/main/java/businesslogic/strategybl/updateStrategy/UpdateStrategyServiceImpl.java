package businesslogic.strategybl.updateStrategy;

import java.util.ArrayList;

import businesslogicservice.strategyblservice.UpdateStrategyService;
import po.StrategyType;
import vo.StrategyVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateStrategyServiceImpl implements UpdateStrategyService{
    
    private StrategyList strategyList=new MockStrategyList();
    
    /**
     * 得到某种策略类型的列表
     * @param address string型，酒店地址
     * @param StrategyType 枚举类，策略类型
     * @return 返回策略列表
     * @see
     */
    @Override
    public ArrayList<StrategyVO> getStrategyList(String address, Enum<StrategyType> StrategyType){
        ArrayList<StrategyItem> strategyItems=strategyList.getStrategyList(address, StrategyType);
        ArrayList<StrategyVO> strategyVOs=new ArrayList<StrategyVO>();
        for(StrategyItem strategyItem:strategyItems){
            strategyVOs.add(strategyItem.toVO());
        }
        return strategyVOs;
    }
    
    /**
     * 得到对应策略名称的策略
     * @param address string型，酒店地址
     * @param name string型，策略名称
     * @return 返回策略信息
     * @see
     */
    @Override
    public StrategyVO getStrategyInfo(String address, Enum<StrategyType> strategyType, String name){
        StrategyItem strategyItem=strategyList.getStrategyInfo(address, strategyType, name);
        return strategyItem.toVO();
    }
    
    /**
     * 增加一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否增加成功
     * @see
     */
    @Override
    public boolean add(String address, StrategyVO strategy){
        return strategyList.add(address,strategy);
    }
    
    /**
     * 修改一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否修改成功
     * @see
     */
    @Override
    public boolean modify(String address, StrategyVO strategy){
        return strategyList.modify(address,strategy);
    }
    
    /**
     * 删除一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否删除成功
     * @see
     */
    @Override
    public boolean delete(String address, StrategyVO strategy){
        return strategyList.delete(address,strategy);
    }
    
    /**
     * 判断该策略信息是否有效
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回该策略信息是否有效
     * @see
     */
    @Override
    public boolean valid(String address, StrategyVO strategy){
        return strategyList.valid(address,strategy);
    }
}
