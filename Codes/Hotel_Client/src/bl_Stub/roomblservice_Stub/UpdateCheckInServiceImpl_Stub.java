package bl_Stub.roomblservice_Stub;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.roomblservice.UpdateCheckInService;
import po.RoomType;
import vo.CheckInOutVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateCheckInServiceImpl_Stub implements UpdateCheckInService{

    public Enum<RoomType> roomType;
    public int roomNum;
    public int roomPrice;
    public String address;
    public Date checkInTime;
    public Date expDepartTime;
    
    public UpdateCheckInServiceImpl_Stub(Enum<RoomType> roomType, int roomNum, int roomPrice, String address,
            Date checkInTime, Date expDepartTime) {
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.roomPrice = roomPrice;
        this.address = address;
        this.checkInTime = checkInTime;
        this.expDepartTime = expDepartTime;
    }

    @Override
    public ArrayList<RoomVO> getCheckInList(String address) {
        RoomVO checkInVO=new CheckInOutVO(roomType, roomNum, address, checkInTime, expDepartTime);
        ArrayList<RoomVO> arrayList=new ArrayList<RoomVO>();
        arrayList.add(checkInVO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomVO> searchCheckInInfo(String address, Date time) {
        RoomVO checkInVO=new CheckInOutVO(roomType, roomNum, address, time, expDepartTime);
        ArrayList<RoomVO> arrayList=new ArrayList<RoomVO>();
        arrayList.add(checkInVO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomVO> searchCheckInInfo(String address, Enum<RoomType> roomType) {
        RoomVO checkInVO=new CheckInOutVO(roomType, roomNum, address, checkInTime, expDepartTime);
        ArrayList<RoomVO> arrayList=new ArrayList<RoomVO>();
        arrayList.add(checkInVO);
        return arrayList;
    }

    @Override
    public boolean addCheckIn(String address, RoomVO checkIn) {
        return true;
    }

    @Override
    public boolean modifyCheckIn(String address, RoomVO checkIn) {
        return true;
    }

    @Override
    public boolean delCheckIn(String address, RoomVO checkIn) {
        return true;
    }

    @Override
    public boolean validCheckIn(String address, RoomVO checkIn) {
        return true;
    }

}
