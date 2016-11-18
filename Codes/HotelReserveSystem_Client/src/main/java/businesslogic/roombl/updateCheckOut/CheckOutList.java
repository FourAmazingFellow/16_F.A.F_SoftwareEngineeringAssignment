package businesslogic.roombl.updateCheckOut;

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
public class CheckOutList {

    private RoomDAO roomDAO;
    
    /**
     * 得到退房信息列表
     * @param address String型，酒店地址
     * @return ArrayList<CheckOutItem>型，退房信息列表
     * @see
     */
    public ArrayList<CheckOutItem> getCheckOutList(String address){
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        try {
            checkOutPOs=roomDAO.getCheckOutInfoList(address);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    /**
     * 根据退房时间搜索退房信息
     * @param address string型，酒店地址
     * @param time Date型，退房时间
     * @return ArrayList<CheckOutItem>型，返回符合条件的退房信息列表
     * @see
     */
    public ArrayList<CheckOutItem> searchCheckOutInfo(String address ,Date time){
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        try {
            checkOutPOs=roomDAO.getCheckOutInfo(address, time);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    /**
     * 根据房间类型搜索退房信息
     * @param address string型，酒店地址
     * @param roomType 枚举类，房间类型
     * @return ArrayList<CheckOutItem>型，返回符合条件的退房信息列表
     * @see
     */
    public ArrayList<CheckOutItem> searchCheckOutInfo(String address ,Enum<RoomType> roomType){
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        try {
            checkOutPOs=roomDAO.getCheckOutInfo(address, roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    /**
     * 增加退房信息
     * @param address string型，酒店地址
     * @param CheckOut Room VO型，退房信息
     * @return 返回是否增加成功
     * @see
     */
    public boolean addCheckOut(String address, RoomVO checkOut){
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.addCheckOut(address);
    }
    
    /**
     * 修改 退房信息
     * @param address string型，酒店地址
     * @param CheckOut Room VO型，退房信息
     * @return 返回是否修改成功
     * @see
     */
    public boolean modifyCheckOut(String address, RoomVO checkOut){
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.modifyCheckOut(address);
    }
    
    /**
     * 删除退房信息
     * @param address string型，酒店地址
     * @param CheckOut Room VO型，退房信息
     * @return 返回是否删除成功
     * @see
     */
    public boolean delCheckOut(String address, RoomVO checkOut){
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.delCheckOut(address);
    }
    
    /**
     * 判断该退房信息是否有效
     * @param address string型，酒店地址
     * @param CheckOut Room VO型，退房信息
     * @return 返回是否退房信息有效
     * @see
     */
    public boolean validCheckOut(String address, RoomVO checkOut){
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.validCheckOut();
    }
}

