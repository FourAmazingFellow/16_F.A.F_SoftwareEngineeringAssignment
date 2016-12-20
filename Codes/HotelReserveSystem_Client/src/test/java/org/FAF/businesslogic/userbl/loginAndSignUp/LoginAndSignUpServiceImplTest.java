package org.FAF.businesslogic.userbl.loginAndSignUp;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.loginAndSignUp.CheckLoginInfo;
import businesslogic.userbl.loginAndSignUp.LoginAndSignUpServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserType;
import rmi.LinkToServer;
import vo.UserVO;

public class LoginAndSignUpServiceImplTest {
	private LoginAndSignUpServiceImpl loginAndSignUp;
	private String userID, userIDNew;
	private String password, passwordNew;
	private String telNum, telNumNew;
	private UserType userType, userTypeNew;
	private UserDAO userDAO;

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

	@Before
	public void setUp() throws Exception {
		this.userID = "原";
		this.password = "qwe123";
		this.telNum = "12345678901";
		this.userType = UserType.Client;

		this.userIDNew = "zxc";
		this.passwordNew = "zxc123";
		this.telNumNew = "12345678911";
		this.userTypeNew = UserType.Client;
		// this.userDAO = new UserDAOImpl_Stub(userID, password, telNum);
	}

	@Test
	public void testLogin() {
		loginAndSignUp = new LoginAndSignUpServiceImpl();
		// check = new CheckLoginInfo();
		// check.setUserDAO(userDAO);
		boolean result;
		try {
			result = loginAndSignUp.login(userID, password);
			assertEquals(true, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testAdd() {
		loginAndSignUp = new LoginAndSignUpServiceImpl();
		UserVO user = new UserVO(userIDNew, passwordNew, telNumNew, userTypeNew);
		boolean result;
		try {
			result = loginAndSignUp.add(user);
			assertEquals(true, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
	}

}
