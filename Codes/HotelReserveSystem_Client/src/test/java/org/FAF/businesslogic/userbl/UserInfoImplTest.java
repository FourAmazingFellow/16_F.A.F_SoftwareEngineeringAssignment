package org.FAF.businesslogic.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.MockUserInfoImpl;
import businesslogic.userbl.UserInfoImpl;
import po.UserType;
import vo.UserVO;

public class UserInfoImplTest {
    private UserInfoImpl userInfoImpl;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testInsert() {
        userInfoImpl = new MockUserInfoImpl();
        UserVO staff = new UserVO(userID, password, telNum, userType);
       boolean result = userInfoImpl.insert(staff);
       assertEquals(true,result);
    }

}
