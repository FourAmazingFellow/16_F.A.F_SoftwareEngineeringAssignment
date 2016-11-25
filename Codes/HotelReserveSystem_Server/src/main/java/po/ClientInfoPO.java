package po;

import java.util.ArrayList;

/**
 * 客户信息的PO（继承于用户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 
 * @see
 */
public class ClientInfoPO extends UserPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7813562391061517043L;
	
	
 
    public ClientInfoPO(String userID, String password, String telNum, UserType userType, int creditValue, ArrayList<CreditRecordPO> creditRecord) {
        super(userID, password, telNum, userType);
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }
    private int creditValue;
    private ArrayList<CreditRecordPO> creditRecord;

   
    
    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }
    public int getCreditValue() {
        return creditValue;
    }
    public ArrayList<CreditRecordPO> getCreditRecord() {
        return creditRecord;
    }
    public void setCreditRecord(ArrayList<CreditRecordPO> creditRecord) {
        this.creditRecord = creditRecord;
    }
}
