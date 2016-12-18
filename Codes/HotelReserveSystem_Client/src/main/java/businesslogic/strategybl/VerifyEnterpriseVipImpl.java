package businesslogic.strategybl;

import java.rmi.RemoteException;

import businesslogic.userbl.VerifyEnterpriseVip;
import dataservice.strategyDAO.StrategyDAO;
import rmi.RemoteHelper;

public class VerifyEnterpriseVipImpl implements VerifyEnterpriseVip {

    StrategyDAO strategyDAO;

    public VerifyEnterpriseVipImpl() {
        strategyDAO = RemoteHelper.getInstance().getStrategyDAO();
        
    }

    @Override
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) throws RemoteException {
        strategyDAO = RemoteHelper.getInstance().getStrategyDAO();
        boolean verifyed = false;
        verifyed = strategyDAO.verifyEnterpriseMember(enterpriseName, securityCode);
        return verifyed;
    }

}
