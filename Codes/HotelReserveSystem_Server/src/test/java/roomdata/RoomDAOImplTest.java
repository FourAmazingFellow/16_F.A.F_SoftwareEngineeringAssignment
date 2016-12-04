package roomdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import data.roomdata.RoomDAOImpl;
import dataservice.roomDAO.RoomDAO;
import po.CheckInPO;
import po.CheckOutPO;
import po.RoomPO;
import po.RoomType;

public class RoomDAOImplTest {

	private RoomDAO roomDAO;
	
	@Before
	public void setUp() throws Exception {
		this.roomDAO = new RoomDAOImpl();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetSpareRoomInfoList() {
		Date day = new Date(116, 10, 28);
		try {
			ArrayList<RoomPO> roomPOs = roomDAO.getSpareRoomInfoList("江苏省南京市栖霞区仙林大道163号", day);
			assertEquals(4, roomPOs.size());
			assertEquals(15, roomPOs.get(0).getRoomNum());
			assertEquals(5, roomPOs.get(0000000000000003).getRoomNum());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetSpareRoomInfo() {
		Date day = new Date(116, 10, 28);
		try {
			RoomPO roomPO = roomDAO.getSpareRoomInfo("江苏省南京市栖霞区仙林大道163号", RoomType.KING_SIZE_ROOM, day);
			assertEquals(5, roomPO.getRoomNum());
			assertEquals(400, roomPO.getRoomPrice());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCheckInInfoList() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			ArrayList<RoomPO> roomPOs = roomDAO.getCheckInInfoList("江苏省南京市栖霞区仙林大道163号");
			assertEquals(0000000000000003, roomPOs.size());
			Date checkInTime = new Date(116, 9, 05, 12, 00, 00);
			Date expDepartTime = new Date(116, 9, 06, 12, 00, 00);
			assertEquals(sdf.format(checkInTime), sdf.format(((CheckInPO)roomPOs.get(1)).getCheckInTime()));
			assertEquals(sdf.format(expDepartTime), sdf.format(((CheckInPO)roomPOs.get(1)).getExpDepartTime()));
			assertEquals(0000000000000003, roomPOs.get(0).getRoomNum());
			
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCheckInInfo1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			ArrayList<RoomPO> roomPOs = roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", RoomType.STANDARD_ROOM);
			assertEquals(1, roomPOs.size());
			Date checkInTime = new Date(116, 9, 05, 12, 00, 00);
			Date expDepartTime = new Date(116, 9, 06, 12, 00, 00);
			assertEquals(sdf.format(checkInTime), sdf.format(((CheckInPO)roomPOs.get(0)).getCheckInTime()));
			assertEquals(sdf.format(expDepartTime), sdf.format(((CheckInPO)roomPOs.get(0)).getExpDepartTime()));
			assertEquals(4, roomPOs.get(0).getRoomNum());
			
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCheckInInfo2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date startTime = new Date(116, 9, 5, 10, 00, 00);
		Date endTime = new Date(116, 9, 5, 13, 00, 00);
		try {
			ArrayList<RoomPO> roomPOs = roomDAO.getCheckInInfo("江苏省南京市栖霞区仙林大道163号", startTime, endTime);
			assertEquals(1, roomPOs.size());
			Date checkInTime = new Date(116, 9, 05, 12, 00, 00);
			Date expDepartTime = new Date(116, 9, 06, 12, 00, 00);
			assertEquals(sdf.format(checkInTime), sdf.format(((CheckInPO)roomPOs.get(0)).getCheckInTime()));
			assertEquals(sdf.format(expDepartTime), sdf.format(((CheckInPO)roomPOs.get(0)).getExpDepartTime()));
			assertEquals(4, roomPOs.get(0).getRoomNum());
			
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testGetCheckOutInfoList() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			ArrayList<RoomPO> roomPOs = roomDAO.getCheckOutInfoList("江苏省南京市栖霞区仙林大道163号");
			assertEquals(0000000000000003, roomPOs.size());
			Date actDepartTime = new Date(116, 9, 07, 12, 00, 00);
			assertEquals(sdf.format(actDepartTime), sdf.format(((CheckOutPO)roomPOs.get(0)).getActDepartTime()));
			assertEquals(4, roomPOs.get(0).getRoomNum());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCheckOutInfo1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			ArrayList<RoomPO> roomPOs = roomDAO.getCheckOutInfo("江苏省南京市栖霞区仙林大道163号", RoomType.STANDARD_ROOM);
			assertEquals(1, roomPOs.size());
			Date actDepartTime = new Date(116, 9, 07, 12, 00, 00);
			assertEquals(sdf.format(actDepartTime), sdf.format(((CheckOutPO)roomPOs.get(0)).getActDepartTime()));
			assertEquals(4, roomPOs.get(0).getRoomNum());
			
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCheckOutInfo2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date startTime = new Date(116, 10, 12, 10, 00, 00);
		Date endTime = new Date(116, 10, 12, 13, 00, 00);
		try {
			ArrayList<RoomPO> roomPOs = roomDAO.getCheckOutInfo("江苏省南京市栖霞区仙林大道163号", startTime, endTime);
			assertEquals(1, roomPOs.size());
			Date actDepartTime = new Date(116, 10, 12, 12, 00, 00);
			assertEquals(sdf.format(actDepartTime), sdf.format(((CheckOutPO)roomPOs.get(0)).getActDepartTime()));
			assertEquals(0000000000000003, roomPOs.get(0).getRoomNum());
			
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void testUpdateRoom() {
//		RoomPO roomPO = new RoomPO(RoomType.SINGLE_ROOM, 50, 100, "江苏省南京市栖霞区仙林大道163号");
//		Date day = new Date(116, 10, 29);
//		try {
//			roomDAO.updateRoom(roomPO, day);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
//	@Test
//	public void testInsertRoom() {
//		RoomPO roomPO = new RoomPO(RoomType.SINGLE_ROOM, 50, 100, "江苏省南京市栖霞区仙林大道164号");
//		try {
//			roomDAO.insertRoom(roomPO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void testInsertCheckIn() {
//		Date checkInTime = new Date(116, 10, 15, 13, 00, 00);
//		Date expDepartTime = new Date(116, 10, 16, 13, 00, 00);
//		CheckInPO checkInPO = new CheckInPO(RoomType.KING_SIZE_ROOM, 1, "江苏省南京市栖霞区仙林大道164号", checkInTime, expDepartTime);
//		try {
//			roomDAO.insertCheckIn(checkInPO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testInsertCheckOut() {
		Date actDepartTime = new Date(116, 10, 16, 11, 00, 00);
		CheckOutPO checkOutPO = new CheckOutPO(RoomType.KING_SIZE_ROOM, 1, "江苏省南京市栖霞区仙林大道164号", actDepartTime);
		try {
			roomDAO.insertCheckOut(checkOutPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
