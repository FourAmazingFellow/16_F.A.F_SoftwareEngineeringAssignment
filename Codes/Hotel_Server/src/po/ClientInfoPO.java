package po;

/**
 * 客户信息的PO（继承于用户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 
 * @see
 */
public class ClientInfoPO extends UserPO{
 
 
    private int creditValue;

    private String[] creditRecord;
 
    public ClientInfoPO(long userID, String passpord, long telNum, String creditChangeRecord,
            Enum<po.UserType> userType, int creditValue, String[] creditRecord) {
        super(userID, passpord, telNum, creditChangeRecord);
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
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
