package businesslogic.strategybl.updateStrategy;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
public class StrategyList {

    private StrategyDAO strategyDAO;
    
    /**
     * 得到某种策略类型的列表
     * @param address string型，酒店地址
     * @param StrategyType 枚举类，策略类型
     * @return 返回策略列表
     * @see
     */
    public ArrayList<StrategyItem> getStrategyList(String address, Enum<StrategyType> strategyType){
        ArrayList<StrategyItem> strategyItems=new ArrayList<StrategyItem>();
        ArrayList<StrategyPO> strategyPOs;
        try {
            strategyPOs=strategyDAO.getStrategyList(address, strategyType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(StrategyPO strategyPO:strategyPOs){
            strategyItems.add(new StrategyItem(strategyPO));
        }
        return strategyItems;
        
    }
    
    /**
     * 得到对应策略名称的策略
     * @param address string型，酒店地址
     * @param name string型，策略名称
     * @return 返回策略类
     * @see
     */
    public StrategyItem getStrategyInfo(String address, Enum<StrategyType> strategyType, String name){
        StrategyPO strategyPO;
        try {
            strategyPO=strategyDAO.getStrategyInfo(address,strategyType, name);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        return new StrategyItem(strategyPO);
    }
    
    /**
     * 增加一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否增加成功
     * @see
     */
    public boolean add(String address, StrategyVO strategyVO){
        StrategyItem strategyItem=new StrategyItem(strategyVO);
        return strategyItem.add(address);
    }
    
    /**
     * 修改一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否修改成功
     * @see
     */
    public boolean modify(String address, StrategyVO strategyVO){
        StrategyItem strategyItem=new StrategyItem(strategyVO);
        return strategyItem.modify(address);
    }
    
    /**
     * 删除一个策略
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回是否删除成功
     * @see
     */
    public boolean delete(String address, StrategyVO strategyVO){
        StrategyItem strategyItem=new StrategyItem(strategyVO);
        return strategyItem.delete(address);
    }
    
    /**
     * 判断该策略信息是否有效
     * @param address string型，酒店地址
     * @param strategy StrategyVO型，包含策略信息
     * @return 返回该策略信息是否有效
     * @see
     */
    public boolean valid(String address, StrategyVO strategyVO){
        StrategyItem strategyItem=new StrategyItem(strategyVO);
        return strategyItem.valid();
    }
}
