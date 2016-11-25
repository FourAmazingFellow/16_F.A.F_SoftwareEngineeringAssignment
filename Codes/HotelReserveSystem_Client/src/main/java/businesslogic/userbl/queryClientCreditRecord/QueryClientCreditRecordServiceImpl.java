package businesslogic.userbl.queryClientCreditRecord;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import dataservice.userDAO.UserDAO;
import vo.ClientCreditRecordVO;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public class QueryClientCreditRecordServiceImpl implements QueryClientCreditRecordService {

    private UserDAO userDAO;
    
    @Override
    public ClientCreditRecordVO queryCreditRecord(String userID) {
        try {
            return new ClientCreditRecordVO(userID, userDAO.queryCreditRecord(userID));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }


    
}