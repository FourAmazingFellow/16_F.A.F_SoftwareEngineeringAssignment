package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.UserVO;
import vo.WebMarketStaffInfoVO;

public class MockManageUserInfoServiceImpl extends ManageUserInfoServiceImpl{
   
    UserDAO userDAO;
    UserVO userVO;
    public MockManageUserInfoServiceImpl(String userID) {
        super(userID);
        userDAO = new UserDAOImpl_Stub("qwe123", "qweqwe", "11111123424");
        userVO = new UserVO("qwe123", "qweqwe", "12345678905", null);
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
    public boolean add(WebMarketStaffInfoVO webMarketStaff) {
        try {
            userDAO.insertUser(new UserPO(webMarketStaff));
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
