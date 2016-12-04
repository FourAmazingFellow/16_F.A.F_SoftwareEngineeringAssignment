package org.FAF.businesslogic.hotelbl.importNewRoom;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.importNewRoom.ImportNewRoomServiceImpl;
import po.RoomType;
import vo.RoomVO;

public class ImportNewRoomServiceImplTest {

	private ImportNewRoomServiceImpl importNewRoom;
	private ArrayList<RoomVO> availableRoomList;
	private RoomVO roomVO1;
	private RoomVO roomVO2;
	private RoomVO roomVO3;
	
	@Before
	public void setUp() throws Exception {
		this.roomVO1 = new RoomVO(RoomType.KING_SIZE_ROOM, 20, "江苏省南京市栖霞区仙林大道163号");
		this.roomVO2 = new RoomVO(RoomType.SINGLE_ROOM, 40, "江苏省南京市栖霞区仙林大道163号");
		this.roomVO3 = new RoomVO(RoomType.STANDARD_ROOM, 30, "江苏省南京市栖霞区仙林大道163号");
		this.availableRoomList = new ArrayList<>();
		availableRoomList.add(roomVO1);
		availableRoomList.add(roomVO2);
		availableRoomList.add(roomVO3);
	}

	@Test
	public void testGetAvailableRoomList() {
		importNewRoom = new ImportNewRoomServiceImpl();
		ArrayList<RoomVO> roomVOs = importNewRoom.getAvailableRoomList("江苏省南京市栖霞区仙林大道163号");
		assertEquals(0000000000000003, roomVOs.size());
		assertEquals(roomVO1.address, roomVOs.get(0).address);
		assertEquals(roomVO1.roomNum, roomVOs.get(0).roomNum);
		assertEquals(roomVO1.roomType, roomVOs.get(0).roomType);
		assertEquals(roomVO2.address, roomVOs.get(1).address);
		assertEquals(roomVO2.roomNum, roomVOs.get(1).roomNum);
		assertEquals(roomVO2.roomType, roomVOs.get(1).roomType);
		assertEquals(roomVO3.address, roomVOs.get(2).address);
		assertEquals(roomVO3.roomNum, roomVOs.get(2).roomNum);
		assertEquals(roomVO3.roomType, roomVOs.get(2).roomType);
	}
	
	@Test
	public void testAddRoom() {
		importNewRoom = new ImportNewRoomServiceImpl();
		boolean result = importNewRoom.addRoom(roomVO1);
		assertEquals(true, result);
	}

}
