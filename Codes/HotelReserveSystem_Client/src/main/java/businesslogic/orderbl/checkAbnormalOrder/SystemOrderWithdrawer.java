package businesslogic.orderbl.checkAbnormalOrder;

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

public class SystemOrderWithdrawer {
	private OrderDAO orderDaoService;
	private ClientCreditInfo userCreditService;
	private RoomInfoService addSpareRoomService;
	
	private FactoryService factory;

	public SystemOrderWithdrawer() {
		factory = new FactoryServiceImpl();
		orderDaoService = RemoteHelper.getInstance().getOrderDAO();
		userCreditService = factory.createClientCreditInfoService();
		addSpareRoomService = factory.createRoomInfoService();
	}
	
	/**
	 * 撤销此异常订单并将其状态置为已撤销、记录撤销时间，恢复此客户信用值的全部或一半
	 * @param vo 要撤销的订单VO
	 * @param isRecoverHalfCredit
	 * @return 操作结果
	 * @see
	 */
	public boolean systemWithdrawOrder(OrderVO vo, boolean isRecoverHalfCredit) {
		// 撤销此异常订单并将其状态置为已撤销、记录撤销时间，恢复此客户信用值的全部或一半
		if(vo == null)
			return false;
		if(vo.orderState != OrderState.ABNORMAL_ORDER)
			return false;
		VO2PO transformer = new VO2PO();
		OrderPO po = transformer.orderVO2PO(vo);
		
		po.setOrderState(OrderState.WITHDREW_ORDER);
		po.setLastedOrderDoneTime(new Date());
		
		try {
			if(orderDaoService.updateOrder(po)){
				if(addSpareRoom(vo.hotelAddress, vo.beginDate, vo.finishDate, vo.num, vo.roomType) &&
						recoverCreditValue(vo.userID, vo.hotelAddress, isRecoverHalfCredit, vo.totalPrice, ActionType.ORDER_RECOVER))
					return true;
				else
					return false;
			}else
				return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	// 下面是该类的各种私有方法, 要用到orderDaoService, userCreditService, addSpareRoomService

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

	/**
	 * 
	 * @param userID 用户ID
	 * @param orderID 订单号
	 * @param isRecoverHalfCredit 要恢复的Record是否是一半
	 * @param price 订单价值（等价于信用值）
	 * @param actionType 操作类型
	 * @return 恢复结果
	 * @throws RemoteException 
	 * @see
	 */
	private boolean recoverCreditValue(String userID, String orderID, boolean isRecoverHalfCredit, int price, ActionType actionType) throws RemoteException {
		if (isRecoverHalfCredit) {
			if (userCreditService.changeCreditValue(userID, price / 2, orderID, actionType))
				return true;
			else
				return false;
		} else {
			if (userCreditService.changeCreditValue(userID, price, orderID, actionType))
				return true;
			else
				return false;
		}
	}

	private Date addOneDay(Date currentDate) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		Date date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		return date;
	}
}
