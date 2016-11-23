package businesslogic.userbl.addCreditValue;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;

public class MockAddCreditValueServiceImpl extends AddCreditValueServiceImpl{

    public MockAddCreditValueServiceImpl(String userID, UserType userType) {
        super();
    }

    UserDAO userDAO = new UserDAOImpl_Stub("qwe123", "qweqwe", "12345678901", 300, null);

    @Override
    public boolean addCreditValue(String userID, int creditAdded) {
        this.userID = userID;
        ClientInfoPO clientInfoPO = new ClientInfoPO(this.userID, null, null, null, creditValue, null);
        creditValue = clientInfoPO.getCreditValue();
        try {
            userDAO.updateUser(new ClientInfoPO(userID, null, null, userType, creditValue+creditAdded, null));;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
