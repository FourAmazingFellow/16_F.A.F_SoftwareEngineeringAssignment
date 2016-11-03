package businesslogic.utilitybl;

import java.util.ArrayList;

import po.BriefOrderInfoPO;
import po.OrderPO;
import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class POList2VOList {
	
	/**
	 * 将简要订单信息PO列表转化为简要VO列表
	 * @param poList
	 * @return 转化后的VO列表
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> briefPo2voList(ArrayList<BriefOrderInfoPO> briefPoList){
		ArrayList<BriefOrderInfoVO> voList = new ArrayList<BriefOrderInfoVO>();
		//briefPoList TO BriefVOList 转化代码
		return voList;
	}
	
	/**
	 * 将订单信息PO列表转化为VO列表
	 * @param poList
	 * @return 转化后的VO列表
	 * @see
	 */
	public ArrayList<OrderVO> detailedPo2voList(ArrayList<OrderPO> poList){
		ArrayList<OrderVO> voList = new ArrayList<OrderVO>();
		//POList TO VOList 转化代码
		return voList;
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 * @see
	 */
	public OrderVO orderPO2VO(OrderPO po){
		OrderVO vo = null;
		//PO TO VO 转化代码
		return vo;
	}
}
