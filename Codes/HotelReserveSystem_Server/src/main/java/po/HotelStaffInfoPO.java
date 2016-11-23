package po;
/**
 * 酒店工作人员信息的PO（继承于用户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 
 * @see
 */
public class HotelStaffInfoPO extends UserPO {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2080081292141695387L;
	
	    
    private String enterpriseName;
    
    public HotelStaffInfoPO(String userID, String passpord, long telNum, String creditChangeRecord,
            UserType userType, String enterpriseName) {
        super(userID, passpord, telNum, userType);
        this.enterpriseName = enterpriseName;
    }
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    public String getEnterpriseName() {
        return enterpriseName;
    }
}
