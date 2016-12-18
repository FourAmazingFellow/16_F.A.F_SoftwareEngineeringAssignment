package businesslogic.userbl.signVip;

import java.rmi.RemoteException;

import businesslogic.strategybl.VerifyEnterpriseVipImpl;
import businesslogic.userbl.VerifyEnterpriseVip;
import businesslogicservice.userblservice.SignVipService;
import dataservice.userDAO.UserDAO;
import po.EnterpriseVipPO;
import po.RegularVipPO;
import rmi.RemoteHelper;
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

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setVerifyEnterpriseVip() {
        this.verifyEnterpriseVip = new VerifyEnterpriseVipImpl();
    }

    @Override
    public boolean signRegularVip(RegularVipVO regularVip) throws RemoteException {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        userDAO.signRegularVip(new RegularVipPO(regularVip));
        return true;
    }

    @Override
    public boolean signEnterpriseVip(EnterpriseVipVO enterpriseVip) throws RemoteException {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        if (verifyEnterpriseVip.verifyEnterpriseMember(enterpriseVip.enterpriseID, enterpriseVip.enterprisePassword) == true) {
        	userDAO.signEnterpriseVip(new EnterpriseVipPO(enterpriseVip));
        	return true;
        } else
            return false;
    }
}
