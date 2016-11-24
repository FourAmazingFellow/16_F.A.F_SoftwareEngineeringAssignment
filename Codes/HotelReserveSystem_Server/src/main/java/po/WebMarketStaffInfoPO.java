package po;
/**
 * 网站营销信息的PO（继承于用户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 
 * @see
 */
public class WebMarketStaffInfoPO extends UserPO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3756890541606953956L;
	
    public WebMarketStaffInfoPO(String userID, String password, String telNum, String creditChangeRecord,
            UserType userType) {
        super(userID, password, telNum, userType);
    }

}
