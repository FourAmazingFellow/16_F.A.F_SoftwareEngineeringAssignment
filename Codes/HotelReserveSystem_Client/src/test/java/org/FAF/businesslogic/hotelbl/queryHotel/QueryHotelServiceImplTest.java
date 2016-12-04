package org.FAF.businesslogic.hotelbl.queryHotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.queryHotel.MockQueryHotelServiceImpl;
import businesslogic.hotelbl.queryHotel.QueryHotelServiceImpl;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.HotelVO;
import vo.OrderVO;

public class QueryHotelServiceImplTest {

	private static LinkToServer linkToServer;
	
	private QueryHotelServiceImpl queryHotel;
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
	private HashMap<RoomType, Integer> roomTypeAndPrice;
	private HashMap<String, String> comments;
	private HashMap<RoomType, Integer> roomTypeAndNums;
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		this.orderID = "0000000000000001";
		this.userID = "原";
		this.hotelName = "Jingling Hotel";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.beginDate = new Date(116, 11, 20);
		this.finishDate = new Date(116, 11, 21);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 200;
		this.orderState = OrderState.DONE_ORDER;
		this.orderProducedTime = new Date(116, 11, 15);
		this.lastedOrderDoneTime = new Date(116, 11, 20);
		this.numOfPerson = 2;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;
		roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 500);
		roomTypeAndPrice.put(RoomType.SINGLE_ROOM, 100);
		roomTypeAndPrice.put(RoomType.STANDARD_ROOM, 200);
		roomTypeAndPrice.put(RoomType.TRIBLE_ROOM, 300);
		comments = new HashMap<>();
		comments.put("原", "该酒店服务到位，应有尽有！");
		roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 52);
		roomTypeAndNums.put(RoomType.SINGLE_ROOM, 50);
		roomTypeAndNums.put(RoomType.STANDARD_ROOM, 50);
		roomTypeAndNums.put(RoomType.TRIBLE_ROOM, 50);
	}

//	@Test
//	public void testGetHotelBriefInfoListByQuerying() {
//		queryHotel = new MockQueryHotelServiceImpl("原");
//		String[] conditions  = {"从低到高", "从高到低", "从高到低", "是"};
//		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOs = queryHotel.getHotelBriefInfoListByQuerying(conditions);
//		
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testGetHotelDetails() {
		queryHotel = new QueryHotelServiceImpl("原");
		HotelVO hotelDetails = queryHotel.getHotelDetails("江苏省南京市栖霞区仙林大道163号");
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelName!", "Jingling Hotel", hotelDetails.hotelName);
	 	assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", "栖霞区", hotelDetails.tradeArea);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", "江苏省南京市栖霞区仙林大道163号", hotelDetails.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", 5, hotelDetails.starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", 5.0f, hotelDetails.mark, 0);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in briefIntroduction!", "南京最好的酒店", hotelDetails.briefIntroduction);
//		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in facilityAndService!", "所有服务应有尽有", hotelDetails.facilityAndService);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndPrice!", roomTypeAndPrice, hotelDetails.roomTypeAndPrice);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndNums!", roomTypeAndNums, hotelDetails.roomTypeAndNums);
//		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in comments!", comments, hotelDetails.comments);	
	}
	
	@Test
	public void testGetOrders() {
		queryHotel = new MockQueryHotelServiceImpl("原");
		ArrayList<OrderVO> orderVOs = queryHotel.getOrders("江苏省南京市栖霞区仙林大道163号", "原");
		assertEquals(4, orderVOs.size());
		assertEquals(orderID, orderVOs.get(0).orderID);
		assertEquals(userID, orderVOs.get(0).userID);
		assertEquals(hotelName, orderVOs.get(0).hotelName);
		assertEquals(hotelAddress, orderVOs.get(0).hotelAddress);
		assertEquals(beginDate, orderVOs.get(0).beginDate);
		assertEquals(finishDate, orderVOs.get(0).finishDate);
		assertEquals(roomType, orderVOs.get(0).roomType);
		assertEquals(num, orderVOs.get(0).num);
		assertEquals(totalPrice, orderVOs.get(1).totalPrice);
		assertEquals(orderState, orderVOs.get(1).orderState);
//		assertEquals(orderProducedTime, orderVOs.get(1).orderProducedTime);
//		assertEquals(lastedOrderDoneTime, orderVOs.get(1).lastedOrderDoneTime);
		assertEquals(numOfPerson, orderVOs.get(0).numOfPerson);
		assertEquals(isChildren, orderVOs.get(0).isChildren);
		assertEquals(isOnSale, orderVOs.get(0).isOnSale);
		assertEquals(isCommented, orderVOs.get(0).isCommented);
	}

}
