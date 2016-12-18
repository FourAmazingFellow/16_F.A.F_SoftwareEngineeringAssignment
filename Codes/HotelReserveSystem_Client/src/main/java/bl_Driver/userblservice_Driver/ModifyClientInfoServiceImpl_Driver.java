package bl_Driver.userblservice_Driver;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyClientInfoService;
import vo.ClientInfoVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ModifyClientInfoServiceImpl_Driver {
    public void drive(ModifyClientInfoService modifyClientInfoService) throws RemoteException{
        
        ClientInfoVO userVO = modifyClientInfoService.getClientInfo("原");
        System.out.println("The client's info are :"+userVO);
        boolean result = modifyClientInfoService.modifyClientInfo(userVO, "原");
        if(result)
           System.out.println("Modify Succeed!\n");
       else
           System.out.println("Modify Failed!\n");

    }
}