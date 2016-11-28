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
import businesslogic.roombl.updateCheckOut.MockCheckOutList;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
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
        checkOutList=new MockCheckOutList();
        address = "江苏省南京市栖霞区仙林大道163号";
        actDepartTime = new Date(2016, 11, 12, 12, 0);
        startTime=new Date(2016, 11, 12, 00, 00, 00);
        startTime=new Date(2016, 11, 13, 00, 00, 00);
        roomType = RoomType.SINGLE_ROOM;
        checkOutVO=new CheckOutVO(roomType, 3, address, actDepartTime);
    }
    
    @Test
    public void testGetCheckOutList(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.getCheckOutList(address);
        assertEquals(1,checkOutItems.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testSearchCheckOutInfo1(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.searchCheckOutInfo(address, startTime, endTime);
        assertEquals(1,checkOutItems.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testSearchCheckOutInfo2(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.searchCheckOutInfo(address, roomType);
        assertEquals(1,checkOutItems.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
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
}
