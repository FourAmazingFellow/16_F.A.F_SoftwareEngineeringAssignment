package presentation.strategyui.model;

import java.util.ArrayList;
import java.util.List;

import vo.StrategyVO;

/**
 * 用来装策略模型类对象的列表
 * @author 双
 * @version 
 * @see
 */
public class StrategyListWrapper {

    private List<Strategy> strategyList=new ArrayList<>();
    
    public List<Strategy> getStrategyList(){
        return strategyList;
    }
    
    public void setStrategyList(ArrayList<StrategyVO> strategyVOs){
        strategyList.clear();
        for(StrategyVO strategyVO:strategyVOs){
            strategyList.add(new Strategy(strategyVO));
        }
    }
}
