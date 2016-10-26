package bl_Driver.userblservice_Driver;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientCreditServiceImpl_Driver {
    public void drive(QueryClientCreditRecordService clientCreditService){
        UserVO userVO = clientCreditService.queryCredit("原");
        System.out.println("The client's credit value and records are: "+userVO);
    
         boolean result = clientCreditService.addCreditValue("原", 100);
         if(result)
            System.out.println("Add Succeed!\n");
        else
            System.out.println("Add Failed!\n");
    }
}
