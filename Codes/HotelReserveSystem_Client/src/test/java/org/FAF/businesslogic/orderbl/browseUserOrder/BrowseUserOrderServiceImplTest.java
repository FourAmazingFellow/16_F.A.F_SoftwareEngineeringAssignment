package org.FAF.businesslogic.orderbl.browseUserOrder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.browseUserOrder.BrowseUserOrderServiceImpl;
import businesslogic.orderbl.browseUserOrder.UserOrderList;
import data_Stub.OrderDAOImpl_Stub;
import dataservice.orderDAO.OrderDAO;
import po.OrderState;
import po.OrderType;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class BrowseUserOrderServiceImplTest {
	private BrowseUserOrderServiceImpl browseUserOrderServiceImpl;
	private OrderDAO orderDAO;
	private UserOrderList list;
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
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		this.orderID = "0001000100010001";
		this.userID = "19970206";
		this.hotelName = "汉庭酒店";
		this.hotelAddress = "南京市栖霞区仙林大道163号";
		this.beginDate = new Date(2016, 12, 20);
		this.finishDate = new Date(2016, 12, 21);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 200;
		this.orderState = OrderState.NOT_DONE_ORDER;
		this.orderProducedTime = new Date(2016, 12, 15);
		this.lastedOrderDoneTime = new Date(2016, 12, 20);
		this.numOfPerson = 2;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;
		orderDAO = new OrderDAOImpl_Stub(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, 
				totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, 
				isChildren, isOnSale, isCommented);
		list = new UserOrderList(userID);
	}
	
	@Test
	public void testHotelOrderArrayList_1(){
		browseUserOrderServiceImpl = new BrowseUserOrderServiceImpl();
		list.setOrderDAO(orderDAO);
		browseUserOrderServiceImpl.setListHelper(list);
		ArrayList<BriefOrderInfoVO> briefOrderInfoList = browseUserOrderServiceImpl.getUserOrderList("19970206", OrderType.ALL);
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
	}
	
	@Test
	public void testHotelOrderDetails_1() {
		browseUserOrderServiceImpl = new BrowseUserOrderServiceImpl();
		list.setOrderDAO(orderDAO);
		browseUserOrderServiceImpl.setListHelper(list);
		OrderVO detailedOrder = browseUserOrderServiceImpl.getDetailedOrder("0001000100010001");
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
	}
}
