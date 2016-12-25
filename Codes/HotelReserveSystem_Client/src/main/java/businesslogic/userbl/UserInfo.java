package businesslogic.userbl;

import java.rmi.RemoteException;

import vo.HotelStaffInfoVO;

/**
 * 供同层间调用的关于用户的接口
 * @author sparkler
 * @version 
 * @see
 */
public interface UserInfo {

    /**
     * 酒店管理人员添加酒店工作人员
     * @param hotelStaffInfoVO HotelStaffInfoVO型，业务逻辑层传递过来的酒店工作人员信息
     * @return 添加成功则返回true，添加失败则返回false
     * @throws RemoteException 
     * @see
     */
    public boolean insert(HotelStaffInfoVO hotelStaffInfoVO) throws RemoteException;
 


}
