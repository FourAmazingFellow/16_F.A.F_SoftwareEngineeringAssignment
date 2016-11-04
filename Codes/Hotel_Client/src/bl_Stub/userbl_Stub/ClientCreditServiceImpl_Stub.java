package bl_Stub.userbl_Stub;

import businesslogic.userbl.ClientCreditInfo;
import vo.ClientCreditRecordVO;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientCreditServiceImpl_Stub implements ClientCreditInfo {

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
    public int getCreditValue(String userID) {
        return 0;
    }

    @Override
    public boolean changeCreditValue(String userID, int num) {
        return false;
    }

    @Override
    public ClientCreditRecordVO getClientCreditInfo(String userID) {
        return null;
    }
    
}
