package org.FAF.businesslogic.orderbl.createNewOrder;

import static org.junit.Assert.assertEquals;
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

		price = 200;
		addResult = true;
		roomNum = 2;
		resultMessage = ResultMessage.SUCCEED;

		this.hotelName_ = "汉庭酒店";
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


	@SuppressWarnings("deprecation")
	@Test
	public void getAvailableRoomNumTest_1() {
		int num = 0;
		num = createNewOrderServiceImpl.getAvailableRoomNum("19970206", RoomType.STANDARD_ROOM,new Date(2016, 11, 28));
		assertEquals("CreateNewOrderServiceImpl.getAvailableRoomNum has an Error!", roomNum, num);
	}

	@Test
	public void checkNewOrderTest_1() {
		OrderVO orderVO = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num,
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