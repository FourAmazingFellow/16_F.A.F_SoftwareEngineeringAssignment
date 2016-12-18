package businesslogic.orderbl.createNewOrder;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.roombl.RoomInfoService;
import businesslogicservice.orderblservice.CreateNewOrderService;
import businesslogicservice.orderblservice.ResultMessage;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.OrderVO;

public class CreateNewOrderServiceImpl implements CreateNewOrderService {
	private HotelInfoService hotelInfoGetter;
	private RoomInfoService roomInfoService;
	private Checker checker;
	private NewOrder newOrder;

	private FactoryService factory;
	
	public CreateNewOrderServiceImpl() {
		factory = new FactoryServiceImpl();
		hotelInfoGetter = factory.createHotelInfoService();
		roomInfoService = factory.createRoomInfoService();
		checker = new Checker();
		newOrder = new NewOrder();
	}
	
	@Override
	public BriefHotelInfoVO getHotelBriefInfo(String address) {
		// 得到的同时界面层应将可选房型置好
		BriefHotelInfoVO briefHotelInfo = hotelInfoGetter.getHotelBriefInfo(address);
		return briefHotelInfo;
	}

	@Override
	public OrderVO initNewOrder(String userID, String hotelName, String hotelAddress) {
		if (checker.canUserCreateNewOrder(userID)) {
			return newOrder.initNewOrder(userID, hotelName , hotelAddress);
		} else
			return null;
	}

	@Override
	public int getAvailableRoomNum(String address, Enum<RoomType> roomType, Date day) {
		int num = -1;
		try {
			num = roomInfoService.getAvailableRoomNum(address, roomType, day);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public ResultMessage checkNewOrder(OrderVO vo) {
		return checker.checkNewOrder(vo);
	}

	@Override
	public int getPrice(OrderVO vo) {
		int price = newOrder.getPrice(vo);
		return price;
	}

	@Override
	public boolean addNewOrder(OrderVO vo) {
		return newOrder.addNewOrder(vo);
	}

	@Override
	public int getOriginalPrice(String hotelAddress, RoomType roomType) {
		return newOrder.getOriginalPrice(hotelAddress, roomType);
	}
}
