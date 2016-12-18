package businesslogicservice.roomblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.RoomVO;

/**
 * 给view层的浏览空房信息任务提供roombl接口
 * @author 双
 * @version 
 * @see
 */
public interface BrowseSpareRoomService {
    
    /**
     * 获取空房信息列表
     * @param address String型， 酒店地址
     * @return ArrayList<RoomVO>，返回空房信息列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<RoomVO> getRoomInfoList (String address) throws RemoteException;
}
