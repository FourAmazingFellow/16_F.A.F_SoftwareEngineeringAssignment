package org.FAF.businesslogic.userbl;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.VipInfoImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.CreditRecordPO;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class VipInfoImplTest {
    private VipInfoImpl vipInfo;
    private String userID;
    private String password;
    private String telNum;
    private int creditValue;
    private ArrayList<CreditRecordPO> creditRecord;
    private Date birth;
    private int vipRank;
    private String enterpriseID;
    private String enterprisePassword;
    private UserDAO userDAO1, userDAO2;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        this.userID = "原";
        this.password = "qwe123";
        this.telNum = "12345678900";
        this.creditValue = 500;
        CreditRecordPO creditRecordPO = new CreditRecordPO(new Date(2016, 11, 11), "2016111100001111",
                ActionType.ORDER_DONE, 500, creditValue + 500);
        this.creditRecord = new ArrayList<>();
        creditRecord.add(creditRecordPO);
        this.birth = new Date(1997, 10, 10);
        this.vipRank = 3;
        this.enterpriseID = "如家";
        this.enterprisePassword = "rujia";
        this.userDAO1 = new UserDAOImpl_Stub(userID, password, telNum, creditValue, creditRecord, birth,
                vipRank);
        this.userDAO2 = new UserDAOImpl_Stub(userID, password, telNum, creditValue, creditRecord, enterpriseID,
                enterprisePassword);
    }

    @Test
    public void testGetRegularVipInfo() {
        vipInfo = new VipInfoImpl();
        vipInfo.setUserDAO(userDAO1);
        RegularVipVO regularVip = vipInfo.getRegularVipInfo(this.userID);
        assertEquals("VipInfo.getRegularVipInfo(userID) has an error in userID!", userID, regularVip.userID);
        assertEquals("VipInfo.getRegularVipInfo(userID) has an error in password!", password, regularVip.password);
        assertEquals("VipInfo.getRegularVipInfo(userID) has an error in telNum!", telNum, regularVip.telNum);
        assertEquals("VipInfo.getRegularVipInfo(userID) has an error in creditValue!", creditValue,
                regularVip.creditValue);
        assertEquals("VipInfo.getRegularVipInfo(userID) has an error in creditRecord!", creditRecord,
                regularVip.creditRecord);
        assertEquals("VipInfo.getRegularVipInfo(userID) has an error in birth!", birth, regularVip.birth);
        assertEquals("VipInfo.getRegularVipInfo(userID) has an error in vipRank!", vipRank, regularVip.vipRank);

    }

    @Test
    public void testGetEnterpriseVipInfo() {
        vipInfo = new VipInfoImpl();
        vipInfo.setUserDAO(userDAO2);
        EnterpriseVipVO enterpriseVip = vipInfo.getEnterpriseVipInfo(this.userID);
        assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in userID!", userID, enterpriseVip.userID);
        assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in password!", password,
                enterpriseVip.password);
        assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in telNum!", telNum, enterpriseVip.telNum);
        assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in creditValue!", creditValue,
                enterpriseVip.creditValue);
        assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in creditRecord!", creditRecord,
                enterpriseVip.creditRecord);
        assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in enterpriseID!", enterpriseID,
                enterpriseVip.enterpriseID);
        assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in enterprisePassword!", enterprisePassword,
                enterpriseVip.enterprisePassword);

    }

}
