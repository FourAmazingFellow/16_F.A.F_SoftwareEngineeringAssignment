package businesslogic.userbl;

import java.rmi.RemoteException;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

/**
 * 供同层调用的会员相关信息
 * 
 * @author sparkler
 * @version
 * @see
 */
public class VipInfoImpl implements VipInfo {
	private RegularVipVO regularVipVO;
	private EnterpriseVipVO enterpriseVipVO;
	private UserDAO userDAO;
	private String userID;

	private FactoryService factoryService;

	public VipInfoImpl() {
		factoryService = new FactoryServiceImpl();
		this.userDAO = factoryService.getUserDAO();
	}

	@Override
	/**
	 * 获取普通会员信息
	 * 
	 * @param ID，String型，业务逻辑层传递过来的用户标识
	 * @return 返回普通会员信息
	 * @throws RemoteException
	 * @see businesslogic.userbl.VipInfo#getRegularVipInfo(java.lang.String)
	 */
	public RegularVipVO getRegularVipInfo(String userID) throws RemoteException {
		this.userID = userID;
		this.regularVipVO = new RegularVipVO(userDAO.getRegularVipInfo(this.userID));
		return regularVipVO;
	}

	@Override
	/**
	 * 获取企业会员信息
	 * 
	 * @param ID，String型，业务逻辑层传递过来的用户标识
	 * @return 返回企业会员信息
	 * @throws RemoteException
	 * @see businesslogic.userbl.VipInfo#getEnterpriseVipInfo(java.lang.String)
	 */
	public EnterpriseVipVO getEnterpriseVipInfo(String userID) throws RemoteException {
		this.userID = userID;
		this.enterpriseVipVO = new EnterpriseVipVO(userDAO.getEnterpriseVipInfo(this.userID));
		return enterpriseVipVO;
	}

}
