package org.FAF.businesslogic.userbl.modifyClientInfo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.modifyClientInfo.MockModifyClientInfoServiceImpl;
import businesslogic.userbl.modifyClientInfo.ModifyClientInfoServiceImpl;
import po.UserType;
import vo.UserVO;

public class ModifyClientInfoServiceImplTest {
    private ModifyClientInfoServiceImpl modifyClientInfo;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    private UserVO userVO;
    
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
    }
    
    @Test
    public void testGetUserInfo() {
        modifyClientInfo = new MockModifyClientInfoServiceImpl(userID);
        userVO = modifyClientInfo.getUserInfo(userID, userType);
        assertEquals("ModifyClientInfoService.getUserInfo(userID,userType) has an error in userID!", userID, userVO.userID);        
        assertEquals("ModifyClientInfoService.getUserInfo(userID,userType) has an error in password!", password, userVO.password);        
        assertEquals("ModifyClientInfoService.getUserInfo(userID,userType) has an error in telNum!", telNum, userVO.telNum);        
    }

    @Test
    public void modifyUserInfo() {
        modifyClientInfo = new MockModifyClientInfoServiceImpl(userID);
        UserVO client = modifyClientInfo.getUserInfo(userID, userType);
        boolean result = modifyClientInfo.modifyUserInfo(client);
        assertEquals(true, result);
    }
    
    
}
