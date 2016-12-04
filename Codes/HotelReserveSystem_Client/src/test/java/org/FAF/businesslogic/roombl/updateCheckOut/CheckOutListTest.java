package org.FAF.businesslogic.roombl.updateCheckOut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckIn.CheckInItem;
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
    private CheckOutVO checkOutVO;
    private Date startTime;
    private Date endTime;
    
    private CheckOutVO checkOutVO1,checkOutVO2,checkOutVO3,checkOutVO4;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        checkOutList=new CheckOutList();
        
        address = "江苏省南京市栖霞区仙林大道163号";
        actDepartTime = new Date();
        startTime=new Date(116,9,7,12,00,00);
        endTime=new Date(116,10,12,12,00,00);
        checkOutVO=new CheckOutVO(RoomType.SINGLE_ROOM, 0000000000000003, address, actDepartTime);
        
        checkOutVO1=new CheckOutVO(RoomType.SINGLE_ROOM, 0000000000000003, "江苏省南京市栖霞区仙林大道163号", new Date(116,10,12,12,00,00));
        checkOutVO2=new CheckOutVO(RoomType.STANDARD_ROOM, 4, "江苏省南京市栖霞区仙林大道163号", new Date(116,9,7,12,00,00));
        checkOutVO3=new CheckOutVO(RoomType.TRIBLE_ROOM, 1, "江苏省南京市栖霞区仙林大道163号", new Date(116,9,1,10,10,00));
        checkOutVO4=new CheckOutVO(RoomType.KING_SIZE_ROOM, 1, "江苏省南京市栖霞区仙林大道164号", new Date(116,10,16,11,00,00));
    }
    
    @Test
    public void testGetCheckOutList(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.getCheckOutList("江苏省南京市栖霞区仙林大道163号");
        assertEquals(0000000000000003,checkOutItems.size());
//        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
//        assertTrue(equalCheckIn(checkOutVO, checkOutVOFromArray));
        for(CheckOutItem checkOutItem:checkOutItems){
            CheckOutVO checkOutVO=(CheckOutVO)checkOutItem.toVO();
            if(checkOutVO.roomType==RoomType.SINGLE_ROOM)
                assertTrue(equalCheckOut(checkOutVO, checkOutVO1));
            if(checkOutVO.roomType==RoomType.STANDARD_ROOM)
                assertTrue(equalCheckOut(checkOutVO, checkOutVO2));
            if(checkOutVO.roomType==RoomType.TRIBLE_ROOM)
                assertTrue(equalCheckOut(checkOutVO, checkOutVO3));
        }
        checkOutItems = checkOutList.getCheckOutList("江苏省南京市栖霞区仙林大道164号");
        assertEquals(1, checkOutItems.size());
        assertTrue(equalCheckOut(checkOutVO4, (CheckOutVO)checkOutItems.get(0).toVO()));
    }
    
    @Test
    public void testSearchCheckOutInfo1(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.searchCheckOutInfo("江苏省南京市栖霞区仙林大道163号", startTime, endTime);
        assertEquals(2,checkOutItems.size());
//        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
//        assertTrue(equalCheckIn(checkOutVO, checkOutVOFromArray));
        for(CheckOutItem checkOutItem:checkOutItems){
            CheckOutVO checkOutVO=(CheckOutVO)checkOutItem.toVO();
            if(checkOutVO.roomType==RoomType.SINGLE_ROOM){
                assertTrue(equalCheckOut(checkOutVO, checkOutVO1));
            }
            if(checkOutVO.roomType==RoomType.STANDARD_ROOM){
                assertTrue(equalCheckOut(checkOutVO, checkOutVO2));
            }
        }
    }
    
    @Test
    public void testSearchCheckOutInfo2(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.searchCheckOutInfo("江苏省南京市栖霞区仙林大道163号", RoomType.TRIBLE_ROOM);
        assertEquals(1,checkOutItems.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutItems.get(0).toVO();
        assertTrue(equalCheckOut(checkOutVO3, checkOutVOFromArray));
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
    
    public boolean equalCheckOut(CheckOutVO checkOutVO1, CheckOutVO checkOutVO2) {
        if (checkOutVO1.roomType != checkOutVO2.roomType || checkOutVO1.roomNum != checkOutVO2.roomNum
                || checkOutVO1.roomPrice != checkOutVO2.roomPrice || checkOutVO1.address != checkOutVO2.address
                || checkOutVO1.actDepartTime.compareTo(checkOutVO2.actDepartTime) != 0) {
            return false;
        }
        return true;
    }
}
