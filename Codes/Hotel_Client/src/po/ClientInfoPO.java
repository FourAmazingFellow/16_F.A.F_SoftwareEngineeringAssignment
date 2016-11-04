package po;

import vo.ClientInfoVO;

/**
 * 客户信息的PO（继承于用户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 
 * @see
 */
public class ClientInfoPO extends UserPO{
 
 

    private int creditValue;
    private String[] creditRecord;

    public ClientInfoPO(String userID, String passpord, String telNum, UserType userType, int creditValue, String[] creditRecord) {
        super(userID, passpord, telNum, userType);
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }
    
    public ClientInfoPO(ClientInfoVO clientInfoVO){
        super(clientInfoVO);
        this.creditValue = clientInfoVO.creditValue;
        this.creditRecord = clientInfoVO.creditRecord;
    }
    
    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }
    public int getCreditValue() {
        return creditValue;
    }
    public String[] getCreditRecord() {
        return creditRecord;
    }
    public void setCreditRecord(String[] creditRecord) {
        this.creditRecord = creditRecord;
    }
}
