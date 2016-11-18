package org.FAF.businesslogic.orderbl.createNewOrder;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.createNewOrder.NewOrder;
import businesslogic.strategybl.StrategyInfoService;
import businesslogic.strategybl.mockStrategyInfoServiceImpl;
import data_Stub.OrderDAOImpl_Stub;
import dataservice.orderDAO.OrderDAO;
import po.OrderState;
import po.RoomType;

public class NewOrderTest {
	private NewOrder newOrder;
	private OrderDAO mockOrderDAO;
	private StrategyInfoService mockStrategyInfoService;

	private int price;
	private boolean addResult;

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

	private boolean isReserved;

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
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

		this.isReserved = true;

		newOrder = new NewOrder();
		mockOrderDAO = new OrderDAOImpl_Stub(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType,
				num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale,
				isCommented, isReserved);
		mockStrategyInfoService = new mockStrategyInfoServiceImpl();
		newOrder.setOrderDAO(mockOrderDAO, mockStrategyInfoService);

		this.price = 200;
		this.addResult = true;
	}

	@Test
	public void initNewOrderTest_1() {

	}

	@Test
	public void getPriceTest_1() {

	}

	@Test
	public void addNewOrderTest_1() {

	}
}
