package bl_Driver.userbl_Driver;

import java.rmi.RemoteException;

import businesslogic.userbl.VipInfo;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class VipInfoImpl_Driver {
    public void drive(VipInfo userInfoService) throws RemoteException{
        UserVO userVO1 = userInfoService.getRegularVipInfo("原");
        System.out.println("The regular VIP's credit information are: "+userVO1);
        
        UserVO userVO2 = userInfoService.getEnterpriseVipInfo("原");
        System.out.println("The regular VIP's credit information are: "+userVO2);
    }
}
