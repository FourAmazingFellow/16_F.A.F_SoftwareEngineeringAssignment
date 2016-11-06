package businesslogic.roombl.browseSpareRoom;

import java.util.ArrayList;

import businesslogicservice.roomblservice.BrowseSpareRoomService;
import vo.RoomVO;


/**
 * 负责实现对应于浏览空房所需要的服务
 * @author 双
 * @version 
 * @see
 */
public class BrowseSpareRoomServiceImpl implements BrowseSpareRoomService{

    SpareRoomList spareRoomList=new SpareRoomList();
    
    /**
     * 得到空房列表
     * @param address String型，酒店地址
     * @return ArrayList<RoomVO>型，返回空房列表
     * @see
     */
    @Override
    public ArrayList<RoomVO> getRoomInfoList(String address) {
        ArrayList<SpareRoomItem> spareRoomItems=spareRoomList.getRoomInfoList(address);
        ArrayList<RoomVO> roomVOs=new ArrayList<RoomVO>();
        for(SpareRoomItem spareRoomItem:spareRoomItems){
            roomVOs.add(spareRoomItem.toVO());
        }
        return roomVOs;
    }
}
