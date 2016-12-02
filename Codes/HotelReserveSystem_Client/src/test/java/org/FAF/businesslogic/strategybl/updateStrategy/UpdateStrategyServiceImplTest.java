package org.FAF.businesslogic.strategybl.updateStrategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogic.strategybl.updateStrategy.UpdateStrategyServiceImpl;
import po.StrategyType;
import vo.StrategyVO;

public class UpdateStrategyServiceImplTest {

    private UpdateStrategyServiceImpl updateStrategyServiceImpl;
    private String address;
    private Enum<StrategyType> strategyType;
    private String name;
    private StrategyVO strategyVO;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        updateStrategyServiceImpl=new UpdateStrategyServiceImpl();
        address="江苏省南京市栖霞区仙林大道163号";
        strategyType=StrategyType.SpecificTimePromotion;
        name="双十一特惠折扣";
        strategyVO=new StrategyVO(address, strategyType, name, 80, new Date(2016,11,10,00,00,00), new Date(2016,11,12,00,00,00));
    }
    
    @Test 
    public void testGetStrategyList(){
        ArrayList<StrategyVO> strategyVOs=updateStrategyServiceImpl.getStrategyList(address, strategyType);
        assertEquals(2,strategyVOs.size());
        StrategyVO strategyVOFromArray=strategyVOs.get(1);
        assertTrue(equalStrategy(strategyVO, strategyVOFromArray));
    }
    
    @Test
    public void testGetStrategyInfo(){
        StrategyVO strategyInfo=updateStrategyServiceImpl.getStrategyInfo(address, strategyType, name);
        assertTrue(equalStrategy(strategyVO, strategyInfo));
    }
    
    @Test
    public void testAdd(){
        boolean added = false;
        try {
            added = updateStrategyServiceImpl.add(address, strategyVO);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        assertTrue(added);
    }
    
    @Test
    public void testModify(){
        boolean modifyed = false;
        strategyVO.discount=70;
        try {
            modifyed = updateStrategyServiceImpl.modify(address, strategyVO);
        } catch (UnableToModifyStrategyException e) {
            System.out.println(e.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        assertTrue(modifyed);
    }
    
    @Test
    public void testDelete(){
        boolean deleted = false,added=false;
        try {
            deleted = updateStrategyServiceImpl.delete(address, strategyVO);
        } catch (UnableToDeleteStrategyException e) {
            System.out.println(e.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        try {
            added=updateStrategyServiceImpl.add(address, strategyVO);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        assertTrue(deleted);
        assertTrue(added);
    }
    
    @Test
    public void testValid(){
        boolean valied = false;
        try {
            valied = updateStrategyServiceImpl.valid(address, strategyVO);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(valied);
    }
    
    public boolean equalStrategy(StrategyVO strategyVO1, StrategyVO strategyVO2){
        if(strategyVO1.address!=strategyVO2.address){
            return false;
        }
        if(strategyVO1.strategyType!=strategyVO2.strategyType){
            return false;
        }
        if(strategyVO1.strategyName!=strategyVO2.strategyName){
            return false;
        }
        if(strategyVO1.discount!=strategyVO2.discount){
            return false;
        }
        if(strategyVO1.strategyType==StrategyType.MemberRankMarket){
            if(strategyVO1.vipRank!=strategyVO2.vipRank){
                return false;
            }
        }else if(strategyVO1.strategyType==StrategyType.MultiRoomPromotion){
            if(strategyVO1.minRoomNum!=strategyVO2.minRoomNum){
                return false;
            }
        }else if(strategyVO1.strategyType==StrategyType.CooperationEnterprisePromotion){
            if(strategyVO1.enterpriseName!=strategyVO2.enterpriseName||strategyVO1.securityCode!=strategyVO2.securityCode){
                return false;
            }
        }else if(strategyVO1.strategyType==StrategyType.SpecificTimeMarket||strategyVO1.strategyType==StrategyType.SpecificTimePromotion){
            if(strategyVO1.startTime.compareTo(strategyVO2.startTime)!=0||strategyVO1.endTime.compareTo(strategyVO2.endTime)!=0){
                return false;
            }
        }else if(strategyVO1.strategyType==StrategyType.VipTradeAreaMarket){
            if(strategyVO1.vipRank!=strategyVO2.vipRank||strategyVO2.tradeArea!=strategyVO2.tradeArea){
                return false;
            }
        }
        return true;
    }
}
