package bl_Stub.userbl_Stub;

import businesslogic.userbl.ClientCreditService;

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
    public int getCreditValue(long ID) {
        return 0;
    }

    @Override
    public boolean changeCreditValue(long ID, int num) {
        return false;
    }
    
}
