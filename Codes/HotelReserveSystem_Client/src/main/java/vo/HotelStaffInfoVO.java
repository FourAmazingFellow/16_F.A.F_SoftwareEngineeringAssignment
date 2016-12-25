package vo;

import po.HotelStaffInfoPO;
import po.UserType;

/**
 * 酒店国内工作人员信息的值对象
 * @author sparkler
 * @version
 * @see
 */
public class HotelStaffInfoVO extends UserVO {
    public String hotelAddress;

    public HotelStaffInfoVO(String userID, String password, String telNum, UserType userType, String enterpriseName) {
        super(userID, password, telNum, userType);
        this.hotelAddress = enterpriseName;
    }

    /**
     * @param hotelStaffInfo
     */
    public HotelStaffInfoVO(HotelStaffInfoPO hotelStaffInfo) {
        super(hotelStaffInfo);
        this.hotelAddress = hotelStaffInfo.getHotelAddress();
    }

}
