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
        userDAO = new UserDAOImpl_Stub("原", "qwe123", "12345678900");
        userVO = new UserVO("原", "qwe123", "12345678900", null);
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
