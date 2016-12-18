package org.FAF.businesslogic.orderbl.browseUserOrder;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.browseUserOrder.BrowseUserOrderServiceImpl;
import po.OrderState;
import po.OrderType;
import po.RoomType;
import rmi.LinkToServer;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseUserOrderServiceImplTest {
	private static LinkToServer linkToServer;
	
	private BrowseUserOrderServiceImpl browseUserOrderServiceImpl;
	private String userID;
	private String orderID;
	private String hotelName;
	private String hotelAddress;
	private Date beginDate;
	private Date finishDate;
	private RoomType roomType;
	private int num;
	private int totalPrice;
	private Enum<OrderState> orderState;
	private Date orderProducedTime;
	private Date lastedOrderDoneTime;
	private int numOfPerson;
	private boolean isChildren;
	private boolean isOnSale;
	private boolean isCommented;
	
	@SuppressWarnings("unused")
	private boolean isReserved;	
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		try {
			linkToServer.linkToServer();
		} catch (RemoteException e) {
			System.out.println("网络通信错误");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		this.orderID = "0000000000000001";
		this.userID = "原";
		this.hotelName = "Jingling Hotel";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.beginDate = new Date(116, 9, 19);
		this.finishDate = new Date(116, 9, 20);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 495;
		this.orderState = OrderState.DONE_ORDER;
		this.orderProducedTime = new Date(116, 9, 19, 16, 20, 0);
		this.lastedOrderDoneTime = new Date(116, 9, 20, 16, 0, 0);
		this.numOfPerson = 1;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;

		browseUserOrderServiceImpl = new BrowseUserOrderServiceImpl();
	}
	
	@Test
	public void testHotelOrderArrayList_1(){
		ArrayList<BriefOrderInfoVO> briefOrderInfoList;
		try {
			briefOrderInfoList = browseUserOrderServiceImpl.getUserOrderList("原", OrderType.ALL);
			BriefOrderInfoVO fisrtOrder = briefOrderInfoList.get(0);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in orderID!", orderID, fisrtOrder.orderID);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in userID!", userID, fisrtOrder.userID);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in hotelName!", hotelName, fisrtOrder.hotelName);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in hotelAddress!", hotelAddress, fisrtOrder.hotelAddress);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in beginDate!", beginDate, fisrtOrder.beginDate);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in finishDate!", finishDate, fisrtOrder.finishDate);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in roomType!", roomType, fisrtOrder.roomType);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in num!", num, fisrtOrder.num);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in totalPrice!", totalPrice, fisrtOrder.totalPrice);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in orderState!", orderState, fisrtOrder.orderState);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testHotelOrderDetails_1() {
		OrderVO detailedOrder;
		try {
			detailedOrder = browseUserOrderServiceImpl.getDetailedOrder("0000000000000001");
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in orderID!", orderID, detailedOrder.orderID);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in userID!", userID, detailedOrder.userID);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in hotelName!", hotelName, detailedOrder.hotelName);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in hotelAddress!", hotelAddress, detailedOrder.hotelAddress);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in beginDate!", beginDate, detailedOrder.beginDate);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in finishDate!", finishDate, detailedOrder.finishDate);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in roomType!", roomType, detailedOrder.roomType);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in num!", num, detailedOrder.num);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in totalPrice!", totalPrice, detailedOrder.totalPrice);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in orderState!", orderState, detailedOrder.orderState);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in orderProducedTime!", orderProducedTime, detailedOrder.orderProducedTime);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in lastedOrderDoneTime!", lastedOrderDoneTime, detailedOrder.lastedOrderDoneTime);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in numOfPerson!", numOfPerson, detailedOrder.numOfPerson);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in isChildren!", isChildren, detailedOrder.isChildren);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in isOnSale!", isOnSale, detailedOrder.isOnSale);
			assertEquals("BrowseUserOrderServiceImpl.getUserOrderList(String address, Enum<OrderType> orderType) has an error in isCommented!", isCommented, detailedOrder.isCommented);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
	}
}
