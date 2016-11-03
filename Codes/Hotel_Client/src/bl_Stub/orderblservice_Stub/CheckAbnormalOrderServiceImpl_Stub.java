package bl_Stub.orderblservice_Stub;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.orderblservice.CheckAbnormalOrderService;
import po.OrderState;
import po.RoomType;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class CheckAbnormalOrderServiceImpl_Stub implements CheckAbnormalOrderService {

	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;
	
	public CheckAbnormalOrderServiceImpl_Stub(String userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orID, hN, hA, bD, fD, rT, n, tP, orderS);
		testOrderVO = new OrderVO(userID, orID, hN, hA, bD, fD, rT, n, tP ,oPT, lODT, nOP, isChild, isOnSale, orderS, isCom);
	}
	
	@Override
	public ArrayList<BriefOrderInfoVO> getAbnormalOrderList(Date date) {
		System.out.println("得到所有异常订单列表");
		ArrayList<BriefOrderInfoVO> a = new ArrayList<BriefOrderInfoVO>();
		a.add(testBriefOrderInfoVO);
		return a;
	}

	@Override
	public OrderVO getDetailedOrder(String orderID) {
		// TODO Auto-generated method stub
		System.out.println("展开异常订单详情");
		return testOrderVO;
	}

	@Override
	public boolean systemWithdrawOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		System.out.println("网站营销人员撤销订单");
		return false;
	}

}
