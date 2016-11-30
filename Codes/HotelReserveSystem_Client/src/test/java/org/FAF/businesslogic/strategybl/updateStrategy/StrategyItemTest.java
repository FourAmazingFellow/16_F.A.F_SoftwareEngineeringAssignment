package org.FAF.businesslogic.strategybl.updateStrategy;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogic.strategybl.updateStrategy.MockStrategyItem;
import businesslogic.strategybl.updateStrategy.StrategyItem;
import po.StrategyType;
import vo.StrategyVO;

public class StrategyItemTest {

    private StrategyItem strategyItem;
    private StrategyVO strategyVO;
    private String address;

    @SuppressWarnings("deprecation")
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
        strategyVO = new StrategyVO(address, StrategyType.MultiRoomPromotion, "3房间折扣", 80,3);
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
}
