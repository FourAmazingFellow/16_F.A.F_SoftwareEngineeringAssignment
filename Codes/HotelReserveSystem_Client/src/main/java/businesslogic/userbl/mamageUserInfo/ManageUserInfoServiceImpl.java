package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelStaffInfoPO;
import po.UserPO;
import vo.HotelStaffInfoVO;
import vo.UserVO;

/**
 * 网站管理人员管理用户相关信息
 * 
 * @author sparkler
 * @version
 * @see
 */
public class ManageUserInfoServiceImpl implements ManageUserInfoService {

	private UserDAO userDAO;
	private String userID;
	private UserVO userVO;
	private HotelStaffInfoVO hotelStaffInfoVO;

	private FactoryService factoryService;

	public ManageUserInfoServiceImpl() {
		this.factoryService = new FactoryServiceImpl();
		this.userDAO = factoryService.getUserDAO();
	}

	@Override
	/**
	 * 网站管理人员新添加网站营销人员
	 * 
	 * @param user，界面传递过来的用户相关信息
	 * @return 添加成功则返回true，失败则返回false
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.ManageUserInfoService#add(vo.UserVO)
	 */
	public boolean add(UserVO user) throws RemoteException {
		UserPO newUser = new UserPO(user);
		boolean result = userDAO.insertUser(newUser);
		return result;
	}

	@Override
	/**
	 * 网站管理人员获取酒店工作人员信息
	 * 
	 * @param userID，界面传递过来的用户标识
	 * @return 返回酒店工作人员信息，没有此人员则返回null
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.ManageUserInfoService#getHotelStaffInfo(java.lang.String)
	 */
	public HotelStaffInfoVO getHotelStaffInfo(String userID) throws RemoteException {
		this.userID = userID;
		this.hotelStaffInfoVO = null;
		HotelStaffInfoPO hotelStaffInfoPO = userDAO.getHotelStaffInfo(this.userID);
		// 判断是否存在此人员
		if (hotelStaffInfoPO != null)
			this.hotelStaffInfoVO = new HotelStaffInfoVO(hotelStaffInfoPO);
		else
			this.hotelStaffInfoVO = null;
		return hotelStaffInfoVO;
	}

	@Override
	/**
	 * 网站管理人员获取网站营销人员信息
	 * 
	 * @param userID，界面传递过来的用户标识
	 * @return 返回网站营销人员信息，没有此人员则返回null
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.ManageUserInfoService#getUserInfo(java.lang.String)
	 */
	public UserVO getUserInfo(String userID) throws RemoteException {
		this.userID = userID;
		UserPO userPO = userDAO.getUserInfo(this.userID);
		// 判断是否存在此人员
		if (userPO != null)
			this.userVO = new UserVO(userPO);
		else
			this.userVO = null;
		return userVO;
	}

	@Override
	/**
	 * 网站管理人员修改用户信息（酒店工作人员信息不能修改，且能修改的只有用户名和联系方式）
	 * 
	 * @param userVO，UserVO型，界面传递过来的修改过的用户信息
	 * @param userID，String型，界面传递过来的修改前的用户账号
	 * @return 修改成功则返回true，失败则返回false
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.ManageUserInfoService#modifyUserInfo(vo.UserVO,
	 *      java.lang.String)
	 */
	public boolean modifyUserInfo(UserVO userVO, String userID) throws RemoteException {
		boolean result = userDAO.updateUser(new UserPO(userVO), userID);
		return result;
	}

}
