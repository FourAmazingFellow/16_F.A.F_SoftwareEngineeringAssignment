package bl_Stub.userblservice_Stub;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import po.ActionType;
import vo.CreditRecordVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class QueryClientCreditRecordServiceImpl_Stub implements QueryClientCreditRecordService {

	public String userID;
	public String password;
	public String telNum;
	public int creditValue;
	public ArrayList<CreditRecordVO> creditRecord;

	public QueryClientCreditRecordServiceImpl_Stub(String userID, String password, String telNum, int creditValue,
			ArrayList<CreditRecordVO> creditRecord) {
		this.userID = userID;
		this.password = password;
		this.telNum = telNum;
		this.creditValue = creditValue;
		this.creditRecord = creditRecord;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ArrayList<CreditRecordVO> queryCreditRecord(String userID) {
		this.creditRecord.add(new CreditRecordVO(new Date(2016 - 1900, 11 - 1, 11), "2016111100001111",
				ActionType.ORDER_DONE, 300, 1800));
		return creditRecord;
	}

}
