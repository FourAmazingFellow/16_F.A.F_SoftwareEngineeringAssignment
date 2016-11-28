package po;

import vo.HotelStaffInfoVO;

/**
 * 酒店工作人员信息的PO（继承于用户信息PO），负责持久化数据传输
 * 
 * @author sparkler
 * @version
 * @see
 */
public class HotelStaffInfoPO extends UserPO {

    /**
     * 
     */
    private static final long serialVersionUID = -2080081292141695387L;

    private String hotelAddress;

    public HotelStaffInfoPO(String userID, String password, String telNum, UserType userType, String hotelAddress) {
        super(userID, password, telNum, userType);
        this.hotelAddress = hotelAddress;
    }

    /**
     * @param hotelStaffInfoVO
     */
    public HotelStaffInfoPO(HotelStaffInfoVO hotelStaffInfoVO) {
        super(hotelStaffInfoVO);
        this.hotelAddress = hotelStaffInfoVO.hotelAddress;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.hotelAddress = enterpriseName;
    }

    public String getEnterpriseName() {
        return hotelAddress;
    }
}
