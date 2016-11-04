package businesslogic.orderbl.getOrderDone;

import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditService;
import dataservice.orderDAO.OrderDAO;
import vo.OrderVO;

public class OrderTerminator {
	private OrderDAO orderDaoService;
	private ClientCreditService userCreditService;
	private RoomInfoService addSpareRoomService;
	
	public boolean getOrderDone(OrderVO vo) {
		// TODO Codes 将该订单改为已执行状态，然后为该客户增加与订单价值等额的信用值, 并增加可用客房
		return false;
	}
	
	public boolean delayCheckIn(OrderVO vo){
		// TODO Codes 将该订单置为已执行订单，恢复扣除的信用值
		return false;
	}
	
	//下面是该类的各种私有方法, 要用到orderDaoService, userCreditService, addSpareRoomService
}
