package bl_Driver.userblservice_Driver;

import businesslogicservice.userblservice.ManageUserInfoService;
import vo.UserType;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ModifyClientInfoServiceImpl_Driver {
    public void drive(ManageUserInfoService manageUserInfoService){
        
        UserVO userVO = manageUserInfoService.getUserInfo("原", UserType.Client);
        System.out.println("The client's info are :"+userVO);
        boolean result = manageUserInfoService.modifyUserInfo(userVO);
        if(result)
           System.out.println("Modify Succeed!\n");
       else
           System.out.println("Modify Failed!\n");

    }
}