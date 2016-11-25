package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;

public class CheckLoginInfo {
    private UserDAO userDAO;
    private String userID;
    private UserPO userPO;
    private String password;
    private String telNum;
    /**
     * 验证登录信息
     * @param userID 业务逻辑层传来的用户标识
     * @param password 业务逻辑层传来的用户密码
     * @return 验证成功则返回true，否则返回false
     * @see
     */
    public boolean checkUser(String userID,String password) {
        this.userID = userID;
        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum);
        try {
            userPO = userDAO.getUserInfo(this.userID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.password = userPO.getPassword();
        if (this.password == password) {
            return true;
        } else
            return false;
    }
}
