package vo;

import po.ClientInfoPO;

public class ClientCreditRecordVO {
    public String userID;
    public String[] creditRecord;
    
    public ClientCreditRecordVO(String userID, String[] creditRecord) {
        super();
        this.userID = userID;
        this.creditRecord = creditRecord;
    }
    
    public ClientCreditRecordVO(ClientInfoPO po){
        userID = po.getUserID();
        creditRecord = po.getCreditRecord();
    }
}
