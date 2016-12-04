package org.FAF.businesslogic.strategybl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.strategybl.StrategyInfoServiceImpl;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class StrategyInfoServiceImplTest {

    private StrategyInfoServiceImpl strategyInfoServiceImpl;
    private OrderVO orderVO;
    
    private String address;
    
    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        linkToServer.linkToServer();
    }

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        address="江苏省南京市栖霞区仙林大道163号";
        strategyInfoServiceImpl = new StrategyInfoServiceImpl();
        orderVO = new OrderVO("原", "0001000100010001", "仙林大酒店", address, new Date(116, 10, 10), new Date(116, 10, 11),
                RoomType.SINGLE_ROOM, 4, 400, OrderState.NOT_DONE_ORDER, new Date(2016, 10, 10, 18, 0),
                new java.util.Date(2016, 10, 10, 20, 0), 2, false, true, false);
    }

    @Test
    public void testGetAvailblePromotionName() {
        
        assertEquals("四间房以上折扣", strategyInfoServiceImpl.getAvailblePromotionName(orderVO));
    }

    @Test
    public void testGetAvailbleMarketStrategyName() {
        assertEquals("VIP1以上会员折扣", strategyInfoServiceImpl.getAvailbleMarketStrategyName(orderVO));
    }

    @Test
    public void testGetBestDiscount() {
        assertEquals(80f, strategyInfoServiceImpl.getBestDiscount(orderVO), 0.01);
    }

}
