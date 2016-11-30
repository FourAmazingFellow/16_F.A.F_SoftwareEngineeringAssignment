package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.HotelStaffInfoPO;
import rmi.RemoteHelper;
import vo.HotelStaffInfoVO;

public class UserInfoImpl implements UserInfo{
    
    private UserDAO userDAO;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    @Override
    public boolean insert(HotelStaffInfoVO hotelStaffInfoVO) {
       // userDAO = RemoteHelper.getInstance().getUserDAO();
        try {
            userDAO.insertUser(new HotelStaffInfoPO(hotelStaffInfoVO));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } 
    }

}
