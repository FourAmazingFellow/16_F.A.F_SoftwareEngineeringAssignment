package businesslogic.roombl.updateCheckOut;

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
public class UpdateCheckOut {

    /**
     * 得到退房信息列表
     * @param address String型，酒店地址
     * @return ArrayList<RoomVO>型，退房信息VO列表 
     * @see
     */
    ArrayList<RoomVO> getCheckOutList(String address){
        return null;
    }
    
    /**
     * 根据实际离开时间搜索退房信息
     * @param address String型，酒店地址
     * @param time Date型，退房时间
     * @return ArrayList<RoomVO>型，返回符合条件的退房信息列表
     * @see
     */
    ArrayList<RoomVO> searchCheckOutInfo(String address ,Date time){
        return null;
    }
    
    /**
     * 根据房间类型搜索退房信息
     * @param address String型，酒店地址
     * @param roomType 枚举类，房间类型
     * @return ArrayList<RoomVO>型，符合条件的退房信息列表
     * @see
     */
    ArrayList<RoomVO> searchCheckOutInfo(String address ,Enum<RoomType> roomType){
        return null;
        
    }
    
    /**
     * 增加退房信息
     * @param address String型，酒店地址
     * @param checkOut Room VO型，退房信息
     * @return 返回是否增加成功
     * @see
     */
    boolean AddCheckOut(String address, RoomVO checkOut){
        return false;
        
    }
    
    /**
     * 修改 退房信息
     * @param address String型，酒店地址
     * @param checkOut Room VO型，退房信息
     * @return 返回是否修改成功
     * @see
     */
    boolean ModifyCheckOut(String address, RoomVO checkOut){
        return false;
        
    }
    
    /**
     * 删除退房信息
     * @param address String型，酒店地址
     * @param checkOut Room VO型，退房信息
     * @return 返回是否删除成功
     * @see
     */
    boolean delCheckOut(String address, RoomVO checkOut){
        return false;
        
    }
    
    /**
     * 判断该退房信息是否有效
     * @param address String型，酒店地址
     * @param checkOut Room VO型，退房信息
     * @return 返回是否退房信息有效
     * @see
     */
    boolean validCheckOut(String address, RoomVO checkOut){
        return false;
        
    }
}

