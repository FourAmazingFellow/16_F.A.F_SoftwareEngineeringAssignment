package po;
/**
 * 网站营销信息的PO（继承于用户信息PO），负责持久化数据传输
 * @author sparkler
 * @version 
 * @see
 */
public class WebMarketStaffInfoPO extends UserPO{

    public WebMarketStaffInfoPO(String userID, String passpord, long telNum, String creditChangeRecord,
            UserType userType) {
        super(userID, passpord, telNum, userType);
    }

}
