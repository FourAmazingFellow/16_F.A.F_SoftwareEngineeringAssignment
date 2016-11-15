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

    public ClientInfoVO(String userID, String passpord, String telNum, Enum<UserType> userType, int creditValue,
            String[] creditRecord) {
        super(userID, passpord, telNum, userType);
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }

    public ClientInfoVO(ClientInfoPO clientInfo) {
        super(clientInfo);
        userID = clientInfo.getUserID();
        passpord = clientInfo.getPasspord();
        telNum = clientInfo.getTelNum();
        creditValue = clientInfo.getCreditValue();
        creditRecord = clientInfo.getCreditRecord();
    }
    
}
