package bl_Driver.userbl_Driver;

import java.rmi.RemoteException;

import businesslogic.userbl.ClientCreditInfo;
import po.ActionType;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientCreditInfoImpl_Driver {
    public void drive(ClientCreditInfo clientCreditService) throws RemoteException{
        int creditValue = clientCreditService.getCreditValue("原");
        System.out.println("The client's credit value is: "+creditValue);
    
         boolean result = clientCreditService.changeCreditValue("原", 100, "2016111100001111", ActionType.ORDER_DONE);
         if(result)
            System.out.println("Change Succeed!\n");
        else
            System.out.println("Change Failed!\n");
    }
}
