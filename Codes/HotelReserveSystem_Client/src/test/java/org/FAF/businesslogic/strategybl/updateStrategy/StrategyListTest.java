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
import businesslogic.strategybl.updateStrategy.StrategyItem;
import businesslogic.strategybl.updateStrategy.StrategyList;
import po.StrategyType;
import vo.StrategyVO;

public class StrategyListTest {

    private StrategyList strategyList;
    private String address;
    private Enum<StrategyType> strategyType;
    private String name;
    private StrategyVO strategyVO;
    private StrategyVO strategyVO2;
    
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception{
        address="江苏省南京市栖霞区仙林大道163号";
        strategyList=StrategyList.getInstance(address);
        strategyType=StrategyType.SpecificTimePromotion;
        name="双十一折扣";
        strategyVO=new StrategyVO(address, strategyType, name, 80, new Date(116,10,10,00,00,00), new Date(116,10,12,00,00,00));
        strategyVO2=new StrategyVO(address, strategyType, "国庆折扣", 80, new Date(116,9,1), new Date(116,9,7));
    }
    
    @Test 
    public void testGetStrategyList(){
        ArrayList<StrategyItem> strategyItems=strategyList.getStrategyList(address, strategyType);
        assertEquals(1,strategyItems.size());
        StrategyVO strategyVOFromArray=strategyItems.get(0).toVO();
        assertTrue(equalStrategy(strategyVO, strategyVOFromArray));
    }
    
    @Test
    public void testGetStrategyInfo(){
        StrategyItem strategyItem=strategyList.getStrategyInfo(address, strategyType, name);
        StrategyVO strategyInfo=strategyItem.toVO();
        assertTrue(equalStrategy(strategyVO, strategyInfo));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testAdd(){
        boolean added = false;
        try {
            added = strategyList.add(address, strategyVO2);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(added);
    }
    
    //不能在同策略类型列表有重复名称的策略
    @Test
    public void testAdd1(){
        boolean added1 = false,added2=false;
        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.SpecificTimePromotion, "双十一折扣", 85, new Date(), new Date());
        StrategyVO strategyVO4=new StrategyVO(address, StrategyType.SpecificTimePromotion, "双十一折扣", 85, new Date(), new Date());

        try {
            added1 = strategyList.add(address, strategyVO3);
            added2 = strategyList.add(address, strategyVO4);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(added1);
        assertFalse(added2);
    }
    
    //不允许出现第二个生日折扣
    @Test
    public void testAdd2(){
        boolean added1 = false,deleted=false,added2=false;
        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.BirthdayPromotion, "生日特惠折扣", 85);
        try {
            added1 = strategyList.add(address, strategyVO3);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        try {
            deleted=strategyList.delete(address, new StrategyVO(address, StrategyType.BirthdayPromotion, "双十一折扣", 80));
            added2=strategyList.add(address, strategyVO3);
        } catch (UnableToDeleteStrategyException e) {
            e.printStackTrace();
        } catch (UnableAddStrategyException e) {
            e.printStackTrace();
        }
        assertFalse(added1);
        assertTrue(deleted);
        assertTrue(added2);
    }
    
    //多房间折扣房间数不相同
    @Test
    public void testAdd3(){
        boolean added1 = false,added2=false;
        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.MultiRoomPromotion, "3房间折扣", 85,3);
        StrategyVO strategyVO4=new StrategyVO(address, StrategyType.MultiRoomPromotion, "多房间折扣", 85,3);
        try {
            added1 = strategyList.add(address, strategyVO3);
            added2 = strategyList.add(address, strategyVO4);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(added1);
        assertFalse(added2);
    }
    
    //合作企业折扣合作公司不能重复
    @Test
    public void testAdd4(){
        boolean added1 = false,added2=false;
        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.CooperationEnterprisePromotion, "万达公司折扣", 85,"万达公司","wanda123");
        StrategyVO strategyVO4=new StrategyVO(address, StrategyType.CooperationEnterprisePromotion, "万达公司特惠折扣", 85,"万达公司","wanda123");
        try {
            added1 = strategyList.add(address, strategyVO3);
            added2 = strategyList.add(address, strategyVO4);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(added1);
        assertFalse(added2);
    }
    
    //会员等级折扣会员等级不相同
    //酒店工作人员不能制定网站营销策略
    @Test
    public void testAdd5(){
        boolean added1 = false,added2=false,added3=false;
        String address1="Web";
        StrategyList strategyList1=StrategyList.getInstance(address1);
        StrategyVO strategyVO3=new StrategyVO(address1, StrategyType.MemberRankMarket, "vip2会员等级折扣", 85,2);
        StrategyVO strategyVO4=new StrategyVO(address1, StrategyType.MemberRankMarket, "vip2特惠折扣", 85,2);
        try {
            added1 = strategyList1.add(address1, strategyVO3);
            added2 = strategyList1.add(address1, strategyVO4);
            
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        try {
            added3=strategyList.add(address, strategyVO3);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(added1);
        assertFalse(added2);
        assertFalse(added3);
    }
    
    //特定商圈折扣在同一个商圈不能有相同会员等级
    @Test
    public void testAdd6(){
        boolean added1 = false,added2=false,added3=false;
        String address1="Web";
        StrategyList strategyList1=StrategyList.getInstance(address1);
        StrategyVO strategyVO3=new StrategyVO(address1, StrategyType.VipTradeAreaMarket, "vip2栖霞区折扣", 85,2,"栖霞区");
        StrategyVO strategyVO4=new StrategyVO(address1, StrategyType.VipTradeAreaMarket, "vip2栖霞区特惠折扣", 85,2,"栖霞区");
        try {
            added1 = strategyList1.add(address1, strategyVO3);
            added2 = strategyList1.add(address1, strategyVO4);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        try {
            added3=strategyList.add(address, strategyVO3);
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(added1);
        assertFalse(added2);
        assertFalse(added3);
    }
    
    //不能修改策略名称不存在的策略
    //不能修改生日折扣的名称
    @Test
    public void testModify(){
        boolean modifyed1 = false,modifyed2=false,modifyed3=false;
        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.VipTradeAreaMarket, "XX折扣", 85,2,"栖霞区");
        StrategyVO strategyVO4=new StrategyVO(address, StrategyType.BirthdayPromotion, "生日折扣", 85);
        try {
            strategyList.add(address, strategyVO);
            modifyed1 =strategyList.modify(address, strategyVO);
            modifyed2 =strategyList.modify(address, strategyVO3);
        } catch (UnableToModifyStrategyException e) {
            System.out.println(e.getMessage());
        } catch (UnableAddStrategyException e) {
            e.printStackTrace();
        }
        try {
            modifyed3=strategyList.modify(address, strategyVO4);
        } catch (UnableToModifyStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(modifyed1);
        assertFalse(modifyed2);
        assertFalse(modifyed3);
    }
    
  //不能删除策略名称不存在的策略
    @SuppressWarnings("deprecation")
    @Test
    public void testDelete(){
        boolean deleted1 = false,deleted2 = false;
        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.VipTradeAreaMarket, "XX折扣", 85,2,"栖霞区");
        try {
            deleted1 = strategyList.delete(address, new StrategyVO(address, StrategyType.SpecificTimePromotion, "双十一折扣", 80, new Date(116,10,10), new Date(116,10,12)));
            deleted2 = strategyList.delete(address, strategyVO3);
        } catch (UnableToDeleteStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(deleted1);
        assertFalse(deleted2);
    }
    
    @Test
    public void testValid(){
        boolean valied = false;
        try {
            valied =strategyList.valid(address, strategyVO);
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
