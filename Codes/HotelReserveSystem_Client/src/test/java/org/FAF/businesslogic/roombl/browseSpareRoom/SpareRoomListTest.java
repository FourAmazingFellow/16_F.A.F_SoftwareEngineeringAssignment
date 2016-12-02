package org.FAF.businesslogic.roombl.browseSpareRoom;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.browseSpareRoom.SpareRoomItem;
import businesslogic.roombl.browseSpareRoom.SpareRoomList;
import po.RoomType;
import po.StrategyType;
import vo.RoomVO;

public class SpareRoomListTest {

    private SpareRoomList spareRoomList;
//    private RoomVO roomVO;
    private String address;
    private RoomVO roomVO1,roomVO2,roomVO3,roomVO4;

    @Before
    public void setUp() throws Exception {
        address = "江苏省南京市栖霞区仙林大道163号";
        spareRoomList = new SpareRoomList();
//        roomVO = new RoomVO(RoomType.SINGLE_ROOM, 15, 200, "江苏省南京市栖霞区仙林大道163号");
        roomVO1=new RoomVO(RoomType.SINGLE_ROOM, 50, 100, "江苏省南京市栖霞区仙林大道163号");
        roomVO2=new RoomVO(RoomType.STANDARD_ROOM, 50, 200, "江苏省南京市栖霞区仙林大道163号");
        roomVO3=new RoomVO(RoomType.TRIBLE_ROOM, 50, 300, "江苏省南京市栖霞区仙林大道163号");
        roomVO4=new RoomVO(RoomType.KING_SIZE_ROOM, 50, 400, "江苏省南京市栖霞区仙林大道163号");
    }

    @Test
    public void testGetRoomInfoList() {
        ArrayList<SpareRoomItem> spareRoomItems = spareRoomList.getRoomInfoList(address);
        assertEquals(4, spareRoomItems.size());
//        RoomVO roomVOFromArray = spareRoomItems.get(0).toVO();
        for(SpareRoomItem spareRoomItem:spareRoomItems){
            RoomVO roomVO=spareRoomItem.toVO();
            if(roomVO.roomType==RoomType.SINGLE_ROOM){
                assertTrue(equalSpareRoom(roomVO1, roomVO));
            }
            if(roomVO.roomType==RoomType.STANDARD_ROOM){
                assertTrue(equalSpareRoom(roomVO2, roomVO));
            }
            if(roomVO.roomType==RoomType.TRIBLE_ROOM){
                assertTrue(equalSpareRoom(roomVO3, roomVO));
            }
            if(roomVO.roomType==RoomType.KING_SIZE_ROOM){
                assertTrue(equalSpareRoom(roomVO4, roomVO));
            }
        }
    }

    public boolean equalSpareRoom(RoomVO roomVO1, RoomVO roomVO2) {
        if (roomVO1.roomType != roomVO2.roomType || roomVO1.roomNum != roomVO2.roomNum
                || roomVO1.roomPrice != roomVO2.roomPrice || roomVO1.address != roomVO2.address) {
            return false;
        }
        return true;
    }
}
