package factory;

import businesslogicservice.roomblservice.BrowseSpareRoomService;
import businesslogicservice.roomblservice.UpdateCheckInService;
import businesslogicservice.roomblservice.UpdateCheckOutService;

public interface RoomUIFactoryService {
    
    public BrowseSpareRoomService createBrowseSpareRoomService();
    
    public UpdateCheckInService createUpdateCheckInService();
    
    public UpdateCheckOutService createUpdateCheckOutService();

}
