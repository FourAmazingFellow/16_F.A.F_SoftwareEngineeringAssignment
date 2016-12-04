package org.FAF.businesslogic.userbl.queryClientCreditRecord;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.queryClientCreditRecord.QueryClientCreditRecordServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.CreditRecordPO;
import rmi.LinkToServer;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public class QueryClientCreditRecordServiceImplTest {
    private QueryClientCreditRecordServiceImpl queryClientCreditRecord;
    private String userID;
//    private String password;
//    private String telNum;
//    private int creditValue;
    private ArrayList<CreditRecordPO> creditRecord;
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
//        this.creditValue = 1000;
        @SuppressWarnings("deprecation")
        CreditRecordPO creditRecordPO1 = new CreditRecordPO(new Date(2016-1900, 11-1, 26), "0000000000000001",
                ActionType.ORDER_DONE, 200, 1100);
        @SuppressWarnings("deprecation")
        CreditRecordPO creditRecordPO2 = new CreditRecordPO(new Date(2016-1900, 11-1, 27), "0000000000000002", ActionType.ORDER_UNDO, -100, 1000);
        this.creditRecord = new ArrayList<>();
        creditRecord.add(creditRecordPO1);
        creditRecord.add(creditRecordPO2);
     //   this.userDAO = new UserDAOImpl_Stub(userID, password, telNum, creditValue, creditRecord);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void queryCreditRecord() {
        queryClientCreditRecord = new QueryClientCreditRecordServiceImpl();
        queryClientCreditRecord.setUserDAO(userDAO);
        assertEquals(creditRecord.get(0).getChangeTime(), new Date(2016-1900, 11-1, 26));
        assertEquals(creditRecord.get(0).getOrderID(), "0000000000000001");
        assertEquals(creditRecord.get(1).getAction(), ActionType.ORDER_UNDO);
        assertEquals(creditRecord.get(1).getProcess(), -100);
        assertEquals(creditRecord.get(1).getCreditResult(), 1000);
    }

}