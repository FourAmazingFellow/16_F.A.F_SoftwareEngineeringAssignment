package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.ManageUserInfoService;
import po.UserType;
import vo.HotelStaffInfoVO;
import vo.UserVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class ManageUserInfoServiceImpl_Stub implements ManageUserInfoService{

	 public String userID;
	 public String password;
	 public String telNum;
	 public UserType userType;
	 public String address;
	
	 

    public ManageUserInfoServiceImpl_Stub(String userID, String password, String telNum, po.UserType userType,
			String address) {
		super();
		this.userID = userID;
		this.password = password;
		this.telNum = telNum;
		this.userType = userType;
		this.address = address;
	}

	@Override
    public boolean add(UserVO user) {
        return true;
    }

    @Override
    public HotelStaffInfoVO getHotelStaffInfo(String userID) {
        return new HotelStaffInfoVO(userID, password, telNum, userType, address);
    }

    @Override
    public UserVO getUserInfo(String userID) {
        return new UserVO(userID, password, telNum, userType);
    }

    @Override
    public boolean modifyUserInfo(UserVO userVO, String userID) {
        return true;
    }

	
	
}
