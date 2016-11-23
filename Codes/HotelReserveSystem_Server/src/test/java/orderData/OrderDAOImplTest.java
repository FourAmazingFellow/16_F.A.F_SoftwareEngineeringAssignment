package orderData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import data.orderdata.OrderDAOImpl;
import po.BriefOrderInfoPO;
import po.OrderPO;
import po.OrderState;
import po.OrderType;
import po.RoomType;

public class OrderDAOImplTest {
	
	private OrderDAOImpl orderDAO;
	private String userID;
	private String orderID;
	private String hotelName;
	private String hotelAddress;
	private Date beginDate;
	private Date finishDate;
	private RoomType roomType;
	private int num;
	private int totalPrice;
	public Enum<OrderState> orderState;
	private Date orderProducedTime;
	private Date lastedOrderDoneTime;
	private int numOfPerson;
	private boolean isChildren;
	private boolean isOnSale;
	private boolean isCommented;
	private OrderPO po;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		orderDAO = new OrderDAOImpl();
		this.userID = "原";
		this.orderID = "0000000000000001";
		this.hotelName = "Jingling Hotel";
		this.hotelAddress = "江苏省南京市栖霞区仙林大道163号";
		this.beginDate = new Date(116, 9, 19);
		this.finishDate = new Date(116, 9, 20);
		this.roomType = RoomType.STANDARD_ROOM;
		this.num = 1;
		this.totalPrice = 495;
		this.orderState = OrderState.DONE_ORDER;
		this.orderProducedTime = new Date(116, 9, 19, 16, 20, 00);
		this.lastedOrderDoneTime = new Date(116, 9, 20, 16, 00, 00);
		this.numOfPerson = 1;
		this.isChildren = false;
		this.isOnSale = false;
		this.isCommented = false;
		this.po = new OrderPO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderState, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale, isCommented);
	}

