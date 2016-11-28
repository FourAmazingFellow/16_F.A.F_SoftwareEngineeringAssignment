package bl_Driver.userblservice_Driver;

import businesslogicservice.userblservice.ManageUserInfoService;
import po.UserType;
import vo.UserVO;
import vo.WebMarketStaffInfoVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ManageUserInfoServiceImpl_Driver {
    public void drive(ManageUserInfoService manageUserInfoService){
        UserVO userVO = manageUserInfoService.getUserInfo("原");
        
        System.out.println("The client's info are :"+userVO);
        boolean result1 = manageUserInfoService.modifyUserInfo(userVO, "原");
        if(result1)
           System.out.println("Modify Succeed!\n");
       else
           System.out.println("Modify Failed!\n");
        
        WebMarketStaffInfoVO newUserVO = new WebMarketStaffInfoVO("原", "qwe123", "12345678908",UserType.Client);
        boolean result2 = manageUserInfoService.add(newUserVO);
        if(result2)
            System.out.println("Add Succeed!\n");
        else
            System.out.println("Add Failed!\n");
    }
}
