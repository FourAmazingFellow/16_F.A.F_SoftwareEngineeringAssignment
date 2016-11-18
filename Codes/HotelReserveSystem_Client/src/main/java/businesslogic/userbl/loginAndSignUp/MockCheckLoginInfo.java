package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;

public class MockCheckLoginInfo extends CheckLoginInfo{
    private UserDAO userDAO = new UserDAOImpl_Stub("qwe123", "qweqwe", "12312312312");
    private String userID;
    private UserType userType;
    private UserPO userPO;
    private String password;
    
    public boolean checkUser(String userID,String password) {
        this.userID = userID;
        this.userType = null;
        try {
            userPO = userDAO.getUserInfo(this.userID, userType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.password = userPO.getPassword();
        if (this.password == password) {
            return false;
        } else
            return true;
    }
}
