package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.LoginAndSignUpService;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserPO;
import po.UserType;
import rmi.RemoteHelper;
import vo.ClientInfoVO;
import vo.UserVO;

public class LoginAndSignUpServiceImpl implements LoginAndSignUpService {

    private UserDAO userDAO;
    private CheckLoginInfo check;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean login(String userID, String password) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        check = new CheckLoginInfo();
        check.setUserDAO(userDAO);
        UserType userType = check.checkUser(userID, password);
        if(userType != null)
            return true;
        else
            return false;
    }

    /**
     * 用户（客户、网站人员）注册
     */
    @Override
    public boolean add(UserVO user) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        try {
            if (user.userType == UserType.Client){
                ClientInfoVO client = new ClientInfoVO(user.userID, user.password, user.telNum, UserType.Client, 0, null);
                userDAO.insertClient(new ClientInfoPO(client));
            }
            else
                userDAO.insertUser(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

}
