package org.FAF.businesslogic.userbl.mamageUserInfo;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.mamageUserInfo.ManageUserInfoServiceImpl;
import businesslogic.userbl.mamageUserInfo.MockManageUserInfoServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserType;
import rmi.LinkToServer;
import vo.HotelStaffInfoVO;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public class ManageUserInfoServiceImplTest{
    private ManageUserInfoServiceImpl manageUserInfo;
    private UserType userType, userTypew, userTypeNew;
    private String userID, userIDw, userIDNew;
    private String password, passwordw, passwordNew;
    private String telNum, telNumw, telNumNew;
    private String hotelAddress;
    private UserVO userVO;
    private HotelStaffInfoVO hotelStaffInfoVO;
    private UserDAO userDAO;

    private static LinkToServer linkToServer;

    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信错误");
		}
    }
    
    @Before
    public void setUp() throws Exception {
        this.userID = "hstaff0001";
        this.password = "hstaff0001123";
        this.telNum = "12312312301";
        this.userType = UserType.HotelStaff;
        this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
        
        this.userIDw = "root";
        this.passwordw = "root123";
        this.telNumw = "12345123401";
        this.userTypew = UserType.WebManageStaff;
        
        this.userIDNew = "claris";
        this.passwordNew = "claris123";
        this.telNumNew = "12345678909";
        this.userTypeNew = UserType.Client;
//        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum, hotelAddress);
    }
    
    @Test
    public void testAdd() {
        manageUserInfo = new ManageUserInfoServiceImpl();
        UserVO user = new UserVO(userIDNew, passwordNew, telNumNew, userTypeNew);
        boolean result;
		try {
			result = manageUserInfo.add(user);
			assertEquals(true, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
    }
    
    @Test
    public void testGetHotelStaffInfo(){
        manageUserInfo = new ManageUserInfoServiceImpl();
        try {
			hotelStaffInfoVO = manageUserInfo.getHotelStaffInfo(userID);
			assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in userID!", userID, hotelStaffInfoVO.userID);        
			assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in password!", password, hotelStaffInfoVO.password);        
			assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in telNum!", telNum, hotelStaffInfoVO.telNum);        
			assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in hotelAddress!", hotelAddress, hotelStaffInfoVO.hotelAddress);        
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
    }
    
    @Test
    public void testGetUserInfo() {
        manageUserInfo = new ManageUserInfoServiceImpl();
        try {
			userVO = manageUserInfo.getUserInfo(userIDw);
			assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in userID!", userIDw, userVO.userID);        
			assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in password!", passwordw, userVO.password);        
			assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in telNum!", telNumw, userVO.telNum);        
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
        
    }
    
    @Test
    public void testModifyUserInfo() {
        manageUserInfo = new ManageUserInfoServiceImpl();
        UserVO modified = new UserVO(userID, "hstaff00011234", telNum, userType);
       boolean result;
	try {
		result = manageUserInfo.modifyUserInfo(modified, userID);
		assertEquals(true, result);
	} catch (RemoteException e) {
		e.printStackTrace();
		fail();
	}
    }



}
