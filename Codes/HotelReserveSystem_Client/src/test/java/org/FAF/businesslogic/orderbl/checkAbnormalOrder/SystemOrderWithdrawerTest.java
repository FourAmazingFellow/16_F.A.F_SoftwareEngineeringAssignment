package org.FAF.businesslogic.orderbl.checkAbnormalOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.checkAbnormalOrder.SystemOrderWithdrawer;
import businesslogic.roombl.MockRoomInfoServiceImpl;
import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.MockClientCreditInfoImpl;
import data_Stub.OrderDAOImpl_Stub;
import dataservice.orderDAO.OrderDAO;
import po.OrderState;
import po.RoomType;
import vo.OrderVO;

public class SystemOrderWithdrawerTest {
	private SystemOrderWithdrawer systemOrderWithdrawer;
	private boolean result;
	private OrderDAO orderDAO;
	private ClientCreditInfo userCreditService;
	private RoomInfoService addSpareRoomService;
	
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
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp(){
		result = true;
		systemOrderWithdrawer = new SystemOrderWithdrawer();
		
		this.orderID = "0001000100010001";
		this.userID = "19970206";
		this.hotelName = "汉庭酒店";
		this.hotelAddress = "南京市栖霞区仙林大道163号";
		this.beginDate = new Date(2016, 12, 20);
		this.finishDate = new Date(2016, 12, 21);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 200;
		this.orderState = OrderState.ABNORMAL_ORDER;
		this.orderProducedTime = new Date(2016, 12, 15, 18, 0);
		this.lastedOrderDoneTime = new Date(2016, 12, 20, 21, 0);
		this.numOfPerson = 2;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;
		
		orderDAO = new OrderDAOImpl_Stub(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale, isCommented, false);
		userCreditService = new MockClientCreditInfoImpl();
		addSpareRoomService = new MockRoomInfoServiceImpl();
		
		systemOrderWithdrawer.set(orderDAO, userCreditService, addSpareRoomService);
	}
	
	//空指针测试
	@Test
	public void systemWithdrawOrderTest_1(){
		boolean actual = systemOrderWithdrawer.systemWithdrawOrder(null, false);
		assertEquals(false, actual);
	}
	
	//正常用例测试
	@Test
	public void systemWithdrawOrderTest_2(){
		OrderVO vo = new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale, isCommented);
		boolean actual = systemOrderWithdrawer.systemWithdrawOrder(vo, true);
		assertEquals(result, actual);
	}
}
