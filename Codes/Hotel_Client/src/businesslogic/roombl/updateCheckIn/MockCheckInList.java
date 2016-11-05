package businesslogic.roombl.updateCheckIn;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import data_Stub.RoomDAOImpl_Stub;
import dataservice.roomDAO.RoomDAO;
import po.RoomPO;
import po.RoomType;
import vo.RoomVO;

public class MockCheckInList extends CheckInList{

    private RoomDAO roomDAO;
    
    @SuppressWarnings("deprecation")
    public MockCheckInList(){
        Date checkInTime=new Date(2016, 11, 5, 18, 0);
        Date expDepartTime=new Date(2016, 11, 6, 12, 0);
        roomDAO=new RoomDAOImpl_Stub(RoomType.SINGLE_ROOM, 3, 400, "江苏省南京市栖霞区仙林大道163号",checkInTime,expDepartTime,null);
    }
    
    @Override
    public ArrayList<CheckInItem> getCheckInList(String address){
        ArrayList<RoomPO> roomPOs;
        ArrayList<CheckInItem> checkInItems=new ArrayList<CheckInItem>();
        try {
            roomPOs=roomDAO.getCheckInInfoList(address);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO roomPO:roomPOs){
            checkInItems.add(new CheckInItem(roomPO));
        }
        return checkInItems;
    }
    
    @Override
    public ArrayList<CheckInItem> searchCheckInInfo(String address ,Date time){
        ArrayList<RoomPO> roomPOs;
        ArrayList<CheckInItem> checkInItems=new ArrayList<CheckInItem>();
        try {
            roomPOs=roomDAO.getCheckInInfo(address, time);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO roomPO:roomPOs){
            checkInItems.add(new CheckInItem(roomPO));
        }
        return checkInItems;
    }
    
    @Override
    public ArrayList<CheckInItem> searchCheckInInfo(String address ,Enum<RoomType> roomType){
        ArrayList<RoomPO> roomPOs;
        ArrayList<CheckInItem> checkInItems=new ArrayList<CheckInItem>();
        try {
            roomPOs=roomDAO.getCheckInInfo(address, roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO roomPO:roomPOs){
            checkInItems.add(new CheckInItem(roomPO));
        }
        return checkInItems;
    }
    
    @Override
    public boolean addCheckIn(String address, RoomVO checkIn){
        CheckInItem checkInItem=new CheckInItem(checkIn);
        return checkInItem.addCheckIn(address);
    }
    
    @Override
    public boolean modifyCheckIn(String address, RoomVO checkIn){
        CheckInItem checkInItem=new CheckInItem(checkIn);
        return checkInItem.modifyCheckIn(address);
    }
    
    @Override
    public boolean delCheckIn(String address, RoomVO checkIn){
        CheckInItem checkInItem=new CheckInItem(checkIn);
        return checkInItem.delCheckIn(address);
    }
    
    @Override
    public boolean validCheckIn(String address, RoomVO checkIn){
        CheckInItem checkInItem=new CheckInItem(checkIn);
        return checkInItem.validCheckIn();
    }
}
