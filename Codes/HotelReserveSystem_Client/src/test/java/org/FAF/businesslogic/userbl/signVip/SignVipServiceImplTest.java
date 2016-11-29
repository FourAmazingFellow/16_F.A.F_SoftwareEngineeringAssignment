package org.FAF.businesslogic.userbl.signVip;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.signVip.MockSignVipServiceImpl;
import businesslogic.userbl.signVip.SignVipServiceImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserType;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

/**
 * 
 * @author sparkler
 * @version
 * @see
 */
public class SignVipServiceImplTest {
    private SignVipServiceImpl signVip;
    private String userID;
    private String password;
    private String telNum;
    private UserType userType;
    private Date birth;
    private String enterpriseID;
    private String enterprisePassword;
    private UserDAO userDAO;
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.userType = UserType.Client;
        this.birth = new Date(1997, 10, 10);
        this.enterpriseID = "如家";
        this.enterprisePassword = "rujia";
        this.userDAO = new UserDAOImpl_Stub(userID, enterprisePassword, telNum);
    }

    @Test
    public void testSignRegularVip() {
        signVip = new SignVipServiceImpl();
        signVip.setUserDAO(userDAO);
        RegularVipVO regularVip = new RegularVipVO(userID, password, telNum, userType, 0, null, birth, 0);
        boolean result = signVip.signRegularVip(regularVip);
        assertEquals(true,result);
    }

    @Test
    public void testSignEnterpriseVip() {
        signVip = new SignVipServiceImpl();
        signVip.setUserDAO(userDAO);
        EnterpriseVipVO enterpriseVip = new EnterpriseVipVO(userID, password, telNum, userType, 0, null, enterpriseID, enterprisePassword);
        boolean result = signVip.signEnterpriseVip(enterpriseVip);
        assertEquals(true,result);
    }

}
