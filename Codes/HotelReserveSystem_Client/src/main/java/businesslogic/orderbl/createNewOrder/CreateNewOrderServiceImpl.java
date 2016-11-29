package businesslogic.orderbl.createNewOrder;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.hotelbl.HotelInfoService;
import businesslogic.roombl.RoomInfoService;
import businesslogicservice.orderblservice.CreateNewOrderService;
import businesslogicservice.orderblservice.ResultMessage;
import po.RoomType;
import vo.BriefHotelInfoVO;
import vo.OrderVO;

public class CreateNewOrderServiceImpl implements CreateNewOrderService {
	private HotelInfoService hotelInfoGetter;
	private RoomInfoService roomInfoService;
	private Checker checker;
	private NewOrder newOrder;

	public void set(HotelInfoService h, RoomInfoService r, Checker c, NewOrder n){
		hotelInfoGetter = h;
		roomInfoService = r;
		checker = c;
		newOrder = n;
	}
	
	@Override
	public BriefHotelInfoVO getHotelBriefInfo(String address) {
		// 得到的同时界面层应将可选房型置好
		BriefHotelInfoVO briefHotelInfo = hotelInfoGetter.getHotelBriefInfo(address);
		return briefHotelInfo;
	}

	@Override
	public OrderVO initNewOrder(String userID, String address) {
		if (checker.canUserCreateNewOrder(userID)) {
			return newOrder.initNewOrder(userID, address);
		} else
			return null;
	}

	@Override
	public int getAvailableRoomNum(String address, Enum<RoomType> roomType, Date day) {
		int num = 0;
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
		// TODO Auto-generated method stub
		return newOrder.addNewOrder(vo);
	}
}
