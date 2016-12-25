package businesslogic.userbl.queryClientCreditRecord;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.CreditRecordPO;
import vo.CreditRecordVO;

/**
 * 客户查询信用记录
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public class QueryClientCreditRecordServiceImpl implements QueryClientCreditRecordService {

	private UserDAO userDAO;
	private String userID;
	private ArrayList<CreditRecordVO> creditRecordVOs;
	private ArrayList<CreditRecordPO> creditRecordPOs;

	private FactoryService factoryService;

	public QueryClientCreditRecordServiceImpl() {
		this.factoryService = new FactoryServiceImpl();
		this.userDAO = factoryService.getUserDAO();
	}

	@Override
	/**
	 * 查询信用记录
	 * 
	 * @param userID，String型，界面传递过来的客户账号
	 * @return 返回对应的信用记录列表
	 * @throws RemoteException
	 * @see businesslogicservice.userblservice.QueryClientCreditRecordService#queryCreditRecord(java.lang.String)
	 */
	public ArrayList<CreditRecordVO> queryCreditRecord(String userID) throws RemoteException {
		this.userID = userID;
		this.creditRecordPOs = new ArrayList<>();
		this.creditRecordVOs = new ArrayList<>();
		// 获得客户的信用记录PO列表
		creditRecordPOs = userDAO.queryCreditRecord(this.userID);
		// 如果记录为空直接返回null
		if (creditRecordPOs == null) {
			return null;
		} else {
			// 不为空则将PO列表转换成VO列表
			for (CreditRecordPO i : creditRecordPOs) {
				CreditRecordVO creditRecordVO = new CreditRecordVO(i);
				creditRecordVOs.add(creditRecordVO);
			}
			return creditRecordVOs;
		}
	}
}