package businesslogic.hotelbl.CheckOrderedHotel;

import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import po.OrderState;
import vo.BriefOrderInfoVO;
import vo.OrderedHotelInfoVO;

public class OrderedHotelList {
	private OrderInfo orderInfo;
	private ArrayList<BriefOrderInfoVO> orderInfoList;
	private OrderedHotelItem hotelItem;
	private String userID;
	
	public OrderedHotelList(String userID) {
		this.userID = userID;
		this.orderInfoList = orderInfo.getReservedOrderList(this.userID);
	}
	
	/**
	 * 获得地址不重复的订单列表
	 * @param orderInfoList
	 * @return
	 * @see
	 */
	private ArrayList<BriefOrderInfoVO> getAddress(ArrayList<BriefOrderInfoVO> orderInfoList) {
		ArrayList<BriefOrderInfoVO> hotelList = new ArrayList<>();
		return hotelList;
	}
	
	private ArrayList<OrderState> getStates(String hotelAddress) {
		ArrayList<OrderState> hotelState = new ArrayList<>();
		return hotelState;
	}
	
	public ArrayList<OrderedHotelInfoVO> enrollHotelBreifInfoList() {
		ArrayList<BriefOrderInfoVO> hotelList = this.getAddress(orderInfoList);
		ArrayList<OrderedHotelInfoVO> result = new ArrayList<>();
		for(BriefOrderInfoVO orderInfoVO : hotelList) {
			hotelItem = new OrderedHotelItem(orderInfoVO.hotelAddress);
			result.add(new OrderedHotelInfoVO(hotelItem.getbriefHotelInfo(), this.getStates(orderInfoVO.hotelAddress)));
		}
		return result;
	}
}
