package org.FAF.businesslogic.hotelbl.queryHotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.queryHotel.MockQueryHotelServiceImpl;
import businesslogic.hotelbl.queryHotel.QueryHotelServiceImpl;
import po.OrderState;
import po.RoomType;
import vo.HotelVO;
import vo.OrderVO;

public class QueryHotelServiceImplTest {

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
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		this.orderID = "0000000000000003";
		this.userID = "原";
		this.hotelName = "汉庭酒店";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
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
		roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 1000);
		comments = new HashMap<>();
		comments.put("原", "该酒店服务到位，应有尽有！");
		roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 20);
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
	 	assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in tradeArea!", "新街口", hotelDetails.tradeArea);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in hotelAddress!", "江苏省南京市栖霞区仙林大道163号", hotelDetails.hotelAddress);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in starLevel!", 5, hotelDetails.starLevel);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in mark!", 5.0f, hotelDetails.mark, 0);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in briefIntroduction!", "南京市最好的酒店", hotelDetails.briefIntroduction);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in facilityAndService!", "所有服务应有尽有", hotelDetails.facilityAndService);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndPrice!", roomTypeAndPrice, hotelDetails.roomTypeAndPrice);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in roomTypeAndNums!", roomTypeAndNums, hotelDetails.roomTypeAndNums);
		assertEquals("HotelInfoServiceImpl.getHotelBriefInfo(String addtrss) has an error in comments!", comments, hotelDetails.comments);	
	}
	
	@Test
	public void testGetOrders() {
		queryHotel = new MockQueryHotelServiceImpl("原");
		ArrayList<OrderVO> orderVOs = queryHotel.getOrders("江苏省南京市栖霞区仙林大道163号", "原");
		assertEquals(1, orderVOs.size());
		assertEquals(orderID, orderVOs.get(0).orderID);
		assertEquals(userID, orderVOs.get(0).userID);
		assertEquals(hotelName, orderVOs.get(0).hotelName);
		assertEquals(hotelAddress, orderVOs.get(0).hotelAddress);
		assertEquals(beginDate, orderVOs.get(0).beginDate);
		assertEquals(finishDate, orderVOs.get(0).finishDate);
		assertEquals(roomType, orderVOs.get(0).roomType);
		assertEquals(num, orderVOs.get(0).num);
		assertEquals(totalPrice, orderVOs.get(0).totalPrice);
		assertEquals(orderState, orderVOs.get(0).orderState);
		assertEquals(orderProducedTime, orderVOs.get(0).orderProducedTime);
		assertEquals(lastedOrderDoneTime, orderVOs.get(0).lastedOrderDoneTime);
		assertEquals(numOfPerson, orderVOs.get(0).numOfPerson);
		assertEquals(isChildren, orderVOs.get(0).isChildren);
		assertEquals(isOnSale, orderVOs.get(0).isOnSale);
		assertEquals(isCommented, orderVOs.get(0).isCommented);
	}

}
