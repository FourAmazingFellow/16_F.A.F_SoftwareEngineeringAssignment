package org.FAF.businesslogic.roombl.updateCheckOut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckOut.CheckOutItem;
import businesslogic.roombl.updateCheckOut.CheckOutList;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
import vo.CheckInVO;
import vo.CheckOutVO;

public class CheckOutListTest {

    private CheckOutList checkOutList;
    private String address;
    private Date actDepartTime;
    private Enum<RoomType> roomType;
    private CheckOutVO checkOutVO;
    private Date startTime;
    private Date endTime;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        checkOutList=new CheckOutList();
        address = "江苏省南京市栖霞区仙林大道163号";
        actDepartTime = new Date(116, 11, 1, 17, 13);
        startTime=new Date(116, 11, 1, 17, 13, 00);
        endTime=new Date(116, 11, 2, 17, 13, 00);
        roomType = RoomType.SINGLE_ROOM;
        checkOutVO=new CheckOutVO(roomType, 3, address, actDepartTime);
    }
    
    @Test
    public void testGetCheckOutList(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.getCheckOutList(address);
        assertEquals(1,checkOutItems.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
        assertTrue(equalCheckIn(checkOutVO, checkOutVOFromArray));
    }
    
    @Test
    public void testSearchCheckOutInfo1(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.searchCheckOutInfo(address, startTime, endTime);
        assertEquals(1,checkOutItems.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
        assertTrue(equalCheckIn(checkOutVO, checkOutVOFromArray));
    }
    
    @Test
    public void testSearchCheckOutInfo2(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.searchCheckOutInfo(address, roomType);
        assertEquals(1,checkOutItems.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
        assertTrue(equalCheckIn(checkOutVO, checkOutVOFromArray));
    }
    
    @Test
    public void testAddCheckOut(){
        boolean added = false;
        try {
            added = checkOutList.addCheckOut(address, checkOutVO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(added);
    }

    @Test
    public void testValidCheckOut(){
        boolean valid = false;
        try {
            valid = checkOutList.validCheckOut(address, checkOutVO);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valid);
    }
    
    public boolean equalCheckIn(CheckOutVO checkOutVO1, CheckOutVO checkOutVO2) {
        if (checkOutVO1.roomType != checkOutVO2.roomType || checkOutVO1.roomNum != checkOutVO2.roomNum
                || checkOutVO1.roomPrice != checkOutVO2.roomPrice || checkOutVO1.address != checkOutVO2.address
                || checkOutVO1.actDepartTime.compareTo(checkOutVO2.actDepartTime) != 0) {
            return false;
        }
        return true;
    }
}