//	@Test
//	public void testGetUserAllOrders() {
//		ArrayList<OrderPO> orderPOs = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			orderPOs = orderDAO.getUserAllOrders(userID);
//			assertEquals(2, orderPOs.size());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					orderPOs.get(0).getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					orderPOs.get(0).getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					orderPOs.get(0).getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					orderPOs.get(0).getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(orderPOs.get(0).getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(orderPOs.get(0).getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					orderPOs.get(0).getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, orderPOs.get(0).getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					orderPOs.get(0).getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					orderPOs.get(0).getOrderState());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderProducedTime!",
//					sdf2.format(orderProducedTime), sdf2.format(orderPOs.get(0).getOrderProducedTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in lastedOrderDoneTime!",
//					sdf2.format(lastedOrderDoneTime), sdf2.format(orderPOs.get(0).getLastedOrderDoneTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in numOfPerson!", numOfPerson,
//					orderPOs.get(0).getNumOfPerson());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isChildren!", isChildren,
//					orderPOs.get(0).isChildren());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isOnSale!", isOnSale,
//					orderPOs.get(0).isOnSale());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isCommented!", isCommented,
//					orderPOs.get(0).isCommented());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testGetCommentableOrders() {
//		ArrayList<OrderPO> orderPOs = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			orderPOs = orderDAO.getCommentableOrders(userID);
//			assertEquals(2, orderPOs.size());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					orderPOs.get(0).getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					orderPOs.get(0).getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					orderPOs.get(0).getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					orderPOs.get(0).getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(orderPOs.get(0).getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(orderPOs.get(0).getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					orderPOs.get(0).getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, orderPOs.get(0).getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					orderPOs.get(0).getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					orderPOs.get(0).getOrderState());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderProducedTime!",
//					sdf2.format(orderProducedTime), sdf2.format(orderPOs.get(0).getOrderProducedTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in lastedOrderDoneTime!",
//					sdf2.format(lastedOrderDoneTime), sdf2.format(orderPOs.get(0).getLastedOrderDoneTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in numOfPerson!", numOfPerson,
//					orderPOs.get(0).getNumOfPerson());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isChildren!", isChildren,
//					orderPOs.get(0).isChildren());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isOnSale!", isOnSale,
//					orderPOs.get(0).isOnSale());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isCommented!", isCommented,
//					orderPOs.get(0).isCommented());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testIsReserved() {
//		try {
//			boolean result = orderDAO.isReserved(userID, hotelAddress);
//			assertEquals(true, result);
//		} catch(RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testGetUserOrdersByHotel() {
//		ArrayList<OrderPO> orderPOs = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			orderPOs = orderDAO.getUserOrdersByHotel(userID, hotelAddress);
//			assertEquals(2, orderPOs.size());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					orderPOs.get(0).getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					orderPOs.get(0).getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					orderPOs.get(0).getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					orderPOs.get(0).getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(orderPOs.get(0).getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(orderPOs.get(0).getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					orderPOs.get(0).getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, orderPOs.get(0).getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					orderPOs.get(0).getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					orderPOs.get(0).getOrderState());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderProducedTime!",
//					sdf2.format(orderProducedTime), sdf2.format(orderPOs.get(0).getOrderProducedTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in lastedOrderDoneTime!",
//					sdf2.format(lastedOrderDoneTime), sdf2.format(orderPOs.get(0).getLastedOrderDoneTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in numOfPerson!", numOfPerson,
//					orderPOs.get(0).getNumOfPerson());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isChildren!", isChildren,
//					orderPOs.get(0).isChildren());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isOnSale!", isOnSale,
//					orderPOs.get(0).isOnSale());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isCommented!", isCommented,
//					orderPOs.get(0).isCommented());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testGetUserOrderList() {
//		ArrayList<BriefOrderInfoPO> briefOrderInfoPOs = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			briefOrderInfoPOs = orderDAO.getUserOrderList(userID, OrderType.DONE_ORDER);
//			assertEquals(1, briefOrderInfoPOs.size());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					briefOrderInfoPOs.get(0).getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					briefOrderInfoPOs.get(0).getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					briefOrderInfoPOs.get(0).getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					briefOrderInfoPOs.get(0).getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(briefOrderInfoPOs.get(0).getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(briefOrderInfoPOs.get(0).getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					briefOrderInfoPOs.get(0).getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, briefOrderInfoPOs.get(0).getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					briefOrderInfoPOs.get(0).getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					briefOrderInfoPOs.get(0).getOrderState());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testGetHotelOrderList() {
//		ArrayList<BriefOrderInfoPO> briefOrderInfoPOs = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			briefOrderInfoPOs = orderDAO.getHotelOrderList(hotelAddress, OrderType.ALL);
//			assertEquals(2, briefOrderInfoPOs.size());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					briefOrderInfoPOs.get(0).getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					briefOrderInfoPOs.get(0).getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					briefOrderInfoPOs.get(0).getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					briefOrderInfoPOs.get(0).getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(briefOrderInfoPOs.get(0).getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(briefOrderInfoPOs.get(0).getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					briefOrderInfoPOs.get(0).getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, briefOrderInfoPOs.get(0).getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					briefOrderInfoPOs.get(0).getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					briefOrderInfoPOs.get(0).getOrderState());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testGetAllAbnormalList() {
//		ArrayList<BriefOrderInfoPO> briefOrderInfoPOs = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			briefOrderInfoPOs = orderDAO.getAllAbnormalList(beginDate);
//			assertEquals(1, briefOrderInfoPOs.size());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					briefOrderInfoPOs.get(0).getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					briefOrderInfoPOs.get(0).getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					briefOrderInfoPOs.get(0).getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					briefOrderInfoPOs.get(0).getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(briefOrderInfoPOs.get(0).getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(briefOrderInfoPOs.get(0).getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					briefOrderInfoPOs.get(0).getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, briefOrderInfoPOs.get(0).getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					briefOrderInfoPOs.get(0).getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					briefOrderInfoPOs.get(0).getOrderState());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//
//	@Test
//	public void testGetSingleOrder() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			OrderPO orderPO = orderDAO.getSingleOrder(hotelAddress, orderID);
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					orderPO.getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					orderPO.getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					orderPO.getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					orderPO.getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(orderPO.getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(orderPO.getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					orderPO.getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, orderPO.getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					orderPO.getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					orderPO.getOrderState());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderProducedTime!",
//					sdf2.format(orderProducedTime), sdf2.format(orderPO.getOrderProducedTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in lastedOrderDoneTime!",
//					sdf2.format(lastedOrderDoneTime), sdf2.format(orderPO.getLastedOrderDoneTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in numOfPerson!", numOfPerson,
//					orderPO.getNumOfPerson());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isChildren!", isChildren,
//					orderPO.isChildren());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isOnSale!", isOnSale,
//					orderPO.isOnSale());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isCommented!", isCommented,
//					orderPO.isCommented());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testGetDetailedOrder() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			OrderPO orderPO = orderDAO.getDetailedOrder(orderID);
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					orderPO.getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					orderPO.getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					orderPO.getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					orderPO.getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(orderPO.getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(orderPO.getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					orderPO.getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, orderPO.getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					orderPO.getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					orderPO.getOrderState());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderProducedTime!",
//					sdf2.format(orderProducedTime), sdf2.format(orderPO.getOrderProducedTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in lastedOrderDoneTime!",
//					sdf2.format(lastedOrderDoneTime), sdf2.format(orderPO.getLastedOrderDoneTime()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in numOfPerson!", numOfPerson,
//					orderPO.getNumOfPerson());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isChildren!", isChildren,
//					orderPO.isChildren());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isOnSale!", isOnSale,
//					orderPO.isOnSale());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in isCommented!", isCommented,
//					orderPO.isCommented());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
//	
//	@Test
//	public void testDeleteOrder() {
//		try {
//			boolean result = orderDAO.deleteOrder(po);
//			assertEquals(true, result);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
	
//	@Test
//	public void testInsertOrder() {
//		try {
//			boolean result = orderDAO.insertOrder(po);
//			assertEquals(true, result);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
	
//	@Test
//	public void testGetReservedOrderList() {
//		ArrayList<BriefOrderInfoPO> briefOrderInfoPOs = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			briefOrderInfoPOs = orderDAO.getReservedOrderList(userID);
//			assertEquals(1, briefOrderInfoPOs.size());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderID!", orderID,
//					briefOrderInfoPOs.get(0).getOrderID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in userID!", userID,
//					briefOrderInfoPOs.get(0).getUserID());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelName!", hotelName,
//					briefOrderInfoPOs.get(0).getHotelName());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in hotelAddress!", hotelAddress,
//					briefOrderInfoPOs.get(0).getHotelAddress());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in beginDate!", sdf.format(beginDate),
//					sdf.format(briefOrderInfoPOs.get(0).getBeginDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in finishDate!", sdf.format(finishDate),
//					sdf.format(briefOrderInfoPOs.get(0).getFinishDate()));
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in roomType!", roomType,
//					briefOrderInfoPOs.get(0).getRoomType());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in num!", num, briefOrderInfoPOs.get(0).getNum());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in totalPrice!", totalPrice,
//					briefOrderInfoPOs.get(0).getTotalPrice());
//			assertEquals("OrderInfoImpl.getReservedOrderList(String userID) has an error in orderState!", orderState,
//					briefOrderInfoPOs.get(0).getOrderState());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			fail("RemoteException has happened!");
//		}
//	}
	
	@Test
	public void testUpdateOrder() {
		try {
			boolean result = orderDAO.updateOrder(po);
			assertEquals(true, result);
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("RemoteException has happened!");
		}		
	}
	
}
