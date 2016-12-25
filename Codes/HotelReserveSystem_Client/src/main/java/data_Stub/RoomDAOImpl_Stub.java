package data_Stub;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;

import dataservice.roomDAO.RoomDAO;
import po.CheckInPO;
import po.CheckOutPO;
import po.RoomPO;
import po.RoomType;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class RoomDAOImpl_Stub implements RoomDAO{

    private Enum<RoomType> roomType;
    private int roomNum;
    private int roomPrice;
    private Date checkInTime;
    private Date expDepartTime;
    private Date actDepartTime;
    
    

    public RoomDAOImpl_Stub(Enum<RoomType> roomType, int roomNum, int roomPrice, String address, Date checkInTime,
            Date expDepartTime, Date actDepartTime) {
        super();
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.roomPrice = roomPrice;
        this.checkInTime = checkInTime;
        this.expDepartTime = expDepartTime;
        this.actDepartTime = actDepartTime;
    }

    @Override
    public ArrayList<RoomPO> getSpareRoomInfoList(String address,Date day) throws RemoteException {
        RoomPO roomPO=new RoomPO(roomType, roomNum, roomPrice, address);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public RoomPO getSpareRoomInfo(String address, Enum<RoomType> roomType,Date day) throws RemoteException {
        RoomPO roomPO=new RoomPO(roomType, roomNum, roomPrice, address);
        return roomPO;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfoList(String address) throws RemoteException {
        RoomPO roomPO=new CheckInPO(roomType, roomNum, address, checkInTime, expDepartTime);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfo(String address, Date startTime, Date endTime) throws RemoteException {
        RoomPO roomPO=new CheckInPO(roomType, roomNum, address, startTime, expDepartTime);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfo(String address, Enum<RoomType> roomType) throws RemoteException {
        RoomPO roomPO=new CheckInPO(roomType, roomNum, address, checkInTime, expDepartTime);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfoList(String address) throws RemoteException {
        RoomPO roomPO=new CheckOutPO(roomType, roomNum, address, actDepartTime);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfo(String address, Date startTime, Date endTime) throws RemoteException {
        RoomPO roomPO=new CheckOutPO(roomType, roomNum, address, startTime);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException {
        RoomPO roomPO=new CheckOutPO(roomType, roomNum, address, actDepartTime);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public void updateRoom(RoomPO po,Date day) throws RemoteException {
        System.out.println("更新该房间信息成功");
        
    }

    @Override
    public void insertRoom(RoomPO po) throws RemoteException {
        System.out.println("插入该房间信息成功");
        
    }

    @Override
    public void insertCheckIn(CheckInPO po) throws RemoteException {
        System.out.println("插入该入住信息成功");
    }

    @Override
    public void insertCheckOut(CheckOutPO po) throws RemoteException {
        System.out.println("插入该退房信息成功");
    }
}
