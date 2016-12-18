package businesslogic.userbl.queryClientCreditRecord;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import dataservice.userDAO.UserDAO;
import po.CreditRecordPO;
import rmi.RemoteHelper;
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

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public ArrayList<CreditRecordVO> queryCreditRecord(String userID) throws RemoteException {
		userDAO = RemoteHelper.getInstance().getUserDAO();
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