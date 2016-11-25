package vo;

import java.util.ArrayList;

import po.ClientInfoPO;
import po.CreditRecordPO;
import po.UserType;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientInfoVO extends UserVO{

    public int creditValue;
    public ArrayList<CreditRecordPO> creditRecord;

    public ClientInfoVO(String userID, String password, String telNum, Enum<UserType> userType, int creditValue,
            ArrayList<CreditRecordPO> creditRecord) {
        super(userID, password, telNum, userType);
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }

    public ClientInfoVO(ClientInfoPO clientInfo) {
        super(clientInfo);
        userID = clientInfo.getUserID();
        password = clientInfo.getPassword();
        telNum = clientInfo.getTelNum();
        creditValue = clientInfo.getCreditValue();
        creditRecord = clientInfo.getCreditRecord();
    }
    
}
