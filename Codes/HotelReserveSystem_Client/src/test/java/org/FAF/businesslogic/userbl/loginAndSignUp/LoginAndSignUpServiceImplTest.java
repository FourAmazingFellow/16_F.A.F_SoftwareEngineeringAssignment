package org.FAF.businesslogic.userbl.loginAndSignUp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.loginAndSignUp.CheckLoginInfo;
import businesslogic.userbl.loginAndSignUp.LoginAndSignUpServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserType;
import vo.UserVO;


public class LoginAndSignUpServiceImplTest {
    private LoginAndSignUpServiceImpl loginAndSignUp;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    private UserDAO userDAO;
    
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.userType = UserType.Client;
        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum);
    }
    
    @Test
    public void testLogin() {
        loginAndSignUp = new LoginAndSignUpServiceImpl();
//        check = new CheckLoginInfo();
        loginAndSignUp.setUserDAO(userDAO);
//        check.setUserDAO(userDAO);
        boolean result = loginAndSignUp.login(userID, password);
        assertEquals(true,result);
    }

    @Test
    public void testAdd() {
        loginAndSignUp = new LoginAndSignUpServiceImpl();
        loginAndSignUp.setUserDAO(userDAO);
        UserVO user = new UserVO(userID, password, telNum,userType);
       boolean result = loginAndSignUp.add(user);
       assertEquals(true, result);
    }


}
