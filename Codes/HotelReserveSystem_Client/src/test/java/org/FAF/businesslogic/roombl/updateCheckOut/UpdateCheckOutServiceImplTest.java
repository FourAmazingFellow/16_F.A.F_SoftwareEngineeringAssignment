package org.FAF.businesslogic.roombl.updateCheckOut;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckOut.UpdateCheckOutServiceImpl;
import po.RoomType;
import vo.CheckInOutVO;
import vo.RoomVO;

public class UpdateCheckOutServiceImplTest {

    private UpdateCheckOutServiceImpl updateCheckOutServiceImpl;
    private String address;
    private Date actDepartTime;
    private Enum<RoomType> roomType;
    private CheckInOutVO checkOutVO;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        updateCheckOutServiceImpl=new UpdateCheckOutServiceImpl();
        address = "江苏省南京市栖霞区仙林大道163号";
        actDepartTime = new Date(2016, 11, 12, 12, 0);
        roomType = RoomType.SINGLE_ROOM;
        checkOutVO=new CheckInOutVO(roomType, 3, address, actDepartTime);
    }
    
    @Test
    public void testGetCheckOutList(){
        ArrayList<RoomVO> checkOutVOs=updateCheckOutServiceImpl.getCheckOutList(address);
        assertEquals(1,checkOutVOs.size());
        CheckInOutVO checkOutVOFromArray=(CheckInOutVO) checkOutVOs.get(0);
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testSearchCheckOutInfo1(){
        ArrayList<RoomVO> checkOutVOs=updateCheckOutServiceImpl.searchCheckOutInfo(address, actDepartTime);
        assertEquals(1,checkOutVOs.size());
        CheckInOutVO checkOutVOFromArray=(CheckInOutVO) checkOutVOs.get(0);
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testSearchCheckOutInfo2(){
        ArrayList<RoomVO> checkOutVOs=updateCheckOutServiceImpl.searchCheckOutInfo(address, roomType);
        assertEquals(1,checkOutVOs.size());
        CheckInOutVO checkOutVOFromArray=(CheckInOutVO) checkOutVOs.get(0);
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testAddCheckOut(){
        boolean added=updateCheckOutServiceImpl.addCheckOut(address, checkOutVO);
        assertTrue(added);
    }
    
    @Test
    public void testModifyCheckOut(){
        boolean modifyed=updateCheckOutServiceImpl.modifyCheckOut(address, checkOutVO);
        assertTrue(modifyed);
    }
    
    @Test
    public void testDelCheckOut(){
        boolean deleted=updateCheckOutServiceImpl.delCheckOut(address, checkOutVO);
        assertTrue(deleted);
    }
    
    @Test
    public void testValidCheckOut(){
        boolean valid=updateCheckOutServiceImpl.validCheckOut(address, checkOutVO);
        assertTrue(valid);
    }
}
