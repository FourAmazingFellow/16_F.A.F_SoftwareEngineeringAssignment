package bl_Stub.orderblservice_Stub;

import java.util.Date;

import businesslogicservice.orderblservice.CreateNewOrderService;
import businesslogicservice.orderblservice.ResultMessage;
import po.OrderState;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.BriefOrderInfoVO;
import vo.OrderVO;
import vo.RoomVO;

public class CreateNewOrderServiceImpl_Stub implements CreateNewOrderService {
	BriefOrderInfoVO testBriefOrderInfoVO;
	OrderVO testOrderVO;
	ResultMessage resultMessage;
	BriefHotelInfoVO testBriefHotelInfoVO;
	RoomVO testRoomVO;
	
	
	public CreateNewOrderServiceImpl_Stub(String userID, String orID, String hN, String hA, Date bD, Date fD, RoomType rT, int n, int tP,
			Date oPT, Date lODT, int nOP, boolean isChild, boolean isOnSale, OrderState orderS,
			boolean isCom, ResultMessage reM, ResultMessage resultMessage, 
			String hotelName, String businessDistrict, String hotelAddress, int starLevel, int mark,
			Enum<RoomType> roomType, int roomNum, int roomPrice, String address) {
		testBriefOrderInfoVO = new BriefOrderInfoVO(userID, orID, hN, hA, bD, fD, rT, n, tP, orderS);
		testOrderVO = new OrderVO(userID, orID, hN, hA, bD, fD, rT, n, tP ,oPT, lODT, nOP, isChild, isOnSale, orderS, isCom);
		this.resultMessage = resultMessage;
		testBriefHotelInfoVO = new BriefHotelInfoVO(hotelName, businessDistrict, hotelAddress, starLevel, mark);
		testRoomVO = new RoomVO(roomType, roomNum, roomPrice, address);
	}
	
	@Override
	public OrderVO initNewOrder(String userID, String address) {
		System.out.println("初始化订单");
		return testOrderVO;
	}

	@Override
	public int getPrice(OrderVO vo) {
		System.out.println("得到订单价格");
		return vo.totalPrice;
	}

	@Override
	public ResultMessage checkNewOrder(OrderVO vo) {
		System.out.println("初始化订单");
		return resultMessage;
	}

	@Override
	public boolean addNewOrder(OrderVO vo) {
		System.out.println("添加订单");
		return true;
	}

	@Override
	public BriefHotelInfoVO getHotelBriefInfo(String address) {
		System.out.println("得到简要酒店信息");
		return testBriefHotelInfoVO;
	}

	@Override
	public int getAvailableRoomNum(String address, Enum<RoomType> roomType) {
		// TODO Auto-generated method stub
		return 3;
	}


}
