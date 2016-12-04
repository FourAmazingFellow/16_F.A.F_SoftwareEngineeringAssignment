package org.FAF.businesslogic.roombl.updateCheckOut;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.roombl.updateCheckOut.CheckOutItem;
import businesslogic.strategybl.exception.WrongInputException;
import po.RoomType;
import rmi.LinkToServer;
import vo.CheckOutVO;

public class CheckOutItemTest {

    private CheckOutItem checkOutItem;
    private String address;
    private CheckOutVO checkOutVO;
    private Date actDepartTime;
    
    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        linkToServer.linkToServer();
    }
    
    @Before
    public void setUp() throws Exception{
        address="江苏省南京市栖霞区仙林大道163号";
        actDepartTime=new Date();
        checkOutVO=new CheckOutVO(RoomType.SINGLE_ROOM, 3, address, actDepartTime);
        
        checkOutItem=new CheckOutItem(checkOutVO);
    }
    
//    @Test
//    public void testAddCheckOut(){
//        boolean added = false;
//        try {
//            added = checkOutItem.addCheckOut(address);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        assertTrue(added);
//    }

    @Test
    public void testValidCheckOut(){
        boolean valied = false;
        try {
            valied = checkOutItem.validCheckOut();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertTrue(valied);
    }
    
  //验证地址长度必须小于50，地址名称必须正确
    @Test
    public void testValidCheckIn1() {
        boolean valid1 = false,valid2=false;
        checkOutItem = new CheckOutItem(
                new CheckOutVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号"+"11111111111111111111111111111111111111111111", actDepartTime));
        try {
            valid1 = checkOutItem.validCheckOut();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkOutItem = new CheckOutItem(
                new CheckOutVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区-,.仙林大道163号", actDepartTime));
        try {
            valid2 = checkOutItem.validCheckOut();
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
        checkOutItem = new CheckOutItem(
                new CheckOutVO(RoomType.SINGLE_ROOM, -2, "江苏省南京市栖霞区仙林大道163号", actDepartTime));
        try {
            valid = checkOutItem.validCheckOut();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertFalse(valid);
    }
    
    // 实际离开时间必须在当天内
    @SuppressWarnings("deprecation")
    @Test
    public void testValidCheckIn3() {
        boolean valid = false;
        checkOutItem = new CheckOutItem(
                new CheckOutVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", new Date(116,10,30,17,35)));
        try {
            valid = checkOutItem.validCheckOut();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertFalse(valid);
    }
    
    // 可用客房数量-空房数量>减少的空房数
    @Test
    public void testValidCheckIn4() {
        boolean valid1 = false,valid2=false;
        checkOutItem=new CheckOutItem(new CheckOutVO(RoomType.KING_SIZE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号", actDepartTime));
        try {
            valid1 = checkOutItem.validCheckOut();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        checkOutItem=new CheckOutItem(new CheckOutVO(RoomType.SINGLE_ROOM, 5, "江苏省南京市栖霞区仙林大道163号", actDepartTime));
        try {
            valid2 = checkOutItem.validCheckOut();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        assertFalse(valid1);
        assertFalse(valid2);
    }
    
}
