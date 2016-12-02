package businesslogic.roombl.browseSpareRoom;

import java.rmi.RemoteException;
import java.sql.Date;
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
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public ArrayList<SpareRoomItem> getRoomInfoList (String address){
        roomDAO=new RoomDAOImpl_Stub(RoomType.SINGLE_ROOM, 15, 200, "江苏省南京市栖霞区仙林大道163号",null,null,null);
        ArrayList<RoomPO> roomPOs;
        ArrayList<SpareRoomItem> spareRoomItems=new ArrayList<SpareRoomItem>();
        try {
            roomPOs=roomDAO.getSpareRoomInfoList(address,new Date(116,10,27));
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
