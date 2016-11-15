package businesslogic.userbl.modifyClientInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyClientInfoService;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.UserVO;

public class ModifyClientInfoServiceImpl implements ModifyClientInfoService{

    private UserDAO userDAO;
    private String userID;
    private UserType userType;
    private UserVO userVO;
    
    public ModifyClientInfoServiceImpl(String userID) {
        this.userID = userID;
        try {
            this.userVO = new UserVO(userDAO.getUserInfo(this.userID, userType));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public UserVO getUserInfo(String userID, UserType user) {
        return userVO;
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
    
    
}
