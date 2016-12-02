package org.FAF.businesslogic.userbl.mamageUserInfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.mamageUserInfo.ManageUserInfoServiceImpl;
import businesslogic.userbl.mamageUserInfo.MockManageUserInfoServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserType;
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
    private UserType userType;
    private String userID;
    private String password;
    private String telNum;
    private String hotelAddress;
    private UserVO userVO;
    private HotelStaffInfoVO hotelStaffInfoVO;
    private UserDAO userDAO;
    
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum);
    }
    
    @Test
    public void testAdd() {
        manageUserInfo = new MockManageUserInfoServiceImpl(userID);
        manageUserInfo.setUserDAO(userDAO);
        UserVO user = new UserVO(userID, password, telNum, userType);
        boolean result = manageUserInfo.add(user);
        assertEquals(true, result);
    }
    
    @Test
    public void testGetHotelStaffInfo(){
        manageUserInfo = new MockManageUserInfoServiceImpl(userID);
        manageUserInfo.setUserDAO(userDAO);
        hotelStaffInfoVO = manageUserInfo.getHotelStaffInfo(userID);
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in userID!", userID, hotelStaffInfoVO.userID);        
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in password!", password, hotelStaffInfoVO.password);        
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in telNum!", telNum, hotelStaffInfoVO.telNum);        
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in hotelAddress!", hotelAddress, hotelStaffInfoVO.hotelAddress);        
    }
    
    @Test
    public void testGetUserInfo() {
        manageUserInfo = new ManageUserInfoServiceImpl(userID);
        manageUserInfo.setUserDAO(userDAO);
        userVO = manageUserInfo.getUserInfo(userID);
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in userID!", userID, userVO.userID);        
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in password!", password, userVO.password);        
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in telNum!", telNum, userVO.telNum);        
        
    }
    
    @Test
    public void testModifyUserInfo() {
        manageUserInfo = new ManageUserInfoServiceImpl(userID);
        manageUserInfo.setUserDAO(userDAO);
        UserVO user = manageUserInfo.getUserInfo(userID);
       boolean result = manageUserInfo.modifyUserInfo(user, userID);
       assertEquals(true, result);
    }



}
