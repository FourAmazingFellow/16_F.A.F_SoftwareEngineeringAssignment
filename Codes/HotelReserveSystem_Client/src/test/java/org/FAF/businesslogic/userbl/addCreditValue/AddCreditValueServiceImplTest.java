package org.FAF.businesslogic.userbl.addCreditValue;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.addCreditValue.AddCreditValueServiceImpl;
import po.CreditRecordPO;
import po.UserType;
import vo.ClientInfoVO;

public class AddCreditValueServiceImplTest {
    private AddCreditValueServiceImpl addCreditValue;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    private int creditValue;
    private int creditAdded;
    private ArrayList<CreditRecordPO> creditRecord ;
    private ClientInfoVO clientInfoVO;
    
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.userType = UserType.Client;
        this.creditValue = 500;
        this.creditAdded = 100;
        clientInfoVO = new ClientInfoVO(userID, password, telNum, userType, creditValue, creditRecord);
        clientInfoVO.creditValue = this.creditValue;
    }
    
    @Test
    public void testAddCreditValue() {
     addCreditValue = new AddCreditValueServiceImpl();
     boolean result = addCreditValue.addCreditValue(userID, creditAdded);
     assertEquals(true , result);

    }
	

}
