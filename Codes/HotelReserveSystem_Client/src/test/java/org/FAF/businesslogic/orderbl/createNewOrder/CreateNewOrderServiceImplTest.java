package org.FAF.businesslogic.orderbl.createNewOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.hotelbl.MockHotelInfoServiceImpl;
import businesslogic.orderbl.createNewOrder.Checker;
import businesslogic.orderbl.createNewOrder.CreateNewOrderServiceImpl;
import businesslogic.orderbl.createNewOrder.MockChecker;
import businesslogic.orderbl.createNewOrder.MockNewOrder;
import businesslogic.orderbl.createNewOrder.NewOrder;
import businesslogic.roombl.MockRoomInfoServiceImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogicservice.orderblservice.ResultMessage;

import po.OrderState;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.HotelVO;
import vo.OrderVO;

public class CreateNewOrderServiceImplTest {
	private CreateNewOrderServiceImpl createNewOrderServiceImpl;
	private HotelInfoService mockHotelInfoGetter;
	private RoomInfoService mockRoomInfoService;
	private Checker mockChecker;
	private NewOrder mockNewOrder;

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
	private String businessDistrict;
	private String hotelAddress_;
	private int starLevel;
	private float mark;

	// DetailedHotel
	private String briefIntroduction;
	private String facilityAndService;
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	private HashMap<RoomType, Integer> roomTypeAndNums;
	private HashMap<String, String> comments;

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		this.orderID = "0001000100010001";
		this.userID = "19970206";
		this.hotelName = "汉庭酒店";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.beginDate = new Date(2016, 12, 20);
		this.finishDate = new Date(2016, 12, 21);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 200;
		this.orderState = OrderState.NOT_DONE_ORDER;
		this.orderProducedTime = new Date(2016, 12, 15, 18, 0);
		this.lastedOrderDoneTime = new Date(2016, 12, 20, 22, 0);
		this.numOfPerson = 2;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;

		price = 200;
		addResult = true;
		roomNum = 2;
		resultMessage = ResultMessage.SUCCEED;

		this.hotelName_ = "汉庭酒店";
		this.businessDistrict = "栖霞区";
		this.hotelAddress_ = "江苏省南京市栖霞区仙林大道163号";
		this.starLevel = 5;
		this.mark = 5.0f;
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

		BriefHotelInfoVO briefHotelInfoVO = new BriefHotelInfoVO(hotelName_, businessDistrict, hotelAddress_, starLevel,
				mark);
		HotelVO hotelvo = new HotelVO(hotelName_, businessDistrict, hotelAddress_, starLevel, mark, briefIntroduction,
				facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);

		createNewOrderServiceImpl = new CreateNewOrderServiceImpl();
		mockHotelInfoGetter = new MockHotelInfoServiceImpl(hotelvo, briefHotelInfoVO);
		mockRoomInfoService = new MockRoomInfoServiceImpl();
		mockChecker = new MockChecker(true, ResultMessage.SUCCEED);
		mockNewOrder = new MockNewOrder(200, true, "19970206", "江苏省南京市栖霞区仙林大道163号");

		createNewOrderServiceImpl.set(mockHotelInfoGetter, mockRoomInfoService, mockChecker, mockNewOrder);
	}

	@Test
	public void getHotelBriefInfoTest_1() {
		BriefHotelInfoVO briefHotelInfo = createNewOrderServiceImpl.getHotelBriefInfo("江苏省南京市栖霞区仙林大道163号");
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in hotelName!", hotelName_,
				briefHotelInfo.hotelName);
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in businessDistrict!", businessDistrict,
				briefHotelInfo.businessDistrict);
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in hotelAddress!", hotelAddress_,
				briefHotelInfo.hotelAddress);
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in starLevel!", starLevel,
				briefHotelInfo.starLevel);
		assertEquals("CreateNewOrderServiceImpl.getHotelBriefInfo has an error in mark!", mark, briefHotelInfo.mark, 0);
	}

	@Test
	public void initNewOrderTest_1() {
		OrderVO result = createNewOrderServiceImpl.initNewOrder("19970206", "江苏省南京市栖霞区仙林大道163号");
		assertEquals("CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in orderID!",
				orderID, result.orderID);
		assertEquals("CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in userID!",
				userID, result.userID);
		assertEquals("CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in hotelName!",
				hotelName, result.hotelName);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in hotelAddress!",
				hotelAddress, result.hotelAddress);
		assertEquals("CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in beginDate!",
				beginDate, result.beginDate);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in finishDate!",
				finishDate, result.finishDate);
		assertEquals("CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in roomType!",
				roomType, result.roomType);
		assertEquals("CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in num!", num,
				result.num);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in totalPrice!",
				totalPrice, result.totalPrice);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in orderState!",
				orderState, result.orderState);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in orderProducedTime!",
				orderProducedTime, result.orderProducedTime);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in lastedOrderDoneTime!",
				lastedOrderDoneTime, result.lastedOrderDoneTime);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in numOfPerson!",
				numOfPerson, result.numOfPerson);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in isChildren!",
				isChildren, result.isChildren);
		assertEquals("CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in isOnSale!",
				isOnSale, result.isOnSale);
		assertEquals(
				"CreateNewOrderServiceImpl.initNewOrder(String userID, String address) has an error in isCommented!",
				isCommented, result.isCommented);
	}

	@Test
	public void getAvailableRoomNumTest_1() {
		int num = mockRoomInfoService.getAvailableRoomNum("19970206", RoomType.STANDARD_ROOM);
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