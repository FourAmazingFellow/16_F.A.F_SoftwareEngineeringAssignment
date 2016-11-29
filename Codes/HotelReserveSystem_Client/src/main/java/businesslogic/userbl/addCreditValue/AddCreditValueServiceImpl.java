package businesslogic.userbl.addCreditValue;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.AddCreditValueService;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;
import rmi.RemoteHelper;

public class AddCreditValueServiceImpl implements AddCreditValueService {
    private UserDAO userDAO;
    private String userID;
    private int creditValue;
    private int creditResult;

    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    public AddCreditValueServiceImpl() {
    }

    @Override
    public boolean addCreditValue(String userID, int creditAdded) {
        this.userDAO = RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        ClientInfoPO clientInfoPO = new ClientInfoPO();
        try {
            clientInfoPO = userDAO.getClientInfo(this.userID);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        this.creditValue = clientInfoPO.getCreditValue();
        this.creditResult = creditValue + creditAdded;
        clientInfoPO = new ClientInfoPO(clientInfoPO.getUserID(), clientInfoPO.getPassword(), clientInfoPO.getTelNum(),
                UserType.Client, creditResult, clientInfoPO.getCreditRecord());
        try {
            userDAO.updateClient(clientInfoPO, userID);
            ;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

}
