package businesslogic.userbl.signVip;

import java.rmi.RemoteException;

import businesslogic.strategybl.VerifyEnterpriseVipImpl;
import businesslogic.userbl.VerifyEnterpriseVip;
import businesslogicservice.userblservice.SignVipService;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.EnterpriseVipPO;
import po.RegularVipPO;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

/**
 * 客户注册会员
 * 
 * @author sparkler
 * @version
 * @see
 */
public class SignVipServiceImpl implements SignVipService {

	private UserDAO userDAO;
	private VerifyEnterpriseVip verifyEnterpriseVip = new VerifyEnterpriseVipImpl();

	private FactoryService factoryService;

	public SignVipServiceImpl() {
		this.factoryService = new FactoryServiceImpl();
		this.userDAO = factoryService.getUserDAO();
	}

	@Override
	/**
	 * 注册普通会员
	 * 
	 * @param regularVip，界面传递过来的普通会员信息
	 * @return 注册成功则返回true，失败则返回false
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.SignVipService#signRegularVip(vo.RegularVipVO)
	 */
	public boolean signRegularVip(RegularVipVO regularVip) throws RemoteException {
		boolean result = userDAO.signRegularVip(new RegularVipPO(regularVip));
		return result;
	}

	@Override
	/**
	 * 注册企业会员
	 * 
	 * @param enterpriseVip，界面传递过来的企业会员信息
	 * @return 注册成功则返回true，失败则返回false
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.SignVipService#signEnterpriseVip(vo.EnterpriseVipVO)
	 */
	public boolean signEnterpriseVip(EnterpriseVipVO enterpriseVip) throws RemoteException {
		boolean check = false;
		// 调用同层验证企业会员的方法，验证企业ID和企业密码是否正确
		check = verifyEnterpriseVip.verifyEnterpriseMember(enterpriseVip.enterpriseID,
				enterpriseVip.enterprisePassword);
		if (check == true) {
			boolean result = userDAO.signEnterpriseVip(new EnterpriseVipPO(enterpriseVip));
			return result;
		} else
			return false;
	}
}
