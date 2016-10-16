package bl_Stub.userblservice_Stub;


import businesslogicservice.userblservice.UserInfoService;
import po.UserType;
import vo.UserVO;

public class UserInfoServiceImpl_Stub implements UserInfoService {

    @Override
    public UserVO getUserInfo(long ID, Enum<UserType> UserType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean modifyUserInfo(UserVO user) {
        // TODO Auto-generated method stub
        return false;
    }

}
