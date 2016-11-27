package org.FAF.businesslogic.userbl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.MockVipInfoImpl;
import businesslogic.userbl.VipInfoImpl;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class VipInfoImplTest {
private VipInfoImpl vipInfo;
    private String userID;
    private String password;
    private String telNum;
    private Date birth;
    private String enterpriseID;
    private String enterprisePassword;
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.birth = new Date(1997,10,10);
        this.enterpriseID = "如家";
        this.enterprisePassword = "rujia";
    }
    
    @Test
    public void testGetRegularVipInfo() {
      vipInfo = new MockVipInfoImpl();
      RegularVipVO regularVip = vipInfo.getRegularVipInfo(this.userID);
      assertEquals("VipInfo.getRegularVipInfo(userID) has an error in userID!", userID, regularVip.userID);        
      assertEquals("VipInfo.getRegularVipInfo(userID) has an error in password!", password, regularVip.password);        
      assertEquals("VipInfo.getRegularVipInfo(userID) has an error in telNum!", telNum, regularVip.telNum);        
      assertEquals("VipInfo.getRegularVipInfo(userID) has an error in birth!", birth, regularVip.birth);        
    }

    @Test
    public void testGetEnterpriseVipInfo() {
      vipInfo = new MockVipInfoImpl();
      EnterpriseVipVO enterpriseVip = vipInfo.getEnterpriseVipInfo(this.userID);
      assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in userID!", userID, enterpriseVip.userID);        
      assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in password!", password, enterpriseVip.password);        
      assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in telNum!", telNum, enterpriseVip.telNum);        
      assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in enterpriseID!", enterpriseID, enterpriseVip.enterpriseID);        
      assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in enterprisePassword!", enterprisePassword, enterpriseVip.enterprisePassword);        
      
    }

}
