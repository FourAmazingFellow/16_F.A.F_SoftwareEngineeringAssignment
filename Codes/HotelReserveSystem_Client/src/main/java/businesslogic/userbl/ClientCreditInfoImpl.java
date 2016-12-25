package businesslogic.userbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.ActionType;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.RegularVipPO;
import po.UserType;

/**
 * 供同层间调用的客户信用值相关信息
 * @author sparkler
 * @version 
 * @see
 */
public class ClientCreditInfoImpl implements ClientCreditInfo {

	private UserDAO userDAO;
	private String userID;
	private int creditValue;
	private int creditResult;
	private int vipRank;
	private ArrayList<CreditRecordPO> creditRecord;
	private ClientInfoPO clientInfoPO;

	private FactoryService factory;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ClientCreditInfoImpl() {
		factory = new FactoryServiceImpl();
		userDAO = factory.getUserDAO();
	}

	@Override
	/**
	 * 获取客户当前的信用值
	 * 
	 * @param userID，String型，业务逻辑层传递过来的用户标识
	 * @return 返回客户当前信用值
	 * @throws RemoteException
	 * @see businesslogic.userbl.ClientCreditInfo#getCreditValue(java.lang.String)
	 */
	public int getCreditValue(String userID) throws RemoteException {
		this.userID = userID;
		this.creditValue = 0;
		this.creditValue = userDAO.getCreditValue(this.userID);
		return creditValue;
	}

	@Override
	/**
	 * 改变客户的信用值（有订单变化）
	 * 
	 * @param userID,String型，业务逻辑层传递过来的用户标识
	 * @param num，int型，业务逻辑层传递过来的增加的信用值
	 * @param orderID，String型，业务逻辑层传递过来的订单号
	 * @param actionType， ActionType型，业务逻辑层传递过来的订单变化类型
	 * @return 改变成功则返回true，改变失败则返回false
	 * @throws RemoteException
	 * @see businesslogic.userbl.ClientCreditInfo#changeCreditValue(java.lang.String,
	 *      int, java.lang.String, po.ActionType)
	 */
	public boolean changeCreditValue(String userID, int num, String orderID, ActionType actionType)
			throws RemoteException {
		this.userID = userID;
		this.creditValue = 0;
		this.clientInfoPO = userDAO.getClientInfo(this.userID);
		creditValue = clientInfoPO.getCreditValue();
		this.creditResult = creditValue + num;

		// update普通会员vipRank
		RegularVipPO regularVipPO = null;
		regularVipPO = userDAO.getRegularVipInfo(this.userID);

		this.creditRecord = new ArrayList<CreditRecordPO>();
		creditRecord = userDAO.queryCreditRecord(this.userID);

		if (regularVipPO != null) {
			// 判断信用值属于那个范围，对应vipRank
			if (creditResult <= 600)
				this.vipRank = 0;
			else if (creditResult > 600 && creditResult <= 2000)
				this.vipRank = 1;
			else if (creditResult > 2000 && creditResult <= 6000)
				this.vipRank = 2;
			else if (creditResult > 6000 && creditResult <= 12000)
				this.vipRank = 0000000000000003;
			else if (creditResult > 12000)
				this.vipRank = 4;

			RegularVipPO modifiedVipRank = new RegularVipPO(regularVipPO.getUserID(), regularVipPO.getPassword(),
					regularVipPO.getTelNum(), UserType.Client, creditResult, creditRecord, regularVipPO.getBirth(),
					vipRank);
			userDAO.updateRegularVipInfo(modifiedVipRank);
		}
		// update信用记录和信用值
		CreditRecordPO creditRecordPO = new CreditRecordPO(new Date(System.currentTimeMillis()), orderID, actionType,
				num, creditResult);
		creditRecord.add(creditRecordPO);
		ClientInfoPO modified = new ClientInfoPO(clientInfoPO.getUserID(), clientInfoPO.getPassword(),
				clientInfoPO.getTelNum(), UserType.Client, creditResult, creditRecord);
		boolean result = userDAO.updateClient(modified, this.userID);
		return result;
	}

}
