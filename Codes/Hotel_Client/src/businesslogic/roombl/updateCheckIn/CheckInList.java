package businesslogic.roombl.updateCheckIn;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataservice.roomDAO.RoomDAO;
import po.RoomPO;
import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class CheckInList {

    private RoomDAO roomDAO;
    
    /**
     * 得到入住信息列表
     * @param address String型，酒店地址
     * @return ArrayList<CheckInItem>型，入住信息列表
     * @see
     */
    ArrayList<CheckInItem> getCheckInList(String address){
        ArrayList<RoomPO> roomPOs;
        ArrayList<CheckInItem> checkInItems=new ArrayList<CheckInItem>();
        try {
            roomPOs=roomDAO.getCheckInInfoList(address);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO roomPO:roomPOs){
            checkInItems.add(new CheckInItem(roomPO));
        }
        return checkInItems;
    }
    
    /**
     * 根据入住时间搜索入住信息
     * @param address string型，酒店地址
     * @param time Date型，入住时间
     * @return ArrayList<CheckInItem>型，返回符合条件的入住信息列表
     * @see
     */
    ArrayList<CheckInItem> searchCheckInInfo(String address ,Date time){
        ArrayList<RoomPO> roomPOs;
        ArrayList<CheckInItem> checkInItems=new ArrayList<CheckInItem>();
        try {
            roomPOs=roomDAO.getCheckInInfo(address, time);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO roomPO:roomPOs){
            checkInItems.add(new CheckInItem(roomPO));
        }
        return checkInItems;
    }
    
    /**
     * 根据房间类型搜索入住信息
     * @param address string型，酒店地址
     * @param time Date型，入住时间
     * @return ArrayList<CheckInItem>型，返回符合条件的入住信息列表
     * @see
     */
    ArrayList<CheckInItem> searchCheckInInfo(String address ,Enum<RoomType> roomType){
        ArrayList<RoomPO> roomPOs;
        ArrayList<CheckInItem> checkInItems=new ArrayList<CheckInItem>();
        try {
            roomPOs=roomDAO.getCheckInInfo(address, roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO roomPO:roomPOs){
            checkInItems.add(new CheckInItem(roomPO));
        }
        return checkInItems;
    }
    
    /**
     * 增加入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否增加成功
     * @see
     */
    boolean addCheckIn(String address, RoomVO checkIn){
        CheckInItem checkInItem=new CheckInItem(checkIn);
        return checkInItem.addCheckIn(address);
    }
    
    /**
     * 修改 入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否修改成功
     * @see
     */
    boolean modifyCheckIn(String address, RoomVO checkIn){
        CheckInItem checkInItem=new CheckInItem(checkIn);
        return checkInItem.modifyCheckIn(address);
    }
    
    /**
     * 删除入住信息
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否删除成功
     * @see
     */
    boolean delCheckIn(String address, RoomVO checkIn){
        CheckInItem checkInItem=new CheckInItem(checkIn);
        return checkInItem.delCheckIn(address);
    }
    
    /**
     * 判断该入住信息是否有效
     * @param address string型，酒店地址
     * @param checkIn Room VO型，入住信息
     * @return 返回是否入住信息有效
     * @see
     */
    boolean validCheckIn(String address, RoomVO checkIn){
        CheckInItem checkInItem=new CheckInItem(checkIn);
        return checkInItem.validCheckIn();
    }
}
