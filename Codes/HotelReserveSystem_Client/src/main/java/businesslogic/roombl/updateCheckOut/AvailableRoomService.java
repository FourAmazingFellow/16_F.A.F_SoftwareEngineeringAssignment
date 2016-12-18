package businesslogic.roombl.updateCheckOut;

import java.rmi.RemoteException;

import vo.HotelVO;

public interface AvailableRoomService {
    
    public HotelVO getHotelDetails(String address) throws RemoteException;

}
