package vo;

import java.util.ArrayList;

import po.ClientInfoPO;
import po.CreditRecordPO;

public class ClientCreditRecordVO {
    public String userID;
    public ArrayList<CreditRecordPO> creditRecord;
    
    public ClientCreditRecordVO(String userID, ArrayList<CreditRecordPO> creditRecord) {
        super();
        this.userID = userID;
        this.creditRecord = creditRecord;
    }
    
    public ClientCreditRecordVO(ClientInfoPO clientInfoPO){
        userID = clientInfoPO.getUserID();
        creditRecord = clientInfoPO.getCreditRecord();
    }
}
