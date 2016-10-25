package bl_Driver.userblservice_Driver;

import businesslogicservice.userblservice.UserService;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class UserServiceImpl_Driver {
    public void drive(UserService userService){
        boolean result1 = userService.login("原", "qwe123");
        if(result1)
           System.out.println("Login Succeed!\n");
       else
           System.out.println("Login Failed!\n");
        
        UserVO userVO = new UserVO("原","qwe123","12345675555");
 
        boolean result4 = userService.add(userVO);
        if(result4)
           System.out.println("Add Succeed!\n");
       else
           System.out.println("Add Failed!\n");
        
        boolean result5 = userService.del(userVO);
        if(result5)
           System.out.println("Delete Succeed!\n");
       else
           System.out.println("Delete Failed!\n");
    }   
}
