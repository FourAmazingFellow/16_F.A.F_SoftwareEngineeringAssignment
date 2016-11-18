package org.FAF.businesslogic.strategybl.updateStrategy;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

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
    public void setUp() throws Exception{
        address="江苏省南京市栖霞区仙林大道163号";
       strategyVO=new StrategyVO(address, StrategyType.SpecificTimePromotion, "双十一折扣", 80, new Date(2016,11,10,00,00,00), new Date(2016,11,12,00,00,00));
       strategyItem=new MockStrategyItem(strategyVO);
    }
    
    @Test
    public void testAdd(){
        assertTrue(strategyItem.add(address));
    }
    
    @Test
    public void testModify(){
        assertTrue(strategyItem.modify(address));
    }
    
    @Test
    public void testDelete(){
        assertTrue(strategyItem.delete(address));
    }
    
    @Test
    public void testValid(){
        assertTrue(strategyItem.valid());
    }
}
