package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ManageUserInfoService;
import data_Stub.UserDAOImpl_Stub;
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
    private UserType userType;
    private String userID;
    private String password;
    private String telNum;
    private UserVO userVO;
    
    public ManageUserInfoServiceImpl(String userID) {
        this.userID = userID;
        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum);
        try {
            userVO = new UserVO(userDAO.getUserInfo(this.userID, userType));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean modifyUserInfo(UserVO user) {
        try {
            userDAO.update(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(UserVO user) {
        try {
            userDAO.insert(new UserPO(user));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserVO getUserInfo(String userID, UserType user) {
        this.userID = userID;
        try {
            userVO = new UserVO(userDAO.getUserInfo(userID, user));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return userVO;
    }

}
