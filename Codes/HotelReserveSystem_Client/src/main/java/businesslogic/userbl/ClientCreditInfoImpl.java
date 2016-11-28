package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;
import rmi.RemoteHelper;

public class ClientCreditInfoImpl implements ClientCreditInfo{

    private UserDAO userDAO;
    private String userID;
    private int creditValue;
    private int creditResult;
    @Override
    public int getCreditValue(String userID) {
        userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        this.creditValue = 0;
        try {
            this.creditValue = userDAO.getCreditValue(this.userID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return creditValue;
    }

    @Override
    public boolean changeCreditValue(String userID, int num) {
        userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        ClientInfoPO clientInfoPO = null;
        try {
            clientInfoPO = userDAO.getClientInfo(this.userID);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        this.creditValue = clientInfoPO.getCreditValue();
        this.creditResult = creditValue + num;
        clientInfoPO = new ClientInfoPO(clientInfoPO.getUserID(), clientInfoPO.getPassword(), clientInfoPO.getTelNum(), UserType.Client, creditResult, clientInfoPO.getCreditRecord());
        try {
            userDAO.updateClient(clientInfoPO, this.userID);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

}
