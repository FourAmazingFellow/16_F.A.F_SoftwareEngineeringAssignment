package org.FAF.businesslogic.strategybl.updateStrategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogic.strategybl.updateStrategy.StrategyItem;
import businesslogic.strategybl.updateStrategy.StrategyList;
import po.StrategyType;
import rmi.LinkToServer;
import vo.StrategyVO;

public class StrategyListTest {

    private StrategyList strategyList;
    private String address;
    
    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        linkToServer.linkToServer();
    }
    
    @Before
    public void setUp() throws Exception{
        address="江苏省南京市栖霞区仙林大道163号";
        strategyList=StrategyList.getInstance(address);
    }
    
    @SuppressWarnings("deprecation")
    @Test 
    public void testGetStrategyList(){
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion, "双十一折扣", 0.9f, new Date(116,10,10), new Date(116,10,12));
        StrategyVO strategyVO2=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion, "国庆狂欢", 0.85f, new Date(116,9,1), new Date(116,9,8));
        StrategyVO strategyVO3=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion, "春节折扣", 0.8f, new Date(117,1,10), new Date(117,1,21));

        ArrayList<StrategyItem> strategyItems=strategyList.getStrategyList("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion);
        assertEquals(0000000000000003,strategyItems.size());
        assertTrue(equalStrategy(strategyItems.get(0).toVO(), strategyVO1));
        assertTrue(equalStrategy(strategyItems.get(1).toVO(), strategyVO2));
        assertTrue(equalStrategy(strategyItems.get(2).toVO(), strategyVO3));
    }
    
    @Test
    public void testGetStrategyInfo(){
        StrategyItem strategyItem=strategyList.getStrategyInfo("江苏省南京市栖霞区仙林大道163号", StrategyType.CooperationEnterprisePromotion, "腾讯公司优惠");
        StrategyVO strategyInfo=strategyItem.toVO();
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.CooperationEnterprisePromotion, "腾讯公司优惠", 0.87f, "腾讯", "tengxun6");
        assertTrue(equalStrategy(strategyVO1, strategyInfo));
    }
    
//    @Test
//    public void testAdd(){
//        boolean added = false;
//        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣", 0.8f, 2);
//        try {
//            added = strategyList.add("江苏省南京市栖霞区仙林大道163号", strategyVO1);
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        assertTrue(added);
//    }
    
//    //不能在同策略类型列表有重复名称的策略
//    @Test
//    public void testAdd1(){
//        boolean added = false;
//        StrategyVO strategyVO1=new StrategyVO(address, StrategyType.SpecificTimePromotion, "双十一折扣", 0.85f, new Date(), new Date());
//        try {
//            added = strategyList.add(address, strategyVO1);
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        assertFalse(added);
//    }
//    
//    //不允许出现第二个生日折扣
//    @Test
//    public void testAdd2(){
//        boolean added = false;
//        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.BirthdayPromotion, "生日特惠折扣", 0.85f);
//        try {
//            added = strategyList.add(address, strategyVO3);
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        assertFalse(added);
//    }
//    
//    //多房间折扣房间数不相同
//    @Test
//    public void testAdd3(){
//        boolean added1 = false;
//        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.MultiRoomPromotion, "3房间以上折扣", 0.85f, 3);
//        try {
//            added1 = strategyList.add(address, strategyVO3);
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        assertFalse(added1);
//    }
//    
//    //合作企业折扣合作公司不能重复
//    @Test
//    public void testAdd4(){
//        boolean added = false;
//        StrategyVO strategyVO1=new StrategyVO(address, StrategyType.CooperationEnterprisePromotion, "万达公司折扣", 0.85f,"万达","wanda666");
//        try {
//            added = strategyList.add(address, strategyVO1);
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        assertFalse(added);
//    }
//    
//    //会员等级折扣会员等级不相同
//    //酒店工作人员不能制定网站营销策略
//    @Test
//    public void testAdd5(){
//        boolean added1 = false,added2=false;
//        String address1="Web";
//        StrategyList strategyList1=StrategyList.getInstance(address1);
//        StrategyVO strategyVO3=new StrategyVO(address1, StrategyType.MemberRankMarket, "vip1会员等级折扣", 0.85f,1);
//        try {
//            added1 = strategyList1.add(address1, strategyVO3);
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            added2=strategyList.add(address, strategyVO3);
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        assertFalse(added1);
//        assertFalse(added2);
//    }
//    
//    //特定商圈折扣在同一个商圈不能有相同会员等级
//    @Test
//    public void testAdd6(){
//        boolean added1 = false;
//        String address1="Web";
//        StrategyList strategyList1=StrategyList.getInstance(address1);
//        StrategyVO strategyVO3=new StrategyVO(address1, StrategyType.VipTradeAreaMarket, "vip1栖霞区折扣", 0.85f,1,"栖霞区");
//        try {
//            added1 = strategyList1.add(address1, strategyVO3);
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        assertFalse(added1);
//    }
    
    //不能修改策略名称不存在的策略
    //不能修改生日折扣的名称
