package org.FAF.businesslogic.userbl.queryClientCreditRecord;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.queryClientCreditRecord.QueryClientCreditRecordServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.CreditRecordPO;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public class QueryClientCreditRecordServiceImplTest {
    private QueryClientCreditRecordServiceImpl queryClientCreditRecord;
    private String userID;
    private String password;
    private String telNum;
    private int creditValue;
    private ArrayList<CreditRecordPO> creditRecord;
    private UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.creditValue = 500;
        @SuppressWarnings("deprecation")
        CreditRecordPO creditRecordPO = new CreditRecordPO(new Date(2016, 11, 11), "2016111100001111",
                ActionType.ORDER_DONE, 500, creditValue + 500);
        this.creditRecord = new ArrayList<>();
        creditRecord.add(creditRecordPO);
        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum, creditValue, creditRecord);
    }

    @Test
    public void queryCreditRecord() {
        queryClientCreditRecord = new QueryClientCreditRecordServiceImpl();
        queryClientCreditRecord.setUserDAO(userDAO);
        assertEquals("QueryClientCreditRecordService.queryCreditRecord(userID) has an error in creditRecord!",
                creditRecord, queryClientCreditRecord.queryCreditRecord(userID));
    }

}