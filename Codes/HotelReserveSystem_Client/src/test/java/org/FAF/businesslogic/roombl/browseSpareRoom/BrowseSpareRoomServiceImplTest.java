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
    private RoomVO roomVO1,roomVO2,roomVO3,roomVO4;
    
    @Before
    public void setUp() throws Exception{
        browseSpareRoomServiceImpl=new BrowseSpareRoomServiceImpl();
        address="江苏省南京市栖霞区仙林大道163号";
//        roomVO=new RoomVO(RoomType.SINGLE_ROOM, 15, 200, "江苏省南京市栖霞区仙林大道163号");
        roomVO1=new RoomVO(RoomType.SINGLE_ROOM, 50, 100, "江苏省南京市栖霞区仙林大道163号");
        roomVO2=new RoomVO(RoomType.STANDARD_ROOM, 50, 200, "江苏省南京市栖霞区仙林大道163号");
        roomVO3=new RoomVO(RoomType.TRIBLE_ROOM, 50, 300, "江苏省南京市栖霞区仙林大道163号");
        roomVO4=new RoomVO(RoomType.KING_SIZE_ROOM, 50, 400, "江苏省南京市栖霞区仙林大道163号");
    }
    
    @Test
    public void testGetRoomInfoList(){
        ArrayList<RoomVO> roomVOs=browseSpareRoomServiceImpl.getRoomInfoList(address);
        assertEquals(4,roomVOs.size());
//        assertTrue(equalSpareRoom(roomVO, roomVOs.get(0)));
        for(RoomVO roomVO:roomVOs){
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
