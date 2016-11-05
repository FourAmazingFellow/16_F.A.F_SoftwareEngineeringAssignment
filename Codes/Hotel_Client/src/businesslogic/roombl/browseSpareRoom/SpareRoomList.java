package businesslogic.roombl.browseSpareRoom;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.roomDAO.RoomDAO;
import po.RoomPO;

/**
 * 
 * @author 双
 * @version
 * @see
 */
public class SpareRoomList {

    private RoomDAO roomDAO;
    
    /**
     * 从数据层得到空房列表
     * @param address String型，酒店地址
     * @return ArrayList<RoomVO>型，返回空房列表
     * @see
     */
    ArrayList<SpareRoomItem> getRoomInfoList (String address){
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
}
