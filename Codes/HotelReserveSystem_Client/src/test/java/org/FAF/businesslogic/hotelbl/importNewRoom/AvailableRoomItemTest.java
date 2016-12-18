package org.FAF.businesslogic.hotelbl.importNewRoom;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.importNewRoom.AvailableRoomItem;
import po.RoomType;
import rmi.LinkToServer;
import vo.RoomVO;

public class AvailableRoomItemTest {

	private static LinkToServer linkToServer;
	
	private AvailableRoomItem availableRoomItem;
	private RoomVO room;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信错误");
		}
	}
	
	@Before
	public void setUp() throws Exception {
		this.room = new RoomVO(RoomType.KING_SIZE_ROOM, 52, 500, "江苏省南京市栖霞区仙林大道163号");
	}

	@Test
	public void testAddRoom() {
		availableRoomItem = new AvailableRoomItem("江苏省南京市栖霞区仙林大道163号");
		boolean result;
		try {
			result = availableRoomItem.addRoom(room);
			assertEquals(true, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
	}

}
