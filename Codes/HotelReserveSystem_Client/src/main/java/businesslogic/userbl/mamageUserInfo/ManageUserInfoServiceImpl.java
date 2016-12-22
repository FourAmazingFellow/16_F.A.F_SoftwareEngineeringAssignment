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

	/*
	 * (non-Javadoc)
	 * 
	 * @param user
	 * 
	 * @return
	 * 
	 * @see
	 * businesslogicservice.userblservice.ManageUserInfoService#add(vo.UserVO)
	 */
	@Override
	public boolean add(UserVO user) throws RemoteException {
		UserPO newUser = new UserPO(user);
		boolean result = userDAO.insertUser(newUser);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @param userID
	 * 
	 * @return
	 * 
	 * @see businesslogicservice.userblservice.ManageUserInfoService#
	 * getHotelStaffInfo(java.lang.String)
	 */
	@Override
	public HotelStaffInfoVO getHotelStaffInfo(String userID) throws RemoteException {
		this.userID = userID;
		this.hotelStaffInfoVO = null;
		HotelStaffInfoPO hotelStaffInfoPO = userDAO.getHotelStaffInfo(this.userID);
		if (hotelStaffInfoPO != null)
			this.hotelStaffInfoVO = new HotelStaffInfoVO(hotelStaffInfoPO);
		else
			this.hotelStaffInfoVO = null;
		return hotelStaffInfoVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @param userID
	 * 
	 * @return
	 * 
	 * @see
	 * businesslogicservice.userblservice.ManageUserInfoService#getUserInfo(java
	 * .lang.String)
	 */
	@Override
	public UserVO getUserInfo(String userID) throws RemoteException {
		this.userID = userID;
		UserPO userPO = userDAO.getUserInfo(this.userID);
		if (userPO != null)
			this.userVO = new UserVO(userPO);
		else
			this.userVO = null;
		return userVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @param userVO
	 * 
	 * @param userID
	 * 
	 * @return
	 * 
	 * @see
	 * businesslogicservice.userblservice.ManageUserInfoService#modifyUserInfo(
	 * vo.UserVO, java.lang.String)
	 */
	@Override
	public boolean modifyUserInfo(UserVO userVO, String userID) throws RemoteException {
		boolean result = userDAO.updateUser(new UserPO(userVO), userID);
		return result;
	}

}
