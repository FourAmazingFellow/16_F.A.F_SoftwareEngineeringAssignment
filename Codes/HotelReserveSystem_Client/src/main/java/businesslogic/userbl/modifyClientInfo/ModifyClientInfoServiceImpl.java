package businesslogic.userbl.modifyClientInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyClientInfoService;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.UserVO;

public class ModifyClientInfoServiceImpl implements ModifyClientInfoService{

    private UserDAO userDAO;
    private String userID;
    private String password;
    private String telNum;
    private UserVO userVO;
    
    public ModifyClientInfoServiceImpl(String userID) {
        this.userID = userID;
        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum);
        try {
            this.userVO = new UserVO(userDAO.getUserInfo(this.userID));
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
            userDAO.updateUser(new UserPO(user), "原");
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}
