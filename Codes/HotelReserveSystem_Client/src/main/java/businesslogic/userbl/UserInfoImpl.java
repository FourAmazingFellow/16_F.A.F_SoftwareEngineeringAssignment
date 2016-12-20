package businesslogic.userbl;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.HotelStaffInfoPO;
import vo.HotelStaffInfoVO;

public class UserInfoImpl implements UserInfo{
    
    private UserDAO userDAO;
    
    private FactoryService factoryService;
    
    public UserInfoImpl() {
    	this.factoryService = new FactoryServiceImpl();
    	this.userDAO = factoryService.getUserDAO();
    }
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    @Override
    public boolean insert(HotelStaffInfoVO hotelStaffInfoVO) throws RemoteException {
        userDAO.insertUser(new HotelStaffInfoPO(hotelStaffInfoVO));
        return true;
    }

}
