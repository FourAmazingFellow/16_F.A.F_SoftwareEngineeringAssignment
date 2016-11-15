package bl_Stub.hotelblservice_Stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import businesslogicservice.hotelblservice.QueryHotelService;
import po.OrderState;
import po.RoomType;
import vo.HotelVO;
import vo.OrderVO;
import vo.OrderedHotelInfoVO;

public class QueryHotelServiceImpl_Stub implements QueryHotelService {

	public String hotelName;
	public String businessDistrict;
	public String hotelAddress;
	public int starLevel;
	public int mark;
	
	public String briefIntroduction;
	public String facilityAndService;
	public HashMap<RoomType, Integer> roomTypeAndPrice;
	public HashMap<RoomType, Integer> roomTypeAndNums;
	public HashMap<String, String> comments;
	
	public String userID;
	public String orderID;
	public Date beginDate;
	public Date finishDate;
	public RoomType roomType;
	public int num;
	public int totalPrice;
	public Date orderProducedTime;
	public Date lastedOrderDoneTime;
	public int numOfPerson;
	public boolean isChildren;
	public boolean isOnSale;
	public OrderState orderState;
	public boolean isCommented;
	
	public QueryHotelServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			int mark, String briefIntroduction, String facilityAndService, HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<RoomType, Integer> roomTypeAndNums,
			HashMap<String, String> comments) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.roomTypeAndNums = roomTypeAndNums;
		this.comments = comments;
	}
	
	public QueryHotelServiceImpl_Stub(String hotelName, String businessDistrict, String hotelAddress, int starLevel,
			int mark) {
		this.hotelName = hotelName;
		this.businessDistrict = businessDistrict;
		this.hotelAddress = hotelAddress;
		this.starLevel = starLevel;
		this.mark = mark;
	}
	
	public QueryHotelServiceImpl_Stub(String briefIntroduction, String facilityAndService,
			HashMap<RoomType, Integer> roomTypeAndPrice, HashMap<RoomType, Integer> roomTypeAndNums, HashMap<String, String> comments) {
		this.briefIntroduction = briefIntroduction;
		this.facilityAndService = facilityAndService;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.roomTypeAndNums = roomTypeAndNums;
		this.comments = comments;
	}
	
	public QueryHotelServiceImpl_Stub(String hotelName, String hotelAddress, String userID, String orderID,
			Date beginDate, Date finishDate, RoomType roomType, int num, int totalPrice, Date orderProducedTime,
			Date lastedOrderDoneTime, int numOfPerson, boolean isChildren, boolean isOnSale, OrderState orderState,
			boolean isCommented) {
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.userID = userID;
		this.orderID = orderID;
		this.beginDate = beginDate;
		this.finishDate = finishDate;
		this.roomType = roomType;
		this.num = num;
		this.totalPrice = totalPrice;
		this.orderProducedTime = orderProducedTime;
		this.lastedOrderDoneTime = lastedOrderDoneTime;
		this.numOfPerson = numOfPerson;
		this.isChildren = isChildren;
		this.isOnSale = isOnSale;
		this.orderState = orderState;
		this.isCommented = isCommented;
	}
	
	@Override
	public ArrayList<OrderedHotelInfoVO> getHotelBriefInfoListByQuerying(String[] condition) {
		ArrayList<OrderedHotelInfoVO> orderedHotelInfoVOList = new ArrayList<>();
		ArrayList<OrderState> orderStates = new ArrayList<>();
		orderStates.add(OrderState.DONE_ORDER);
		orderedHotelInfoVOList.add(new OrderedHotelInfoVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, orderStates));
		return orderedHotelInfoVOList;
	}

	@Override
	public HotelVO getHotelDetails(String address) {
		return new HotelVO(hotelName, businessDistrict, hotelAddress, starLevel, mark, briefIntroduction, facilityAndService, roomTypeAndPrice, roomTypeAndNums, comments);
	}

	@Override
	public ArrayList<OrderVO> getOrders(String address, String userID) {
		ArrayList<OrderVO> orderVOList = new ArrayList<>();
		orderVOList.add(new OrderVO(userID, orderID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale, orderState, isCommented));
		return orderVOList;
	}

}
