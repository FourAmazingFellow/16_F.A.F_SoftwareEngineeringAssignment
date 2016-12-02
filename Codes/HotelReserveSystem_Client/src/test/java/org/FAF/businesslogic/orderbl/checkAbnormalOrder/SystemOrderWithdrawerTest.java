package org.FAF.businesslogic.orderbl.checkAbnormalOrder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.orderbl.checkAbnormalOrder.SystemOrderWithdrawer;
import businesslogic.roombl.RoomInfoService;
import businesslogic.roombl.RoomInfoServiceImpl;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.userbl.ClientCreditInfoImpl;
import dataservice.orderDAO.OrderDAO;
import po.OrderState;
import po.RoomType;
import rmi.LinkToServer;
import rmi.RemoteHelper;
import vo.OrderVO;

public class SystemOrderWithdrawerTest {
	private static LinkToServer linkToServer;
	
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
	
	@BeforeClass
	public static void set() {
		linkToServer = new LinkToServer();
		linkToServer.linkToServer();
	}
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp(){
		result = true;
		systemOrderWithdrawer = new SystemOrderWithdrawer();
		
		this.orderID = "0001000100010001";
		this.userID = "19970206";
		this.hotelName = "汉庭酒店";
		this.hotelAddress = "南京市栖霞区仙林大道163号";
		this.beginDate = new Date(116, 11, 20);
		this.finishDate = new Date(116, 11, 21);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 200;
		this.orderState = OrderState.ABNORMAL_ORDER;
		this.orderProducedTime = new Date(116, 11, 15, 18, 0);
		this.lastedOrderDoneTime = new Date(116, 11, 20, 22, 0);
		this.numOfPerson = 2;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;
		
		orderDAO = RemoteHelper.getInstance().getOrderDAO();
		userCreditService = new ClientCreditInfoImpl();
		addSpareRoomService = new RoomInfoServiceImpl();
		
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
