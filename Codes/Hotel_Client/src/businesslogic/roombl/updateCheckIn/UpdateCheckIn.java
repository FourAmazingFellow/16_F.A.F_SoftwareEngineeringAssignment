package businesslogic.roombl.updateCheckIn;

import java.util.ArrayList;
import java.util.Date;

import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateCheckIn {

    /**
     * 得到入住信息列表
     * @param address String型，酒店地址
     * @return ArrayList<RoomVO>型，入住信息VO列表 
     * @see
     */
    ArrayList<RoomVO> getCheckInList(String address){
        return null;
    }
    
    /**
     * 根据入住时间搜索入住信息
     * @param address string型，酒店地址
     * @param time Date型，入住时间
     * @return ArrayList<RoomVO>型，返回符合条件的入住信息列表
     * @see
     */
    ArrayList<RoomVO> searchCheckInInfo(String address ,Date time){
        return null;
    }
    
    /**
     * 根据房间类型搜索入住信息
     * @param address string型，酒店地址
     * @param roomType 枚举类，房间类型
     * @return ArrayList<RoomVO>型，符合条件的入住信息列表
     * @see
     */
    ArrayList<RoomVO> searchCheckInInfo(String address ,Enum<RoomType> roomType){
        return null;
        
    }
    
    /**
     * 增加入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否增加成功
     * @see
     */
    boolean AddCheckIn(String address, RoomVO checkIn){
        return false;
        
    }
    
    /**
     * 修改 入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否修改成功
     * @see
     */
    boolean ModifyCheckIn(String address, RoomVO checkIn){
        return false;
        
    }
    
    /**
     * 删除入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否删除成功
     * @see
     */
    boolean delCheckIn(String address, RoomVO checkIn){
        return false;
        
    }
    
    /**
     * 判断该入住信息是否有效
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否入住信息有效
     * @see
     */
    boolean validCheckIn(String address, RoomVO checkIn){
        return false;
        
    }
}
