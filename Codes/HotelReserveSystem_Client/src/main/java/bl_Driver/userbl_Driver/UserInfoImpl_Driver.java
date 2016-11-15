package bl_Driver.userbl_Driver;

import businesslogic.userbl.UserInfo;
import po.UserType;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserInfoImpl_Driver {
    public void drive(UserInfo userService){
    
        UserVO userVO = new UserVO("原","qwe123","12345672222", UserType.Client);
        boolean result = userService.insert(userVO);
        if(result)
           System.out.println("Add Succeed!\n");
       else
           System.out.println("Add Failed!\n");
        
    }   
}
