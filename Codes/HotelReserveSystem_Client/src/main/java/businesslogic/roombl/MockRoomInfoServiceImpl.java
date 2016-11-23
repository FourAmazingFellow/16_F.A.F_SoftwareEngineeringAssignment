package businesslogic.roombl;

import java.util.Date;

import businesslogicservice.orderblservice.ResultMessage;
import po.RoomType;
import vo.OrderVO;
import vo.RoomVO;

public class MockRoomInfoServiceImpl extends RoomInfoServiceImpl{
	
	
	public int getAvailableRoomNum(String address, Enum<RoomType> roomType) {
		return 2;
	}

	@Override
	public boolean isTimeAvailable(String addresss, Enum<RoomType> roomType, Date beginDate, Date finishDate) {
		return true;
	}

	@Override
	public ResultMessage checkOrder(OrderVO vo) {
		return ResultMessage.SUCCEED;
	}

	@Override
	public boolean updateSpareRoom(String address, RoomVO roomvo) {
		return true;
	}

	@Override
	public boolean reduceRoom(String address, int change, Enum<RoomType> roomType) {
		return true;
	}

	@Override
	public boolean addRoom(String address, int change, Enum<RoomType> roomType) {
		return true;
	}
	
}