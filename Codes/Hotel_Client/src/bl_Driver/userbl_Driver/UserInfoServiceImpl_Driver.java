package bl_Driver.userbl_Driver;

import businesslogic.userbl.UserInfoService;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserInfoServiceImpl_Driver {
    public void drive(UserInfoService userInfoService){
        UserVO userVO1 = userInfoService.getRegularVipInfo(1111);
        System.out.println("The regular VIP's credit information are: "+userVO1);
        
        UserVO userVO2 = userInfoService.getEnterpriseVipInfo(2211);
        System.out.println("The regular VIP's credit information are: "+userVO2);
    }
}
