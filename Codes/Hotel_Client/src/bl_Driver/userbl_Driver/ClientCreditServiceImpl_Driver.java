package bl_Driver.userbl_Driver;

import businesslogic.userbl.ClientCreditService;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientCreditServiceImpl_Driver {
    public void drive(ClientCreditService clientCreditService){
        int creditValue = clientCreditService.getCreditValue("原");
        System.out.println("The client's credit value is: "+creditValue);
    
         boolean result = clientCreditService.changeCreditValue("原", 100);
         if(result)
            System.out.println("Change Succeed!\n");
        else
            System.out.println("Change Failed!\n");
    }
}
