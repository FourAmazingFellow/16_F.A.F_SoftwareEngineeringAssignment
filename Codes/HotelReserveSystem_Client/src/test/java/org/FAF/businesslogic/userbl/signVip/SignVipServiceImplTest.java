package org.FAF.businesslogic.userbl.signVip;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.signVip.MockSignVipServiceImpl;
import businesslogic.userbl.signVip.SignVipServiceImpl;
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

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSignRegularVip() {
        signVip = new MockSignVipServiceImpl();
        RegularVipVO regularVip = new RegularVipVO(userID, password, telNum, userType, 0, null, birth, 0);
        boolean result = signVip.signRegularVip(regularVip);
        assertEquals(true,result);
    }

    @Test
    public void testSignEnterpriseVip() {
        signVip = new MockSignVipServiceImpl();
        EnterpriseVipVO enterpriseVip = new EnterpriseVipVO(userID, password, telNum, userType, 0, null, enterpriseID, enterprisePassword);
        boolean result = signVip.signEnterpriseVip(enterpriseVip);
        assertEquals(true,result);
    }

}
