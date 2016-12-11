package presentation.roomui.spareRoom.model;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.roomblservice.BrowseSpareRoomService;
import factory.RoomUIFactoryService;
import factory.RoomUIFactoryServiceImpl;
import vo.RoomVO;

public class SpareRoomListWrapper {
    
    private List<SpareRoom> spareRoomList;
    
    private RoomUIFactoryService roomUIFactoryService;
    private BrowseSpareRoomService browseSpareRoomService;
    
    private ArrayList<RoomVO> spareRoomVOs;
    
    public List<SpareRoom> getSpareRoomList(){
        return spareRoomList;
    }
    
    //把空房VO转化成SpareRoom这一模型类
    private SpareRoom voToModel(RoomVO spareRoomVO){
        return new SpareRoom(spareRoomVO.roomType, spareRoomVO.roomNum, spareRoomVO.roomPrice);
    }
    
    //从bl层中取得空房列表
    public void setSpareRoomListFromData(String address){
        roomUIFactoryService=new RoomUIFactoryServiceImpl();
        browseSpareRoomService=roomUIFactoryService.createBrowseSpareRoomService();
        spareRoomVOs=browseSpareRoomService.getRoomInfoList(address);
        for(RoomVO spareRoomVO: spareRoomVOs){
            spareRoomList.add(voToModel(spareRoomVO));
        }
    }
    
    public void setSpareRoomList(List<SpareRoom> spareRooms){
        spareRoomList=spareRooms;
    }
    
}
