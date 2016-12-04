package org.FAF.businesslogic.userbl.addCreditValue;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.addCreditValue.AddCreditValueServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.CreditRecordPO;
import rmi.LinkToServer;

public class AddCreditValueServiceImplTest {
    private AddCreditValueServiceImpl addCreditValue;
    private String userID;
//    private String password;
//    private String telNum;
//    private int creditValue;
//    private ArrayList<CreditRecordPO> creditRecord;
    private int creditAdded;
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
//        this.password = "qwe123";
//        this.telNum = "12345678900";
//        this.creditValue = 1000;
        this.creditAdded = 100;
//        @SuppressWarnings("deprecation")
//        CreditRecordPO creditRecordPO1 = new CreditRecordPO(new Date(2016-1900, 11-1, 26), "0000000000000001",
//                ActionType.ORDER_DONE, 200, 1100);
//        @SuppressWarnings("deprecation")
//        CreditRecordPO creditRecordPO2 = new CreditRecordPO(new Date(2016-1900, 11-1, 27), "0000000000000002", ActionType.ORDER_UNDO, -100, 1000);
//        this.creditRecord = new ArrayList<>();
//        creditRecord.add(creditRecordPO1);
//        creditRecord.add(creditRecordPO2);
    //    this.userDAO = new UserDAOImpl_Stub(userID, password, telNum, creditValue, creditRecord);
        
    }
    
    @Test
    public void testAddCreditValue() {
     addCreditValue = new AddCreditValueServiceImpl();
     addCreditValue.setUserDAO(userDAO);
     boolean result = addCreditValue.addCreditValue(userID, creditAdded);
     assertEquals(true , result);

    }
	

}
