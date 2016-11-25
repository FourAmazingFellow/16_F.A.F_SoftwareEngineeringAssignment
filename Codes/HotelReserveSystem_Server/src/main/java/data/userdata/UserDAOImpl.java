package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.HotelStaffInfoPO;
import po.RegularVipPO;
import po.UserPO;

public class UserDAOImpl implements UserDAO {

    @Override
    public UserPO getUserInfo(String userID) throws RemoteException {
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

    @Override
    public ArrayList<CreditRecordPO> queryCreditRecord(String userID) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RegularVipPO getRegularVipInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EnterpriseVipPO getEnterpriseVipInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

   
}
