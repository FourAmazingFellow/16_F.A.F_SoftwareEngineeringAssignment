package businesslogic.userbl.addCreditValue;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.userblservice.AddCreditValueService;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.ActionType;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.RegularVipPO;
import po.UserType;

/**
 * 信用充值的实现
 * 
 * @author sparkler
 * @version
 * @see
 */
public class AddCreditValueServiceImpl implements AddCreditValueService {
	private UserDAO userDAO;
	private String userID;
	private int creditValue;
	private int creditResult;
	private int vipRank;
	private ArrayList<CreditRecordPO> creditRecord;

	private FactoryService factoryService;

	public AddCreditValueServiceImpl() {
		this.factoryService = new FactoryServiceImpl();
		this.userDAO = factoryService.getUserDAO();
	}

	@Override
	/**
	 * 增加信用值
	 * 
	 * @param userID，String型，界面传递过来的用户标识
	 * @param creditAdded，int型，界面传递过来的增加的信用值
	 * @return 充值成功则返回true，失败则返回false
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.AddCreditValueService#addCreditValue(java.lang.String,
	 *      int)
	 */
	public boolean addCreditValue(String userID, int creditAdded) throws RemoteException {
		this.userID = userID;
		ClientInfoPO clientInfoPO = new ClientInfoPO();
		clientInfoPO = userDAO.getClientInfo(this.userID);
		this.creditValue = clientInfoPO.getCreditValue();
		this.creditResult = creditValue + creditAdded;

		// creditRecords更新
		this.creditRecord = new ArrayList<>();
		// 获取原本的creditRecords
		creditRecord = userDAO.queryCreditRecord(userID);
		// 订单号为“-1”表示信用充值
		CreditRecordPO creditRecordPO = new CreditRecordPO(new Date(System.currentTimeMillis()), "-1",
				ActionType.RECHARGE, creditAdded, creditResult);
		// 添加新的一条信用记录
		creditRecord.add(creditRecordPO);

		// update普通会员vipRank
		RegularVipPO regularVipPO = null;
		regularVipPO = userDAO.getRegularVipInfo(this.userID);
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
			// 更改过后的vipInfoPO
			RegularVipPO modifiedVipRank = new RegularVipPO(regularVipPO.getUserID(), regularVipPO.getPassword(),
					regularVipPO.getTelNum(), UserType.Client, creditResult, creditRecord, regularVipPO.getBirth(),
					vipRank);
			userDAO.updateRegularVipInfo(modifiedVipRank);
		}

		// update客户信用记录和信用值
		ClientInfoPO modified = new ClientInfoPO(clientInfoPO.getUserID(), clientInfoPO.getPassword(),
				clientInfoPO.getTelNum(), UserType.Client, creditResult, creditRecord);
		boolean result = userDAO.updateClient(modified, userID);
		return result;

	}

}
