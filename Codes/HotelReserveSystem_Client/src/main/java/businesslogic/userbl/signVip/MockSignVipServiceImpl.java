package businesslogic.userbl.signVip;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.EnterpriseVipPO;
import po.RegularVipPO;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class MockSignVipServiceImpl extends SignVipServiceImpl{
   private UserDAO userDAO = new UserDAOImpl_Stub("原", "qwe123", "12345678900");
    
    @Override
    public boolean signRegularVip(RegularVipVO regularVip) {
        try {
            userDAO.signRegularVip(new RegularVipPO(regularVip));;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean signEnterpriseVip(EnterpriseVipVO enterpriseVip) {
        try {
            userDAO.signEnterpriseVip(new EnterpriseVipPO(enterpriseVip));;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }    }
    
}
