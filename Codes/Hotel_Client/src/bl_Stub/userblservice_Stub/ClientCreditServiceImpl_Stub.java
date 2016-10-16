package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.ClientCreditService;
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
    public UserVO queryCredit(long ID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addCreditValue(long ID, int creditAdded) {
        // TODO Auto-generated method stub
        return false;
    }

}
