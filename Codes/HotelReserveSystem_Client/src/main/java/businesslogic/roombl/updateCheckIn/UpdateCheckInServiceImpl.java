package businesslogic.roombl.updateCheckIn;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.roomblservice.UpdateCheckInService;
import po.RoomType;
import vo.CheckInOutVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateCheckInServiceImpl implements UpdateCheckInService{

    private CheckInList checkInList=new MockCheckInList();
    
    /**
     * 得到入住信息列表
     * @param address String型，酒店地址
     * @return ArrayList<RoomVO>型，入住信息VO列表 
     * @see
     */
    @Override
    public ArrayList<RoomVO> getCheckInList(String address){
        ArrayList<CheckInItem> checkInItems=checkInList.getCheckInList(address);
        ArrayList<RoomVO> checkInVOs=new ArrayList<RoomVO>();
        for(CheckInItem checkInItem:checkInItems){
            checkInVOs.add(checkInItem.toVO());
        }
        return checkInVOs;
    }
    
    /**
     * 根据入住时间搜索入住信息
     * @param address string型，酒店地址
     * @param time Date型，入住时间
     * @return ArrayList<RoomVO>型，返回符合条件的入住信息列表
     * @see
     */
    @Override
    public ArrayList<RoomVO> searchCheckInInfo(String address ,Date time){
        ArrayList<CheckInItem> checkInItems=checkInList.searchCheckInInfo(address, time);
        ArrayList<RoomVO> checkInVOs=new ArrayList<RoomVO>();
        for(CheckInItem checkInItem:checkInItems){
            checkInVOs.add(checkInItem.toVO());
        }
        return checkInVOs;
    }
    
    /**
     * 根据房间类型搜索入住信息
     * @param address string型，酒店地址
     * @param roomType 枚举类，房间类型
     * @return ArrayList<RoomVO>型，符合条件的入住信息列表
     * @see
     */
    @Override
    public ArrayList<RoomVO> searchCheckInInfo(String address ,Enum<RoomType> roomType){
        ArrayList<CheckInItem> checkInItems=checkInList.searchCheckInInfo(address, roomType);
        ArrayList<RoomVO> checkInVOs=new ArrayList<RoomVO>();
        for(CheckInItem checkInItem:checkInItems){
            checkInVOs.add(checkInItem.toVO());
        }
        return checkInVOs;
    }
    
    /**
     * 增加入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否增加成功
     * @see
     */
    @Override
    public boolean addCheckIn(String address, RoomVO checkIn){
        return checkInList.addCheckIn(address, checkIn);
    }
    
    /**
     * 修改 入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否修改成功
     * @see
     */
    @Override
    public boolean modifyCheckIn(String address, RoomVO checkIn){
        return checkInList.modifyCheckIn(address, checkIn);
    }
    
    /**
     * 删除入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否删除成功
     * @see
     */
    @Override
    public boolean delCheckIn(String address, RoomVO checkIn){
        return checkInList.delCheckIn(address, checkIn);
    }
    
    /**
     * 判断该入住信息是否有效
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否入住信息有效
     * @see
     */
    @Override
    public boolean validCheckIn(String address, RoomVO checkIn){
        return checkInList.validCheckIn(address, checkIn);
        
    }

}
