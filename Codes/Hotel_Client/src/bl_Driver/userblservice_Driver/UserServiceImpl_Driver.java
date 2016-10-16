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
        boolean result1 = userService.login(1111, "qwe123");
        if(result1)
           System.out.println("Login Succeed!\n");
       else
           System.out.println("Login Failed!\n");
        
        UserVO userVO = new UserVO(1111,"qwe123",1234567);
        boolean result2 = userService.signRegularVip(userVO);
        if(result2)
           System.out.println("Sign Succeed!\n");
       else
           System.out.println("Sign Failed!\n");
        
        boolean result3 = userService.signEnterpriseVip(userVO);
        if(result3)
           System.out.println("Sign Succeed!\n");
       else
           System.out.println("Sign Failed!\n");
        
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
