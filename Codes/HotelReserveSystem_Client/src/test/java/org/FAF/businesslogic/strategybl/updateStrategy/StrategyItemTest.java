package org.FAF.businesslogic.strategybl.updateStrategy;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.strategybl.exception.WrongInputException;
import businesslogic.strategybl.updateStrategy.StrategyItem;
import po.StrategyType;
import vo.StrategyVO;

public class StrategyItemTest {

    private StrategyItem strategyItem;
    private StrategyVO strategyVO;
    private String address;

    @Before
    public void setUp() throws Exception {
        address = "江苏省南京市栖霞区仙林大道163号";
        strategyVO = new StrategyVO(address, StrategyType.VipTradeAreaMarket, "2级会员折扣", 80,3,"栖霞区");
        strategyItem = new StrategyItem(strategyVO);
    }

    @Test
    public void testAdd() {
        boolean added = false;
        added = strategyItem.add(address);
        assertTrue(added);
    }

    @Test
    public void testModify() {
        boolean modifyed = false;
        modifyed = strategyItem.modify(address);
        assertTrue(modifyed);
    }

    @Test
    public void testDelete() {
        boolean deleted = false;
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
    
    @Test
    public void testValid3() {
        strategyVO = new StrategyVO(address, StrategyType.MultiRoomPromotion, "21房间折扣", 80, 21);
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
    
    @Test
    public void testValid6() {
        strategyVO = new StrategyVO(address, StrategyType.MemberRankMarket, "万达公司折扣", 80, 5);
        strategyItem = new StrategyItem(strategyVO);
        boolean valied = false;
        try {
            valied = strategyItem.valid();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(valied);
    }
    
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
            verified=strategyItem.verifyTradeArea("上海市");
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(verified);
    }
    
    
}
