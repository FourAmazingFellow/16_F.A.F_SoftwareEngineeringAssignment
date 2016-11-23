package org.FAF.businesslogic.roombl.updateCheckIn;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckIn.CheckInItem;
import businesslogic.roombl.updateCheckIn.MockCheckInItem;
import po.RoomType;
import vo.CheckInOutVO;

public class CheckInItemTest {

    private CheckInItem checkInItem;
    private String address;
    private CheckInOutVO checkInVO;
    
    @SuppressWarnings("deprecation")
    @Before 
    public void setUp() throws Exception{
        checkInVO = new CheckInOutVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", new Date(2016, 11, 11, 12, 0),
                new Date(2016, 11, 11, 12, 0));
        checkInItem=new MockCheckInItem(checkInVO);
    }
    
    @Test
    public void testAddCheckIn(){
        boolean added=checkInItem.addCheckIn(address);
        assertTrue(added);
    }
    
    @Test
    public void testModifyCheckIn(){
        boolean modifyed=checkInItem.modifyCheckIn(address);
        assertTrue(modifyed);
    }
    
    @Test
    public void testDelCheckIn(){
        boolean deleted=checkInItem.modifyCheckIn(address);
        assertTrue(deleted);
    }
    
    public void testValidCheckIn(){
        boolean valid=checkInItem.validCheckIn();
        assertTrue(valid);
    }
}
