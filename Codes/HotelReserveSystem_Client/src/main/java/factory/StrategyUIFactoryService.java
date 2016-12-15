package factory;

import businesslogicservice.strategyblservice.UpdateStrategyService;

public interface StrategyUIFactoryService {
    
    public UpdateStrategyService createUpdateStrategyService();
    
}
