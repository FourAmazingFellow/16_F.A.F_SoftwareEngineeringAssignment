package data_Stub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.roomDAO.RoomDAO;
import po.CheckInOutPO;
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
    private String address;
    private Date checkInTime;
    private Date expDepartTime;
    private Date actDepartTime;
    
    public RoomDAOImpl_Stub(Enum<RoomType> roomType, int roomNum, int roomPrice, String address) {
        super();
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.roomPrice = roomPrice;
        this.address = address;
    }

    @Override
    public ArrayList<RoomPO> getSpareRoomInfoList(String address) throws RemoteException {
        RoomPO roomPO=new RoomPO(roomType, roomNum, roomPrice, address);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public RoomPO getSpareRoomInfo(String address, Enum<RoomType> roomType) throws RemoteException {
        RoomPO roomPO=new RoomPO(roomType, roomNum, roomPrice, address);
        return roomPO;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfoList(String address) throws RemoteException {
        RoomPO roomPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public RoomPO getCheckInInfo(String address, String time) throws RemoteException {
        RoomPO roomPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        return roomPO;
    }

    @Override
    public RoomPO getCheckInInfo(String address, Enum<RoomType> roomType) throws RemoteException {
        RoomPO roomPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        return roomPO;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfoList(String address) throws RemoteException {
        RoomPO roomPO=new CheckInOutPO(roomType, roomNum, address, actDepartTime);
        ArrayList<RoomPO> arrayList=new ArrayList<RoomPO>();
        arrayList.add(roomPO);
        return arrayList;
    }

    @Override
    public RoomPO getCheckOutInfo(String address, String time) throws RemoteException {
        RoomPO roomPO=new CheckInOutPO(roomType, roomNum, address, actDepartTime);
        return roomPO;
    }

    @Override
    public RoomPO getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException {
        RoomPO roomPO=new CheckInOutPO(roomType, roomNum, address, actDepartTime);
        return roomPO;
    }

    @Override
    public RoomPO find(long id) throws RemoteException {
        RoomPO roomPO=new CheckInOutPO(roomType, roomNum, address, actDepartTime);
        return roomPO;
    }

    @Override
    public void update(RoomPO po) throws RemoteException {
        System.out.println("更新该房间信息成功");
        
    }

    @Override
    public void insert(RoomPO po) throws RemoteException {
        System.out.println("插入该房间信息成功");
        
    }

    @Override
    public void delete(RoomPO po) throws RemoteException {
        System.out.println("删除该房间信息成功");
        
    }

    @Override
    public void init() throws RemoteException {
        System.out.println("初始化room持久化数据存储成功");
        
    }

    @Override
    public void finish() throws RemoteException {
        System.out.println("结束room持久化数据存储的使用成功");
        
    }

}
