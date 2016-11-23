package org.FAF.businesslogic.userbl.loginAndSignUp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.loginAndSignUp.LoginAndSignUpServiceImpl;
import po.UserType;
import vo.UserVO;


public class LoginAndSignUpServiceImplTest {
    private LoginAndSignUpServiceImpl loginAndSignUp;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345676543";
        this.userType = UserType.Client;
    }
    
    @Test
    public void testLogin() {
        loginAndSignUp = new LoginAndSignUpServiceImpl();
        boolean result = loginAndSignUp.login(userID, password);
        assertEquals(true,result);
    }

    @Test
    public void testAdd() {
        loginAndSignUp = new LoginAndSignUpServiceImpl();
        UserVO user = new UserVO(userID, password, telNum,userType);
       boolean result = loginAndSignUp.add(user);
       assertEquals(true, result);
    }


}
