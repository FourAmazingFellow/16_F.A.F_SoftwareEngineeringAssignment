package org.FAF.businesslogic.userbl;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import businesslogic.userbl.ClientCreditInfoImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.CreditRecordPO;
import rmi.LinkToServer;

public class ClientCreditInfoImplTest {
    private ClientCreditInfoImpl clientCreditInfo;
    private String userID;
//    private String password;
//    private String telNum;
    private int creditValue;
    private String orderID;
    private ActionType actionType;
    private ArrayList<CreditRecordPO> creditRecord;
    private int num;
    private UserDAO userDAO;
    
    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        linkToServer.linkToServer();
    }
    
    @Before
    public void setUp() throws Exception {
        this.userID = "Accident";
//        this.password = "123456789";
//        this.telNum = "12345678906";
        this.creditValue = 1000;
//        int creditPre = creditValue;
//        @SuppressWarnings("deprecation")
//        CreditRecordPO creditRecordPO = new CreditRecordPO(new Date(2016, 11, 11), "2016111100001111", ActionType.ORDER_DONE, 500, creditPre+500);
//        this.creditRecord = new ArrayList<>();
//        creditRecord.add(creditRecordPO);
        this.num = 400;
        this.orderID = "0000000000000003";
        this.actionType = ActionType.ORDER_DONE;
     //   this.userDAO = new UserDAOImpl_Stub(this.userID, this.password, this.telNum, this.creditValue, this.creditRecord);
    }
    
    @Test
    public void testGetCreditValue() {
       clientCreditInfo = new ClientCreditInfoImpl();
       clientCreditInfo.setUserDAO(userDAO);
       assertEquals("ClientCreditInfo.getCreditValue(userID) has an error in creditValue!",this.creditValue,clientCreditInfo.getCreditValue(userID));
    }

    @Test
    public void testChangeCreditValue() {
      clientCreditInfo = new ClientCreditInfoImpl();
      clientCreditInfo.setUserDAO(userDAO);
      boolean result = clientCreditInfo.changeCreditValue(userID, num,orderID, actionType);
      assertEquals(true,result);
    }

}
