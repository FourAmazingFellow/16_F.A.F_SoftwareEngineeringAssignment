package businesslogic.userbl.loginAndSignUp;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;

public class CheckLoginInfo {
    private UserDAO userDAO;
    private String userID;
    private UserType userType;
    private UserPO userPO;
    private String password;
    /**
     * 验证登录信息
     * @param userID 业务逻辑层传来的用户标识
     * @param passpord 业务逻辑层传来的用户密码
     * @return 验证成功则返回true，否则返回false
     * @see
     */
    public boolean checkUser(String userID,String password) {
        this.userID = userID;
        this.userType = null;
        try {
            userPO = userDAO.getUserInfo(this.userID, userType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.password = userPO.getPasspord();
        if (this.password == password) {
            return false;
        } else
            return true;
    }
}
