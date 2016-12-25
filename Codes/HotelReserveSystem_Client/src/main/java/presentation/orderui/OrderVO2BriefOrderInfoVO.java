package presentation.orderui;

import java.util.ArrayList;

import vo.BriefOrderInfoVO;
import vo.OrderVO;

public class OrderVO2BriefOrderInfoVO {
	/**
	 * 将OrderVO转化为对应的BriefOrderInfoVO的静态方法
	 * @param list
	 * @return
	 * @see
	 */
	public static ArrayList<BriefOrderInfoVO> trans(ArrayList<OrderVO> list) {
		ArrayList<BriefOrderInfoVO> newList = new ArrayList<BriefOrderInfoVO>();
		for(OrderVO vo : list) {
			BriefOrderInfoVO temp = new BriefOrderInfoVO(vo.userID, vo.orderID, vo.hotelName, vo.hotelAddress, vo.beginDate, 
					vo.finishDate, vo.roomType, vo.num, vo.totalPrice, vo.orderState);
			newList.add(temp);
		}
		return newList;
	}
}
