package org.FAF.businesslogic.orderbl.createNewOrder;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import businesslogic.orderbl.createNewOrder.CreateNewOrderServiceImpl;
import businesslogicservice.orderblservice.ResultMessage;

import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.BriefHotelInfoVO;
import vo.OrderVO;

public class CreateNewOrderServiceImplTest {
	private static LinkToServer linkToServer;
	
	private CreateNewOrderServiceImpl createNewOrderServiceImpl;

	private int price;
	private boolean addResult;
	private int roomNum;
	private ResultMessage resultMessage;

	// BriefOrderInfo
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

	// DetailedOrder
	private Date orderProducedTime;
	private Date lastedOrderDoneTime;
	private int numOfPerson;
	private boolean isChildren;
	private boolean isOnSale;
	private boolean isCommented;

	// HotelBriefInfo
	private String hotelName_;
	private String tradeArea;
	private String hotelAddress_;
	private int starLevel;
	private float mark;
	@SuppressWarnings("unused")
	private String city;

	// DetailedHotel
	@SuppressWarnings("unused")
	private String briefIntroduction;
	@SuppressWarnings("unused")
	private String facilityAndService;
	@SuppressWarnings("unused")
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	@SuppressWarnings("unused")
	private HashMap<RoomType, Integer> roomTypeAndNums;
	@SuppressWarnings("unused")
	private HashMap<String, String> comments;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		this.orderID = "0000000000000001";
		this.userID = "原";
		this.hotelName = "Jingling Hotel";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.beginDate = new Date(116, 11, 15);
		this.finishDate = new Date(116, 11, 16);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 200;
		this.orderState = OrderState.NOT_DONE_ORDER;
		this.orderProducedTime = new Date(116, 11, 15, 18, 0);
		this.lastedOrderDoneTime = new Date(116, 11, 20, 22, 0);
		this.numOfPerson = 1;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;

		price = 200;
		addResult = true;
		roomNum = 10;
		resultMessage = ResultMessage.SUCCEED;

		this.hotelName_ = "Jingling Hotel";
		this.tradeArea = "栖霞区";
		this.hotelAddress_ = "江苏省南京市栖霞区仙林大道163号";
		this.starLevel = 5;
		this.mark = 5.0f;
		this.city = "南京市";
		this.briefIntroduction = "南京最好的酒店";
		this.facilityAndService = "wifi;washer;park;air-condition;elevator";
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.SINGLE_ROOM, 100);
		roomTypeAndPrice.put(RoomType.STANDARD_ROOM, 200);
		roomTypeAndPrice.put(RoomType.TRIBLE_ROOM, 300);
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 400);
		this.roomTypeAndPrice = roomTypeAndPrice;
		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.SINGLE_ROOM, 40);
		roomTypeAndNums.put(RoomType.STANDARD_ROOM, 50);
		roomTypeAndNums.put(RoomType.TRIBLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 50);
		this.roomTypeAndNums = roomTypeAndNums;
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "环境一流，服务贴心");
		this.comments = comments;

		createNewOrderServiceImpl = new CreateNewOrderServiceImpl();
	}

	@Test
	public void getHotelBriefInfoTest_1() {
		BriefHotelInfoVO briefHotelInfo = createNewOrderServiceImpl.getHotelBriefInfo("江苏省南京市栖霞区仙林大道163号");
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in hotelName!", hotelName_,
				briefHotelInfo.hotelName);
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in tradeArea!", tradeArea,
				briefHotelInfo.tradeArea);
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in hotelAddress!", hotelAddress_,
				briefHotelInfo.hotelAddress);
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in starLevel!", starLevel,
				briefHotelInfo.starLevel);
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in mark!", mark, briefHotelInfo.mark, 0);
	}

	@Test
	public void initNewOrderTest_1() {
		OrderVO result = createNewOrderServiceImpl.initNewOrder(userID, hotelName, hotelAddress);
		assertEquals("orderID!", null, result.orderID);
		assertEquals("userID!", userID, result.userID);
		assertEquals("hotelName!", hotelName, result.hotelName);
		assertEquals("hotelAddress!", hotelAddress, result.hotelAddress);
		assertEquals("beginDate!", null, result.beginDate);
		assertEquals("finishDate!", null, result.finishDate);
		assertEquals("roomType!", null, result.roomType);
		assertEquals("num!", -1, result.num);
		assertEquals("totalPrice!", -1, result.totalPrice);
		assertEquals("orderState!", OrderState.NOT_DONE_ORDER, result.orderState);
		assertEquals("orderProducedTime!", null, result.orderProducedTime);
		assertEquals("lastedOrderDoneTime!", null, result.lastedOrderDoneTime);
		assertEquals("numOfPerson!", -1, result.numOfPerson);
		assertEquals("isChildren!", false, result.isChildren);
		assertEquals("isOnSale!", false, result.isOnSale);
		assertEquals("isCommented!", false, result.isCommented);
	}


	@SuppressWarnings("deprecation")
	@Test
	public void getAvailableRoomNumTest_1() {
		int num = -1;
		num = createNewOrderServiceImpl.getAvailableRoomNum(hotelAddress, RoomType.STANDARD_ROOM, new Date(116, 11, 15));
		assertEquals("CreateNewOrderServiceImpl.getAvailableRoomNum has an Error!", roomNum, num);
	}

	@Test
	public void checkNewOrderTest_1() {
		OrderVO orderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num,
				totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale,
				isCommented);
		ResultMessage result = createNewOrderServiceImpl.checkNewOrder(orderVO);
		assertEquals(null, result);
	}
	
	@Test
	public void checkNewOrderTest_2() {
		@SuppressWarnings("deprecation")
		OrderVO orderVO = new OrderVO("Accident", "8", hotelName, hotelAddress, new Date(116,11,15), new Date(116,11,16), roomType, num,
				totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale,
				isCommented);
		ResultMessage result = createNewOrderServiceImpl.checkNewOrder(orderVO);
		assertEquals(resultMessage, result);
	}

	@Test
	public void getPriceTest_1() {
		OrderVO orderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num,
				totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale,
				isCommented);
		int result = createNewOrderServiceImpl.getPrice(orderVO);
		assertEquals("CreateNewOrderServiceImpl.getPrice has an error!", price, result);
	}

	@Test
	public void addNewOrderTest_1() {
		OrderVO orderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num,
				totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale,
				isCommented);
		boolean result = createNewOrderServiceImpl.addNewOrder(orderVO);
		assertEquals("CreateNewOrderServiceImpl.addNewOrder has an error!", addResult, result);
	}
}