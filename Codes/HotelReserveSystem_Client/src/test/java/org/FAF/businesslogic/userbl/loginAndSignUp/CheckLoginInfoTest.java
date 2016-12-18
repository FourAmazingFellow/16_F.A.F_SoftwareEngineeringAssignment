package org.FAF.businesslogic.userbl.loginAndSignUp;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.loginAndSignUp.CheckLoginInfo;
import dataservice.userDAO.UserDAO;
import po.UserType;
import rmi.LinkToServer;

public class CheckLoginInfoTest {
    private CheckLoginInfo checkLoginInfo;
    private String userID;
    private String password;
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
//        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum);
    }

    @Test
    public void testCheckUser() {
        checkLoginInfo = new CheckLoginInfo();
        checkLoginInfo.setUserDAO(userDAO);
        UserType result;
		try {
			result = checkLoginInfo.checkUser(userID, password);
			assertNotNull(result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
        
    }
}