package bl_Driver.userblservice_Driver;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.LoginAndSignUpService;
import po.UserType;
import vo.UserVO;

public class LoginAndSignUpServiceImpl_Driver {
    public void drive(LoginAndSignUpService loginAndSignUpService) throws RemoteException{
        boolean result1 = loginAndSignUpService.login("原", "qwe123");
        if(result1)
           System.out.println("Login Succeed!\n");
       else
           System.out.println("Login Failed!\n");
        
        UserVO userVO = new UserVO("原","qwe123","12345675555", UserType.Client);
 
        boolean result4 = loginAndSignUpService.add(userVO);
        if(result4)
           System.out.println("Sign up Succeed!\n");
       else
           System.out.println("Sign up Failed!\n");
        
    }
}
