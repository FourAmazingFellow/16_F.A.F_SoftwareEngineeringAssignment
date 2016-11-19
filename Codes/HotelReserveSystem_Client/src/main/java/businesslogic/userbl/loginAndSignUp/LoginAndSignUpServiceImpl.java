package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.LoginAndSignUpService;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import vo.UserVO;


public class LoginAndSignUpServiceImpl implements LoginAndSignUpService {

    private UserDAO userDAO;
    private CheckLoginInfo check;
    
    @Override
    public boolean login(String userID, String password) {
        return check.checkUser(userID, password);
    }

    @Override
    public boolean add(UserVO user) {
        try {
            userDAO.insertUser(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }


}
