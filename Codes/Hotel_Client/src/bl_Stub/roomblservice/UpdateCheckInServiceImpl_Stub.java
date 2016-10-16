package bl_Stub.roomblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.roomblservice.UpdateCheckInService;
import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateCheckInServiceImpl_Stub implements UpdateCheckInService{

    @Override
    public ArrayList<RoomVO> getCheckInList(String address) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoomVO searchCheckInInfo(String address, Date time) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoomVO searchCheckInInfo(String address, Enum<RoomType> roomType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean AddCheckIn(String address, RoomVO checkIn) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean ModifyCheckIn(String address, RoomVO checkIn) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delCheckIn(String address, RoomVO checkIn) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validCheckIn(String address, RoomVO checkIn) {
        // TODO Auto-generated method stub
        return false;
    }

}
