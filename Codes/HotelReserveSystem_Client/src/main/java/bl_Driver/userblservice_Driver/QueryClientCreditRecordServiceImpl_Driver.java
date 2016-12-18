package bl_Driver.userblservice_Driver;

import java.util.ArrayList;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import po.CreditRecordPO;
import vo.CreditRecordVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class QueryClientCreditRecordServiceImpl_Driver {
    public void drive(QueryClientCreditRecordService queryClientCreditService){
        ArrayList<CreditRecordVO> userVO = queryClientCreditService.queryCreditRecord("原");
        System.out.println("The client's credit value and records are: "+userVO);
    }
}
