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
     * 
     * @param address
     * @return
     * @see
     */
    public ArrayList<RoomVO> getRoomInfoList (String address);
}
