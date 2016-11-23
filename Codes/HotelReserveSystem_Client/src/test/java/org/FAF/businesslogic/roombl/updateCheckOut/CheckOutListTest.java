package org.FAF.businesslogic.roombl.updateCheckOut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckOut.CheckOutItem;
import businesslogic.roombl.updateCheckOut.CheckOutList;
import businesslogic.roombl.updateCheckOut.MockCheckOutList;
import po.RoomType;
import vo.CheckInOutVO;

public class CheckOutListTest {

    private CheckOutList checkOutList;
    private String address;
    private Date actDepartTime;
    private Enum<RoomType> roomType;
    private CheckInOutVO checkOutVO;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        checkOutList=new MockCheckOutList();
        address = "江苏省南京市栖霞区仙林大道163号";
        actDepartTime = new Date(2016, 11, 12, 12, 0);
        roomType = RoomType.SINGLE_ROOM;
        checkOutVO=new CheckInOutVO(roomType, 3, address, actDepartTime);
    }
    
    @Test
    public void testGetCheckOutList(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.getCheckOutList(address);
        assertEquals(1,checkOutItems.size());
        CheckInOutVO checkOutVOFromArray=(CheckInOutVO) checkOutItems.get(0).toVO();
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testSearchCheckOutInfo1(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.searchCheckOutInfo(address, actDepartTime);
        assertEquals(1,checkOutItems.size());
        CheckInOutVO checkOutVOFromArray=(CheckInOutVO) checkOutItems.get(0).toVO();
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testSearchCheckOutInfo2(){
        ArrayList<CheckOutItem> checkOutItems=checkOutList.searchCheckOutInfo(address, roomType);
        assertEquals(1,checkOutItems.size());
        CheckInOutVO checkOutVOFromArray=(CheckInOutVO) checkOutItems.get(0).toVO();
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testAddCheckOut(){
        boolean added=checkOutList.addCheckOut(address, checkOutVO);
        assertTrue(added);
    }
    
    @Test
    public void testModifyCheckOut(){
        boolean modifyed=checkOutList.modifyCheckOut(address, checkOutVO);
        assertTrue(modifyed);
    }
    
    @Test
    public void testDelCheckOut(){
        boolean deleted=checkOutList.delCheckOut(address, checkOutVO);
        assertTrue(deleted);
    }
    
    @Test
    public void testValidCheckOut(){
        boolean valid=checkOutList.validCheckOut(address, checkOutVO);
        assertTrue(valid);
    }
}
