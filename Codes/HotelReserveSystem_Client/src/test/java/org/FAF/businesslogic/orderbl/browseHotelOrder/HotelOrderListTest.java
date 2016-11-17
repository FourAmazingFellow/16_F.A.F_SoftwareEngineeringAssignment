package org.FAF.businesslogic.orderbl.browseHotelOrder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.browseHotelOrder.HotelOrderList;
import data_Stub.OrderDAOImpl_Stub;
import dataservice.orderDAO.OrderDAO;
import po.OrderState;
import po.OrderType;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class HotelOrderListTest {

	private HotelOrderList list;
	private OrderDAO orderDAO;
	public String userID;
	public String orderID;
	public String hotelName;
	public String hotelAddress;
	public Date beginDate;
	public Date finishDate;
	public RoomType roomType;
	public int num;
	public int totalPrice;
	public Enum<OrderState> orderState;
	public Date orderProducedTime;
	public Date lastedOrderDoneTime;
	public int numOfPerson;
	public boolean isChildren;
	public boolean isOnSale;
	public boolean isCommented;
	
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
		orderDAO = new OrderDAOImpl_Stub(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale, isCommented);
		list = new HotelOrderList(hotelAddress);
		list.setOrderDAO(orderDAO);
	}
	
	@Test
	public void testHotelOrderArrayList_1(){
		ArrayList<BriefOrderInfoVO> briefOrderInfoList = list.getHotelOrderList("南京市栖霞区仙林大道163号", OrderType.ALL);
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
	}
	
	@Test
	public void testHotelOrderDetails_1() {
		OrderVO detailedOrder = list.getSingleOrder("南京市栖霞区仙林大道163号", "0001000100010001");
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
