package org.FAF.businesslogic.roombl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogicservice.orderblservice.ResultMessage;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class RoomInfoServiceImplTest {

    private RoomInfoServiceImpl roomInfoServiceImpl;
    private OrderVO orderVO;
    
    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信错误");
		}
    }

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        roomInfoServiceImpl = new RoomInfoServiceImpl();

        orderVO = new OrderVO("Accident", "0001000100010001", "Jingling hotel", "江苏省南京市栖霞区仙林大道163号", new Date(116, 11, 15),
                new Date(116, 11, 16), RoomType.STANDARD_ROOM, 1, 200, OrderState.NOT_DONE_ORDER,
                new Date(116, 11, 15, 18, 0), new java.util.Date(116, 11, 16, 20, 0), 2, false, true, false);
    }
/**
    @Test
    public void testGetAvailableRoomNum() {
        try {
            Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                today = sdf.parse(sdf.format(today));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            assertEquals(50, roomInfoServiceImpl.getAvailableRoomNum("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM, today));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testIsTimeAvailable() {
        try {
            assertTrue(roomInfoServiceImpl.isTimeAvailable("江苏省南京市栖霞区仙林大道163号", RoomType.SINGLE_ROOM,
                    new Date(116, 11, 4), 4));
            assertFalse(roomInfoServiceImpl.isTimeAvailable("江苏省南京市栖霞区仙林大道163号", RoomType.STANDARD_ROOM,
                    new Date(116, 11, 4), 51));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
 */

    @Test
    public void testCheckOrder() {
        try {
            assertEquals(ResultMessage.SUCCEED, roomInfoServiceImpl.checkOrder(orderVO));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    /**
    @Test
    public void testUpdateSpareRoom() {
        try {
            RoomVO roomVO = new RoomVO(RoomType.SINGLE_ROOM, 20, 300, "江苏省南京市栖霞区仙林大道163号");
            assertTrue(roomInfoServiceImpl.updateSpareRoom("江苏省南京市栖霞区仙林大道163号", roomVO));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("deprecation")
    @Test
    public void testReduceRoom() {
        try {
            assertTrue(roomInfoServiceImpl.reduceRoom("江苏省南京市栖霞区仙林大道163号", 3, RoomType.SINGLE_ROOM,
                    new Date(116, 11, 4)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testAddRoom() {
        try {
            assertTrue(roomInfoServiceImpl.addRoom("江苏省南京市栖霞区仙林大道163号", 3, RoomType.SINGLE_ROOM, new Date(116, 11, 4)));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    */
}
