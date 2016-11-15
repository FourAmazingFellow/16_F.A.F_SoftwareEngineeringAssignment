package businesslogic.roombl.browseSpareRoom;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data_Stub.RoomDAOImpl_Stub;
import dataservice.roomDAO.RoomDAO;
import po.RoomPO;
import po.RoomType;

/**
 * SpareRoomItemList的实现类
 * @author 双
 * @version 
 * @see
 */
public class MockSpareRoomList extends SpareRoomList{
    
    private RoomDAO roomDAO;
    
    public MockSpareRoomList(){
        roomDAO=new RoomDAOImpl_Stub(RoomType.SINGLE_ROOM, 3, 400, "江苏省南京市栖霞区仙林大道163号",null,null,null);
    }
    
    @Override
    public ArrayList<SpareRoomItem> getRoomInfoList (String address){
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
