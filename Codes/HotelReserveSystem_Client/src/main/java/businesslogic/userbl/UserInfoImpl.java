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
    public boolean insert(HotelStaffInfoVO hotelStaffInfoVO) throws RemoteException {
        userDAO = RemoteHelper.getInstance().getUserDAO();
        userDAO.insertUser(new HotelStaffInfoPO(hotelStaffInfoVO));
        return true;
    }

}
