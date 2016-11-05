package businesslogic.roombl.updateCheckIn;

import java.rmi.RemoteException;
import java.util.Date;

import data_Stub.RoomDAOImpl_Stub;
import dataservice.roomDAO.RoomDAO;
import po.CheckInOutPO;
import po.RoomPO;
import po.RoomType;
import vo.CheckInOutVO;
import vo.RoomVO;

public class MockCheckInItem extends CheckInItem{

    private Enum<RoomType> roomType;
    private int roomNum;
    private String address;
    private Date checkInTime;
    private Date expDepartTime;
    
    private RoomDAO checkInDAO;
    
    @SuppressWarnings("deprecation")
    public MockCheckInItem(){
        Date checkInTime=new Date(2016, 11, 5, 18, 0);
        Date expDepartTime=new Date(2016, 11, 6, 12, 0);
        checkInDAO=new RoomDAOImpl_Stub(RoomType.SINGLE_ROOM, 3, 400, "江苏省南京市栖霞区仙林大道163号",checkInTime,expDepartTime,null);
    }
    
    public MockCheckInItem(RoomPO roomPO) {
        this();
        CheckInOutPO checkInPO=(CheckInOutPO)roomPO;
        this.roomType = checkInPO.getRoomType();
        this.roomNum = checkInPO.getRoomNum();
        this.address = checkInPO.getAddress();
        this.checkInTime = checkInPO.getCheckInTime();
        this.expDepartTime = checkInPO.getExpDepartTime();
    }
    
    public MockCheckInItem(RoomVO roomVO){
        this();
        CheckInOutVO checkInVO=(CheckInOutVO)roomVO;
        this.roomType = checkInVO.roomType;
        this.roomNum = checkInVO.roomNum;
        this.address = checkInVO.address;
        this.checkInTime = checkInVO.checkInTime;
        this.expDepartTime = checkInVO.expDepartTime;
    }
    
    @Override
    boolean addCheckIn(String address){
        RoomPO checkInPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.insert(checkInPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    boolean modifyCheckIn(String address){
        RoomPO checkInPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.update(checkInPO);;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    boolean delCheckIn(String address){
        RoomPO checkInPO=new CheckInOutPO(roomType, roomNum, address, checkInTime, expDepartTime);
        try {
            checkInDAO.delete(checkInPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    boolean validCheckIn(){
        return false;
    }
    
    @Override
    public RoomVO toVO(){
        return new CheckInOutVO(roomType, roomNum, address, checkInTime, expDepartTime);
    }
}
