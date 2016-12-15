package factory;

import businesslogic.strategybl.updateStrategy.UpdateStrategyServiceImpl;
import businesslogicservice.strategyblservice.UpdateStrategyService;

public class StrategyUIFactoryServiceImpl implements StrategyUIFactoryService{

    @Override
    public UpdateStrategyService createUpdateStrategyService() {
        return new UpdateStrategyServiceImpl();
    }

    
    
}
