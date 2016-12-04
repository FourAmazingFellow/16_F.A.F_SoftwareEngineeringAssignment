package org.FAF.businesslogic.roombl.updateCheckIn;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.roombl.updateCheckIn.CheckInItem;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
import rmi.LinkToServer;
import vo.CheckInVO;

public class CheckInItemTest {

    private CheckInItem checkInItem;
    private CheckInVO checkInVO;
    private boolean updateSpareRoom;
    private Date checkInTime;
    private Date expDepartTime;
    
    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        linkToServer.linkToServer();
    }

    @Before
    public void setUp() throws Exception {
        checkInTime = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkInTime);
        calendar.add(Calendar.DATE, 1);
        expDepartTime = calendar.getTime();
        checkInVO = new CheckInVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", checkInTime, expDepartTime);
        checkInItem = new CheckInItem(checkInVO);
        updateSpareRoom = true;
    }

    @Test
    public void testAddCheckIn() {
        boolean added = false;
        try {
            added = checkInItem.addCheckIn("江苏省南京市栖霞区仙林大道163号", updateSpareRoom);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(added);
    }

    @Test
    public void testValidCheckIn() {
        boolean valid = false;
        try {
            valid = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valid);
    }

    //验证地址长度必须小于50，地址名称必须正确
    @Test
    public void testValidCheckIn1() {
        boolean valid1 = false,valid2=false;
        checkInItem = new CheckInItem(
                new CheckInVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号"+"11111111111111111111111111111111111111111111", checkInTime, expDepartTime));
        try {
            valid1 = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkInItem = new CheckInItem(
                new CheckInVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区-,.仙林大道163号", checkInTime, expDepartTime));
        try {
            valid2 = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertFalse(valid1);
        assertFalse(valid2);
    }
    
    //验证房间数必须为正整数
    @Test
    public void testValidCheckIn2() {
        boolean valid = false;
        checkInItem = new CheckInItem(
                new CheckInVO(RoomType.SINGLE_ROOM, -2, "江苏省南京市栖霞区仙林大道163号", checkInTime, expDepartTime));
        try {
            valid = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertFalse(valid);
    }
    
    
    //验证入住时间必须为当天,且入住时间必须大于预计离开时间
    @SuppressWarnings("deprecation")
    @Test
    public void testValidCheckIn3() {
        boolean valid1 = false,valid2=false;
        
        checkInItem = new CheckInItem(
                new CheckInVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", new Date(116,10,30), expDepartTime));
        try {
            valid1 = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);;
        expDepartTime=calendar.getTime();
        checkInItem = new CheckInItem(
                new CheckInVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", checkInTime, expDepartTime));
        try {
            valid2 = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertFalse(valid1);
        assertFalse(valid2);
    }
    
    //必须存在该类型的空房，且空房数大于预订房间数
    @Test
    public void testValidCheckIn4() {
        boolean valid1 = false,valid2=false;
        checkInItem=new CheckInItem(new CheckInVO(RoomType.KING_SIZE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", checkInTime, expDepartTime));
        try {
            valid1 = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkInItem=new CheckInItem(new CheckInVO(RoomType.SINGLE_ROOM, 51, "江苏省南京市栖霞区仙林大道163号", checkInTime, expDepartTime));
        try {
            valid2 = checkInItem.validCheckIn();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valid1);
        assertFalse(valid2);
    }
}
