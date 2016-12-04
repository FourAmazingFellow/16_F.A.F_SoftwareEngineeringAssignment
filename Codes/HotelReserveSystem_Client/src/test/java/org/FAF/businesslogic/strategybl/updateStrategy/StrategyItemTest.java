package org.FAF.businesslogic.strategybl.updateStrategy;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogic.strategybl.updateStrategy.StrategyItem;
import po.StrategyType;
import rmi.LinkToServer;
import vo.StrategyVO;

public class StrategyItemTest {

    private StrategyItem strategyItem;
    private StrategyVO strategyVO;
    private String address;
    
    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        linkToServer.linkToServer();
    }

    @Before
    public void setUp() throws Exception {
        address = "江苏省南京市栖霞区仙林大道163号";
        strategyVO = new StrategyVO(address, StrategyType.MultiRoomPromotion, "2房间以上折扣", 80,2);
        strategyItem = new StrategyItem(strategyVO);
    }

    @Test
    public void testAdd() {
        boolean added = false;
        try {
            added = strategyItem.add(address);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(added);
    }

    @Test
    public void testModify() {
        boolean modifyed = false;
        strategyItem=new StrategyItem(new StrategyVO(address, StrategyType.MultiRoomPromotion, "2房间以上折扣", 85,2));
        modifyed = strategyItem.modify(address);
        assertTrue(modifyed);
    }

    @Test
    public void testDelete() {
        boolean deleted = false;
        strategyItem=new StrategyItem(new StrategyVO(address, StrategyType.MultiRoomPromotion, "2房间以上折扣", 85,2));
        deleted = strategyItem.delete(address);
        assertTrue(deleted);
    }

    @Test
    public void testValid() {
        strategyVO = new StrategyVO(address, StrategyType.BirthdayPromotion, "双十一折扣", 80);
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(valied);
    }
    
    //地址长度《50
    @Test
    public void testValid1() {
        strategyVO = new StrategyVO(address+"111111111111111111111111111111111111111111111", StrategyType.BirthdayPromotion, "生日特惠折扣", 80);
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(valied);
    }
    
    //折扣名称
    @Test
    public void testValid2() {
        strategyVO = new StrategyVO(address, StrategyType.BirthdayPromotion, "生日-,.特惠折扣", 80);
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(valied);
    }
    
    //房间数量小于可用客房数
    @Test
    public void testValid3() {
        strategyVO = new StrategyVO(address, StrategyType.MultiRoomPromotion, "多房间折扣", 80, 251);
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(valied);
    }
    
    //验证码为8位
    @Test
    public void testValid4() {
        strategyVO = new StrategyVO(address, StrategyType.CooperationEnterprisePromotion, "万达公司折扣", 80, "万达公司","wanda");
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(valied);
    }
    
    //验证码只能有字母和数字
    @Test
    public void testValid5() {
        strategyVO = new StrategyVO(address, StrategyType.CooperationEnterprisePromotion, "万达公司折扣", 80, "万达公司","万达wanda1");
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(valied);
    }
    
    //会员等级要0《X《4
    @Test
    public void testValid6() {
        strategyVO = new StrategyVO(address, StrategyType.MemberRankMarket, "会员等级折扣", 80, 5);
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(valied);
    }
    
    //开始时间大于结束时间
    @SuppressWarnings("deprecation")
    @Test
    public void testValid7() {
        strategyVO = new StrategyVO(address, StrategyType.SpecificTimeMarket, "万达公司折扣", 80, new Date(116,10,10),new Date(116,10,9));
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(valied);
    }
    
    @Test
    public void testVerifyTradeArea(){
        boolean verified=false;
        strategyItem=new StrategyItem(new StrategyVO("Web", StrategyType.VipTradeAreaMarket, "南京市栖霞区VIP2会员优惠", 86, 2, "栖霞区"));
        try {
            verified=strategyItem.verifyTradeArea("南京市");
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(verified);
    }
    
    @Test
    public void testVerifyTradeArea1(){
        boolean verified=false;
        try {
            verified=strategyItem.verifyTradeArea("南宁市");
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(verified);
    }
    
    
}
