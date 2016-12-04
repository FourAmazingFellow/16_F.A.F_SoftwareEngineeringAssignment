package businesslogic.orderbl.withdrawOrder;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import businesslogic.utilitybl.VO2PO;
import dataservice.orderDAO.OrderDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.ActionType;
import po.OrderPO;
import po.OrderState;
import po.RoomType;
import rmi.RemoteHelper;
import vo.OrderVO;

public class OrderWithdrawer {
	private OrderDAO orderDaoService;
	private ClientCreditInfo userCreditService;
	private RoomInfoService addSpareRoomService;
	
	private FactoryService factory;
	
	public OrderWithdrawer() {
		factory = new FactoryServiceImpl();
		orderDaoService = RemoteHelper.getInstance().getOrderDAO();
		userCreditService = factory.createClientCreditInfoService();
		addSpareRoomService = factory.createRoomInfoService();
	}
	
	public boolean withdrawOrder(OrderVO vo, boolean isTooLate) {
		// TODO Codes 更改订单信息，置为已撤销状态，记录撤销时间, 根据isTooLate更改客户信用值
		if(vo == null){
			System.out.println("客户所要撤销的订单为空指针");
			return false;
		}
		if(vo.orderState != OrderState.NOT_DONE_ORDER){
			System.out.println("客户所要撤销的订单不是未执行订单");
			return false;
		}
		VO2PO transformer = new VO2PO();
		OrderPO po = transformer.orderVO2PO(vo);
		po.setOrderState(OrderState.WITHDREW_ORDER);
		po.setLastedOrderDoneTime(new Date());
		if(isTooLate){
			userCreditService.changeCreditValue(vo.userID, -vo.totalPrice/2, vo.orderID, ActionType.ORDER_UNDO);
		}
		po.setLastedOrderDoneTime(new Date());
		
		try {
			//更改订单信息，增加空房
			if(orderDaoService.updateOrder(po) && addSpareRoom(vo.hotelAddress, vo.beginDate, vo.finishDate, vo.num, vo.roomType)){
				return true;
			}else{
				return false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}

	/**
	 * 为对应酒店增加该订单对应的空房
	 * @param address 酒店名称
	 * @param beginDate 订单开始时间
	 * @param finishDate 订单结束时间
	 * @param num 房间数
	 * @param roomType 对应房型
	 * @return 增加成功与否
	 * @see
	 */
	private boolean addSpareRoom(String address, Date beginDate, Date finishDate, int num, Enum<RoomType> roomType){
		for(Date currentDate = beginDate; currentDate.compareTo(finishDate) <= 0; currentDate = addOneDay(currentDate)){
			try {
				addSpareRoomService.addRoom(address, num, roomType, addOneDay(currentDate));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
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
