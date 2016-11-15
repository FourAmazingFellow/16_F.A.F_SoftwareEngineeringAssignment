package businesslogic.orderbl.withdrawOrder;

import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import dataservice.orderDAO.OrderDAO;
import vo.OrderVO;

public class OrderWithdrawer {
	private OrderDAO orderDaoService;
	private ClientCreditInfo userCreditService;
	private RoomInfoService addSpareRoomService;
	
	public boolean withdrawOrder(OrderVO vo, boolean isTooLate) {
		// TODO Codes 更改订单信息，置为已撤销状态，记录撤销时间, 根据isTooLate更改客户信用值
		return false;
	}
	
	//下面是该类的各种私有方法, 要用到orderDaoService, userCreditService, addSpareRoomService
}
