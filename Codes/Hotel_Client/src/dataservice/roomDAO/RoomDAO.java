package dataservice.roomDAO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomPO;
import po.RoomType;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public interface RoomDAO {
    
    /**
     * 
     * @param address
     * @return
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getSpareRoomInfoList(String address) throws RemoteException;
    
    /**
     * 
     * @param address
     * @param roomType
     * @return
     * @throws RemoteException
     * @see
     */
    public RoomPO getSpareRoomInfo(String address , Enum<RoomType> roomType) throws RemoteException;
    
    
    /**
     * 
     * @param address
     * @return
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getCheckInInfoList(String address) throws RemoteException;
    
    /**
     * 
     * @param address
     * @param time
     * @return
     * @throws RemoteException
     * @see
     */
    public RoomPO getCheckInInfo(String address , String time) throws RemoteException;
    
    /**
     * 
     * @param address
     * @param roomType
     * @return
     * @throws RemoteException
     * @see
     */
    public RoomPO getCheckInInfo (String address, Enum<RoomType> roomType) throws RemoteException;
    
    /**
     * 
     * @param address
     * @return
     * @throws RemoteException
     * @see
     */
    public ArrayList<RoomPO> getCheckOutInfoList(String address) throws RemoteException;
    
    /**
     * 
     * @param address
     * @param time
     * @return
     * @throws RemoteException
     * @see
     */
    public RoomPO getCheckOutInfo(String address, String time) throws RemoteException;
    
    /**
     * 
     * @param address
     * @param roomType
     * @return
     * @throws RemoteException
     * @see
     */
    public RoomPO getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException;
    
    /**
     * 
     * @param id
     * @return
     * @throws RemoteException
     * @see
     */
    public RoomPO find(long id) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void update(RoomPO po) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void insert(RoomPO po) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void delete(RoomPO po) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void init(RoomPO po) throws RemoteException;
    
    /**
     * 
     * @param po
     * @throws RemoteException
     * @see
     */
    public void finish(RoomPO po) throws RemoteException;
    
}
