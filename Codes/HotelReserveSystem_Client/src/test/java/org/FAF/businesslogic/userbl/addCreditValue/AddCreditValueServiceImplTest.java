package org.FAF.businesslogic.userbl.addCreditValue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.addCreditValue.AddCreditValueServiceImpl;
import businesslogic.userbl.addCreditValue.MockAddCreditValueServiceImpl;

public class AddCreditValueServiceImplTest {
    private AddCreditValueServiceImpl addCreditValue;
    private String userID;
    private int creditAdded;
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.creditAdded = 100;
    }
    
    @Test
    public void testAddCreditValue() {
     addCreditValue = new MockAddCreditValueServiceImpl();
     boolean result = addCreditValue.addCreditValue(userID, creditAdded);
     assertEquals(true , result);

    }
	

}
