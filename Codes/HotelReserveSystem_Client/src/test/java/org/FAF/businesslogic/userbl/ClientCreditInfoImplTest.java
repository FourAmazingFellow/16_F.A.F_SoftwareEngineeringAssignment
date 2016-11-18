package org.FAF.businesslogic.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.ClientCreditInfoImpl;
import businesslogic.userbl.MockClientCreditInfoImpl;

public class ClientCreditInfoImplTest {
    private ClientCreditInfoImpl clientCreditInfo;
    private int creditValue;
    private String userID;
    private int num;
    
    @Before
    public void setUp() throws Exception {
        this.creditValue = 400;
    }
    
    @Test
    public void testGetCreditValue() {
       clientCreditInfo = new MockClientCreditInfoImpl();
       assertEquals("ClientCreditInfo.getCreditValue(userID) has an error in creditValue!",this.creditValue,clientCreditInfo.getCreditValue(userID));
    }

    @Test
    public void testChangeCreditValue() {
      clientCreditInfo = new MockClientCreditInfoImpl();
      boolean result = clientCreditInfo.changeCreditValue(userID, num);
      assertEquals(true,result);
    }

}
