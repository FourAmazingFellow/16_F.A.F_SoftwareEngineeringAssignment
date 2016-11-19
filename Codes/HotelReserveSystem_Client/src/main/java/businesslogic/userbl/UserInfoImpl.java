package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.UserPO;
import vo.UserVO;

public class UserInfoImpl implements UserInfo{
    
    private UserDAO userDAO;
    
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
