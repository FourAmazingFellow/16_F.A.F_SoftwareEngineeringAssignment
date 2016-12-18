package org.FAF.businesslogic.orderbl.browseHotelOrder;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.browseHotelOrder.HotelOrderList;
import po.OrderState;
import po.OrderType;
import po.RoomType;
import rmi.LinkToServer;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class HotelOrderListTest {
	private static LinkToServer linkToServer;
	
	private HotelOrderList list;

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
		
		this.isReserved = true;
		
		list = new HotelOrderList();
	}
	
	@Test
	public void getHotelOrderListTest_1(){
		ArrayList<BriefOrderInfoVO> briefOrderInfoList;
		try {
			briefOrderInfoList = list.getHotelOrderList("江苏省南京市栖霞区仙林大道163号", OrderType.ALL);
			BriefOrderInfoVO fisrtOrder = briefOrderInfoList.get(0);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in orderID!", orderID, fisrtOrder.orderID);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in userID!", userID, fisrtOrder.userID);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in hotelName!", hotelName, fisrtOrder.hotelName);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in hotelAddress!", hotelAddress, fisrtOrder.hotelAddress);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in beginDate!", beginDate, fisrtOrder.beginDate);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in finishDate!", finishDate, fisrtOrder.finishDate);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in roomType!", roomType, fisrtOrder.roomType);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in num!", num, fisrtOrder.num);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in totalPrice!", totalPrice, fisrtOrder.totalPrice);
			assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in orderState!", orderState, fisrtOrder.orderState);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void getSingleOrderTest_1() {
		OrderVO detailedOrder = list.getSingleOrder("江苏省南京市栖霞区仙林大道163号", "0000000000000001");
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in orderID!", orderID, detailedOrder.orderID);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in userID!", userID, detailedOrder.userID);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in hotelName!", hotelName, detailedOrder.hotelName);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in hotelAddress!", hotelAddress, detailedOrder.hotelAddress);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in beginDate!", beginDate, detailedOrder.beginDate);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in finishDate!", finishDate, detailedOrder.finishDate);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in roomType!", roomType, detailedOrder.roomType);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in num!", num, detailedOrder.num);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in totalPrice!", totalPrice, detailedOrder.totalPrice);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in orderState!", orderState, detailedOrder.orderState);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in orderProducedTime!", orderProducedTime, detailedOrder.orderProducedTime);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in lastedOrderDoneTime!", lastedOrderDoneTime, detailedOrder.lastedOrderDoneTime);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in numOfPerson!", numOfPerson, detailedOrder.numOfPerson);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in isChildren!", isChildren, detailedOrder.isChildren);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in isOnSale!", isOnSale, detailedOrder.isOnSale);
		assertEquals("BrowseHotelOrderServiceImpl.getHotelOrderList(String address, Enum<OrderType> orderType) has an error in isCommented!", isCommented, detailedOrder.isCommented);
	}
	
}
