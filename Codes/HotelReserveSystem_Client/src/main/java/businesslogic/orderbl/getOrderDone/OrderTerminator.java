package businesslogic.orderbl.getOrderDone;

import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import dataservice.orderDAO.OrderDAO;
import vo.OrderVO;

public class OrderTerminator {
	private OrderDAO orderDaoService;
	private ClientCreditInfo userCreditService;
	private RoomInfoService addSpareRoomService;
	
	public void set(OrderDAO orderDAO, ClientCreditInfo c, RoomInfoService r){
		orderDaoService = orderDAO;
		userCreditService = c;
		addSpareRoomService = r;
	}
	
	public boolean getOrderDone(OrderVO vo) {
		// TODO Codes 将该订单改为已执行状态，记录入住时间，然后为该客户增加与订单价值等额的信用值, 并增加可用客房
		return true;
	}
	
	public boolean delayCheckIn(OrderVO vo){
		// TODO Codes 将该订单置为已执行订单，记录入住时间，恢复扣除的信用值, 并增加可用客房
		return true;
	}
	
	//下面是该类的各种私有方法, 要用到orderDaoService, userCreditService, addSpareRoomService
}
