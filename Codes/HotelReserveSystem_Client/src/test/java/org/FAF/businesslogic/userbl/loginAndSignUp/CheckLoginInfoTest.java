package org.FAF.businesslogic.userbl.loginAndSignUp;

import static org.junit.Assert.*;

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
        linkToServer.linkToServer();
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
        UserType result = checkLoginInfo.checkUser(userID, password);
        assertNotNull(result);
        
    }
}