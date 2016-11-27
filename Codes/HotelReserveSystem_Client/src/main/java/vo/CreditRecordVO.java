package vo;

import java.util.ArrayList;

import po.ClientInfoPO;
import po.CreditRecordPO;

public class CreditRecordVO {
    public String userID;
    public ArrayList<CreditRecordPO> creditRecord;
    
    public CreditRecordVO(String userID, ArrayList<CreditRecordPO> creditRecord) {
        super();
        this.userID = userID;
        this.creditRecord = creditRecord;
    }
    
    public CreditRecordVO(ClientInfoPO clientInfoPO){
        userID = clientInfoPO.getUserID();
        creditRecord = clientInfoPO.getCreditRecord();
    }
}
