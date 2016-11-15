package businesslogic.hotelbl.queryHotel;

import java.util.HashMap;

import data_Stub.HotelDAOImpl_Stub;
import po.RoomType;

public class MockQueryHotelServiceImpl extends QueryHotelServiceImpl {

	public MockQueryHotelServiceImpl(String userID) {
		super(userID);
		HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
		roomTypeAndPrice.put(RoomType.KING_SIZE_ROOM, 1000);
		HashMap<String, String> comments = new HashMap<>();
		comments.put("原", "该酒店服务到位，应有尽有！");
		HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
		roomTypeAndNums.put(RoomType.KING_SIZE_ROOM, 20);
		super.hotelDAO = new HotelDAOImpl_Stub("Jingling Hotel", "新街口", "江苏省南京市栖霞区仙林大道163号", 5, 5.0f, "南京市最好的酒店", "所有服务应有尽有", roomTypeAndPrice, roomTypeAndNums, comments);
	}
	
}
