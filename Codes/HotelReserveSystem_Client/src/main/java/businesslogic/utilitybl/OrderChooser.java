package businesslogic.utilitybl;

import java.util.ArrayList;

import po.OrderType;
import vo.BriefOrderInfoVO;

public class OrderChooser {
	ArrayList<BriefOrderInfoVO> resultList;
	
	/**
	 * 筛选算法，根据orderType将给定订单列表排序
	 * @param briefOrderlist 所要排序的OrderList
	 * @param orderType 按照返回何种
	 * @return 筛选后的List
	 * @see
	 */
	public ArrayList<BriefOrderInfoVO> sort(ArrayList<BriefOrderInfoVO> briefOrderlist, Enum<OrderType> orderType){
		//筛选算法，根据orderType筛选
		return resultList;
	}
}
