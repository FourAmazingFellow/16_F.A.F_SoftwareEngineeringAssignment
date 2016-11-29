package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.LoginAndSignUpService;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import rmi.RemoteHelper;
import vo.UserVO;


public class LoginAndSignUpServiceImpl implements LoginAndSignUpService {

    private UserDAO userDAO;
    private CheckLoginInfo check;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    @Override
    public boolean login(String userID, String password) {
        check = new CheckLoginInfo();
        return check.checkUser(userID, password);
    }

    @Override
    public boolean add(UserVO user) {
 //       userDAO = RemoteHelper.getInstance().getUserDAO();
        try {
            userDAO.insertUser(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }


}
