package businesslogic.roombl.updateCheckOut;

import java.rmi.RemoteException;

import vo.HotelVO;

/**
 * 为了解除与hotelbl的循环依赖建立的接口
 * @author 双
 * @version 
 * @see
 */
public interface AvailableRoomService {
    
    /**
     * 得到某酒店的详细信息
     * @param address String型，酒店地址
     * @return
     * @throws RemoteException
     * @see
     */
    public HotelVO getHotelDetails(String address) throws RemoteException;

}
