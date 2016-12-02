package org.FAF.businesslogic.orderbl.getOrderDone;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.browseHotelOrder.HotelOrderList;
import businesslogic.orderbl.getOrderDone.GetOrderDoneServiceImpl;
import businesslogic.orderbl.getOrderDone.OrderTerminator;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class GetOrderDoneServiceImplTest {
	private static LinkToServer linkToServer;
	
	private GetOrderDoneServiceImpl getOrderDoneServiceImpl;
	private HotelOrderList hotelOrderBrowser;
	private OrderTerminator orderTerminator;

	private ArrayList<BriefOrderInfoVO> notDoneOrderList;
	private OrderVO detailedOrder;
	private boolean canGetOrderDone;
	private boolean canDelayCheckIn;

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
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		this.orderID = "0001000100010001";
		this.userID = "19970206";
		this.hotelName = "汉庭酒店";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.beginDate = new Date(116, 11, 20);
		this.finishDate = new Date(116, 11, 21);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 200;
		this.orderState = OrderState.NOT_DONE_ORDER;
		this.orderProducedTime = new Date(116, 11, 15, 18, 0);
		this.lastedOrderDoneTime = new Date(116, 11, 20, 22, 0);
		this.numOfPerson = 2;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;
		
		notDoneOrderList = new ArrayList<BriefOrderInfoVO>();
		BriefOrderInfoVO briefOrderInfoVO = new BriefOrderInfoVO(userID, orderID, hotelName, hotelAddress, beginDate, 
				finishDate, roomType, num, totalPrice, orderState);
		notDoneOrderList.add(briefOrderInfoVO);
		detailedOrder = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, 
				roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, 
				numOfPerson, isChildren, isOnSale, isCommented);
		
		canGetOrderDone = true;
		canDelayCheckIn = true;
		
		hotelOrderBrowser = new HotelOrderList(hotelAddress);
		orderTerminator = new OrderTerminator();
		getOrderDoneServiceImpl = new GetOrderDoneServiceImpl();
		getOrderDoneServiceImpl.set(hotelOrderBrowser, orderTerminator);
	}
	
	@Test
	public void getHotelNotDoneOrderListTest_1(){
		ArrayList<BriefOrderInfoVO> resultList = getOrderDoneServiceImpl.getHotelNotDoneOrderList("江苏省南京市栖霞区仙林大道163号");
		BriefOrderInfoVO fisrtOrder = resultList.get(0);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in orderID!", orderID, fisrtOrder.orderID);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in userID!", userID, fisrtOrder.userID);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in hotelName!", hotelName, fisrtOrder.hotelName);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in hotelAddress!", hotelAddress, fisrtOrder.hotelAddress);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in beginDate!", beginDate, fisrtOrder.beginDate);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in finishDate!", finishDate, fisrtOrder.finishDate);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in roomType!", roomType, fisrtOrder.roomType);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in num!", num, fisrtOrder.num);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in totalPrice!", totalPrice, fisrtOrder.totalPrice);
		assertEquals("GetOrderDoneServiceImpl.getHotelNotDoneOrderList has an error in orderState!", orderState, fisrtOrder.orderState);
	}
	
	@Test
	public void getSingleOrderTest_1() {
		OrderVO result = getOrderDoneServiceImpl.getSingleOrder("南京市栖霞区仙林大道163号", "0001000100010001");
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in orderID!", detailedOrder.orderID, result.orderID);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in userID!", detailedOrder.userID, result.userID);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in hotelName!", detailedOrder.hotelName, result.hotelName);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in hotelAddress!", detailedOrder.hotelAddress, result.hotelAddress);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in beginDate!", detailedOrder.beginDate, result.beginDate);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in finishDate!", detailedOrder.finishDate, result.finishDate);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in roomType!", detailedOrder.roomType, result.roomType);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in num!", detailedOrder.num, result.num);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in totalPrice!", detailedOrder.totalPrice, result.totalPrice);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in orderState!", detailedOrder.orderState, result.orderState);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in orderProducedTime!", detailedOrder.orderProducedTime, result.orderProducedTime);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in lastedOrderDoneTime!", detailedOrder.lastedOrderDoneTime, result.lastedOrderDoneTime);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in numOfPerson!", detailedOrder.numOfPerson, result.numOfPerson);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in isChildren!", detailedOrder.isChildren, result.isChildren);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in isOnSale!", detailedOrder.isOnSale, result.isOnSale);
		assertEquals("GetOrderDoneServiceImpl.getSingleOrder has an error in isCommented!", detailedOrder.isCommented, result.isCommented);
	}
	
	@Test
	public void getOrderDoneTest_1() {
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 200, null, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
		boolean result = getOrderDoneServiceImpl.getOrderDone(vo);
		assertEquals(canGetOrderDone, result);
	}
	
	@Test
	public void delayCheckInTest_1(){
		@SuppressWarnings("deprecation")
		OrderVO vo = new OrderVO("19970206", "0001000100010001", "汉庭酒店", "江苏省南京市栖霞区仙林大道163号", 
				new Date(116, 11, 20), new Date(116, 11, 21), RoomType.STANDARD_ROOM,
				1, 200, null, new Date(116, 11, 15, 18, 0), new Date(116, 11, 20, 22, 0), 2, 
				false, false, false);
		boolean result = getOrderDoneServiceImpl.delayCheckIn(vo);
		assertEquals(canDelayCheckIn, result);
	}
}
