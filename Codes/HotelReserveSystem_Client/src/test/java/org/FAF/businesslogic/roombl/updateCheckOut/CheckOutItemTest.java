package org.FAF.businesslogic.roombl.updateCheckOut;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckOut.CheckOutItem;
import businesslogic.roombl.updateCheckOut.MockCheckOutItem;
import po.RoomType;
import vo.CheckInOutVO;

public class CheckOutItemTest {

    private CheckOutItem checkOutItem;
    private String address;
    private CheckInOutVO checkOutVO;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        address="江苏省南京市栖霞区仙林大道163号";
        checkOutVO=new CheckInOutVO(RoomType.SINGLE_ROOM, 3, address, new Date(2016, 11, 12, 18, 0));
        checkOutItem=new MockCheckOutItem(checkOutVO);
    }
    
    @Test
    public void testAddCheckOut(){
        boolean added=checkOutItem.addCheckOut(address);
        assertTrue(added);
    }

    @Test
    public void testValidCheckOut(){
        boolean valied=checkOutItem.validCheckOut();
        assertTrue(valied);
    }
}
