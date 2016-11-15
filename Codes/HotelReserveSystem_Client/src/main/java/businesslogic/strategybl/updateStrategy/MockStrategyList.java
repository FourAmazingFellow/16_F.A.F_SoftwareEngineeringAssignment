package businesslogic.strategybl.updateStrategy;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data_Stub.StrategyDAOImpl_Stub;
import dataservice.strategyDAO.StrategyDAO;
import po.StrategyPO;
import po.StrategyType;
import vo.StrategyVO;

public class MockStrategyList extends StrategyList{

    private StrategyDAO strategyDAO;
    
    public MockStrategyList(){
        strategyDAO=new StrategyDAOImpl_Stub("江苏省南京市栖霞区仙林大道163号", "仙林大酒店", StrategyType.BirthdayPromotion, "生日折扣", 80, 0, null, null, null, null, null, 0);
    }
    
    @Override
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
    
    @Override
    public StrategyItem getStrategyInfo(String address, String name){
        StrategyPO strategyPO;
        try {
            strategyPO=strategyDAO.getMarketStrategyInfo(address, name);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        return new StrategyItem(strategyPO);
    }
    
    @Override
    public boolean add(String address, StrategyVO strategyVO){
        StrategyItem strategyItem=new StrategyItem(strategyVO);
        return strategyItem.add(address);
    }
    
    @Override
    public boolean modify(String address, StrategyVO strategyVO){
        StrategyItem strategyItem=new StrategyItem(strategyVO);
        return strategyItem.modify(address);
    }
    
    @Override
    public boolean delete(String address, StrategyVO strategyVO){
        StrategyItem strategyItem=new StrategyItem(strategyVO);
        return strategyItem.delete(address);
    }
    
    @Override
    public boolean valid(String address, StrategyVO strategyVO){
        StrategyItem strategyItem=new StrategyItem(strategyVO);
        return strategyItem.valid();
    }
}