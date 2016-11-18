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
        assertEquals(roomVO.roomType, roomVOs.get(0).roomType);
        assertEquals(roomVO.roomNum, roomVOs.get(0).roomNum);
        assertEquals(roomVO.roomPrice, roomVOs.get(0).roomPrice);
        assertEquals(roomVO.address, roomVOs.get(0).address);
    }
}
