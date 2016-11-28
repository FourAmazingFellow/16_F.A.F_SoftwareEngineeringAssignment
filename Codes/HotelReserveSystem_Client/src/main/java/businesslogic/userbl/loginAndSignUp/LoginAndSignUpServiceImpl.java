package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.LoginAndSignUpService;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import vo.UserVO;


public class LoginAndSignUpServiceImpl implements LoginAndSignUpService {

    private UserDAO userDAO;
    private CheckLoginInfo check;
    private String userID;
    private String password;
    private String telNum;
    

    @Override
    public boolean login(String userID, String password) {
        check = new CheckLoginInfo();
        return check.checkUser(userID, password);
    }

    @Override
    public boolean add(UserVO user) {
        userDAO = new UserDAOImpl_Stub(userID, password, telNum);
        try {
            userDAO.insertUser(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }


}
