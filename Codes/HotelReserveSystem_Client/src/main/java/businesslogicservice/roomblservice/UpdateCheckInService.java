package businesslogicservice.roomblservice;

import java.util.Date;

import businesslogic.strategybl.exception.WrongInputException;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomType;
import vo.RoomVO;

/**
 * 给界面层提供更新入住信息任所需的方法
 * @author 双
 * @version 
 * @see
 */
public interface UpdateCheckInService {
    
    /**
     * 获取入住信息列表
     * @param address String型， 酒店地址
     * @return ArrayList<RoomVO>，返回入住信息列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<RoomVO> getCheckInList(String address) throws RemoteException;
    
    /**
     * 搜索入住时间在某个时间段的入住信息列表
     * @param address String型， 酒店地址
     * @param time Date型，入住时间
     * @return ArrayList<RoomVO>型，返回入住信息列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<RoomVO> searchCheckInInfo(String address, Date startTime, Date endTime) throws RemoteException;
    
    /**
     * 按房间类型查找相应的入住信息
     * @param address String型， 酒店地址
     * @param roomType 枚举类，酒店房间类型
     * @return ArrayList<RoomVO>型，返回入住信息列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<RoomVO> searchCheckInInfo(String address , Enum<RoomType> roomType) throws RemoteException;
    
    /**
     * 增加入住信息
     * @param address String型， 酒店地址
     * @param checkIn RoomVO型，入住信息
     * @param updateSpareRoom boolean型，是否更新空房
     * @return boolean型，返回是否增加入住信息成功
     * @throws RemoteException 
     * @throws WrongInputException 
     * @see
     */
    public boolean addCheckIn(String address, RoomVO checkIn, boolean updateSpareRoom) throws RemoteException, WrongInputException;

    /**
     * 检查入住信息是否符合规范
     * @param address String型， 酒店地址
     * @param checkIn RoomVO型，入住信息
     * @return boolean型，返回入住信息是否符合规范
     * @throws WrongInputException 
     * @throws RemoteException 
     * @see
     */
    public boolean validCheckIn(String address, RoomVO checkIn) throws WrongInputException, RemoteException;
    
}
