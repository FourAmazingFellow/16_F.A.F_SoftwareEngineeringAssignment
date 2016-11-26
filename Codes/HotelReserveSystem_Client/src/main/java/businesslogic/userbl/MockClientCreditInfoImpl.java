package businesslogic.userbl;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;

public class MockClientCreditInfoImpl extends ClientCreditInfoImpl{
    private UserDAO userDAO = new UserDAOImpl_Stub("qwe123", "qweqwe", "12312312341", 400, null);
    private UserType userType = UserType.Client;
    private int creditValue = 400;
    private String userID = "qwe123";
    
    @Override
    public int getCreditValue(String userID) {
        try {
            this.creditValue = userDAO.getCreditValue(userID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return creditValue;
    }

    @Override
    public boolean changeCreditValue(String userID, int num) {
        this.userID = userID;
        ClientInfoPO clientInfoPO = new ClientInfoPO(this.userID, null, null, null, creditValue, null);
        creditValue = clientInfoPO.getCreditValue();
        try {
            userDAO.updateUser(new ClientInfoPO(userID, null, null, userType, creditValue, null), "原");;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

}
