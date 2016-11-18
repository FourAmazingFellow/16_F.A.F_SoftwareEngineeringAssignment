package businesslogic.orderbl.checkAbnormalOrder;

import businesslogic.roombl.RoomInfoService;
import businesslogic.userbl.ClientCreditInfo;
import dataservice.orderDAO.OrderDAO;
import vo.OrderVO;

public class SystemOrderWithdrawer {
	private OrderDAO orderDaoService;
	private ClientCreditInfo userCreditService;
	private RoomInfoService addSpareRoomService;
	
	/**
	 * 撤销此异常订单并将其状态置为已撤销、记录撤销时间，恢复此客户信用值的全部或一半
	 * @param vo 要撤销的订单VO
	 * @param isRecoverHalfCredit
	 * @return 操作结果
	 * @see
	 */
	public boolean systemWithdrawOrder(OrderVO vo, boolean isRecoverHalfCredit){
		//Codes To be written
		//撤销此异常订单并将其状态置为已撤销、记录撤销时间，恢复此客户信用值的全部或一半
		return true;
	}
	
	//下面是该类的各种私有方法, 要用到orderDaoService, userCreditService, addSpareRoomService
}
