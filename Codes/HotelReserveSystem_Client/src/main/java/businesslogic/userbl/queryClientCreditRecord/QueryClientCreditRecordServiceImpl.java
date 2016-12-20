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
	public ArrayList<CreditRecordVO> queryCreditRecord(String userID) throws RemoteException {
		this.userID = userID;
		this.creditRecordPOs = new ArrayList<>();
		this.creditRecordVOs = new ArrayList<>();
		creditRecordPOs = userDAO.queryCreditRecord(this.userID);
		for (CreditRecordPO i : creditRecordPOs) {
			CreditRecordVO creditRecordVO = new CreditRecordVO(i);
			creditRecordVOs.add(creditRecordVO);

		}
		return creditRecordVOs;
	}
}