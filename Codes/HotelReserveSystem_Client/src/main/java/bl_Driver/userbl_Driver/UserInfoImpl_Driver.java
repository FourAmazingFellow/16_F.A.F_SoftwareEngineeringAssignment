package bl_Driver.userbl_Driver;

import java.rmi.RemoteException;

import businesslogic.userbl.UserInfo;
import po.UserType;
import vo.HotelStaffInfoVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserInfoImpl_Driver {
    public void drive(UserInfo userService) throws RemoteException{
    
        HotelStaffInfoVO hotelStaffInfoVO = new HotelStaffInfoVO("原","qwe123","12345672222", UserType.HotelStaff, "江苏省南京市栖霞区仙林大道163号");
        boolean result = userService.insert(hotelStaffInfoVO);
        if(result)
           System.out.println("Add Succeed!\n");
       else
           System.out.println("Add Failed!\n");
        
    }   
}
