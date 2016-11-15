package bl_Driver.roomblservice_Driver;

import java.util.ArrayList;

import businesslogicservice.roomblservice.BrowseSpareRoomService;
import vo.RoomVO;

/**
 * 
 * @author 双
 * @version 
 * @see
 */
public class BrowseSpareRoomService_Driver {
    public void drive(BrowseSpareRoomService browseSpareRoomService){
        ArrayList<RoomVO> spareRoomList=browseSpareRoomService.getRoomInfoList("江苏省南京市栖霞区仙林大道163号");
        if(spareRoomList.isEmpty())
            System.out.println("No spareRoom!\n");
        else
            System.out.println("There are " + spareRoomList.size() + " kinds of spareRoom!\n");
    }
}
