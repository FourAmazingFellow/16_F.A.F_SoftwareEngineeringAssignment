package dataservice.roomDAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.CheckInOutPO;
import po.RoomPO;
import po.RoomType;

/**
 * 为业务逻辑层提供所需要的酒店房间数据
 * @author 双
 * @version 
 * @see
 */
public interface RoomDAO extends Remote{
    
    /**
     * 获取空房信息列表
     * @param address String型，业务逻辑层传递来的酒店地址
     * @return 返回空房信息列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getSpareRoomInfoList(String address) throws RemoteException;
    
    /**
     * 获取对应房间类型的空房信息
     * @param address String型，业务逻辑层传递来的酒店地址
     * @param roomType Enum型，房间类型
     * @return RooomPO型，返回空房信息
     * @throws RemoteException
     * @see
     */
    public RoomPO getSpareRoomInfo(String address , Enum<RoomType> roomType) throws RemoteException;
    
    
    /**
     * 获取入住信息列表
     * @param address String型，业务逻辑层传递来的酒店地址
     * @return 返回入住信息列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getCheckInInfoList(String address) throws RemoteException;
    
    /**
     * 获取对应入住时间的入住信息
     * @param address String型，业务逻辑层传递来的酒店地址
     * @param time Date型，入住时间
     * @return ArrayList<RoomPO>型，返回入住信息列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getCheckInInfo(String address , Date time) throws RemoteException;
    
    /**
     * 获取对应房间类型的入住信息
     * @param address String型，业务逻辑层传递来的酒店地址
     * @param roomType Enum型，房间类型
     * @return ArrayList<RoomPO>型，返回入住信息列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getCheckInInfo (String address, Enum<RoomType> roomType) throws RemoteException;
    
    /**
     * 获取退房信息列表
     * @param address String型，业务逻辑层传递来的酒店地址
     * @return 返回退房信息列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getCheckOutInfoList(String address) throws RemoteException;
    
    /**
     * 获取对应实际离开时间的退房信息
     * @param address String型，业务逻辑层传递来的酒店地址
     * @param time Date型，实际离开时间
     * @return ArrayList<RoomPO>型，返回退房信息列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getCheckOutInfo(String address, Date time) throws RemoteException;
    
    /**
     * 获取对应房间类型的退房信息
     * @param address String型，业务逻辑层传递来的酒店地址
     * @param roomType Enum型，房间类型
     * @return ArrayList<RoomPO>型，返回退房信息列表
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException;
    
    
    /**
     * 更新某个房间信息
     * @param po RoomPO型，业务逻辑层传递来的房间信息
     * @throws RemoteException
     * @see
     */
    public void updateRoom(RoomPO po) throws RemoteException;
    
    /**
     * 更新某个入住或退房信息
     * @param po CheckInOutPO型，业务逻辑层传递来的入住或退房信息
     * @throws RemoteException
     * @see
     */
    public void updateCheckInOut(CheckInOutPO po) throws RemoteException;
    
    /**
     * 插入一个房间信息
     * @param po RoomPO型，业务逻辑层传递来的房间信息
     * @throws RemoteException
     * @see
     */
    public void insertRoom(RoomPO po) throws RemoteException;
    
    /**
     * 插入一个入住或退房信息
     * @param po CheckInOutPO型，业务逻辑层传递来的入住或退房信息
     * @throws RemoteException
     * @see
     */
    public void insertCheckInOut(CheckInOutPO po) throws RemoteException;
    
    /**
     * 删除一个房间信息
     * @param po RoomPO型，业务逻辑层传递来的房间信息
     * @throws RemoteException
     * @see
     */
    public void deleteRoom(RoomPO po) throws RemoteException;
    
    /**
     * 删除一个入住或退房信息
     * @param po CheckInOutPO型，业务逻辑层传递来的入住或退房信息
     * @throws RemoteException
     * @see
     */
    public void deleteCheckInOut(RoomPO po) throws RemoteException;
}
