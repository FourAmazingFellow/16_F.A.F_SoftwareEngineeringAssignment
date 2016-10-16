package vo;
/**
 * 
 * @author sparkler
 * @version 
 * @see
 */
public class HotelStaffInfoVO extends UserVO{
    private String enterpriseName;
    
    public HotelStaffInfoVO(long userID, String passpord, long telNum,
            Enum<vo.UserType> userType, String enterpriseName) {
        super(userID, passpord, telNum);
        this.UserType = userType;
        this.enterpriseName = enterpriseName;
    }
    
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    public String getEnterpriseName() {
        return enterpriseName;
    }
}
