package org.FAF.businesslogic.hotelbl.importNewRoom;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.importNewRoom.AvailableRoomList;
import po.RoomType;
import rmi.LinkToServer;
import vo.RoomVO;

public class AvailableRoomListTest {

	private static LinkToServer linkToServer;
	
	private AvailableRoomList availableRooms;
	private RoomVO roomVO1;
	private RoomVO roomVO2;
	private RoomVO roomVO3;
	
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
		this.roomVO1 = new RoomVO(RoomType.KING_SIZE_ROOM, 52, "江苏省南京市栖霞区仙林大道163号");
		this.roomVO2 = new RoomVO(RoomType.SINGLE_ROOM, 50, "江苏省南京市栖霞区仙林大道163号");
		this.roomVO3 = new RoomVO(RoomType.STANDARD_ROOM, 50, "江苏省南京市栖霞区仙林大道163号");
	}

	@Test
	public void testGetAvailableRoomList() {
		availableRooms = new AvailableRoomList("江苏省南京市栖霞区仙林大道163号");
		ArrayList<RoomVO> roomVOs;
		try {
			roomVOs = availableRooms.getAvailableRoomList();
			assertEquals(4, roomVOs.size());
			assertEquals(roomVO1.address, roomVOs.get(3).address);
			assertEquals(roomVO1.roomNum, roomVOs.get(3).roomNum);
			assertEquals(roomVO1.roomType, roomVOs.get(3).roomType);
			assertEquals(roomVO2.address, roomVOs.get(2).address);
			assertEquals(roomVO2.roomNum, roomVOs.get(2).roomNum);
			assertEquals(roomVO2.roomType, roomVOs.get(2).roomType);
			assertEquals(roomVO3.address, roomVOs.get(1).address);
			assertEquals(roomVO3.roomNum, roomVOs.get(1).roomNum);
			assertEquals(roomVO3.roomType, roomVOs.get(1).roomType);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
		
	}

}
