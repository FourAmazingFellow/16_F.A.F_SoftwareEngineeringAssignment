package po;

/**
 * 客户信息的PO（继承于用户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 
 * @see
 */
public class ClientInfoPO extends UserPO{
 
    private int creditValue;
    
    public ClientInfoPO(long userID, String passpord, long telNum, String creditChangeRecord,
            Enum<po.UserType> userType, int creditValue) {
        super(userID, passpord, telNum, creditChangeRecord, userType);
        this.creditValue = creditValue;
    }
    
    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }
    public int getCreditValue() {
        return creditValue;
    }
}
