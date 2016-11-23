package org.FAF.businesslogic.strategybl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.strategybl.StrategyInfoServiceImpl;
import businesslogic.strategybl.mockStrategyInfoServiceImpl;
import po.OrderState;
import po.RoomType;
import vo.OrderVO;

public class StrategyInfoServiceImplTest {

    private StrategyInfoServiceImpl strategyInfoServiceImpl;
    private OrderVO orderVO;
    private String enterpriseName;
    private String securityCode;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        strategyInfoServiceImpl=new mockStrategyInfoServiceImpl();
        orderVO=new OrderVO("原","0001000100010001","仙林大酒店","",new Date(2016,10,16),new Date(2016,10,17),RoomType.KING_SIZE_ROOM,1,100,OrderState.NOT_DONE_ORDER,new Date(2016,10,16,18,0),new java.util.Date(2016, 10, 16, 20, 0),2,false,true,false);
        enterpriseName="万达公司";
        securityCode="123456";
    }
    
    @Test
    public void testGetAvailblePromotionName(){
        assertEquals("双十一促销",strategyInfoServiceImpl.getAvailblePromotionName(orderVO));
    }
    
    @Test
    public void testGetAvailbleMarketStrategyName(){
        assertEquals("WhatEver", strategyInfoServiceImpl.getAvailbleMarketStrategyName(orderVO));
    }
    
    @Test 
    public void testGetBestDiscount(){
        assertEquals(70, strategyInfoServiceImpl.getBestDiscount(orderVO));
    }
    
    @Test
    public void testVerifyEnterpriseMember(){
        assertTrue(strategyInfoServiceImpl.verifyEnterpriseMember(enterpriseName, securityCode));
    }
}
