package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.QueryClientCreditRecordService;
import vo.ClientInfoVO;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientCreditServiceImpl_Stub implements QueryClientCreditRecordService {


    public long userID;
    public String passpord;
    public String telNum;
    public int creditValue;
    public String[] creditRecord;
    
    public ClientCreditServiceImpl_Stub(long userID, String passpord, String telNum, int creditValue,
            String[] creditRecord) {
        super();
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

    @Override
    public boolean addCreditValue(String userID, int creditAdded) {
        return false;
    }
    


 
}
