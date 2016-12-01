package org.FAF.businesslogic.roombl.updateCheckOut;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.roombl.updateCheckOut.UpdateCheckOutServiceImpl;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
import vo.CheckOutVO;
import vo.RoomVO;

public class UpdateCheckOutServiceImplTest {

    private UpdateCheckOutServiceImpl updateCheckOutServiceImpl;
    private String address;
    private Date actDepartTime;
    private Enum<RoomType> roomType;
    private CheckOutVO checkOutVO;
    private Date startTime;
    private Date endTime;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        updateCheckOutServiceImpl=new UpdateCheckOutServiceImpl();
        
        address = "江苏省南京市栖霞区仙林大道163号";
        actDepartTime = new Date(116, 11, 1, 17, 13);
        startTime=new Date(116, 11, 1, 17, 13, 00);
        endTime=new Date(116, 11, 2, 17, 13, 00);
        roomType = RoomType.SINGLE_ROOM;
        checkOutVO=new CheckOutVO(roomType, 3, address, actDepartTime);
    }
    
    @Test
    public void testGetCheckOutList(){
        ArrayList<RoomVO> checkOutVOs=updateCheckOutServiceImpl.getCheckOutList(address);
        assertEquals(1,checkOutVOs.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutVOs.get(0);
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testSearchCheckOutInfo1(){
        ArrayList<RoomVO> checkOutVOs=updateCheckOutServiceImpl.searchCheckOutInfo(address, startTime, endTime);
        assertEquals(1,checkOutVOs.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutVOs.get(0);
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testSearchCheckOutInfo2(){
        ArrayList<RoomVO> checkOutVOs=updateCheckOutServiceImpl.searchCheckOutInfo(address, roomType);
        assertEquals(1,checkOutVOs.size());
        CheckOutVO checkOutVOFromArray=(CheckOutVO) checkOutVOs.get(0);
        assertEquals(checkOutVO.address, checkOutVOFromArray.address);
        assertEquals(checkOutVO.roomNum, checkOutVOFromArray.roomNum);
        assertEquals(checkOutVO.roomType,checkOutVOFromArray.roomType);
        assertEquals(0,checkOutVO.actDepartTime.compareTo(checkOutVOFromArray.actDepartTime));
    }
    
    @Test
    public void testAddCheckOut(){
        boolean added = false;
        try {
            added = updateCheckOutServiceImpl.addCheckOut(address, checkOutVO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(added);
    }

    @Test
    public void testValidCheckOut(){
        boolean valid = false;
        try {
            valid = updateCheckOutServiceImpl.validCheckOut(address, checkOutVO);
        } catch (WrongInputException e) {
           System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valid);
    }
}
