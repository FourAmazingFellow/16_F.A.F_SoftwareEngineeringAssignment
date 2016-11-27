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
    private boolean updateSpareRoom;
    
    @SuppressWarnings("deprecation")
    @Before 
    public void setUp() throws Exception{
        checkInVO = new CheckInOutVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", new Date(2016, 11, 11, 12, 0),
                new Date(2016, 11, 11, 12, 0));
        checkInItem=new MockCheckInItem(checkInVO);
        updateSpareRoom=true;
    }
    
    @Test
    public void testAddCheckIn(){
        boolean added=checkInItem.addCheckIn(address,updateSpareRoom);
        assertTrue(added);
    }

    public void testValidCheckIn(){
        boolean valid=checkInItem.validCheckIn();
        assertTrue(valid);
    }
}
