package userdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.userdata.UserDAOImpl;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.HotelStaffInfoPO;
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
		this.userPO = new UserPO("webMarket3", "market103", "15161416509", UserType.WebMarketStaff);
		this.clientInfoPO = new ClientInfoPO("Accident", "123456789", "12345678906", UserType.Client, 900, null);
		this.hotelStaff = new HotelStaffInfoPO("hstaff0006", "hstaff0006123", "12312312306", UserType.HotelStaff, "上海长宁区仙霞西路585号");
		
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
			assertEquals(hotelAddress, hotelStaffInfoPO.getEnterpriseName());
			
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
	
	@Test
	public void testInsertHotelStaff() {
		try {
			userDAO.insertHotelStaff(hotelStaff);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
