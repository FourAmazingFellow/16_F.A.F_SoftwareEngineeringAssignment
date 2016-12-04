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
		if(briefPoList == null)
			return null;
		
		ArrayList<BriefOrderInfoVO> voList = new ArrayList<BriefOrderInfoVO>();
		for(BriefOrderInfoPO po:briefPoList){
			voList.add(briefPO2VO(po));
		}
		return voList;
	}
	
	/**
	 * 将订单信息PO列表转化为VO列表
	 * @param poList
	 * @return 转化后的VO列表
	 * @see
	 */
	public ArrayList<OrderVO> detailedPo2voList(ArrayList<OrderPO> poList){
		if(poList == null)
			return null;
		
		ArrayList<OrderVO> voList = new ArrayList<OrderVO>();
		for(OrderPO po:poList){
			voList.add(orderPO2VO(po));
		}
		return voList;
	}
	
	/**
	 * 
	 * @param po
	 * @return
	 * @see
	 */
	public OrderVO orderPO2VO(OrderPO po){
		if(po == null)
			return null;
		
		OrderVO vo = new OrderVO(po.getUserID(), po.getOrderID(), po.getHotelName(), po.getHotelAddress(),
				po.getBeginDate(), po.getFinishDate(), po.getRoomType(), po.getNum(), po.getTotalPrice(), po.getOrderState(), 
				po.getOrderProducedTime(), po.getLastedOrderDoneTime(), po.getNumOfPerson(), po.isChildren(), po.isOnSale(), po.isCommented());
		
		return vo;
	}
	
	private BriefOrderInfoVO briefPO2VO(BriefOrderInfoPO po){
		if(po == null)
			return null;
		
		BriefOrderInfoVO result = new BriefOrderInfoVO( po.getUserID(), po.getOrderID(), po.getHotelName(), po.getHotelAddress(),
				po.getBeginDate(), po.getFinishDate(), po.getRoomType(), po.getNum(), po.getTotalPrice(), po.getOrderState());
		return result;
		
	}
}
