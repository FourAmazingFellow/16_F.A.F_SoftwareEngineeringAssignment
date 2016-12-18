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
import rmi.RemoteHelper;
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
		orderDao = RemoteHelper.getInstance().getOrderDAO();
		hotelInfoService = factory.createHotelInfoService();
		roomInfoService = factory.createRoomInfoService();
		strategyInfoService = factory.createStrategyInfoService();
		voTransformer = new VO2PO();	
	}
	
	public OrderVO initNewOrder(String userID, String hotelName, String hotelAddress) {
		OrderVO newOrderVO = new OrderVO(userID, null, hotelName, hotelAddress, 
				null, null, null,
				-1, -1, OrderState.NOT_DONE_ORDER, null, null, -1, 
				false, false, false);
		return newOrderVO;
	}
	
	public int getOriginalPrice(String hotelAddress, RoomType roomType) throws RemoteException {
		return hotelInfoService.getRoomPrice(hotelAddress, roomType);
	}
	
	public int getPrice(OrderVO vo) throws RemoteException {
		// Codes 用到strategyInfoService,orderDao 并将VO中是否被打过折属性重置
		double discount = -1;
		discount = strategyInfoService.getBestDiscount(vo);
		
		if(Math.abs(discount - 1) > 0.01)
			vo.isOnSale = true;
		
		return (int)(vo.totalPrice * discount);
	}

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
	
	private boolean reduceSpareRoom(String address, Date beginDate, Date finishDate, int num, Enum<RoomType> roomType) throws RemoteException{
		for(Date currentDate = beginDate; currentDate.compareTo(finishDate) <= 0; currentDate = addOneDay(currentDate)){
			roomInfoService.reduceRoom(address, num, roomType, addOneDay(currentDate));
		}
		return true;
	}
	
	private Date addOneDay(Date currentDate) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		Date date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		return date;
	}
}
