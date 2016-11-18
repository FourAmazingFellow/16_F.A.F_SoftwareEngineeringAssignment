package org.FAF.businesslogic.userbl.mamageUserInfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.mamageUserInfo.ManageUserInfoServiceImpl;
import businesslogic.userbl.mamageUserInfo.MockManageUserInfoServiceImpl;
import po.UserType;
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
    private UserVO userVO;
    
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
    }
    
    @Test
    public void testModifyUserInfo() {
        manageUserInfo = new ManageUserInfoServiceImpl(userID);
        UserVO user = manageUserInfo.getUserInfo(userID, userType);
       boolean result = manageUserInfo.modifyUserInfo(user);
       assertEquals(true, result);
    }

    @Test
    public void testAdd() {
        manageUserInfo = new ManageUserInfoServiceImpl(userID);
        UserVO user = new UserVO(userID, password, telNum, userType);
        boolean result = manageUserInfo.add(user);
        assertEquals(true, result);
    }

    @Test
    public void testGetUserInfo() {
        manageUserInfo = new MockManageUserInfoServiceImpl(userID);
        userVO = manageUserInfo.getUserInfo(userID, userType);
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in userID!", userID, userVO.userID);        
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in password!", password, userVO.password);        
        assertEquals("ManageUserInfoService.getUserInfo(userID,userType) has an error in telNum!", telNum, userVO.telNum);        
    
    }

}
