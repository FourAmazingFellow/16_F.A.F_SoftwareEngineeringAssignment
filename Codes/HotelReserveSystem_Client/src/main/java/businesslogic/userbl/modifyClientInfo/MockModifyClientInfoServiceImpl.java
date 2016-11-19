package businesslogic.userbl.modifyClientInfo;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.UserVO;

public class MockModifyClientInfoServiceImpl extends ModifyClientInfoServiceImpl{

    private UserDAO userDAO;
    private UserVO userVO;
    
    public MockModifyClientInfoServiceImpl(String userID) {
        super(userID);
        userDAO = new UserDAOImpl_Stub("qwe123", "qweqwe", "1234567896");
        userVO = new UserVO("qwe123", "qweqwe", "12345678965", null);
    }

    @Override
    public UserVO getUserInfo(String userID, UserType user) {
        return userVO;
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
    
}
