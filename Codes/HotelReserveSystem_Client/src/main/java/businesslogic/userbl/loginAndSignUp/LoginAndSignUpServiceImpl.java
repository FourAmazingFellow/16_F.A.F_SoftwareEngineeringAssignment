package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.LoginAndSignUpService;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.ClientInfoPO;
import po.UserPO;
import po.UserType;
import vo.ClientInfoVO;
import vo.UserVO;

public class LoginAndSignUpServiceImpl implements LoginAndSignUpService {

    private UserDAO userDAO;
    private CheckLoginInfo check;

    private FactoryService factoryService;
    
    public LoginAndSignUpServiceImpl() {
    	this.factoryService = new FactoryServiceImpl();
    	this.userDAO = factoryService.getUserDAO();
    }

    @Override
    public boolean login(String userID, String password) throws RemoteException {
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
     * @throws RemoteException 
     */
    @Override
    public boolean add(UserVO user) throws RemoteException {
    	boolean result = false;
        if (user.userType == UserType.Client){
            ClientInfoVO client = new ClientInfoVO(user.userID, user.password, user.telNum, UserType.Client, 0, null);
            ClientInfoPO clientInfoPO = new ClientInfoPO(client);
            result = userDAO.insertClient(clientInfoPO);
        }
        else
        {
        	UserPO userPO = new UserPO(user);
        	result = userDAO.insertUser(userPO);
        }
        return result;
    }

}
