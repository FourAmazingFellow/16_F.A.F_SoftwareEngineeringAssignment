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

/**
 * 登录和注册的实现
 * 
 * @author sparkler
 * @version
 * @see
 */
public class LoginAndSignUpServiceImpl implements LoginAndSignUpService {

	private UserDAO userDAO;
	private CheckLoginInfo check;

	private FactoryService factoryService;

	public LoginAndSignUpServiceImpl() {
		this.factoryService = new FactoryServiceImpl();
		this.userDAO = factoryService.getUserDAO();
	}

	@Override
	/**
	 * 登陆的验证
	 * 
	 * @param userID，String型，界面传递过来的用户标识
	 * @param password，String型，界面传递过来的用户密码
	 * @return 登录成功则返回true，失败则返回false
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.LoginAndSignUpService#login(java.lang.String,
	 *      java.lang.String)
	 */
	public boolean login(String userID, String password) throws RemoteException {
		check = new CheckLoginInfo();
		check.setUserDAO(userDAO);
		UserType userType = check.checkUser(userID, password);
		if (userType != null)
			return true;
		else
			return false;
	}

	@Override
	/**
	 * 用户（客户、网站人员）注册
	 * 
	 * @param user，UserVO型，界面传递过来的用户相关信息
	 * @return 注册成功则返回true，失败则返回false
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.LoginAndSignUpService#add(vo.UserVO)
	 */
	public boolean add(UserVO user) throws RemoteException {
		boolean result = false;
		// 如果用户类型是client则new一个ClientInfoVO，new出来的客户初始信用值为0，信用记录为空
		if (user.userType == UserType.Client) {
			ClientInfoVO client = new ClientInfoVO(user.userID, user.password, user.telNum, UserType.Client, 0, null);
			ClientInfoPO clientInfoPO = new ClientInfoPO(client);
			result = userDAO.insertClient(clientInfoPO);
		}
		// 用户类型为网站人员直接用传递过来的user
		else {
			UserPO userPO = new UserPO(user);
			result = userDAO.insertUser(userPO);
		}
		return result;
	}

}
