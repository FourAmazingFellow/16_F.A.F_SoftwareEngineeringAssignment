package businesslogic.userbl.mamageUserInfo;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.HotelStaffInfoVO;
import vo.UserVO;

public class MockManageUserInfoServiceImpl extends ManageUserInfoServiceImpl {

    private UserDAO userDAO;
    private UserVO webManageStaff;
    private HotelStaffInfoVO hotelStaffInfoVO;

    public MockManageUserInfoServiceImpl(String userID) {
        super(userID);
        userDAO = new UserDAOImpl_Stub("原", "qwe123", "12345678900");
        webManageStaff = new UserVO("原", "qwe123", "12345678900", UserType.WebManageStaff);
      //  new UserVO("wmarket123", "qwe123", "12345678901", UserType.WebMarketStaff);
        hotelStaffInfoVO = new HotelStaffInfoVO("原", "qwe123", "12345678900", UserType.HotelStaff,
                "江苏省南京市栖霞区仙林大道163号");
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
    public HotelStaffInfoVO getHotelStaffInfo(String userID) {
        return hotelStaffInfoVO;
    }

    @Override
    public UserVO getUserInfo(String userID) {
        return webManageStaff;
    }

    @Override
    public boolean modifyUserInfo(UserVO userVO, String userID) {
        try {
            userDAO.updateUser(new UserPO(userVO), userID);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

}
