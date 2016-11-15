package bl_Driver.userblservice_Driver;

import businesslogicservice.userblservice.SignVipService;
import po.UserType;
import vo.VipInfoVO;

public class SignVipServiceImpl_Driver {
    public void drive(SignVipService signVipService){
       VipInfoVO VipInfoVO = new VipInfoVO("原", "qwe123", "12327777345", UserType.Client, "hotel123", "12341234");
        
        boolean result2 = signVipService.signRegularVip(VipInfoVO);
        if(result2)
           System.out.println("Sign Succeed!\n");
       else
           System.out.println("Sign Failed!\n");
        
        boolean result3 = signVipService.signEnterpriseVip(VipInfoVO);
        if(result3)
           System.out.println("Sign Succeed!\n");
       else
           System.out.println("Sign Failed!\n");
        
    }
}
