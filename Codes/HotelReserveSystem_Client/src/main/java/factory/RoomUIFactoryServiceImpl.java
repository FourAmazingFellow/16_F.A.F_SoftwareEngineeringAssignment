package factory;

import businesslogic.roombl.browseSpareRoom.BrowseSpareRoomServiceImpl;
import businesslogic.roombl.updateCheckIn.UpdateCheckInServiceImpl;
import businesslogic.roombl.updateCheckOut.UpdateCheckOutServiceImpl;
import businesslogicservice.roomblservice.BrowseSpareRoomService;
import businesslogicservice.roomblservice.UpdateCheckInService;
import businesslogicservice.roomblservice.UpdateCheckOutService;

public class RoomUIFactoryServiceImpl implements RoomUIFactoryService{

    @Override
    public BrowseSpareRoomService createBrowseSpareRoomService() {
        return new BrowseSpareRoomServiceImpl();
    }

    @Override
    public UpdateCheckInService createUpdateCheckInService() {
        return new UpdateCheckInServiceImpl();
    }

    @Override
    public UpdateCheckOutService createUpdateCheckOutService() {
        return new UpdateCheckOutServiceImpl();
    }

}
