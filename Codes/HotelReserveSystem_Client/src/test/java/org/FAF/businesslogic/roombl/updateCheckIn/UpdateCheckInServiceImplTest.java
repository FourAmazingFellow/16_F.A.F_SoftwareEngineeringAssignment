package org.FAF.businesslogic.roombl.updateCheckIn;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckIn.UpdateCheckInServiceImpl;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
import vo.CheckInVO;
import vo.RoomVO;

public class UpdateCheckInServiceImplTest {

    private UpdateCheckInServiceImpl updateCheckInServiceImpl;
    private String address;
    private Date checkInTime;
    private Date expDepartTime;
    private Enum<RoomType> roomType;
    private CheckInVO checkInVO;
    private Date startTime;
    private Date endTime;
    private boolean updateSpareRoom;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        updateCheckInServiceImpl = new UpdateCheckInServiceImpl();
        address = "江苏省南京市栖霞区仙林大道163号";
        checkInTime = new Date(116,11,1,17,13);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkInTime);
        calendar.add(Calendar.DATE, 1);
        expDepartTime = calendar.getTime();
        startTime=checkInTime;
        endTime=expDepartTime;
        roomType = RoomType.SINGLE_ROOM;
        checkInVO = new CheckInVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", checkInTime,
                expDepartTime);
        updateSpareRoom=true;
    }

    @Test
    public void testGetCheckInList() {
        ArrayList<RoomVO> checkInVOs=updateCheckInServiceImpl.getCheckInList(address);
        assertEquals(1,checkInVOs.size());
        CheckInVO checkInfromArray=(CheckInVO)checkInVOs.get(0);
        assertTrue(equalCheckIn(checkInVO, checkInfromArray));
    }

    @Test
    public void testSearchCheckInInfo1() {
        ArrayList<RoomVO> checkInVOs=updateCheckInServiceImpl.searchCheckInInfo(address,startTime,endTime);
        assertEquals(1,checkInVOs.size());
        CheckInVO checkInfromArray=(CheckInVO)checkInVOs.get(0);
        assertTrue(equalCheckIn(checkInVO, checkInfromArray));
    }

    @Test
    public void testSearchCheckInInfo2() {
        ArrayList<RoomVO> checkInVOs=updateCheckInServiceImpl.searchCheckInInfo(address, roomType);
        assertEquals(1,checkInVOs.size());
        CheckInVO checkInfromArray=(CheckInVO)checkInVOs.get(0);
        assertTrue(equalCheckIn(checkInVO, checkInfromArray));
    }

    @Test
    public void testAddCheckIn() {
        boolean added = false;
        try {
            added = updateCheckInServiceImpl.addCheckIn(address, checkInVO, updateSpareRoom);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        assertTrue(added);
    }

    @Test
    public void testValidCheckIn() {
        boolean valid = false;
        try {
            valid = updateCheckInServiceImpl.validCheckIn(address, checkInVO);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valid);
    }
    
    public boolean equalCheckIn(CheckInVO checkInVO1, CheckInVO checkInVO2) {
        if (checkInVO1.roomType != checkInVO2.roomType || checkInVO1.roomNum != checkInVO2.roomNum
                || checkInVO1.roomPrice != checkInVO2.roomPrice || checkInVO1.address != checkInVO2.address
                || checkInVO1.checkInTime.compareTo(checkInVO2.checkInTime) != 0
                || checkInVO1.expDepartTime.compareTo(checkInVO2.expDepartTime) != 0) {
            return false;
        }
        return true;
    }
}
