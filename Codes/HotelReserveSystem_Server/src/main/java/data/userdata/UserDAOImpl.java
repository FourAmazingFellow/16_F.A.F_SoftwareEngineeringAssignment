package data.userdata;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.EnterpriseVipPO;
import po.HotelStaffInfoPO;
import po.RegularVipPO;
import po.UserPO;
import po.UserType;

public class UserDAOImpl implements UserDAO {

    @Override
    public UserPO getUserInfo(String userID, UserType userType) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClientInfoPO getClientInfo(String userID) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HotelStaffInfoPO getHotelStaffInfo(String userID) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClientInfoPO queryCreditRecord(String userID) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getCreditValue(String userID) throws RemoteException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void insertUser(UserPO userPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertClient(ClientInfoPO clientInfoPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertHotelStaff(HotelStaffInfoPO hotelStaffInfoPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateUser(UserPO userPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateClient(ClientInfoPO clientInfoPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void signRegularVip(RegularVipPO regularVipPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void signEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

   
}
