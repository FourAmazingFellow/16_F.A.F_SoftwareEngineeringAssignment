package org.FAF.businesslogic.orderbl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.OrderInfoImpl;
import data_Stub.OrderDAOImpl_Stub;
import dataservice.orderDAO.OrderDAO;
import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class OrderInfoImplTest {
	private OrderInfoImpl orderInfoImpl;
	private OrderDAO orderDAO;
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

	private boolean isReserved;

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
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
		this.orderProducedTime = new Date(2016, 12, 15, 18, 0);
		this.lastedOrderDoneTime = new Date(2016, 12, 20, 21, 0);
		this.numOfPerson = 2;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;

		this.isReserved = true;
		orderDAO = new OrderDAOImpl_Stub(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num,
				totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale,
				isCommented, isReserved);
		orderInfoImpl = new OrderInfoImpl();
		orderInfoImpl.setOrderDAO(orderDAO);
	}

	@Test
	public void getAllOrdersTest_1() {
		ArrayList<OrderVO> allOrders = orderInfoImpl.getAllOrders("19970206");
		OrderVO firstOrder = allOrders.get(0);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
				firstOrder.orderID);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
				firstOrder.userID);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
				firstOrder.hotelName);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
				firstOrder.hotelAddress);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", beginDate,
				firstOrder.beginDate);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", finishDate,
				firstOrder.finishDate);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
				firstOrder.roomType);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, firstOrder.num);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
				firstOrder.totalPrice);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
				firstOrder.orderState);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderProducedTime!",
				orderProducedTime, firstOrder.orderProducedTime);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in lastedOrderDoneTime!",
				lastedOrderDoneTime, firstOrder.lastedOrderDoneTime);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in numOfPerson!", numOfPerson,
				firstOrder.numOfPerson);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isChildren!", isChildren,
				firstOrder.isChildren);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isOnSale!", isOnSale,
				firstOrder.isOnSale);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isCommented!", isCommented,
				firstOrder.isCommented);
	}

	@Test
	public void isReservedTest_1() {
		boolean result = orderInfoImpl.isReserved("19970206", "南京市栖霞区仙林大道163号");
		assertEquals(isReserved, result);
	}

	@Test
	public void getCommentableOrderListTest_1() {
		ArrayList<OrderVO> result = orderInfoImpl.getCommentableOrderList(userID);
		OrderVO firstOrder = result.get(0);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
				firstOrder.orderID);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
				firstOrder.userID);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
				firstOrder.hotelName);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
				firstOrder.hotelAddress);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", beginDate,
				firstOrder.beginDate);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", finishDate,
				firstOrder.finishDate);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
				firstOrder.roomType);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, firstOrder.num);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
				firstOrder.totalPrice);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
				firstOrder.orderState);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderProducedTime!",
				orderProducedTime, firstOrder.orderProducedTime);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in lastedOrderDoneTime!",
				lastedOrderDoneTime, firstOrder.lastedOrderDoneTime);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in numOfPerson!", numOfPerson,
				firstOrder.numOfPerson);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isChildren!", isChildren,
				firstOrder.isChildren);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isOnSale!", isOnSale,
				firstOrder.isOnSale);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isCommented!", isCommented,
				firstOrder.isCommented);
	}
	
	@Test
	public void getOrderListTest_1(){
		ArrayList<OrderVO> result = orderInfoImpl.getOrderList("19970206", "南京市栖霞区仙林大道163号");
		OrderVO firstOrder = result.get(0);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
				firstOrder.orderID);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
				firstOrder.userID);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
				firstOrder.hotelName);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
				firstOrder.hotelAddress);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", beginDate,
				firstOrder.beginDate);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", finishDate,
				firstOrder.finishDate);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
				firstOrder.roomType);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, firstOrder.num);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
				firstOrder.totalPrice);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
				firstOrder.orderState);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderProducedTime!",
				orderProducedTime, firstOrder.orderProducedTime);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in lastedOrderDoneTime!",
				lastedOrderDoneTime, firstOrder.lastedOrderDoneTime);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in numOfPerson!", numOfPerson,
				firstOrder.numOfPerson);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isChildren!", isChildren,
				firstOrder.isChildren);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isOnSale!", isOnSale,
				firstOrder.isOnSale);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isCommented!", isCommented,
				firstOrder.isCommented);	
	}
	
	@Test
	public void getReservedOrderListTest_1(){
		ArrayList<BriefOrderInfoVO> result = orderInfoImpl.getReservedOrderList("19970206");
		BriefOrderInfoVO firstOrder = result.get(0);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
				firstOrder.orderID);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
				firstOrder.userID);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
				firstOrder.hotelName);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
				firstOrder.hotelAddress);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", beginDate,
				firstOrder.beginDate);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", finishDate,
				firstOrder.finishDate);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
				firstOrder.roomType);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, firstOrder.num);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
				firstOrder.totalPrice);
		assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
				firstOrder.orderState);	
	}
}
