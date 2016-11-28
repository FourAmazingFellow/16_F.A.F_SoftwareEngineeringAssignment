package businesslogic.roombl.browseSpareRoom;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.roomDAO.RoomDAO;
import po.RoomPO;
import po.RoomType;
import rmi.RemoteHelper;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public class SpareRoomList {

    private RoomDAO roomDAO;
    
    //在bl层存储的空房列表
    private ArrayList<SpareRoomItem> blSpareRoomList;
    
    //设置成单件模式
    private static SpareRoomList spareRoomList;
    private String address;
    
    protected SpareRoomList(String address){
        this.address=address;
        blSpareRoomList=getRoomInfoList(address);
        
        roomDAO=RemoteHelper.getInstance().getRoomDAO();
    }
    
    public static SpareRoomList getInstance(String address){
        if(spareRoomList==null){
            spareRoomList=new SpareRoomList(address);
        }
        if(spareRoomList.address!=address){
            spareRoomList=new SpareRoomList(address);
        }
        return spareRoomList;
    }
    /**
     * 从数据层得到空房列表
     * @param address String型，酒店地址
     * @return ArrayList<SpareRoomItem>型，返回空房列表
     * @see
     */
    public ArrayList<SpareRoomItem> getRoomInfoList (String address){
      //如果传入address不是该类的address,即查看非本酒店的策略，则返回null
        if(this.address!=address){
            return null;
        }
        //如果该类已初始化，则可以直接调用逻辑层的空房列表
        if(blSpareRoomList!=null){
            return blSpareRoomList;
        }
        ArrayList<RoomPO> roomPOs;
        ArrayList<SpareRoomItem> spareRoomItems=new ArrayList<SpareRoomItem>();
        try {
            roomPOs=roomDAO.getCheckInInfoList(address);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO roomPO:roomPOs){
            spareRoomItems.add(new SpareRoomItem(roomPO));
        }
        return spareRoomItems;
    }
    
    public SpareRoomItem getSprareRoomInfo(String address, Enum<RoomType> roomType) throws NoThisRoomTypeSpareRoomException{
        if(this.address!=address){
            return null;
        }
        for(SpareRoomItem spareRoomItem:blSpareRoomList){
            if(spareRoomItem.toVO().roomType==roomType){
                return spareRoomItem;
            }
        }
        throw new NoThisRoomTypeSpareRoomException("Spare Room of this RoomType hasn't existed yet");
    }
}
