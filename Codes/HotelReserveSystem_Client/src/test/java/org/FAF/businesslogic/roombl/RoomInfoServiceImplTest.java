package org.FAF.businesslogic.roombl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.MockRoomInfoServiceImpl;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogicservice.orderblservice.ResultMessage;
import po.OrderState;
import po.RoomType;
import vo.OrderVO;
import vo.RoomVO;

public class RoomInfoServiceImplTest {

    private RoomInfoServiceImpl roomInfoServiceImpl;
    private String address;
    private Enum<RoomType> roomType;
    private Date beginDate;
    private Date finishDate;
    private OrderVO orderVO;
    private int change;
    private RoomVO roomVO;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        roomInfoServiceImpl=new MockRoomInfoServiceImpl();
        address="江苏省南京市栖霞区仙林大道163号";
        roomType=RoomType.SINGLE_ROOM;
        beginDate=new Date(2016, 11, 11, 12, 0);
        finishDate=new Date(2016, 11, 12, 12, 0);
        change=2;
        orderVO=new OrderVO("原","0001000100010001","仙林大酒店","",new Date(2016,10,16),new Date(2016,10,17),RoomType.KING_SIZE_ROOM,1,100,OrderState.NOT_DONE_ORDER,new Date(2016,10,16,18,0),new java.util.Date(2016, 10, 16, 20, 0),2,false,true,false);
        roomVO=new RoomVO(roomType, 3, 200, address);
    }
    
    @Test
    public void testGetAvailableRoomNum(){
        assertEquals(2,roomInfoServiceImpl.getAvailableRoomNum(address, roomType));
    }
    
    @Test
    public void testIsTimeAvailable(){
        assertTrue(roomInfoServiceImpl.isTimeAvailable(address, roomType, beginDate, finishDate));
    }
    
    @Test
    public void testCheckOrder(){
        assertEquals(ResultMessage.SUCCEED, roomInfoServiceImpl.checkOrder(orderVO));
    }
    
    @Test
    public void testUpdateSpareRoom(){
        assertTrue(roomInfoServiceImpl.updateSpareRoom(address, roomVO));
    }
    
    @Test
    public void testReduceRoom(){
        assertTrue(roomInfoServiceImpl.reduceRoom(address, change, roomType));
    }
    
    @Test
    public void testAddRoom(){
        assertTrue(roomInfoServiceImpl.addRoom(address, change, roomType));
    }
}
