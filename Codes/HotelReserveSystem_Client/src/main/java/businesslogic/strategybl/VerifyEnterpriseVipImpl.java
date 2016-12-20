package businesslogic.strategybl;

import java.rmi.RemoteException;

import businesslogic.userbl.VerifyEnterpriseVip;
import dataservice.strategyDAO.StrategyDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;

public class VerifyEnterpriseVipImpl implements VerifyEnterpriseVip {

    private StrategyDAO strategyDAO;
    
    private FactoryService factoryService;

    public VerifyEnterpriseVipImpl() {
    	this.factoryService = new FactoryServiceImpl();
        strategyDAO = factoryService.getStrategyDAO();
        
    }

    @Override
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) throws RemoteException {
        boolean verifyed = false;
        verifyed = strategyDAO.verifyEnterpriseMember(enterpriseName, securityCode);
        return verifyed;
    }

}