//    @Test
//    public void testModify(){
//        boolean modifyed1 = false,modifyed2=false,modifyed3=false;
//        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣", 0.8f, 2);
//        StrategyVO strategyVO3=new StrategyVO(address, StrategyType.VipTradeAreaMarket, "XX折扣", 0.85f,2,"栖霞区");
//        StrategyVO strategyVO4=new StrategyVO(address, StrategyType.BirthdayPromotion, "生日折扣", 0.85f);
//        try {
//            strategyList.add(address, strategyVO1);
//            strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣", 0.85f, 2);
//            modifyed1 =strategyList.modify(address, strategyVO1);
//            strategyList.delete(address, strategyVO1);
//            modifyed2 =strategyList.modify(address, strategyVO3);
//        } catch (UnableToModifyStrategyException e) {
//            System.out.println(e.getMessage());
//        } catch (UnableAddStrategyException e) {
//            System.out.println(e.getMessage());
//        } catch (UnableToDeleteStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            modifyed3=strategyList.modify(address, strategyVO4);
//        } catch (UnableToModifyStrategyException e) {
//            System.out.println(e.getMessage());
//        }
//        assertTrue(modifyed1);
//        assertFalse(modifyed2);
//        assertFalse(modifyed3);
//    }
    
  //不能删除策略名称不存在的策略
    @Test
    public void testDelete(){
        boolean deleted1 = false,deleted2 = false;
        strategyList=StrategyList.getInstance("江苏省南京市栖霞区仙林大道163号");
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣", 0.8f, 2);
        try {
            deleted1 = strategyList.delete(address, strategyVO1);
        } catch (UnableToDeleteStrategyException e) {
            System.out.println(e.getMessage());
        }
        strategyList=StrategyList.getInstance("Web");
        StrategyVO strategyVO3=new StrategyVO("Web", StrategyType.VipTradeAreaMarket, "XX折扣", 0.85f,2,"栖霞区");
        try {
            deleted2 = strategyList.delete(address, strategyVO3);
        } catch (UnableToDeleteStrategyException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(deleted1);
        assertFalse(deleted2);
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testValid(){
        boolean valied = false;
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion, "双十一折扣",0.9f, new Date(116,10,30,00,00,00), new Date(116,11,10,00,00,00));
        try {
            valied =strategyList.valid(address, strategyVO1);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(valied);
    }
    
    public boolean equalStrategy(StrategyVO strategyVO1, StrategyVO strategyVO2){
        if(strategyVO1.address.equals(strategyVO2.address)){
            return false;
        }
        if(strategyVO1.strategyType!=strategyVO2.strategyType){
            return false;
        }
        if(strategyVO1.strategyName.equals(strategyVO2.strategyName)){
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
            if(!strategyVO1.enterpriseName.equals(strategyVO2.enterpriseName)||!strategyVO1.securityCode.equals(strategyVO2.securityCode)){
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
