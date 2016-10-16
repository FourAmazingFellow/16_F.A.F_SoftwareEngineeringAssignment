package businesslogicservice.roomblservice;

import java.util.ArrayList;

import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public interface BrowseSpareRoomService {
    
    /**
     * 获取空房信息列表
     * @param address String型， 酒店地址
     * @return ArrayList<RoomVO>，返回空房信息列表
     * @see
     */
    public ArrayList<RoomVO> getRoomInfoList (String address);
}
