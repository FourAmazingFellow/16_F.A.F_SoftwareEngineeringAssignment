package businesslogic.hotelbl.queryHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import businesslogic.hotelbl.OrderInfo;
import businesslogicservice.hotelblservice.QueryHotelService;
import dataservice.hotelDAO.HotelDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.OrderState;
import rmi.RemoteHelper;
import vo.BriefHotelInfoVO;
import vo.BriefOrderInfoVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.OrderedHotelInfoVO;

public class QueryHotelServiceImpl implements QueryHotelService {

	private OrderInfo orderInfo;
	private QueryHotelList hotelList;
	private ArrayList<BriefOrderInfoVO> orderList;
	protected HotelDAO hotelDAO;
	
	private FactoryService factory;
	
	/**
	 * 获得地址不重复的订单列表
	 * @param orderInfoList
	 * @return
	 * @see
	 */
	private ArrayList<BriefOrderInfoPO> getAddress() {
		ArrayList<BriefOrderInfoPO> hotelList = new ArrayList<>();
		for(BriefOrderInfoVO order: orderList) {
			hotelList.add(new BriefOrderInfoPO(order));
		}
		for(int i = 0; i < hotelList.size(); i++) {
			for(int j = i + 1; j < hotelList.size(); j++) {
				if(hotelList.get(i).getHotelAddress().equals(hotelList.get(j).getHotelAddress())) {
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
		for(BriefOrderInfoVO orderInfoVO : orderList) {
			if(orderInfoVO.hotelAddress.equals(hotelAddress)) {
				hotelState.add(orderInfoVO.orderState);
			}
		}
		return hotelState;
	}
	
	public QueryHotelServiceImpl(String userID) {
		this.hotelDAO = RemoteHelper.getInstance().getHotelDAO();
		this.factory = new FactoryServiceImpl();
		this.orderInfo = factory.createOrderInfo();
		this.hotelList = new QueryHotelList();
		orderList = orderInfo.getReservedOrderList(userID);
	}
	
	@Override
	public ArrayList<OrderedHotelInfoVO> getHotelBriefInfoListByQuerying(String[] condition) {
		ArrayList<BriefOrderInfoPO> orderedHotelList = this.getAddress();
		ArrayList<BriefHotelInfoPO> list = hotelList.getHotelBriefInfoListByQuerying(condition, orderedHotelList);
		ArrayList<OrderedHotelInfoVO> result = new ArrayList<>();
		for(BriefHotelInfoPO hotelInfoPO : list) {
			result.add(new OrderedHotelInfoVO(new BriefHotelInfoVO(hotelInfoPO), this.getStates(hotelInfoPO.getHotelAddress())));
		}
		return result;
	}

	@Override
	public HotelVO getHotelDetails(String address) {
		try {
			return new HotelVO(hotelDAO.getHotelDetails(address));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<OrderVO> getOrders(String address, String userID) {
		return orderInfo.getOrderList(userID, address);
	}

}
