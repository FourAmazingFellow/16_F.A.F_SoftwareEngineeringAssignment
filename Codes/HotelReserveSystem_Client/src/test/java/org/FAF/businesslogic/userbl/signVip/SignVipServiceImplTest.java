package org.FAF.businesslogic.userbl.signVip;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.signVip.MockSignVipServiceImpl;
import businesslogic.userbl.signVip.SignVipServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserType;
import rmi.LinkToServer;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public class SignVipServiceImplTest {
    private SignVipServiceImpl signVip;
    private String userID, userIDe;
    private String password;
    private String telNum;
    private UserType userType;
    private Date birth;
    private String enterpriseID;
    private String enterprisePassword;
    private UserDAO userDAO;
    private RegularVipVO regularVip;
    private EnterpriseVipVO enterpriseVip;

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

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        this.userID = "newVip";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.userType = UserType.Client;
        this.birth = new Date(1994-1900, 10-1, 10);
        this.userIDe = "zxc";
        this.enterpriseID = "阿里巴巴";
        this.enterprisePassword = "alibaba6";
//        this.userDAO = new UserDAOImpl_Stub(userID, enterprisePassword, telNum);
//        this.regularVip = null;
//        this.enterpriseVip = null;
    }

    @Test
    public void testSignRegularVip() {
        signVip = new SignVipServiceImpl();
        signVip.setUserDAO(userDAO);
        regularVip = new RegularVipVO(userID, password, telNum, userType, 0, null, birth, 3);
        boolean result;
		try {
			result = signVip.signRegularVip(regularVip);
			assertEquals(true, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
    }

    @Test
    public void testSignEnterpriseVip() {
        signVip = new SignVipServiceImpl();
        signVip.setUserDAO(userDAO);
        signVip.setVerifyEnterpriseVip();
        enterpriseVip = new EnterpriseVipVO(userIDe, password, telNum, userType, 0, null, enterpriseID,
                enterprisePassword);
        boolean result;
		try {
			result = signVip.signEnterpriseVip(enterpriseVip);
			assertEquals(true, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
    }

}
