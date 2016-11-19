package businesslogic.userbl;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import vo.UserVO;

public class MockUserInfoImpl extends UserInfoImpl{
   private UserDAO userDAO = new UserDAOImpl_Stub("qwe123", "qweqwe", "12312312312");
    
    @Override
    public boolean insert(UserVO staff) {
        try {
            userDAO.insertUser(new UserPO(staff));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } 
    }
}
