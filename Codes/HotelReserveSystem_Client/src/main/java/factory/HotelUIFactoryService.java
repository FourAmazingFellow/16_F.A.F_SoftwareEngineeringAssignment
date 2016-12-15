package factory;

import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import businesslogicservice.hotelblservice.CommentOnHotelService;
import businesslogicservice.hotelblservice.ImportNewRoomService;
import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import businesslogicservice.hotelblservice.QueryHotelService;
import businesslogicservice.hotelblservice.SearchHotelService;

public interface HotelUIFactoryService {
	public CheckOrderedHotelService createCheckOrderedHotelService();

	public CommentOnHotelService createCommentOnHotelService();

	public ImportNewRoomService createImportNewRoomService();

	public MaintainHotelBasicInfoService createMaintainHotelBasicInfoService();

	public ManageHotelInfoService createManageHotelInfoService();

	public QueryHotelService createQueryHotelService();

	public SearchHotelService createSearchHotelService();
}
