package bl_Stub.roomblservice_Stub;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.roomblservice.UpdateCheckOutService;
import po.RoomType;
import vo.CheckInOutVO;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class UpdateCheckOutServiceImpl_Stub implements UpdateCheckOutService{

    public Enum<RoomType> roomType;
    public int roomNum;
    public int roomPrice;
    public String address;
    public Date actDepartTime;
    
    public UpdateCheckOutServiceImpl_Stub(Enum<RoomType> roomType, int roomNum, int roomPrice, String address,
            Date actDepartTime) {
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.roomPrice = roomPrice;
        this.address = address;
        this.actDepartTime = actDepartTime;
    }

    @Override
    public ArrayList<RoomVO> getCheckOutList(String address) {
        RoomVO checkOutVO=new CheckInOutVO(roomType, roomNum, address, actDepartTime);
        ArrayList<RoomVO> arrayList=new ArrayList<RoomVO>();
        arrayList.add(checkOutVO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomVO> getCheckOutInfo(String address, Date time) {
        RoomVO checkOutVO=new CheckInOutVO(roomType, roomNum, address, time);
        ArrayList<RoomVO> arrayList=new ArrayList<RoomVO>();
        arrayList.add(checkOutVO);
        return arrayList;
    }

    @Override
    public ArrayList<RoomVO> getCheckOutInfo(String address, Enum<RoomType> roomType) {
        RoomVO checkOutVO=new CheckInOutVO(roomType, roomNum, address, actDepartTime);
        ArrayList<RoomVO> arrayList=new ArrayList<RoomVO>();
        arrayList.add(checkOutVO);
        return arrayList;
    }

    @Override
    public boolean addCheckOut(String address, RoomVO roomvo) {
        return true;
    }

    @Override
    public boolean modifyCheckOut(String address, RoomVO roomvo) {
        return true;
    }

    @Override
    public boolean delCheckOut(String address, RoomVO roomvo) {
        return true;
    }

    @Override
    public boolean validCheckOut(String address, RoomVO checkOut) {
        return true;
    }

}
