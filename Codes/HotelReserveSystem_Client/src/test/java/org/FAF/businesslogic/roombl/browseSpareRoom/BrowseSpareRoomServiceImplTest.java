package org.FAF.businesslogic.roombl.browseSpareRoom;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import businesslogic.roombl.browseSpareRoom.BrowseSpareRoomServiceImpl;
import po.RoomType;
import vo.RoomVO;

public class BrowseSpareRoomServiceImplTest {

    private BrowseSpareRoomServiceImpl browseSpareRoomServiceImpl;
    private String address;
    private RoomVO roomVO;
    
    @Before
    public void setUp() throws Exception{
        browseSpareRoomServiceImpl=new BrowseSpareRoomServiceImpl();
        address="江苏省南京市栖霞区仙林大道163号";
        roomVO=new RoomVO(RoomType.SINGLE_ROOM, 15, 200, "江苏省南京市栖霞区仙林大道163号");
    }
    
    @Test
    public void testGetRoomInfoList(){
        ArrayList<RoomVO> roomVOs=browseSpareRoomServiceImpl.getRoomInfoList(address);
        assertEquals(1,roomVOs.size());
        assertTrue(equalSpareRoom(roomVO, roomVOs.get(0)));
    }
    
    public boolean equalSpareRoom(RoomVO roomVO1, RoomVO roomVO2) {
        if (roomVO1.roomType != roomVO2.roomType || roomVO1.roomNum != roomVO2.roomNum
                || roomVO1.roomPrice != roomVO2.roomPrice || roomVO1.address != roomVO2.address) {
            return false;
        }
        return true;
    }
}
