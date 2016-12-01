package org.FAF.businesslogic.roombl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

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
        roomInfoServiceImpl=new RoomInfoServiceImpl();
        address="江苏省南京市栖霞区仙林大道163号";
        roomType=RoomType.SINGLE_ROOM;
        beginDate=new Date(116, 11, 1, 12, 0);
        finishDate=new Date(116, 11, 2, 12, 0);
        change=2;
        orderVO=new OrderVO("原","0001000100010001","仙林大酒店","",new Date(116,11,1),new Date(116,11,2),RoomType.SINGLE_ROOM,3,100,OrderState.NOT_DONE_ORDER,new Date(116,11,1,18,0),new java.util.Date(116, 11, 1, 20, 0),2,false,true,false);
        roomVO=new RoomVO(roomType, 3, 200, address);
    }
    
    @Test
    public void testGetAvailableRoomNum(){
        try {
            Date today=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            try {
                today=sdf.parse(sdf.format(today));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            assertEquals(16,roomInfoServiceImpl.getAvailableRoomNum(address, roomType,today));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testIsTimeAvailable(){
        try {
            assertTrue(roomInfoServiceImpl.isTimeAvailable(address, roomType, beginDate, change));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCheckOrder(){
        try {
            assertEquals(ResultMessage.SUCCEED, roomInfoServiceImpl.checkOrder(orderVO));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testUpdateSpareRoom(){
        try {
            assertTrue(roomInfoServiceImpl.updateSpareRoom(address, roomVO));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testReduceRoom(){
        try {
            assertTrue(roomInfoServiceImpl.reduceRoom(address, change, roomType,new Date()));
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testAddRoom(){
        try {
            assertTrue(roomInfoServiceImpl.addRoom(address, change, roomType,new Date()));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
