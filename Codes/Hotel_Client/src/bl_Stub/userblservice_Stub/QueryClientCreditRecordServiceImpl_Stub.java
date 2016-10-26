package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import vo.ClientInfoVO;
import vo.UserVO;

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
	public UserVO queryCredit(String userID) {
		return new ClientInfoVO(userID, passpord, telNum, creditRecord, creditValue);
	}

}
