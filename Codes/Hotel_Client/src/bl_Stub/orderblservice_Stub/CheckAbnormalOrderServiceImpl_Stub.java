package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class CheckAbnormalOrderServiceImpl_Stub implements CheckAbnormalOrderService {

	@Override
	public ArrayList<BriefOrderInfoVO> getAbnormalOrderList(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO getDetailedOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean systemWithdrawOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
