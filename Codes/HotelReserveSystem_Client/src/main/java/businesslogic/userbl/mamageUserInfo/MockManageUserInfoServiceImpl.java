package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.UserVO;

public class MockManageUserInfoServiceImpl extends ManageUserInfoServiceImpl{
   
    UserDAO userDAO;
    UserVO userVO;
    public MockManageUserInfoServiceImpl(String userID) {
        super(userID);
        userDAO = new UserDAOImpl_Stub("原", "qwe123", "1234567890");
        userVO = new UserVO("原", "qwe123", "12345678900", null);
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
        return userVO;
    }
}
