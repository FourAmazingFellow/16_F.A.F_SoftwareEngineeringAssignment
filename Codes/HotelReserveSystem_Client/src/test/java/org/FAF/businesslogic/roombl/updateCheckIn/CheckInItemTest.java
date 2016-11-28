package org.FAF.businesslogic.roombl.updateCheckIn;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckIn.CheckInItem;
import businesslogic.roombl.updateCheckIn.MockCheckInItem;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
import vo.CheckInVO;

public class CheckInItemTest {

    private CheckInItem checkInItem;
    private String address;
    private CheckInVO checkInVO;
    private boolean updateSpareRoom;
    
    @SuppressWarnings("deprecation")
    @Before 
    public void setUp() throws Exception{
        checkInVO = new CheckInVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", new Date(2016, 11, 11, 12, 0),
                new Date(2016, 11, 11, 12, 0));
        checkInItem=new MockCheckInItem(checkInVO);
        updateSpareRoom=true;
    }
    
    @Test
    public void testAddCheckIn(){
        boolean added = false;
        try {
            added = checkInItem.addCheckIn(address,updateSpareRoom);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(added);
    }

    public void testValidCheckIn(){
        boolean valid = false;
        try {
            valid = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.print(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valid);
    }
}
