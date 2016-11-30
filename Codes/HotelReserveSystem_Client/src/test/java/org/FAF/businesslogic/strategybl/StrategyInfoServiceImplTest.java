package org.FAF.businesslogic.strategybl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.strategybl.StrategyInfoServiceImpl;
import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.updateStrategy.UpdateStrategyServiceImpl;
import businesslogicservice.strategyblservice.UpdateStrategyService;
import po.OrderState;
import po.RoomType;
import po.StrategyType;
import vo.OrderVO;
import vo.StrategyVO;

public class StrategyInfoServiceImplTest {

    private StrategyInfoServiceImpl strategyInfoServiceImpl;
    private OrderVO orderVO;
    private UpdateStrategyService updateStrategyService=new UpdateStrategyServiceImpl();
    
    private StrategyVO strategyVO1,strategyVO2,strategyVO3,strategyVO4,strategyVO5,strategyVO6;
    
    private String address;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        address="江苏省南京市栖霞区仙林大道163号";
        strategyInfoServiceImpl = new StrategyInfoServiceImpl();
        orderVO = new OrderVO("原", "0001000100010001", "仙林大酒店", address, new Date(116, 10, 30), new Date(116, 11, 1),
                RoomType.KING_SIZE_ROOM, 5, 100, OrderState.NOT_DONE_ORDER, new Date(2016, 10, 16, 18, 0),
                new java.util.Date(2016, 10, 16, 20, 0), 2, false, true, false);
        strategyVO1=new StrategyVO(address, StrategyType.MultiRoomPromotion, "3房间以上折扣", 81, 3);
        strategyVO2=new StrategyVO(address, StrategyType.SpecificTimePromotion, "国庆折扣", 85, new Date(116,9,1),new Date(116,9,8));
        strategyVO3=new StrategyVO(address, StrategyType.BirthdayPromotion, "生日特惠折扣", 87);
        strategyVO4=new StrategyVO(address, StrategyType.MemberRankMarket, "VIP3会员等级折扣", 75, 3);
        strategyVO5=new StrategyVO(address, StrategyType.VipTradeAreaMarket, "VIP2栖霞区折扣", 89, 2, "栖霞区");
        strategyVO6=new StrategyVO(address, StrategyType.CooperationEnterprisePromotion, "万达公司折扣", 90, "万达公司", "wanda123");
    }

    @Test
    public void testGetAvailblePromotionName() {
        try {
            updateStrategyService.delete(address, new StrategyVO(address, StrategyType.BirthdayPromotion, "双十一折扣", 80));
            updateStrategyService.add(address, strategyVO1);
            updateStrategyService.add(address, strategyVO2);
            updateStrategyService.add(address, strategyVO3);
            updateStrategyService.add(address, strategyVO6);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        } catch (UnableToDeleteStrategyException e) {
            e.printStackTrace();
        }
        assertEquals("双十一促销", strategyInfoServiceImpl.getAvailblePromotionName(orderVO));
    }

    @Test
    public void testGetAvailbleMarketStrategyName() {
        try {
            updateStrategyService.add("Web", strategyVO4);
            updateStrategyService.add("Web", strategyVO5);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("WhatEver", strategyInfoServiceImpl.getAvailbleMarketStrategyName(orderVO));
    }

    @Test
    public void testGetBestDiscount() {
        assertEquals(70f, strategyInfoServiceImpl.getBestDiscount(orderVO), 0.01);
    }

}
