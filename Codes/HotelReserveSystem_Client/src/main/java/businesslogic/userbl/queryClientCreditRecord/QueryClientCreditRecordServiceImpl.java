package businesslogic.userbl.queryClientCreditRecord;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import dataservice.userDAO.UserDAO;
import po.CreditRecordPO;
import rmi.RemoteHelper;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public class QueryClientCreditRecordServiceImpl implements QueryClientCreditRecordService {

    private UserDAO userDAO;
    private String userID;
    private ArrayList<CreditRecordPO> creditRecord;
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    @Override
    public ArrayList<CreditRecordPO> queryCreditRecord(String userID) {
        userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        this.creditRecord = new ArrayList<>();
        try {
            creditRecord = userDAO.queryCreditRecord(this.userID);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        return creditRecord;
    }


    
}