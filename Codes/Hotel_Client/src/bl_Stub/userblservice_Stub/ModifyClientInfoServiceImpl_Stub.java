package bl_Stub.userblservice_Stub;

import businesslogicservice.userblservice.ModifyClientInfoService;
import vo.UserType;
import vo.UserVO;

/**
 * 
 * @author 原
 * @version
 * @see
 */
public class ModifyClientInfoServiceImpl_Stub implements ModifyClientInfoService {

	 public long userID;
	 public String passpord;
	 public String telNum;
	 public Enum<UserType> UserType;
	 public int creditValue;
	 public String enterpriseName;
	
	 public ModifyClientInfoServiceImpl_Stub(long userID, String passpord, String telNum, UserType userType,
			int creditValue, String enterpriseName) {
		this.userID = userID;
		this.passpord = passpord;
		this.telNum = telNum;
		UserType = userType;
		this.creditValue = creditValue;
		this.enterpriseName = enterpriseName;
	}
	 
	@Override
	public UserVO getUserInfo(String userID, UserType userType) {
		return new UserVO(userID, passpord, telNum);
	}

	@Override
	public boolean modifyUserInfo(UserVO user) {
		return true;
	}

}
