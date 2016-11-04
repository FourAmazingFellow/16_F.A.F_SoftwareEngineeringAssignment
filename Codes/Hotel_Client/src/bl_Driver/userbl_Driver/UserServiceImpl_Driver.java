package bl_Driver.userbl_Driver;

import businesslogic.userbl.UserInfo;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserServiceImpl_Driver {
    public void drive(UserInfo userService){
    
        UserVO userVO = new UserVO("原","qwe123","12345672222");
        boolean result = userService.insert(userVO);
        if(result)
           System.out.println("Add Succeed!\n");
       else
           System.out.println("Add Failed!\n");
        
    }   
}
