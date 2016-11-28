package org.FAF.businesslogic.roombl.updateCheckOut;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckOut.CheckOutItem;
import businesslogic.roombl.updateCheckOut.MockCheckOutItem;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
import vo.CheckOutVO;

public class CheckOutItemTest {

    private CheckOutItem checkOutItem;
    private String address;
    private CheckOutVO checkOutVO;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        address="江苏省南京市栖霞区仙林大道163号";
        checkOutVO=new CheckOutVO(RoomType.SINGLE_ROOM, 3, address, new Date(2016, 11, 12, 18, 0));
        checkOutItem=new MockCheckOutItem(checkOutVO);
    }
    
    @Test
    public void testAddCheckOut(){
        boolean added = false;
        try {
            added = checkOutItem.addCheckOut(address);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(added);
    }

    @Test
    public void testValidCheckOut(){
        boolean valied = false;
        try {
            valied = checkOutItem.validCheckOut();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valied);
    }
}
