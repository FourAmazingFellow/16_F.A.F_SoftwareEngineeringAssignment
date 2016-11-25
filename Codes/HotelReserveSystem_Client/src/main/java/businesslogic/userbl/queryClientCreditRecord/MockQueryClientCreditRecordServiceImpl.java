package businesslogic.userbl.queryClientCreditRecord;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import vo.ClientCreditRecordVO;

public class MockQueryClientCreditRecordServiceImpl extends QueryClientCreditRecordServiceImpl{
 private UserDAO userDAO = new UserDAOImpl_Stub("原", "qwe123", "12345678900", 500, null);
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
