package businesslogic.hotelbl.queryHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hotelbl.OrderInfo;
import businesslogicservice.hotelblservice.QueryHotelService;
import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.OrderState;
import vo.BriefHotelInfoVO;
import vo.BriefOrderInfoVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.OrderedHotelInfoVO;

public class QueryHotelServiceImpl implements QueryHotelService {

	private OrderInfo orderInfo;
	private QueryHotelList hotelList;
	private ArrayList<BriefOrderInfoVO> orderList;
	private HotelDAO hotelDAO;
	
	/**
	 * 获得地址不重复的订单列表
	 * @param orderInfoList
	 * @return
	 * @see
	 */
	private ArrayList<BriefOrderInfoPO> getAddress(ArrayList<BriefOrderInfoVO> orderInfoList) {
		ArrayList<BriefOrderInfoPO> hotelList = new ArrayList<>();
		return hotelList;
	}
	
	private ArrayList<OrderState> getStates(String hotelAddress) {
		ArrayList<OrderState> hotelState = new ArrayList<>();
		return hotelState;
	}
	
	public QueryHotelServiceImpl(String userID) {
		orderList = orderInfo.getReservedOrderList(userID);
	}
	
	@Override
	public ArrayList<OrderedHotelInfoVO> getHotelBriefInfoListByQuerying(String[] condition) {
		ArrayList<BriefOrderInfoPO> orderedHotelList = this.getAddress(orderList);
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
