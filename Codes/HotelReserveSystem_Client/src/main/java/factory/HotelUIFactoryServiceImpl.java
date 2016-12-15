package factory;

<<<<<<< HEAD
=======
import businesslogic.hotelbl.OrderInfo;
>>>>>>> origin/master
import businesslogic.hotelbl.checkOrderedHotel.CheckOrderedHotelServiceImpl;
import businesslogic.hotelbl.commentOnHotel.CommentOnHotelServiceImpl;
import businesslogic.hotelbl.importNewRoom.ImportNewRoomServiceImpl;
import businesslogic.hotelbl.maintainHotelBasicInfo.MaintainHotelBasicInfoServiceImpl;
import businesslogic.hotelbl.manageHotelInfo.ManageHotelInfoServiceImpl;
import businesslogic.hotelbl.queryHotel.QueryHotelServiceImpl;
import businesslogic.hotelbl.searchHotel.SearchHotelServiceImpl;
<<<<<<< HEAD
=======
import businesslogic.orderbl.OrderInfoImpl;
>>>>>>> origin/master
import businesslogicservice.hotelblservice.CheckOrderedHotelService;
import businesslogicservice.hotelblservice.CommentOnHotelService;
import businesslogicservice.hotelblservice.ImportNewRoomService;
import businesslogicservice.hotelblservice.MaintainHotelBasicInfoService;
import businesslogicservice.hotelblservice.ManageHotelInfoService;
import businesslogicservice.hotelblservice.QueryHotelService;
import businesslogicservice.hotelblservice.SearchHotelService;

<<<<<<< HEAD
public class HotelUIFactoryServiceImpl implements HotelUIFactoryService {
	private String hotelAddress;
	private String userID;
=======
public class HotelUIFactoryServiceImpl implements HotelUIFactoryService{
>>>>>>> origin/master

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
<<<<<<< HEAD
	public MaintainHotelBasicInfoService createMaintainHotelBasicInfoService() {
=======
	public MaintainHotelBasicInfoService createMaintainHotelBasicInfoService(String hotelAddress) {
>>>>>>> origin/master
		return new MaintainHotelBasicInfoServiceImpl(hotelAddress);
	}

	@Override
<<<<<<< HEAD
	public ManageHotelInfoService createManageHotelInfoService() {
=======
	public ManageHotelInfoService createManageHotelInfoService(String hotelAddress) {
>>>>>>> origin/master
		return new ManageHotelInfoServiceImpl();
	}

	@Override
<<<<<<< HEAD
	public QueryHotelService createQueryHotelService() {
=======
	public QueryHotelService createQueryHotelService(String userID) {
>>>>>>> origin/master
		return new QueryHotelServiceImpl(userID);
	}

	@Override
<<<<<<< HEAD
	public SearchHotelService createSearchHotelService() {
		return new SearchHotelServiceImpl(userID);
	}

=======
	public SearchHotelService createSearchHotelService(String userID) {
		return new SearchHotelServiceImpl(userID);
	}

	@Override
	public OrderInfo createOrderInfo() {
		return new OrderInfoImpl();
	}

>>>>>>> origin/master
}
