package businesslogic.userbl.signVip;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import vo.VipInfoVO;

public class MockSignVipServiceImpl extends SignVipServiceImpl{
   private UserDAO userDAO = new UserDAOImpl_Stub("asd123", "asdasd", "12312312312", "如家");
    
    @Override
    public boolean signRegularVip(VipInfoVO regularVip) {
        try {
            userDAO.updateUser(new UserPO(regularVip));;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
