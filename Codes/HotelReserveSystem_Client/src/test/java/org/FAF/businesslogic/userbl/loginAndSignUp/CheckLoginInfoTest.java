package org.FAF.businesslogic.userbl.loginAndSignUp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.loginAndSignUp.CheckLoginInfo;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;

public class CheckLoginInfoTest {
    private CheckLoginInfo checkLoginInfo;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    private UserDAO userDAO;
    private UserPO userPO; 

    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.userType = UserType.Client;
        userDAO = new UserDAOImpl_Stub(userID, password, telNum);
        userPO = userDAO.getUserInfo(userID, userType);
    }

    @Test
    public void testCheckUser() {
        checkLoginInfo = new CheckLoginInfo();
        String userID = userPO.getUserID();
        String password = userPO.getPassword();
        boolean result = checkLoginInfo.checkUser(userID, password);
        assertEquals(true,result);
    }
}