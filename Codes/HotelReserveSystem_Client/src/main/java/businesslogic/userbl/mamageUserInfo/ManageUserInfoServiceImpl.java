package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public class ManageUserInfoServiceImpl implements ManageUserInfoService{

    private UserDAO userDAO;
    private String userID;
    private UserVO userVO;
    
    public ManageUserInfoServiceImpl(String userID) {
        this.userID = userID;
        try {
            this.userVO = new UserVO(userDAO.getUserInfo(this.userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean modifyUserInfo(UserVO user) {
        try {
            userDAO.updateUser(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(UserVO user) {
        try {
            userDAO.insertUser(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserVO getUserInfo(String userID, UserType user) {
        return userVO;
    }

}
