package businesslogic.userbl.addCreditValue;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;

public class MockAddCreditValueServiceImpl extends AddCreditValueServiceImpl{

    public MockAddCreditValueServiceImpl() {
        super();
    }

    private UserDAO userDAO = new UserDAOImpl_Stub("原", "qwe123", "12345678900", 500, null);
    private String userID;
    private int creditValue;
//    private int creditResult;
    private ClientInfoPO clientInfoPO;

    @Override
    public boolean addCreditValue(String userID, int creditAdded) {
        this.userID = userID;
        this.clientInfoPO = new ClientInfoPO();
        this.creditValue = 0;
        try {
            this.clientInfoPO = userDAO.getClientInfo(this.userID);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
   //     creditValue = clientInfoPO.getCreditValue();
//        this.creditResult = creditValue + creditAdded;
//        clientInfoPO = new ClientInfoPO(clientInfoPO.getUserID(), clientInfoPO.getPassword(), clientInfoPO.getTelNum(),
//                UserType.Client, creditResult, clientInfoPO.getCreditRecord());
        try {
            userDAO.updateClient(clientInfoPO, userID);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
