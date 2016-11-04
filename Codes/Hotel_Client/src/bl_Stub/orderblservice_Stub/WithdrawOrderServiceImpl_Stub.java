package bl_Stub.orderblservice_Stub;

import java.util.Date;

import businesslogicservice.orderblservice.WithdrawOrderService;
import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class WithdrawOrderServiceImpl_Stub implements WithdrawOrderService {
	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;
	
	public WithdrawOrderServiceImpl_Stub(String userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orID, hN, hA, bD, fD, rT, n, tP, orderS);
		testOrderVO = new OrderVO(userID, orID, hN, hA, bD, fD, rT, n, tP ,oPT, lODT, nOP, isChild, isOnSale, orderS, isCom);
	}

	@Override
	public boolean withdrawOrder(OrderVO vo, boolean isToolate) {
		// TODO Auto-generated method stub
		return false;
	}
}
