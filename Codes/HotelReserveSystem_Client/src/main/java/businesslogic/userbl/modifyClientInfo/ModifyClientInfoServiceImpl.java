package businesslogic.userbl.modifyClientInfo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.ModifyClientInfoService;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.RegularVipPO;
import po.UserType;
import vo.ClientInfoVO;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;
import vo.UserVO;

/**
 * 客户维护自己的基本信息
 * 
 * @author sparkler
 * @version
 * @see
 */
public class ModifyClientInfoServiceImpl implements ModifyClientInfoService {

	private UserDAO userDAO;
	private String userID;
	private ClientInfoVO clientInfoVO;

	private FactoryService factoryService;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ModifyClientInfoServiceImpl() {
		this.factoryService = new FactoryServiceImpl();
		this.userDAO = factoryService.getUserDAO();
	}

	@Override
	/**
	 * 获得客户当前的信息
	 * 
	 * @param userID，String型，界面传递过来的客户标识
	 * @return 返回客户信息
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.ModifyClientInfoService#getClientInfo(java.lang.String)
	 */
	public ClientInfoVO getClientInfo(String userID) throws RemoteException {
		this.userID = userID;
		// 获得客户的信息PO
		ClientInfoPO clientInfoPO = userDAO.getClientInfo(this.userID);
		// PO转VO，若为空则VO为null
		if (clientInfoPO != null)
			this.clientInfoVO = new ClientInfoVO(clientInfoPO);
		else
			this.clientInfoVO = null;

		// 得到该客户的会员信息
		EnterpriseVipPO enterpriseVipPO = userDAO.getEnterpriseVipInfo(userID);
		RegularVipPO regularVipPO = userDAO.getRegularVipInfo(userID);
		// 若该客户是会员，则将其对应的会员VO返回，若不是则直接返回clientinfoVO
		if (clientInfoPO != null) {
			// 判断其是否为企业会员
			if (enterpriseVipPO.getEnterpriseID() != null) {
				EnterpriseVipVO enterpriseVipVO = new EnterpriseVipVO(clientInfoVO.userID, clientInfoVO.password,
						clientInfoVO.telNum, clientInfoVO.userType, clientInfoVO.creditValue, clientInfoVO.creditRecord,
						enterpriseVipPO.getEnterpriseID(), enterpriseVipPO.getEnterprisepassword());
				return enterpriseVipVO;
			}
			// 判断其是否为普通会员
			else if (regularVipPO.getBirth() != null) {
				RegularVipVO regularVipVO = new RegularVipVO(clientInfoVO.userID, clientInfoVO.password,
						clientInfoVO.telNum, clientInfoVO.userType, clientInfoVO.creditValue, clientInfoVO.creditRecord,
						regularVipPO.getBirth(), regularVipPO.getVipRank());
				return regularVipVO;
			} else {
				return clientInfoVO;
			}
		} else
			return null;
	}

	@Override
	/**
	 * 客户修改自己的信息
	 * 
	 * @param user，UserVO型，界面传递过来的用户信息
	 * @param oldUserID，String型，界面传递过来的原本的用户账号
	 * @return 修改成功则返回true，失败则返回false
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.ModifyClientInfoService#modifyClientInfo(vo.UserVO,
	 *      java.lang.String)
	 */
	public boolean modifyClientInfo(UserVO user, String oldUserID) throws RemoteException {
		this.clientInfoVO = getClientInfo(oldUserID);
		// 获得客户的信用记录，数据层中getClientInfo时信用记录是空的，信用记录必须另外获得
		ArrayList<CreditRecordPO> creditRecords = userDAO.queryCreditRecord(oldUserID);
		ClientInfoPO modified = new ClientInfoPO(user.userID, user.password, user.telNum, UserType.Client,
				clientInfoVO.creditValue, creditRecords);
		boolean result = userDAO.updateClient(modified, oldUserID);
		return result;
	}

}
