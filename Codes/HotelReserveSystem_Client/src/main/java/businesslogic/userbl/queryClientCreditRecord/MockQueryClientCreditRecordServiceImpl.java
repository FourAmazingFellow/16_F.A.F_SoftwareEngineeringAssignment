package businesslogic.userbl.queryClientCreditRecord;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;

public class MockQueryClientCreditRecordServiceImpl extends QueryClientCreditRecordServiceImpl{
 @SuppressWarnings("unused")
private UserDAO userDAO = new UserDAOImpl_Stub("原", "qwe123", "12345678900", 500, null);
// private ArrayList<CreditRecordPO> creditRecord;
//    @Override
//    public ArrayList<CreditRecordPO> queryCreditRecord(String userID) {
//        return creditRecord;
//    }
}
