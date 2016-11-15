package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import vo.ClientCreditRecordVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class QueryClientCreditRecordServiceImpl_Stub implements QueryClientCreditRecordService {

	public long userID;
	public String passpord;
    public String telNum;
    public int creditValue;
    public String[] creditRecord;
	
    public QueryClientCreditRecordServiceImpl_Stub(long userID, String passpord, String telNum, int creditValue,
			String[] creditRecord) {
		this.userID = userID;
		this.passpord = passpord;
		this.telNum = telNum;
		this.creditValue = creditValue;
		this.creditRecord = creditRecord;
	}
    
	@Override
	public ClientCreditRecordVO queryCreditRecord(String userID) {
		return new ClientCreditRecordVO(userID, creditRecord);
	}

}