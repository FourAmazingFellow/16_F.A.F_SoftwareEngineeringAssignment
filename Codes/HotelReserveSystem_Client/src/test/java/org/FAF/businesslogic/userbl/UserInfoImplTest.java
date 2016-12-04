package org.FAF.businesslogic.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.MockUserInfoImpl;
import businesslogic.userbl.UserInfoImpl;
import dataservice.userDAO.UserDAO;
import po.UserType;
import rmi.LinkToServer;
import vo.HotelStaffInfoVO;

public class UserInfoImplTest {
    private UserInfoImpl userInfoImpl;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    private String hotelAddress;
    private UserDAO userDAO;

    private static LinkToServer linkToServer;

    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        linkToServer.linkToServer();
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testInsert() {
        userInfoImpl = new UserInfoImpl();
        userInfoImpl.setUserDAO(userDAO);
        HotelStaffInfoVO staff = new HotelStaffInfoVO(userID, password, telNum, userType, hotelAddress);
        boolean result = userInfoImpl.insert(staff);
        assertEquals(true, result);
    }

}
