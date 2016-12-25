package businesslogic.strategybl;

import java.rmi.RemoteException;

import businesslogic.userbl.VerifyEnterpriseVip;
import dataservice.strategyDAO.StrategyDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;

/**
 * 实现为了解除与userbl的循环依赖的接口VerifyEnterprise的方法，提供给userbl模块使用
 * @author 双
 * @version 
 * @see
 */
public class VerifyEnterpriseVipImpl implements VerifyEnterpriseVip {

    private StrategyDAO strategyDAO;
    
    private FactoryService factoryService;

    public VerifyEnterpriseVipImpl() {
        //用工厂初始化DAO
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
