package businesslogic.hotelbl.checkOrderedHotel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import businesslogic.hotelbl.OrderInfo;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.OrderState;
import vo.BriefOrderInfoVO;
import vo.OrderedHotelInfoVO;

public class OrderedHotelList {
	private OrderInfo orderInfo;
	private ArrayList<BriefOrderInfoVO> orderInfoList;
	private OrderedHotelItem hotelItem;
	private String userID;
	
	private FactoryService factory;
	
	public OrderedHotelList(String userID) {
		this.userID = userID;
		this.factory = new FactoryServiceImpl();
		this.orderInfo = factory.createOrderInfo();
		this.orderInfoList = orderInfo.getReservedOrderList(this.userID);
	}
	
	/**
	 * 获得地址不重复的订单列表
	 * @param orderInfoList
	 * @return
	 * @see
	 */
	private ArrayList<BriefOrderInfoVO> getAddress() {
		ArrayList<BriefOrderInfoVO> hotelList = new ArrayList<>(orderInfoList);
		for(int i = 0; i < hotelList.size(); i++) {
			for(int j = i + 1; j < hotelList.size(); j++) {
				if(hotelList.get(i).hotelAddress.equals(hotelList.get(j).hotelAddress)) {
					hotelList.remove(j);
					j--;
				}
			}
		}
		return hotelList;
	}
	
	/**
	 * 获得该用户在该酒店的所有订单类型
	 * @param hotelAddress
	 * @return
	 * @see
	 */
	private Set<Enum<OrderState>> getStates(String hotelAddress) {
		Set<Enum<OrderState>> hotelState = new HashSet<>();
		for(BriefOrderInfoVO orderInfoVO : orderInfoList) {
			if(orderInfoVO.hotelAddress.equals(hotelAddress)) {
				hotelState.add(orderInfoVO.orderState);
			}
		}
		return hotelState;
	}
	
	public ArrayList<OrderedHotelInfoVO> enrollHotelBreifInfoList() {
		ArrayList<BriefOrderInfoVO> hotelList = this.getAddress();
		ArrayList<OrderedHotelInfoVO> result = new ArrayList<>();
		for(BriefOrderInfoVO orderInfoVO : hotelList) {
			hotelItem = new OrderedHotelItem(orderInfoVO.hotelAddress);
			result.add(new OrderedHotelInfoVO(hotelItem.getBriefHotelInfo(), this.getStates(orderInfoVO.hotelAddress)));
		}
		return result;
	}
}


