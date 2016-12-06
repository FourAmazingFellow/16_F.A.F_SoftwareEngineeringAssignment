package org.FAF.businesslogic.orderbl.createNewOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.createNewOrder.NewOrder;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class NewOrderTest {
	private static LinkToServer linkToServer;
	
	private NewOrder newOrder;

	private int price;
	private boolean addResult;

	//OrderBriefInfo
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

	//DetailedOrder
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
		linkToServer.linkToServer();
	}

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		this.orderID = "0000000000000007";
		this.userID = "原";
		this.hotelName = "Jingling Hotel";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.beginDate = new Date(116, 11, 6);
		this.finishDate = new Date(116, 11, 7);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 400;
		this.orderState = OrderState.NOT_DONE_ORDER;
		this.orderProducedTime = new Date(116, 11, 15, 18, 0);
		this.lastedOrderDoneTime = new Date(116, 11, 20, 22, 0);
		this.numOfPerson = 2;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;

		this.isReserved = true;
		this.price = 400;
		this.addResult = true;
		
		newOrder = new NewOrder();
	}

	@Test
	public void initNewOrderTest_1() {
		OrderVO result = newOrder.initNewOrder(userID, hotelName, hotelAddress);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in orderID!", null, result.orderID);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in userID!", userID, result.userID);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in hotelName!", hotelName, result.hotelName);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in hotelAddress!", hotelAddress, result.hotelAddress);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in beginDate!", null, result.beginDate);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in finishDate!", null, result.finishDate);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in roomType!", null, result.roomType);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in num!", -1, result.num);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in totalPrice!", -1, result.totalPrice);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in orderState!", OrderState.NOT_DONE_ORDER, result.orderState);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in orderProducedTime!", null, result.orderProducedTime);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in lastedOrderDoneTime!", null, result.lastedOrderDoneTime);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in numOfPerson!", -1, result.numOfPerson);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in isChildren!", false, result.isChildren);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in isOnSale!", false, result.isOnSale);
		assertEquals("NewOrder.initNewOrder(String userID, String address) has an error in isCommented!", false, result.isCommented);
		
	}

	@Test
	public void getPriceTest_1() {
		OrderVO tempOrder = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale, isCommented);
		int result = newOrder.getPrice(tempOrder);
		assertEquals("NewOrder.getPrice has an error!", 320, result);
	}

//	@Test
	public void addNewOrderTest_1() {
		OrderVO testOrder = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, 
				orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale, isCommented);
		boolean result = newOrder.addNewOrder(testOrder);
		assertEquals("NewOrder.addNewOrder has an error!", addResult, result);
	}
}