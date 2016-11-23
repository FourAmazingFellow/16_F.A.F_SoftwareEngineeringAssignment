package vo;

import po.ClientInfoPO;
import po.UserType;

/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class ClientInfoVO extends UserVO{

    public int creditValue;
    public String[] creditRecord;

    public ClientInfoVO(String userID, String password, String telNum, Enum<UserType> userType, int creditValue,
            String[] creditRecord) {
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
