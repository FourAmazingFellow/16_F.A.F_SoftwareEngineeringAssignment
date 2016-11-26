package org.FAF.businesslogic.roombl.updateCheckIn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckIn.CheckInItem;
import businesslogic.roombl.updateCheckIn.CheckInList;
import businesslogic.roombl.updateCheckIn.MockCheckInList;
import po.RoomType;
import vo.CheckInOutVO;

public class CheckInListTest {

    private CheckInList checkInList;
    private String address;
    private Date checkInTime;
    private Enum<RoomType> roomType;
    private CheckInOutVO checkInVO;
    private Date startTime;
    private Date endTime;
    private boolean updateSpareRoom;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        checkInList = new MockCheckInList();
        address = "江苏省南京市栖霞区仙林大道163号";
        checkInTime = new Date(2016, 11, 11, 12, 0);
        startTime=new Date(2016, 11, 11, 00, 00, 00);
        startTime=new Date(2016, 11, 12, 00, 00, 00);
        roomType = RoomType.SINGLE_ROOM;
        checkInVO = new CheckInOutVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", checkInTime,
                new Date(2016, 11, 12, 12, 0));
        updateSpareRoom=true;
    }

    @Test
    public void testGetCheckInList() {
        ArrayList<CheckInItem> checkInItems=checkInList.getCheckInList(address);
        assertEquals(1,checkInItems.size());
        CheckInOutVO checkInfromArray=(CheckInOutVO) checkInItems.get(0).toVO();
        assertEquals(checkInVO.address, checkInfromArray.address);
        assertEquals(checkInVO.roomType, checkInfromArray.roomType);
        assertEquals(checkInVO.roomNum, checkInfromArray.roomNum);
        assertEquals(0,checkInVO.checkInTime.compareTo(checkInfromArray.checkInTime));
        assertEquals(0,checkInVO.expDepartTime.compareTo(checkInfromArray.expDepartTime));
    }

    @Test
    public void testSearchCheckInInfo1() {
        ArrayList<CheckInItem> checkInItems=checkInList.searchCheckInInfo(address, startTime, endTime);
        assertEquals(1,checkInItems.size());
        CheckInOutVO checkInfromArray=(CheckInOutVO) checkInItems.get(0).toVO();
        assertEquals(checkInVO.address, checkInfromArray.address);
        assertEquals(checkInVO.roomType, checkInfromArray.roomType);
        assertEquals(checkInVO.roomNum, checkInfromArray.roomNum);
        assertEquals(0,checkInVO.checkInTime.compareTo(checkInfromArray.checkInTime));
        assertEquals(0,checkInVO.expDepartTime.compareTo(checkInfromArray.expDepartTime));
    }

    @Test
    public void testSearchCheckInInfo2() {
        ArrayList<CheckInItem> checkInItems=checkInList.searchCheckInInfo(address, roomType);
        assertEquals(1,checkInItems.size());
        CheckInOutVO checkInfromArray=(CheckInOutVO) checkInItems.get(0).toVO();
        assertEquals(checkInVO.address, checkInfromArray.address);
        assertEquals(checkInVO.roomType, checkInfromArray.roomType);
        assertEquals(checkInVO.roomNum, checkInfromArray.roomNum);
        assertEquals(0,checkInVO.checkInTime.compareTo(checkInfromArray.checkInTime));
        assertEquals(0,checkInVO.expDepartTime.compareTo(checkInfromArray.expDepartTime));
    }

    @Test
    public void testAddCheckIn() {
        boolean added=checkInList.addCheckIn(address, checkInVO, updateSpareRoom);
        assertTrue(added);
    }

    @Test
    public void testValidCheckIn() {
        boolean valid=checkInList.validCheckIn(address, checkInVO);
        assertTrue(valid);
    }
}
