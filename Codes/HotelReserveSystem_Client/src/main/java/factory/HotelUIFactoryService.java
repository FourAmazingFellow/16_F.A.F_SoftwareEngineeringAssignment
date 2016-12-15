package factory;


import businesslogic.hotelbl.OrderInfo;
import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import businesslogicservice.hotelblservice.CommentOnHotelService;
import businesslogicservice.hotelblservice.ImportNewRoomService;
import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import businesslogicservice.hotelblservice.QueryHotelService;
import businesslogicservice.hotelblservice.SearchHotelService;


/**
 * 有关Hotel界面所要用到的Service的工厂接口
 * @author Accident
 * @version 1.0
 * @see
 */
public interface HotelUIFactoryService {
	public CheckOrderedHotelService createCheckOrderedHotelService();
	
	public CommentOnHotelService createCommentOnHotelService();
	
	public ImportNewRoomService createImportNewRoomService();
	
	public MaintainHotelBasicInfoService createMaintainHotelBasicInfoService(String hotelAddress);
	
	public ManageHotelInfoService createManageHotelInfoService(String hotelAddress);
	
	public QueryHotelService createQueryHotelService(String userID);
	
	public SearchHotelService createSearchHotelService(String userID);
	
	public OrderInfo createOrderInfo();

}
