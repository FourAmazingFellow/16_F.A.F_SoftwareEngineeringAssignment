package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.UserVO;
import vo.WebMarketStaffInfoVO;

public class MockManageUserInfoServicImpl extends ManageUserInfoServicImpl{
   
    UserDAO userDAO;
    UserVO userVO;
    public MockManageUserInfoServicImpl(String userID) {
        super(userID);
        userDAO = new UserDAOImpl_Stub("qwe123", "qweqwe", "11111123424");
        userVO = new UserVO("qwe123", "qweqwe", "12345678905", null);
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
    public boolean add(WebMarketStaffInfoVO webMarketStaff) {
        try {
            userDAO.insert(new UserPO(webMarketStaff));
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
