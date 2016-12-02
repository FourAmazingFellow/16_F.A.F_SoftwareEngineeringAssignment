package org.FAF.businesslogic.userbl.addCreditValue;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.addCreditValue.AddCreditValueServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.CreditRecordPO;

public class AddCreditValueServiceImplTest {
    private AddCreditValueServiceImpl addCreditValue;
    private String userID;
    private String password;
    private String telNum;
    private int creditValue;
    private ArrayList<CreditRecordPO> creditRecord;
    private int creditAdded;
    private UserDAO userDAO;
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.creditValue = 500;
        this.creditAdded = 100;
        @SuppressWarnings("deprecation")
        CreditRecordPO creditRecordPO = new CreditRecordPO(new Date(2016, 11, 11), "2016111100001111", ActionType.ORDER_DONE, creditAdded, creditValue+creditAdded);
        creditRecord = new ArrayList<>();
        creditRecord.add(creditRecordPO);
        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum, creditValue, creditRecord);
        
    }
    
    @Test
    public void testAddCreditValue() {
     addCreditValue = new AddCreditValueServiceImpl();
     addCreditValue.setUserDAO(userDAO);
     boolean result = addCreditValue.addCreditValue(userID, creditAdded);
     assertEquals(true , result);

    }
	

}
