package org.FAF.businesslogic.strategybl.updateStrategy;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.strategybl.exception.UnableAddStrategyException;
import businesslogic.strategybl.exception.UnableToDeleteStrategyException;
import businesslogic.strategybl.exception.UnableToModifyStrategyException;
import businesslogic.strategybl.exception.WrongInputException;
import businesslogic.strategybl.updateStrategy.UpdateStrategyServiceImpl;
import po.StrategyType;
import rmi.LinkToServer;
import vo.StrategyVO;

public class UpdateStrategyServiceImplTest {

    private UpdateStrategyServiceImpl updateStrategyServiceImpl;
    private String address;
    
    private static LinkToServer linkToServer;
    
    @BeforeClass
    public static void set() {
        linkToServer = new LinkToServer();
        try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信问题");
		}
    }
    
    @Before
    public void setUp() throws Exception{
        updateStrategyServiceImpl=new UpdateStrategyServiceImpl();
        address="江苏省南京市栖霞区仙林大道163号";
        }
    
    @SuppressWarnings("deprecation")
    @Test 
    public void testGetStrategyList(){
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion, "双十一折扣", 0.9f, new Date(116,10,10), new Date(116,10,12));
        StrategyVO strategyVO2=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion, "国庆狂欢", 0.85f, new Date(116,9,1), new Date(116,9,8));
        StrategyVO strategyVO3=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion, "春节折扣", 0.8f, new Date(117,1,10), new Date(117,1,21));

        ArrayList<StrategyVO> strategyVOs=updateStrategyServiceImpl.getStrategyList("江苏省南京市栖霞区仙林大道163号", StrategyType.SpecificTimePromotion);
        assertEquals(3,strategyVOs.size());
        assertTrue(equalStrategy(strategyVOs.get(0), strategyVO1));
        assertTrue(equalStrategy(strategyVOs.get(1), strategyVO2));
        assertTrue(equalStrategy(strategyVOs.get(2), strategyVO3));
    }
    
    @Test
    public void testGetStrategyInfo(){
        StrategyVO strategyVO=updateStrategyServiceImpl.getStrategyInfo("江苏省南京市栖霞区仙林大道163号", StrategyType.CooperationEnterprisePromotion, "腾讯公司优惠");
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.CooperationEnterprisePromotion, "腾讯公司优惠", 0.87f, "腾讯", "tengxun6");
        assertTrue(equalStrategy(strategyVO1, strategyVO));
    }
    
    @Test
    public void testAdd(){
        boolean added = false;
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣", 0.8f, 2);
        try {
            try {
				added = updateStrategyServiceImpl.add(address, strategyVO1);
				assertTrue(added);
			} catch (RemoteException e) {
				e.printStackTrace();
				fail();
			}
        } catch (UnableAddStrategyException e) {
            System.out.println(e.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testModify(){
        boolean modifyed = false;
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣",0.8f, 2);
        try {
            try {
				updateStrategyServiceImpl.add(address, strategyVO1);
				strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣", 0.85f, 2);
				modifyed =updateStrategyServiceImpl.modify(address, strategyVO1);
				updateStrategyServiceImpl.delete(address, strategyVO1);
				assertTrue(modifyed);
			} catch (RemoteException e) {
				e.printStackTrace();
				fail();
			}
        } catch (UnableToModifyStrategyException e) {
            System.out.println(e.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        } catch (UnableAddStrategyException e) {
            e.printStackTrace();
        } catch (UnableToDeleteStrategyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        boolean deleted = false;
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣", 0.8f, 2);
        try {
            try {
				deleted = updateStrategyServiceImpl.delete(address, strategyVO1);
				assertTrue(deleted);
			} catch (RemoteException e) {
				e.printStackTrace();
				fail();
			}
        } catch (UnableToDeleteStrategyException e) {
            System.out.println(e.getMessage());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testValid(){
        boolean valied = false;
        StrategyVO strategyVO1=new StrategyVO("江苏省南京市栖霞区仙林大道163号", StrategyType.MultiRoomPromotion, "2房间以上折扣", 0.85f, 2);
        try {
            try {
				valied = updateStrategyServiceImpl.valid(address, strategyVO1);
				assertTrue(valied);
			} catch (RemoteException e) {
				e.printStackTrace();
				fail();
			}
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean equalStrategy(StrategyVO strategyVO1, StrategyVO strategyVO2){
        if(!strategyVO1.address.equals(strategyVO2.address)){
            return false;
        }
        if(strategyVO1.strategyType!=strategyVO2.strategyType){
            return false;
        }
        if(!strategyVO1.strategyName.equals(strategyVO2.strategyName)){
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
            if(strategyVO1.vipRank!=strategyVO2.vipRank||!strategyVO2.tradeArea.equals(strategyVO2.tradeArea)){
                return false;
            }
        }
        return true;
    }
}
