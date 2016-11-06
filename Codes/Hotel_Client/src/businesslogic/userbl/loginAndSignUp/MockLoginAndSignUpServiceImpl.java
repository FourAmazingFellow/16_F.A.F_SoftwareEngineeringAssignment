package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import vo.UserVO;

public class MockLoginAndSignUpServiceImpl extends LoginAndSignUpServiceImpl{
    
    UserDAO userDAO = new UserDAOImpl_Stub("qwe123", "qweqwe", "12345678901");
    MockCheckLoginInfo check;
    @Override
    public boolean login(String userID, String password) {
        return check.checkUser(userID, password);
    }

    @Override
    public boolean add(UserVO user) {
        try {
            userDAO.insert(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
