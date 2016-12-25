package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelStaffInfoPO;
import vo.HotelStaffInfoVO;

/**
 * 供同层间调用的用户相关信息
 * 
 * @author sparkler
 * @version
 * @see
 */
public class UserInfoImpl implements UserInfo {

	private UserDAO userDAO;

	private FactoryService factoryService;

	public UserInfoImpl() {
		this.factoryService = new FactoryServiceImpl();
		this.userDAO = factoryService.getUserDAO();
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	/**
	 * 酒店管理人员添加酒店工作人员
	 * 
	 * @param hotelStaffInfoVO，HotelStaffInfoVO型，业务逻辑层传递过来的酒店工作人员信息
	 * @return 添加成功则返回true，添加失败则返回false
	 * @throws RemoteException
	 * @see businesslogic.userbl.UserInfo#insert(vo.HotelStaffInfoVO)
	 */
	public boolean insert(HotelStaffInfoVO hotelStaffInfoVO) throws RemoteException {
		boolean result = userDAO.insertUser(new HotelStaffInfoPO(hotelStaffInfoVO));
		return result;
	}

}
