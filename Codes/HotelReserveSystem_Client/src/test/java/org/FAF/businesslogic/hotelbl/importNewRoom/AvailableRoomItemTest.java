package org.FAF.businesslogic.hotelbl.importNewRoom;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.importNewRoom.AvailableRoomItem;
import businesslogic.hotelbl.importNewRoom.MockAvailableRoomItem;
import po.RoomType;
import vo.RoomVO;

public class AvailableRoomItemTest {

	private AvailableRoomItem availableRoomItem;
	private RoomVO room;
	
	@Before
	public void setUp() throws Exception {
		this.room = new RoomVO(RoomType.KING_SIZE_ROOM, 20, "江苏省南京市栖霞区仙林大道163号");
	}

	@Test
	public void testAddRoom() {
		availableRoomItem = new MockAvailableRoomItem("江苏省南京市栖霞区仙林大道163号");
		boolean result = availableRoomItem.addRoom(room);
		assertEquals(true, result);
	}

}
