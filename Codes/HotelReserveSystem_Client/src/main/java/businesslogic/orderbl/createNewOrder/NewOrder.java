package businesslogic.orderbl.createNewOrder;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.roombl.RoomInfoService;
import businesslogic.strategybl.StrategyInfoService;
import businesslogic.utilitybl.VO2PO;
import dataservice.orderDAO.OrderDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.OrderPO;
import po.OrderState;
import po.RoomType;
import vo.OrderVO;

public class NewOrder {
	private OrderDAO orderDao;
	private RoomInfoService roomInfoService;
	private StrategyInfoService strategyInfoService;
	private HotelInfoService hotelInfoService;
	private VO2PO voTransformer;

	private FactoryService factory;
	
	public NewOrder() {
		factory = new FactoryServiceImpl();
		orderDao = factory.getOrderDAO();
		hotelInfoService = factory.createHotelInfoService();
		roomInfoService = factory.createRoomInfoService();
		strategyInfoService = factory.createStrategyInfoService();
		voTransformer = new VO2PO();	
	}
	
	/**
	 * 初始化订单
	 * @param userID 用户名 String类型
	 * @param hotelName 酒店名称 String
	 * @param hotelAddress 酒店地址 String
	 * @return 用户名、酒店名称、地址已经被初始化过的新订单VO
	 * @see
	 */
	public OrderVO initNewOrder(String userID, String hotelName, String hotelAddress) {
		OrderVO newOrderVO = new OrderVO(userID, null, hotelName, hotelAddress, 
				null, null, null,
				-1, -1, OrderState.NOT_DONE_ORDER, null, null, -1, 
				false, false, false);
		return newOrderVO;
	}
	
	/**
	 * 得到某酒店某房型原始价格
	 * @param hotelAddress
	 * @param roomType
	 * @return 对应酒店对应房型的原始价格
	 * @throws RemoteException
	 * @see
	 */
	public int getOriginalPrice(String hotelAddress, RoomType roomType) throws RemoteException {
		return hotelInfoService.getRoomPrice(hotelAddress, roomType);
	}
	
	/**
	 * 得到最终的订单价格（同时将是否打过折属性重置）
	 * @param vo 
	 * @return 该OrderVO对应的的最终订单价格
	 * @throws RemoteException
	 * @see
	 */
	public int getPrice(OrderVO vo) throws RemoteException {
		double discount = -1;
		discount = strategyInfoService.getBestDiscount(vo);
		
		if(Math.abs(discount - 1) > 0.01)
			vo.isOnSale = true;
		
		return (int)(vo.totalPrice * discount);
	}

	/**
	 * 将订单信息加入数据库
	 * @param vo
	 * @return boolean 将订单信息加入数据库是否成功
	 * @throws RemoteException
	 * @see
	 */
	public boolean addNewOrder(OrderVO vo) throws RemoteException {
		OrderPO newOrderPO = voTransformer.orderVO2PO(vo);
		newOrderPO.setOrderProducedTime(new Date());
		if(reduceSpareRoom(vo.hotelAddress, vo.beginDate, vo.finishDate, vo.num, vo.roomType) 
				 && orderDao.insertOrder(newOrderPO))
			 return true;
		 else {
			return false;
		}
	}
	
	/**
	 * 当生成订单成功时此方法应被调用（减少对应的房间数）
	 * @param address String 酒店地址
	 * @param beginDate String 入住时间
	 * @param finishDate Date 退房时间
	 * @param num Integer 房间数目
	 * @param roomType 房间类型
	 * @return 是否成功
	 * @throws RemoteException
	 * @see
	 */
	private boolean reduceSpareRoom(String address, Date beginDate, Date finishDate, int num, Enum<RoomType> roomType) throws RemoteException{
		//把在订单持续时间内的每一天的空房数减去
		for(Date currentDate = beginDate; currentDate.compareTo(finishDate) <= 0; currentDate = addOneDay(currentDate)){
			roomInfoService.reduceRoom(address, num, roomType, addOneDay(currentDate));
		}
		return true;
	}
	
	/**
	 * 返回currentDate之后的一天的Date
	 * @param currentDate
	 * @return
	 * @see
	 */
	private Date addOneDay(Date currentDate) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		Date date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		return date;
	}
}
