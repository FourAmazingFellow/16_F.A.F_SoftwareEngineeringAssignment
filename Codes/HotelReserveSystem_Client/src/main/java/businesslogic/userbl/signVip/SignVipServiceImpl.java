package businesslogic.userbl.signVip;

import java.rmi.RemoteException;

import businesslogic.strategybl.VerifyEnterpriseVipImpl;
import businesslogic.userbl.VerifyEnterpriseVip;
import businesslogicservice.userblservice.SignVipService;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.EnterpriseVipPO;
import po.RegularVipPO;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public class SignVipServiceImpl implements SignVipService {

    private UserDAO userDAO;
    private VerifyEnterpriseVip verifyEnterpriseVip;

    private FactoryService factoryService;
    
    
    public SignVipServiceImpl() {
    	this.factoryService = new FactoryServiceImpl();
    	this.userDAO = factoryService.getUserDAO();
    }

    public void setVerifyEnterpriseVip() {
        this.verifyEnterpriseVip = new VerifyEnterpriseVipImpl();
    }

    @Override
    public boolean signRegularVip(RegularVipVO regularVip) throws RemoteException {
        userDAO.signRegularVip(new RegularVipPO(regularVip));
        return true;
    }

    @Override
    public boolean signEnterpriseVip(EnterpriseVipVO enterpriseVip) throws RemoteException {
        if (verifyEnterpriseVip.verifyEnterpriseMember(enterpriseVip.enterpriseID, enterpriseVip.enterprisePassword) == true) {
        	userDAO.signEnterpriseVip(new EnterpriseVipPO(enterpriseVip));
        	return true;
        } else
            return false;
    }
}
