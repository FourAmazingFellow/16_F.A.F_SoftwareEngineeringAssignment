package businesslogic.roombl.browseSpareRoom;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.roombl.exception.NoThisRoomTypeSpareRoomException;
import dataservice.roomDAO.RoomDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.RoomPO;
import po.RoomType;

/**
 * 空房的列表类
 * @author 双
 * @version
 * @see
 */
public class SpareRoomList {

    private RoomDAO roomDAO;
    
    private FactoryService factoryService;
    
    public SpareRoomList(){
        //用工厂初始化roomDAO
    	this.factoryService = new FactoryServiceImpl();
        roomDAO=factoryService.getRoomDAO();
    }
    
    /**
     * 从数据层得到空房列表
     * @param address String型，酒店地址
     * @return ArrayList<SpareRoomItem>型，返回空房列表
     * @throws RemoteException 
     * @see
     */
    public ArrayList<SpareRoomItem> getRoomInfoList (String address) throws RemoteException{
        ArrayList<RoomPO> roomPOs;
        ArrayList<SpareRoomItem> spareRoomItems=new ArrayList<SpareRoomItem>();
        Date today=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            today=sdf.parse(sdf.format(today));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        roomPOs=roomDAO.getSpareRoomInfoList(address, today);
        for(RoomPO roomPO:roomPOs){
            spareRoomItems.add(new SpareRoomItem(roomPO));
        }
        return spareRoomItems;
    }
    
    /**
     * 得到某家酒店的某个房型的空房信息
     * @param address String型，酒店地址
     * @param roomType RoomType型，房间类型
     * @return
     * @throws NoThisRoomTypeSpareRoomException  当没有这种房型的空房时抛出异常
     * @throws RemoteException
     * @see
     */
    public SpareRoomItem getSprareRoomInfo(String address, Enum<RoomType> roomType) throws NoThisRoomTypeSpareRoomException, RemoteException{
        SpareRoomItem spareRoomItem;
        RoomPO roomPO;
        Date today=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
        try {
            today=sdf.parse(sdf.format(today));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        roomPO=roomDAO.getSpareRoomInfo(address, roomType, today);
        if(roomPO==null)
            throw new NoThisRoomTypeSpareRoomException("Spare Room of this RoomType hasn't existed yet");
        spareRoomItem=new SpareRoomItem(roomPO);
        return spareRoomItem;
    }
}
