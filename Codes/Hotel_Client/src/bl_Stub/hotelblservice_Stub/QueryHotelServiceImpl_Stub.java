package bl_Stub.hotelblservice_Stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import businesslogicservice.hotelblservice.QueryHotelService;
import po.OrderState;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.HotelVO;
import vo.OrderVO;

public class QueryHotelServiceImpl_Stub implements QueryHotelService {

	public String hotelName;
	public String businessDistrict;
	public String hotelAddress;
	public int starLevel;
	public int mark;
	
	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<String, String> comments;
	
	public Date orderProducedTime;
	public Date lastedOrderDoneTime;
	public int numOfPerson;
	public boolean isChildren;
	public boolean isOnSale;
	public OrderState orderState;
	public boolean isCommented;
	
	public QueryHotelServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			int mark) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
	}
	
	public QueryHotelServiceImpl_Stub(String briefIntroduction, String facilityAndService,
			HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<String, String> comments) {
		super();
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.comments = comments;
	}
	
	public QueryHotelServiceImpl_Stub(Date orderProducedTime, Date lastedOrderDoneTime, int numOfPerson,
			boolean isChildren, boolean isOnSale, OrderState orderState, boolean isCommented) {
		super();
		this.orderProducedTime = orderProducedTime;
		this.lastedOrderDoneTime = lastedOrderDoneTime;
		this.numOfPerson = numOfPerson;
		this.isChildren = isChildren;
		this.isOnSale = isOnSale;
		this.orderState = orderState;
		this.isCommented = isCommented;
	}
	
	@Override
	public ArrayList<BriefHotelInfoVO> getHotelBriefInfoListByQuerying(String[] condition) {
		return null;
	}

	@Override
	public HotelVO getHotelDetails(String address) {
		return null;
	}

	@Override
	public ArrayList<OrderVO> getOrders(String address, long ID) {
		return null;
	}

}
