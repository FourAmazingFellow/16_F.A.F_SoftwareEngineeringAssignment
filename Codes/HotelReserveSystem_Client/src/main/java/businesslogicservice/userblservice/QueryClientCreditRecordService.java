package businesslogicservice.userblservice;

import vo.CreditRecordVO;

/**
 * 
 * @author sparkler
 * @version 1.0
 * @see
 */
public interface QueryClientCreditRecordService {

    /**
     * 查询信用记录
     * @param ID long型，界面传递过来的用户标识
     * @return 返回用户的信用记录
     * @see
     */
    public CreditRecordVO queryCreditRecord(String userID);
    
}