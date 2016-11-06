package businesslogic.roombl;

import java.util.Date;

import businesslogicservice.orderblservice.ResultMessage;
import dataservice.roomDAO.RoomDAO;
import po.RoomType;
import vo.OrderVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class RoomInfoServiceImpl implements RoomInfoService{

    RoomDAO roomDAO;
    
    @Override
    public int getAvailableRoomNum(String address, Enum<RoomType> roomType) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isTimeAvailable(String addresss, Enum<RoomType> roomType, Date beginDate, Date finishDate) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ResultMessage checkOrder(OrderVO vo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateSpareRoom(String address, RoomVO roomvo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean reduceRoom(String address, int change, Enum<RoomType> roomType) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addRoom(String address, int change, Enum<RoomType> roomType) {
        // TODO Auto-generated method stub
        return false;
    }

}
