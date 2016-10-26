package bl_Driver.userblservice_Driver;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class QueryClientCreditRecordServiceImpl_Driver {
    public void drive(QueryClientCreditRecordService queryClientCreditService){
        UserVO userVO = queryClientCreditService.queryCredit("原");
        System.out.println("The client's credit value and records are: "+userVO);
    }
}
