package businesslogic.userbl.queryClientCreditRecord;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import dataservice.userDAO.UserDAO;
import vo.CreditRecordVO;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public class QueryClientCreditRecordServiceImpl implements QueryClientCreditRecordService {

    private UserDAO userDAO;
    
    @Override
    public CreditRecordVO queryCreditRecord(String userID) {
        try {
            return new CreditRecordVO(userID, userDAO.queryCreditRecord(userID));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }


    
}