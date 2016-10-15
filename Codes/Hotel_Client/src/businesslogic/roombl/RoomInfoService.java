package businesslogic.roombl;

import java.sql.Date;

import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public interface RoomInfoService {
    
    /**
     * 
     * @param address
     * @param roomType
     * @return
     * @see
     */
    public int getAvailableRoomNum(String address, Enum<RoomType> roomType);
    
    /**
     * 
     * @param addresss
     * @param roomType
     * @param beginDate
     * @param finishDate
     * @return
     * @see
     */
    public boolean isTimeAvailable (String addresss, Enum<RoomType> roomType, Date beginDate, Date finishDate);
    
    /**
     * 
     * @param address
     * @param roomvo
     * @return
     * @see
     */
    public boolean updateSpareRoom (String address, RoomVO roomvo);
    
    /**
     * 
     * @param address
     * @param change
     * @param roomType
     * @return
     * @see
     */
    public boolean reduceRoom(String address, int change, Enum<RoomType> roomType);
    
    /**
     * 
     * @param address
     * @param change
     * @param roomType
     * @return
     * @see
     */
    public boolean addRoom(String address, int change, Enum<RoomType> roomType);
    
}
