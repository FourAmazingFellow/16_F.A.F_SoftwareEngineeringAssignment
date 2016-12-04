package businesslogic.orderbl.checkAbnormalOrder;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class CheckAbnormalOrderServiceImpl implements CheckAbnormalOrderService {
	private AbnormalOrderList abnormalOrderListHelper;
	private SystemOrderWithdrawer withdrawer;
	
	public CheckAbnormalOrderServiceImpl() {
		abnormalOrderListHelper = new AbnormalOrderList();
		withdrawer = new SystemOrderWithdrawer();
	}
	
	@Override
	public ArrayList<BriefOrderInfoVO> getAbnormalOrderList(Date date) {
		ArrayList<BriefOrderInfoVO> abnormalBriefOrderList = abnormalOrderListHelper.getAbnormalOrderList(date);
		
		return abnormalBriefOrderList;
	}

	@Override
	public OrderVO getDetailedOrder(String orderID) {
		OrderVO detailedAbnormalOrder = abnormalOrderListHelper.getDetailedOrder(orderID);
		
		return detailedAbnormalOrder;
	}


	@Override
	public boolean systemWithdrawOrder(OrderVO vo, boolean isRecoverHalfCredit) {
		
		return withdrawer.systemWithdrawOrder(vo, isRecoverHalfCredit);
	}

}
