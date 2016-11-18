package org.FAF.businesslogic.roombl.browseSpareRoom;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.browseSpareRoom.MockSpareRoomList;
import businesslogic.roombl.browseSpareRoom.SpareRoomItem;
import businesslogic.roombl.browseSpareRoom.SpareRoomList;
import po.RoomType;
import vo.RoomVO;

public class SpareRoomListTest {

    private SpareRoomList spareRoomList;
    private RoomVO roomVO;
    private String address;
    
    @Before
    public void setUp() throws Exception{
        spareRoomList=new MockSpareRoomList();
        roomVO=new RoomVO(RoomType.SINGLE_ROOM, 15, 200, "江苏省南京市栖霞区仙林大道163号");
        address= "江苏省南京市栖霞区仙林大道163号";
    }
    
    @Test
    public void testGetRoomInfoList(){
        ArrayList<SpareRoomItem> spareRoomItems=spareRoomList.getRoomInfoList(address);
        assertEquals(1,spareRoomItems.size());
        RoomVO roomVOFromArray=spareRoomItems.get(0).toVO();
        assertEquals(roomVO.roomType, roomVOFromArray.roomType);
        assertEquals(roomVO.roomNum, roomVOFromArray.roomNum);
        assertEquals(roomVO.roomPrice, roomVOFromArray.roomPrice);
        assertEquals(roomVO.address, roomVOFromArray.address);
    }
    
}
