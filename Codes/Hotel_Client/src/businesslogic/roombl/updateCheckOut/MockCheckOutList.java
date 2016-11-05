package businesslogic.roombl.updateCheckOut;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import data_Stub.RoomDAOImpl_Stub;
import dataservice.roomDAO.RoomDAO;
import po.RoomPO;
import po.RoomType;
import vo.RoomVO;

public class MockCheckOutList extends CheckOutList{

    private RoomDAO roomDAO;
    
    @SuppressWarnings("deprecation")
    public MockCheckOutList(){
        Date actDepartTime=new Date(2016, 11, 6, 12, 0);
        roomDAO=new RoomDAOImpl_Stub(RoomType.SINGLE_ROOM, 3, 400, "江苏省南京市栖霞区仙林大道163号",null,null,actDepartTime);
    }
    
    @Override
    public ArrayList<CheckOutItem> getCheckOutList(String address){
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        try {
            checkOutPOs=roomDAO.getCheckOutInfoList(address);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    @Override
    public ArrayList<CheckOutItem> searchCheckOutInfo(String address ,Date time){
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        try {
            checkOutPOs=roomDAO.getCheckOutInfo(address, time);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    @Override
    public ArrayList<CheckOutItem> searchCheckOutInfo(String address ,Enum<RoomType> roomType){
        ArrayList<RoomPO> checkOutPOs;
        ArrayList<CheckOutItem> checkOutItems=new ArrayList<CheckOutItem>();
        try {
            checkOutPOs=roomDAO.getCheckInInfo(address, roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
        for(RoomPO checkOutPO:checkOutPOs){
            checkOutItems.add(new CheckOutItem(checkOutPO));
        }
        return checkOutItems;
    }
    
    @Override
    public boolean addCheckOut(String address, RoomVO checkOut){
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.addCheckOut(address);
    }
    
    @Override
    public boolean modifyCheckOut(String address, RoomVO checkOut){
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.modifyCheckOut(address);
    }
    
    @Override
    public boolean delCheckOut(String address, RoomVO checkOut){
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.delCheckOut(address);
    }
    
    @Override
    public boolean validCheckOut(String address, RoomVO checkOut){
        CheckOutItem checkOutItem=new CheckOutItem(checkOut);
        return checkOutItem.validCheckOut();
    }
}
