package org.FAF.businesslogic.userbl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.VipInfoImpl;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ActionType;
import po.CreditRecordPO;
import rmi.LinkToServer;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class VipInfoImplTest {
    private VipInfoImpl vipInfo;
    private String userIDr, userIDe;
    private String passwordr, passworde;
    private String telNumr, telNume;
    private int creditValuer,creditValuee;
//    private ArrayList<CreditRecordPO> creditRecord;
    private Date birth;
    private int vipRank;
    private String enterpriseID;
    private UserDAO userDAO;

    private static LinkToServer linkToServer;

    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信错误");
		}
    }

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        this.userIDr = "原";
        this.passwordr = "qwe123";
        this.telNumr = "12345678901";
        this.creditValuer = 500;
//        CreditRecordPO creditRecordPO = new CreditRecordPO(new Date(2016, 11, 11), "2016111100001111",
//                ActionType.ORDER_DONE, 500, creditValuer + 500);
//        this.creditRecord = new ArrayList<>();
//        creditRecord.add(creditRecordPO);
        this.birth = new Date(1997-1900, 10-1, 10);
        this.vipRank = 1;
        
        this.userIDe = "mike";
        this.passworde = "mike123";
        this.telNume = "12345678903";
        this.creditValuee = 1000;
        this.enterpriseID = "阿里巴巴";
//        this.userDAO1 = new UserDAOImpl_Stub(userIDr, passwordr, telNumr, creditValuer, creditRecord, birth, vipRank);
//        this.userDAO2 = new UserDAOImpl_Stub(userIDe, passworde, telNume, creditValuee, creditRecord, enterpriseID,
//                enterprisePassword);
    }

    @Test
    public void testGetRegularVipInfo() {
        vipInfo = new VipInfoImpl();
        RegularVipVO regularVip;
		try {
			regularVip = vipInfo.getRegularVipInfo(this.userIDr);
			assertEquals("VipInfo.getRegularVipInfo(userID) has an error in userID!", userIDr, regularVip.userID);
			assertEquals("VipInfo.getRegularVipInfo(userID) has an error in password!", passwordr, regularVip.password);
			assertEquals("VipInfo.getRegularVipInfo(userID) has an error in telNum!", telNumr, regularVip.telNum);
			assertEquals("VipInfo.getRegularVipInfo(userID) has an error in creditValue!", creditValuer,
					regularVip.creditValue);
//        assertEquals("VipInfo.getRegularVipInfo(userID) has an error in creditRecord!", creditRecord,
//                regularVip.creditRecord);
			assertEquals("VipInfo.getRegularVipInfo(userID) has an error in birth!", birth, regularVip.birth);
			assertEquals("VipInfo.getRegularVipInfo(userID) has an error in vipRank!", vipRank, regularVip.vipRank);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}

    }

    @Test
    public void testGetEnterpriseVipInfo() {
        vipInfo = new VipInfoImpl();
        EnterpriseVipVO enterpriseVip;
		try {
			enterpriseVip = vipInfo.getEnterpriseVipInfo(this.userIDe);
			assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in userID!", userIDe, enterpriseVip.userID);
			assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in password!", passworde,
					enterpriseVip.password);
			assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in telNum!", telNume, enterpriseVip.telNum);
			assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in creditValue!", creditValuee,
					enterpriseVip.creditValue);
//        assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in creditRecord!", creditRecord,
//                enterpriseVip.creditRecord);
			assertEquals("VipInfo.getEnterpriseVipInfo(userID) has an error in enterpriseID!", enterpriseID,
					enterpriseVip.enterpriseID);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
    }

}
