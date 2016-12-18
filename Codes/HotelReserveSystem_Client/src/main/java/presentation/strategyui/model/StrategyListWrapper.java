package presentation.strategyui.model;

import java.util.ArrayList;
import java.util.List;

import vo.StrategyVO;

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
