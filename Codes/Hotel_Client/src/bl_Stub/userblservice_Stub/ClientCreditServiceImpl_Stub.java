package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.ClientCreditService;
import vo.ClientInfoVO;
import vo.UserVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientCreditServiceImpl_Stub implements ClientCreditService {
    public long userID;
    public String passpord;
    public int creditValue;
    public String[] creditRecord;
    
    public ClientCreditServiceImpl_Stub(long userID, String passpord, int creditValue, String[] creditRecord) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }
    
    @Override
    public UserVO queryCredit(String userID) {
        return new ClientInfoVO(userID, passpord, 0, creditRecord, creditValue);
    }

    @Override
    public boolean addCreditValue(String userID, int creditAdded) {
        return false;
    }
 
}
