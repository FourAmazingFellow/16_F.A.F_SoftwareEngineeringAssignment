package bl_Driver.userblservice_Driver;

import java.util.Date;

import businesslogicservice.userblservice.SignVipService;
import po.UserType;
import vo.EnterpriseVipVO;
import vo.RegularVipVO;

public class SignVipServiceImpl_Driver {
    public void drive(SignVipService signVipService) {
        @SuppressWarnings("deprecation")
        RegularVipVO regularVipVO = new RegularVipVO("原", "qwe123", "12345678900", UserType.Client, 500, null,
                new Date(1997, 10, 10), 2);
        EnterpriseVipVO enterpriseVipVO = new EnterpriseVipVO("yuan", "yuan123", "12345678901", UserType.Client, 500,
                null, "rujia", "rujia123");
        boolean result2 = signVipService.signRegularVip(regularVipVO);
        if (result2)
            System.out.println("Sign Succeed!\n");
        else
            System.out.println("Sign Failed!\n");

        boolean result3 = signVipService.signEnterpriseVip(enterpriseVipVO);
        if (result3)
            System.out.println("Sign Succeed!\n");
        else
            System.out.println("Sign Failed!\n");

    }
}
