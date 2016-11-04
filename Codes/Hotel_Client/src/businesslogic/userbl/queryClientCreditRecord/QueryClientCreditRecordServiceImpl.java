package businesslogic.userbl.queryClientCreditRecord;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import vo.ClientCreditRecordVO;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public class QueryClientCreditRecordServiceImpl implements QueryClientCreditRecordService {

    private ClientCreditRecordVO ccrVO;

    @Override
    public ClientCreditRecordVO queryCreditRecord(String userID) {
        return ccrVO;
    }


    
}