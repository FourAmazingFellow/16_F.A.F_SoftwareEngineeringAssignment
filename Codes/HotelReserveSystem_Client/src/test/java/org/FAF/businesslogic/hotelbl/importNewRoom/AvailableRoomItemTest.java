package org.FAF.businesslogic.hotelbl.importNewRoom;

import static org.junit.Assert.*;

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
		linkToServer.linkToServer();
	}
	
	@Before
	public void setUp() throws Exception {
		this.room = new RoomVO(RoomType.KING_SIZE_ROOM, 20, 500, "江苏省南京市栖霞区仙林大道163号");
	}

	@Test
	public void testAddRoom() {
		availableRoomItem = new AvailableRoomItem("江苏省南京市栖霞区仙林大道163号");
		boolean result = availableRoomItem.addRoom(room);
		assertEquals(true, result);
	}

}
