package bl_Stub.userbl_Stub;

import businesslogic.userbl.ClientCreditInfo;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientCreditInfoImpl_Stub implements ClientCreditInfo {

    public String userID;
    public String password;
    public int creditValue;
    public String[] creditRecord;
    
    public ClientCreditInfoImpl_Stub(String userID, String password, int creditValue, String[] creditRecord) {
        super();
        this.userID = userID;
        this.password = password;
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
    
}
