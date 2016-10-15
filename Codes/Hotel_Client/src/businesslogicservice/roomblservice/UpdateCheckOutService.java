package businesslogicservice.roomblservice;

import java.util.ArrayList;

import po.RoomPO;
import po.RoomType;
import vo.RoomVO;

public interface UpdateCheckOutService {

    /**
     * 
     * @param address
     * @return
     * @see
     */
    public ArrayList<RoomVO> getCheckOutList(String address);
    
    /**
     * 
     * @param address
     * @param time
     * @return
     * @see
     */
    public RoomPO getCheckOutInfo(String address, String time);
    
    /**
     * 
     * @param address
     * @param roomType
     * @return
     * @see
     */
    public RoomPO getCheckOutInfo(String address, Enum<RoomType> roomType);
    
    /**
     * 
     * @param address
     * @param roomvo
     * @return
     * @see
     */
    public boolean AddCheckOut(String address, RoomVO roomvo);
    
    /**
     * 
     * @param address
     * @param roomvo
     * @return
     * @see
     */
    public boolean ModifyCheckOut(String address, RoomVO roomvo);
    
    /**
     * 
     * @param address
     * @param roomvo
     * @return
     * @see
     */
    public boolean delCheckOut(String address, RoomVO roomvo);
    
    /**
     * 
     * @param address
     * @param checkOut
     * @return
     * @see
     */
    public boolean validCheckOut(String address, RoomVO checkOut);
}
