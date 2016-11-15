package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;

public class ClientCreditInfoImpl implements ClientCreditInfo{

    private UserDAO userDAO;
    private UserType userType;
    private int creditValue;
    private String userID;
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
            userDAO.update(new ClientInfoPO(userID, null, null, userType, creditValue, null));;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

}
