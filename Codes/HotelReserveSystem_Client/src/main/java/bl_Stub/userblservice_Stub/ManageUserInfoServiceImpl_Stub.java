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
public class ManageUserInfoServiceImpl_Stub extends ModifyClientInfoServiceImpl_Stub implements ManageUserInfoService{

	public ManageUserInfoServiceImpl_Stub(String userID, String password, String telNum, UserType userType,
			int creditValue, String enterpriseName) {
		super(userID, password, telNum, userType, creditValue, null);
	}

    @Override
    public boolean add(UserVO user) {
        return false;
    }

    @Override
    public HotelStaffInfoVO getHotelStaffInfo(String userID) {
        return null;
    }

    @Override
    public UserVO getUserInfo(String userID) {
        return null;
    }

    @Override
    public boolean modifyUserInfo(UserVO userVO, String userID) {
        return false;
    }

	
	
}
