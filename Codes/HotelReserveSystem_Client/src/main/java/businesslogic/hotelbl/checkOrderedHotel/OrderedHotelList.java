package businesslogic.hotelbl.checkOrderedHotel;

import java.rmi.RemoteException;
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

	public OrderedHotelList(String userID) throws RemoteException {
		this.userID = userID;
		this.factory = new FactoryServiceImpl();
		this.orderInfo = factory.createOrderInfo();
		this.orderInfoList = orderInfo.getReservedOrderList(this.userID);
	}

	/**
	 * 获得地址不重复的订单列表
	 * @param orderInfoList
	 * @return 返回将重复地址删去的订单列表
	 * @see
	 */
	private ArrayList<BriefOrderInfoVO> getAddress() {
		//将原来的订单列表拷贝一份，防止此次操作对原来的数据产生修改
		ArrayList<BriefOrderInfoVO> hotelList = new ArrayList<>(orderInfoList);
		
		//删除地址重复的订单
		for (int i = 0; i < hotelList.size(); i++) {
			for (int j = i + 1; j < hotelList.size(); j++) {
				if (hotelList.get(i).hotelAddress.equals(hotelList.get(j).hotelAddress)) {
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
	 * @return 返回该用户在该酒店的所有订单状态的集合
	 * @see
	 */
	private Set<Enum<OrderState>> getStates(String hotelAddress) {
		//用户的订单状态的集合
		Set<Enum<OrderState>> hotelState = new HashSet<>();
		
		//遍历用户的订单列表，将订单状态添加进集合中，由于Set类的add方法会自动舍弃已经存在的状态，所以这里直接调用add方法即可，并不用判断状态是否重复
		for (BriefOrderInfoVO orderInfoVO : orderInfoList) {
			if (orderInfoVO.hotelAddress.equals(hotelAddress)) {
				hotelState.add(orderInfoVO.orderState);
			}
		}
		return hotelState;
	}

	/**
	 * 获得预定过的酒店列表
	 * @return 预订过的酒店列表（包含用户在此酒店的订单状态）
	 * @throws RemoteException
	 * @see
	 */
	public ArrayList<OrderedHotelInfoVO> enrollHotelBreifInfoList() throws RemoteException {
		ArrayList<BriefOrderInfoVO> hotelList = this.getAddress();
		ArrayList<OrderedHotelInfoVO> result = new ArrayList<>();
		for (BriefOrderInfoVO orderInfoVO : hotelList) {
			hotelItem = new OrderedHotelItem(orderInfoVO.hotelAddress);
			result.add(new OrderedHotelInfoVO(hotelItem.getBriefHotelInfo(), this.getStates(orderInfoVO.hotelAddress)));
		}
		return result;
	}
}
