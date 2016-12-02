package org.FAF.businesslogic.hotelbl.commentOnHotel;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelbl.OrderInfo;
import businesslogic.hotelbl.commentOnHotel.CommentableOrderList;
import businesslogic.orderbl.OrderInfoImpl;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import vo.OrderVO;

public class CommentableOrderListTest {

	private static LinkToServer linkToServer;
	
	private CommentableOrderList commentableOrderList;
	private OrderInfo orderInfo;
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
		orderInfo = new OrderInfoImpl();
		this.orderID = "0000000000000001";
		this.userID = "原";
		this.hotelName = "Jingling Hotel";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.beginDate = new Date(116, 9, 19);
		this.finishDate = new Date(116, 9, 20);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 495;
		this.orderState = OrderState.DONE_ORDER;
		this.orderProducedTime = new Date(116, 9, 19, 16, 20, 0);
		this.lastedOrderDoneTime = new Date(116, 9, 20, 16, 0, 0);
		this.numOfPerson = 1;
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

	@Test
	public void testGetCommentableOrderList() {
		commentableOrderList = new CommentableOrderList("原");
//		commentableOrderList.setOrderInfo(orderInfo);
		ArrayList<OrderVO> orderVOs = commentableOrderList.getCommentableOrderList();
		assertEquals(2, orderVOs.size());
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
