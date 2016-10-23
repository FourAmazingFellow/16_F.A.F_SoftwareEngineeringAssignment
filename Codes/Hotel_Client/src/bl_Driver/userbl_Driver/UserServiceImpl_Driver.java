package bl_Driver.userbl_Driver;

import businesslogic.userbl.UserService;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserServiceImpl_Driver {
    public void drive(UserService userService){
    
        UserVO userVO = new UserVO("原","qwe123",1234567);
        boolean result = userService.insert(userVO);
        if(result)
           System.out.println("Add Succeed!\n");
       else
           System.out.println("Add Failed!\n");
        
    }   
}
