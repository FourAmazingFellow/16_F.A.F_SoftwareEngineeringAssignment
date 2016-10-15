package po;

/**
 * 
 * @author sparkler
 * @version 1.0
 */
public class UserPO {
    private long userID;
    private String passpord;
    private long telNum;
    private int creditValue;
    private String creditChangeRecord;
    private String enterpriseName;
    @SuppressWarnings("unused")
    private Enum<UserType> UserType;
    
    public void setUserID(long userID) {
        this.userID = userID;
    }
    public long getUserID() {
        return userID;
    }
    public void setPasspord(String passpord) {
        this.passpord = passpord;
    }
    public String getPasspord() {
        return passpord;
    }
    public void setTelNum(long telNum) {
        this.telNum = telNum;
    }
    public long getTelNum() {
        return telNum;
    }
    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }
    public int getCreditValue() {
        return creditValue;
    }
    public void setCreditChangeRecord(String creditChangeRecord) {
        this.creditChangeRecord = creditChangeRecord;
    }
    public String getCreditChangeRecord() {
        return creditChangeRecord;
    }
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    public String getEnterpriseName() {
        return enterpriseName;
    }
}
