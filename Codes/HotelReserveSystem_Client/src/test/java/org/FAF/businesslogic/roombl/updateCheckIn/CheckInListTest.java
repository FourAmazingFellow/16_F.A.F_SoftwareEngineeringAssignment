package org.FAF.businesslogic.roombl.updateCheckIn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.roombl.updateCheckIn.CheckInItem;
import businesslogic.roombl.updateCheckIn.CheckInList;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
import rmi.LinkToServer;
import vo.CheckInVO;

public class CheckInListTest {

    private CheckInList checkInList;
    private String address;
    private Date checkInTime;
    private Date expDepartTime;
    private CheckInVO checkInVO;
    private Date startTime;
    private Date endTime;
    private boolean updateSpareRoom;
    
    private CheckInVO checkInVO1,checkInVO2,checkInVO3,checkInVO4;

    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        linkToServer.linkToServer();
    }
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        checkInList = new CheckInList();
        address = "江苏省南京市栖霞区仙林大道163号";
        checkInTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkInTime);
        calendar.add(Calendar.DATE, 1);
        expDepartTime = calendar.getTime();
        startTime =new Date(116,9,5,12,00,00);
        endTime = new Date(116,10,11,12,00,00);
        checkInVO = new CheckInVO(RoomType.SINGLE_ROOM, 3, address, checkInTime, expDepartTime);
        updateSpareRoom = true;
        
        checkInVO1=new CheckInVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", new Date(116,10,11,12,00,00), new Date(116,10,12,12,00,00));
        checkInVO2=new CheckInVO(RoomType.STANDARD_ROOM, 4, "江苏省南京市栖霞区仙林大道163号", new Date(116,9,5,12,00,00), new Date(116,9,6,12,00,00));
        checkInVO3=new CheckInVO(RoomType.TRIBLE_ROOM, 1, "江苏省南京市栖霞区仙林大道163号", new Date(116,8,20,12,00,00), new Date(116,9,1,12,00,00));
        checkInVO4=new CheckInVO(RoomType.KING_SIZE_ROOM, 1, "江苏省南京市栖霞区仙林大道164号", new Date(116,10,15,13,00,00), new Date(116,10,16,13,00,00));

    }

    @Test
    public void testGetCheckInList() {
        ArrayList<CheckInItem> checkInItems = checkInList.getCheckInList("江苏省南京市栖霞区仙林大道163号");
        assertEquals(3, checkInItems.size());
        for(CheckInItem checkInItem:checkInItems){
            CheckInVO checkInVO=(CheckInVO)checkInItem.toVO();
            if(checkInVO.roomType==RoomType.SINGLE_ROOM)
                assertTrue(equalCheckIn(checkInVO, checkInVO1));
            if(checkInVO.roomType==RoomType.STANDARD_ROOM)
                assertTrue(equalCheckIn(checkInVO, checkInVO2));
            if(checkInVO.roomType==RoomType.TRIBLE_ROOM)
                assertTrue(equalCheckIn(checkInVO, checkInVO3));
        }
        checkInItems = checkInList.getCheckInList("江苏省南京市栖霞区仙林大道164号");
        assertEquals(1, checkInItems.size());
        assertTrue(equalCheckIn(checkInVO4, (CheckInVO)checkInItems.get(0).toVO()));
    }

    @Test
    public void testSearchCheckInInfo1() {
        ArrayList<CheckInItem> checkInItems = checkInList.searchCheckInInfo("江苏省南京市栖霞区仙林大道163号", startTime, endTime);
        assertEquals(2, checkInItems.size());
        for(CheckInItem checkInItem:checkInItems){
            CheckInVO checkInVO=(CheckInVO)checkInItem.toVO();
            if(checkInVO.roomType==RoomType.SINGLE_ROOM){
                assertTrue(equalCheckIn(checkInVO, checkInVO1));
            }
            if(checkInVO.roomType==RoomType.STANDARD_ROOM){
                assertTrue(equalCheckIn(checkInVO, checkInVO2));
            }
        }
    }

    @Test
    public void testSearchCheckInInfo2() {
        ArrayList<CheckInItem> checkInItems = checkInList.searchCheckInInfo("江苏省南京市栖霞区仙林大道163号", RoomType.TRIBLE_ROOM);
        assertEquals(1, checkInItems.size());
        CheckInVO checkInfromArray = (CheckInVO) checkInItems.get(0).toVO();
        assertTrue(equalCheckIn(checkInVO3, checkInfromArray));
    }

//    @Test
//    public void testAddCheckIn() {
//        boolean added = false;
//        try {
//            added = checkInList.addCheckIn(address, checkInVO, updateSpareRoom);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        assertTrue(added);
//    }

    @Test
    public void testValidCheckIn() {
        boolean valid = false;
        try {
            valid = checkInList.validCheckIn(address, checkInVO);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valid);
    }

    public boolean equalCheckIn(CheckInVO checkInVO1, CheckInVO checkInVO2) {
        if (checkInVO1.roomType != checkInVO2.roomType || checkInVO1.roomNum != checkInVO2.roomNum
                || checkInVO1.roomPrice != checkInVO2.roomPrice || !checkInVO1.address.equals(checkInVO2.address)
                || checkInVO1.checkInTime.compareTo(checkInVO2.checkInTime) != 0
                || checkInVO1.expDepartTime.compareTo(checkInVO2.expDepartTime) != 0) {
            return false;
        }
        return true;
    }
}
