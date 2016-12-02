package businesslogicservice.roomblservice;

import java.util.Date;

import businesslogic.strategybl.exception.WrongInputException;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomType;
import vo.RoomVO;

/**
 * 给view层的更新退房信息任务提供roombl接口
 * @author 双
 * @version 
 * @see
 */
public interface UpdateCheckOutService {

    /**
     * 获取退房信息列表
     * @param address String型， 酒店地址
     * @return ArrayList<RoomVO>，返回退房信息列表
     * @see
     */
    public ArrayList<RoomVO> getCheckOutList(String address);
    
    /**
     * 搜索实际离开时间在某个时间段的退房信息列表
     * @param address String型， 酒店地址
     * @param time Date型，实际离开时间
     * @return ArrayList<RoomVO>型，返回退房信息列表
     * @see
     */
    public ArrayList<RoomVO> searchCheckOutInfo(String address, Date startTime, Date endTime);
    
    /**
     * 按房间类型查找相应的退房信息
     * @param address String型， 酒店地址
     * @param roomType 枚举类，酒店房间类型
     * @return ArrayList<RoomVO>型，返回退房信息列表
     * @see
     */
    public ArrayList<RoomVO> searchCheckOutInfo(String address, Enum<RoomType> roomType);
    
    /**
     * 增加退房信息
     * @param address String型， 酒店地址
     * @param checkIn RoomVO型，退房信息
     * @return boolean型，返回是否增加退房信息成功
     * @throws RemoteException 
     * @throws WrongInputException 
     * @see
     */
    public boolean addCheckOut(String address, RoomVO roomvo) throws RemoteException, WrongInputException;
    
    /**
     *  检查退房信息是否符合规范
     * @param address String型， 酒店地址
     * @param checkIn RoomVO型，退房信息
     * @return boolean型，返回退房信息是否符合规范
     * @throws WrongInputException 
     * @throws RemoteException 
     * @see
     */
    public boolean validCheckOut(String address, RoomVO checkOut) throws WrongInputException, RemoteException;
}
