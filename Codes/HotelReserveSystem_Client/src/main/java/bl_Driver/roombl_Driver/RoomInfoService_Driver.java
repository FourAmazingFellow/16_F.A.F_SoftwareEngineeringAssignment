package bl_Driver.roombl_Driver;

import java.rmi.RemoteException;
import java.sql.Date;

import businesslogic.roombl.RoomInfoService;
import po.RoomType;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class RoomInfoService_Driver {
    @SuppressWarnings("deprecation")
    public void drive(RoomInfoService roomInfoService){
        RoomType roomType=RoomType.SINGLE_ROOM;
        int roomNum = 0;
        try {
            roomNum = roomInfoService.getAvailableRoomNum("江苏省南京市栖霞区仙林大道163号", roomType,new Date(116,10,27));
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(roomType+" has "+roomNum+" spare rooms");
        
        Date beginDate=new Date(System.currentTimeMillis());
        boolean isTimeAvailble = false;
        try {
            isTimeAvailble = roomInfoService.isTimeAvailable("江苏省南京市栖霞区仙林大道163号", roomType, beginDate, 0000000000000003);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        if(isTimeAvailble)
            System.out.println("This roomType has spare room now!\n");
        else
            System.out.println("This roomType doesn't have spare room now!\n");
        
        RoomVO roomvo=new RoomVO(RoomType.SINGLE_ROOM, 0000000000000003, "江苏省南京市栖霞区仙林大道163号");
        boolean updateSpareRoom = false;
        try {
            updateSpareRoom = roomInfoService.updateSpareRoom("江苏省南京市栖霞区仙林大道163号", roomvo);
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        if(updateSpareRoom)
            System.out.println("Spare Room has been updated!\n");
        else
            System.out.println("Spare Room has not been updated!\n");
        
        boolean reduceSpareRoom = false;
        try {
            reduceSpareRoom = roomInfoService.reduceRoom("江苏省南京市栖霞区仙林大道163号", 0000000000000003, RoomType.SINGLE_ROOM,new Date(116,10,27));
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        if(reduceSpareRoom)
            System.out.println("Spare Room has been reduced!\n");
        else
            System.out.println("Spare Room has not been reduced!\n");
        
        boolean addSpareRoom = false;
        try {
            addSpareRoom = roomInfoService.addRoom("江苏省南京市栖霞区仙林大道163号", 0000000000000003, RoomType.SINGLE_ROOM,new Date(116,10,27));
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        if(addSpareRoom)
            System.out.println("Spare Room has been added!\n");
        else
            System.out.println("Spare Room has not been added!\n");
    }
}
