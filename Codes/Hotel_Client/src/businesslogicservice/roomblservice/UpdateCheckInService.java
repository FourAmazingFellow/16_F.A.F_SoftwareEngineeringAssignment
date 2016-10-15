package businesslogicservice.roomblservice;

import java.util.ArrayList;

import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public interface UpdateCheckInService {
    
    /**
     * 
     * @param address
     * @return
     * @see
     */
    public ArrayList<RoomVO> getCheckInList(String address);
    
    /**
     * 
     * @param address
     * @param time
     * @return
     * @see
     */
    public RoomVO searchCheckInInfo(String address ,String time);
    
    /**
     * 
     * @param address
     * @param roomType
     * @return
     * @see
     */
    public RoomVO searchCheckInInfo(String address , Enum<RoomType> roomType);
    
    /**
     * 
     * @param address
     * @param checkIn
     * @return
     * @see
     */
    public boolean AddCheckIn(String address, RoomVO checkIn);
    
    /**
     * 
     * @param address
     * @param checkIn
     * @return
     * @see
     */
    public boolean ModifyCheckIn(String address, RoomVO checkIn);
    
    /**
     * 
     * @param address
     * @param checkIn
     * @return
     * @see
     */
    public boolean delCheckIn(String address, RoomVO checkIn);
    
    /**
     * 
     * @param address
     * @param checkIn
     * @return
     * @see
     */
    public boolean validCheckIn(String address, RoomVO checkIn);
    
}
