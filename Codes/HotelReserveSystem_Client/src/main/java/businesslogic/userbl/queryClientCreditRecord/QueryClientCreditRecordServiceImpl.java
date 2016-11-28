package businesslogic.userbl.queryClientCreditRecord;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import dataservice.userDAO.UserDAO;
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
    
    @Override
    public CreditRecordVO queryCreditRecord(String userID) {
        userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        try {
            return new CreditRecordVO(userID, userDAO.queryCreditRecord(this.userID));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }


    
}