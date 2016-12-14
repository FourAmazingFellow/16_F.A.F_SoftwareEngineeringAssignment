package factory;

import businesslogic.hotelbl.OrderInfo;
import businesslogic.hotelbl.checkOrderedHotel.CheckOrderedHotelServiceImpl;
import businesslogic.hotelbl.commentOnHotel.CommentOnHotelServiceImpl;
import businesslogic.hotelbl.importNewRoom.ImportNewRoomServiceImpl;
import businesslogic.hotelbl.maintainHotelBasicInfo.MaintainHotelBasicInfoServiceImpl;
import businesslogic.hotelbl.manageHotelInfo.ManageHotelInfoServiceImpl;
import businesslogic.hotelbl.queryHotel.QueryHotelServiceImpl;
import businesslogic.hotelbl.searchHotel.SearchHotelServiceImpl;
import businesslogic.orderbl.OrderInfoImpl;
import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import businesslogicservice.hotelblservice.CommentOnHotelService;
import businesslogicservice.hotelblservice.ImportNewRoomService;
import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import businesslogicservice.hotelblservice.QueryHotelService;
import businesslogicservice.hotelblservice.SearchHotelService;

public class HotelUIFactoryServiceImpl implements HotelUIFactoryService{

	@Override
	public CheckOrderedHotelService createCheckOrderedHotelService() {
		return new CheckOrderedHotelServiceImpl();
	}

	@Override
	public CommentOnHotelService createCommentOnHotelService() {
		return new CommentOnHotelServiceImpl();
	}

	@Override
	public ImportNewRoomService createImportNewRoomService() {
		return new ImportNewRoomServiceImpl();
	}

	@Override
	public MaintainHotelBasicInfoService createMaintainHotelBasicInfoService(String hotelAddress) {
		return new MaintainHotelBasicInfoServiceImpl(hotelAddress);
	}

	@Override
	public ManageHotelInfoService createManageHotelInfoService(String hotelAddress) {
		return new ManageHotelInfoServiceImpl();
	}

	@Override
	public QueryHotelService createQueryHotelService(String userID) {
		return new QueryHotelServiceImpl(userID);
	}

	@Override
	public SearchHotelService createSearchHotelService(String userID) {
		return new SearchHotelServiceImpl(userID);
	}

	@Override
	public OrderInfo createOrderInfo() {
		return new OrderInfoImpl();
	}

}
