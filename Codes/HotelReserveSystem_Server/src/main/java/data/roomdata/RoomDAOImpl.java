package data.roomdata;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;

import dataservice.roomDAO.RoomDAO;
import po.CheckInOutPO;
import po.RoomPO;
import po.RoomType;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public ArrayList<RoomPO> getSpareRoomInfoList(String address) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoomPO getSpareRoomInfo(String address, Enum<RoomType> roomType) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfoList(String address) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfo(String address, Date time) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfo(String address, Enum<RoomType> roomType) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfoList(String address) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfo(String address, Date time) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateRoom(RoomPO po) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateCheckInOut(CheckInOutPO po) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertRoom(RoomPO po) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertCheckInOut(CheckInOutPO po) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteRoom(RoomPO po) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteCheckInOut(RoomPO po) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

}
