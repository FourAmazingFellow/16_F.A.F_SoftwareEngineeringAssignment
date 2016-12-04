package org.FAF.businesslogic.userbl.modifyClientInfo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.modifyClientInfo.ModifyClientInfoServiceImpl;
import dataservice.userDAO.UserDAO;
import po.UserType;
import rmi.LinkToServer;
import vo.ClientInfoVO;

public class ModifyClientInfoServiceImplTest {
    private ModifyClientInfoServiceImpl modifyClientInfo;
    private String userID;
    private String password;
    private String telNum;
    private int creditValue;
    private ClientInfoVO clientInfoVO;
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
        this.telNum = "12345678900";
        this.creditValue = 900;
        // this.userDAO = new UserDAOImpl_Stub(userID, password, telNum,
        // creditValue, null);
    }

    @Test
    public void testGetClientInfo() {
        modifyClientInfo = new ModifyClientInfoServiceImpl(userID);
        modifyClientInfo.setUserDAO(userDAO);
        this.clientInfoVO = modifyClientInfo.getClientInfo(userID);
        assertEquals("ModifyClientInfoService.getUserInfo(userID,userType) has an error in userID!", userID,
                clientInfoVO.userID);
        assertEquals("ModifyClientInfoService.getUserInfo(userID,userType) has an error in password!", password,
                clientInfoVO.password);
        assertEquals("ModifyClientInfoService.getUserInfo(userID,userType) has an error in telNum!", telNum,
                clientInfoVO.telNum);
        assertEquals("ModifyClientInfoService.getUserInfo(userID,userType) has an error in creditValue!", creditValue,
                clientInfoVO.creditValue);
    }

    @Test
    public void testModifyClientInfo() {
        modifyClientInfo = new ModifyClientInfoServiceImpl(userID);
        modifyClientInfo.setUserDAO(userDAO);
        this.clientInfoVO = modifyClientInfo.getClientInfo(userID);
        ClientInfoVO modified = new ClientInfoVO(clientInfoVO.userID, clientInfoVO.password, "12345678900",
                UserType.Client, clientInfoVO.creditValue, clientInfoVO.creditRecord);
        boolean result = modifyClientInfo.modifyClientInfo(modified, userID);
        assertEquals(true, result);
    }

}
