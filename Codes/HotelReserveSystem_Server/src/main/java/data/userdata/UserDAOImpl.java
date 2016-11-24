package data.userdata;

import java.rmi.RemoteException;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.HotelStaffInfoPO;
import po.UserPO;
import po.UserType;

public class UserDAOImpl implements UserDAO {

    @Override
    public UserPO getUserInfo(String userID, UserType UserType) throws RemoteException {
        return null;
    }

    @Override
    public ClientInfoPO queryCreditRecord(String userID) throws RemoteException {
        return null;
    }

    @Override
    public int getCreditValue(String userID) throws RemoteException {
        return 0;
    }

    @Override
    public void insertUser(UserPO userPO) throws RemoteException {

    }

    @Override
    public void insertClient(ClientInfoPO clientInfoPO) throws RemoteException {

    }

    @Override
    public void insertHotelStaff(HotelStaffInfoPO hotelStaffInfoPO) throws RemoteException {

    }

    @Override
    public void deleteUser(UserPO po) throws RemoteException {

    }

    @Override
    public void updateUser(UserPO po) throws RemoteException {

    }

}
