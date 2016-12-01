package org.FAF.businesslogic.roombl.browseSpareRoom;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.browseSpareRoom.SpareRoomItem;
import businesslogic.roombl.browseSpareRoom.SpareRoomList;
import po.RoomType;
import vo.RoomVO;

public class SpareRoomListTest {

    private SpareRoomList spareRoomList;
    private RoomVO roomVO;
    private String address;

    @Before
    public void setUp() throws Exception {
        address = "江苏省南京市栖霞区仙林大道163号";
        spareRoomList = SpareRoomList.getInstance(address);
        roomVO = new RoomVO(RoomType.SINGLE_ROOM, 15, 200, "江苏省南京市栖霞区仙林大道163号");
    }

    @Test
    public void testGetRoomInfoList() {
        ArrayList<SpareRoomItem> spareRoomItems = spareRoomList.getRoomInfoList(address);
        assertEquals(1, spareRoomItems.size());
        RoomVO roomVOFromArray = spareRoomItems.get(0).toVO();
        assertTrue(equalSpareRoom(roomVO, roomVOFromArray));
    }

    public boolean equalSpareRoom(RoomVO roomVO1, RoomVO roomVO2) {
        if (roomVO1.roomType != roomVO2.roomType || roomVO1.roomNum != roomVO2.roomNum
                || roomVO1.roomPrice != roomVO2.roomPrice || roomVO1.address != roomVO2.address) {
            return false;
        }
        return true;
    }
}
