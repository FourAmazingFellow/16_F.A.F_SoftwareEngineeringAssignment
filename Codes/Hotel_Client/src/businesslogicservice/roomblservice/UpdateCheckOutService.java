package businesslogicservice.roomblservice;

import java.sql.Date;
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
     * 按实际离开时间查找相应的退房信息
     * @param address String型， 酒店地址
     * @param time Date型，实际离开时间
     * @return ArrayList<RoomVO>型，返回退房信息列表
     * @see
     */
    public ArrayList<RoomVO> getCheckOutInfo(String address, Date time);
    
    /**
     * 按房间类型查找相应的退房信息
     * @param address String型， 酒店地址
     * @param roomType 枚举类，酒店房间类型
     * @return ArrayList<RoomVO>型，返回退房信息列表
     * @see
     */
    public ArrayList<RoomVO> getCheckOutInfo(String address, Enum<RoomType> roomType);
    
    /**
     * 增加退房信息
     * @param address String型， 酒店地址
     * @param checkIn RoomVO型，退房信息
     * @return boolean型，返回是否增加退房信息成功
     * @see
     */
    public boolean addCheckOut(String address, RoomVO roomvo);
    
    /**
     * 修改某条退房信息
     * @param address String型， 酒店地址
     * @param checkIn RoomVO型，退房信息
     * @return boolean型，返回是否修改退房信息成功
     * @see
     */
    public boolean modifyCheckOut(String address, RoomVO roomvo);
    
    /**
     *  删除某条退房信息
     * @param address String型， 酒店地址
     * @param checkIn RoomVO型，退房信息
     * @return boolean型，返回是否删除退房信息成功
     * @see
     */
    public boolean delCheckOut(String address, RoomVO roomvo);
    
    /**
     *  检查退房信息是否符合规范
     * @param address String型， 酒店地址
     * @param checkIn RoomVO型，退房信息
     * @return boolean型，返回退房信息是否符合规范
     * @see
     */
    public boolean validCheckOut(String address, RoomVO checkOut);
}
