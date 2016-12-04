package userdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.userdata.UserDAOImpl;
import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.HotelStaffInfoPO;
import po.RegularVipPO;
import po.UserPO;
import po.UserType;

public class UserDAOImplTest {

	private UserDAO userDAO;
	private String userID;
	private String password;
	private String telNum;
	private String clientID;
	private String clientPassword;
	private String clientTelNum;
	private int creditValue;
	private String hotelStaffID;
	private String hotelStaffPassword;
	private String hotelAddress;
	private String hotelStaffTelNum;
	private UserPO userPO;
	private ClientInfoPO clientInfoPO;
	private HotelStaffInfoPO hotelStaff;
	private RegularVipPO regularVipPO;
	private EnterpriseVipPO enterpriseVipPO;
	
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		userDAO = new UserDAOImpl();
		this.userID = "root";
		this.password = "root123";
		this.telNum = "12345123401";
		this.clientID = "原";
		this.clientPassword = "qwe123";
		this.clientTelNum = "12345678901";
		this.creditValue = 500;
		this.hotelStaffID = "hstaff0001";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.hotelStaffTelNum = "12312312301";
		this.hotelStaffPassword = "hstaff0001123";
		this.userPO = new UserPO("webMarket4", "market104", "15161416510", UserType.WebMarketStaff);
		ArrayList<CreditRecordPO> creditRecordPOs = new ArrayList<>();
		Date changeTime = new Date(116, 10, 26);
		Date changeTime2 = new Date(116, 10, 27);
		creditRecordPOs.add(new CreditRecordPO(changeTime, "0000000000000001", ActionType.ORDER_DONE, 200, 1100));
		creditRecordPOs.add(new CreditRecordPO(changeTime2, "0000000000000002", ActionType.ORDER_UNDO, -100, 1000));
		this.clientInfoPO = new ClientInfoPO("Accident", "123456789", "12345678906", UserType.Client, 1000, creditRecordPOs);
		this.hotelStaff = new HotelStaffInfoPO("hstaff0006", "hstaff0006123", "12312312306", UserType.HotelStaff, "上海长宁区仙霞西路585号");
		Date birth = new Date(97, 0, 1);
		this.regularVipPO = new RegularVipPO("Accident", "123456789", "12345678906", UserType.Client, 1000, creditRecordPOs, birth, 0000000000000003);
		this.enterpriseVipPO = new EnterpriseVipPO("lucy", "lucy123", "12345678904", UserType.Client, 700, null, "万达", "wanda666");
	}

	@Test
	public void testGetUserInfo() {
		try {
			UserPO userPO = userDAO.getUserInfo(userID);
			assertEquals(userID,userPO.getUserID());
			assertEquals(password, userPO.getpassword());
			assertEquals(telNum, userPO.getTelNum());
			assertEquals(UserType.WebManageStaff, userPO.getUserType());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void testGetClientInfo() {
		try {
			ClientInfoPO clientInfoPO = userDAO.getClientInfo(clientID);
			assertEquals(clientID,clientInfoPO.getUserID());
			assertEquals(clientPassword, clientInfoPO.getpassword());
			assertEquals(clientTelNum, clientInfoPO.getTelNum());
			assertEquals(UserType.Client, clientInfoPO.getUserType());
			assertEquals(creditValue, clientInfoPO.getCreditValue());
			assertNull(clientInfoPO.getCreditRecord());
			
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void testGetHotelStaffInfo() {
		try {
			HotelStaffInfoPO hotelStaffInfoPO = userDAO.getHotelStaffInfo(hotelStaffID);
			assertEquals(hotelStaffID,hotelStaffInfoPO.getUserID());
			assertEquals(hotelStaffPassword, hotelStaffInfoPO.getpassword());
			assertEquals(hotelStaffTelNum, hotelStaffInfoPO.getTelNum());
			assertEquals(UserType.HotelStaff, hotelStaffInfoPO.getUserType());
			assertEquals(hotelAddress, hotelStaffInfoPO.getHotelAddress());
			
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void testGetCreditValue() {
		try {
			int credit = userDAO.getCreditValue(clientID);
			assertEquals(creditValue, credit);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
//	@Test
//	public void testInsertUser() {
//		try {
//			userDAO.insertUser(userPO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
//	
//	@Test
//	public void testnsertClient() {
//		try {
//			userDAO.insertClient(clientInfoPO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
//	@Test
//	public void testInsertHotelStaff() {
//		try {
//			userDAO.insertHotelStaff(hotelStaff);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
//	@Test
//	public void testUpdateClient() {
//		try {
//			userDAO.updateClient(clientInfoPO, "Accident");
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
//	@Test
//	public void testUpdateUser() {
//		try {
//			userDAO.updateUser(userPO, "webMarket3");
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
//	@Test
//	public void testSignRegularVip() {
//		try {
//			userDAO.signRegularVip(regularVipPO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
//	@Test
//	public void testSignEnterpriseVip() {
//		try {
//			userDAO.signEnterpriseVip(enterpriseVipPO);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("Not yet implemented");
//		}
//	}
	
	@Test
	public void testQueryCreditRecord() {
		try {
			ArrayList<CreditRecordPO> creditRecordPOs = userDAO.queryCreditRecord("Accident");
			assertEquals(2, creditRecordPOs.size());
			assertEquals("0000000000000001", creditRecordPOs.get(0).getOrderID());
			assertEquals(ActionType.ORDER_DONE, creditRecordPOs.get(0).getAction());
			assertEquals(-100, creditRecordPOs.get(1).getProcess());
			assertEquals(1100, creditRecordPOs.get(0).getCreditResult());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void testGetRegularVipInfo() {
		try {
			RegularVipPO regularVipPO = userDAO.getRegularVipInfo("原");
			assertEquals("原", regularVipPO.getUserID());
			assertEquals(clientPassword, regularVipPO.getpassword());
			assertEquals(clientTelNum, regularVipPO.getTelNum());
			assertEquals(UserType.Client, regularVipPO.getUserType());
			assertEquals(creditValue, regularVipPO.getCreditValue());
			assertNull(regularVipPO.getCreditRecord());
			assertEquals(1, regularVipPO.getVipRank());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	@Test
	public void testGetEnterpriseVipInfo() {
		try {
			EnterpriseVipPO enterpriseVipPO = userDAO.getEnterpriseVipInfo("mike");
			assertEquals("mike", enterpriseVipPO.getUserID());
			assertEquals(UserType.Client, enterpriseVipPO.getUserType());
			assertEquals(1000, enterpriseVipPO.getCreditValue());
			assertNull(enterpriseVipPO.getCreditRecord());
			assertEquals("阿里巴巴", enterpriseVipPO.getEnterpriseID());
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}
	
	@Test
	public void testUpdateRegularVipInfo() {
		regularVipPO.setVipRank(0000000000000003);
		try {
			userDAO.updateRegularVipInfo(regularVipPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
