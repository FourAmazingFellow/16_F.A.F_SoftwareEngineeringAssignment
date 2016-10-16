package bl_Stub.roomblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.roomblservice.UpdateCheckOutService;
import po.RoomPO;
import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateCheckOutServiceImpl_Stub implements UpdateCheckOutService{

    @Override
    public ArrayList<RoomVO> getCheckOutList(String address) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoomPO getCheckOutInfo(String address, Date time) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoomPO getCheckOutInfo(String address, Enum<RoomType> roomType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean AddCheckOut(String address, RoomVO roomvo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean ModifyCheckOut(String address, RoomVO roomvo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delCheckOut(String address, RoomVO roomvo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validCheckOut(String address, RoomVO checkOut) {
        // TODO Auto-generated method stub
        return false;
    }

}
