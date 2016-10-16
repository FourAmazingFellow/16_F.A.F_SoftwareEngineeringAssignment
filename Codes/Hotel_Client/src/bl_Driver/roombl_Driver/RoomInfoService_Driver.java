package bl_Driver.roombl_Driver;

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
    public void drive(RoomInfoService roomInfoService){
        RoomType roomType=RoomType.SINGLE_ROOM;
        int roomNum=roomInfoService.getAvailableRoomNum("江苏省南京市栖霞区仙林大道163号", roomType);
        System.out.println(roomType+" has "+roomNum+" spare rooms");
        
        Date beginDate=new Date(System.currentTimeMillis());
        Date finishDate=new Date(System.currentTimeMillis()+1);
        boolean isTimeAvailble=roomInfoService.isTimeAvailable("江苏省南京市栖霞区仙林大道163号", roomType, beginDate, finishDate);
        if(isTimeAvailble)
            System.out.println("This roomType has spare room now!\n");
        else
            System.out.println("This roomType doesn't have spare room now!\n");
        
        RoomVO roomvo=new RoomVO(RoomType.SINGLE_ROOM, 3, "江苏省南京市栖霞区仙林大道163号");
        boolean updateSpareRoom=roomInfoService.updateSpareRoom("江苏省南京市栖霞区仙林大道163号", roomvo);
        if(updateSpareRoom)
            System.out.println("Spare Room has been updated!\n");
        else
            System.out.println("Spare Room has not been updated!\n");
        
        boolean reduceSpareRoom=roomInfoService.reduceRoom("江苏省南京市栖霞区仙林大道163号", 3, RoomType.SINGLE_ROOM);
        if(reduceSpareRoom)
            System.out.println("Spare Room has been reduced!\n");
        else
            System.out.println("Spare Room has not been reduced!\n");
        
        boolean addSpareRoom=roomInfoService.addRoom("江苏省南京市栖霞区仙林大道163号", 3, RoomType.SINGLE_ROOM);
        if(addSpareRoom)
            System.out.println("Spare Room has been added!\n");
        else
            System.out.println("Spare Room has not been added!\n");
    }
}
