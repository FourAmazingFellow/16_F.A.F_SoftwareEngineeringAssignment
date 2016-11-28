package businesslogic.userbl.modifyClientInfo;

import java.rmi.RemoteException;

import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import po.UserType;
import vo.ClientInfoVO;
import vo.UserVO;

public class MockModifyClientInfoServiceImpl extends ModifyClientInfoServiceImpl{

    private UserDAO userDAO;
    private ClientInfoVO clientInfoVO;
    
    public MockModifyClientInfoServiceImpl(String userID) {
        super(userID);
        userDAO = new UserDAOImpl_Stub("原", "qwe123", "12345678900");
        clientInfoVO = new ClientInfoVO("原", "qwe123", "12345678900", UserType.Client, 500, null);
    }

    @Override
    public ClientInfoVO getClientInfo(String userID) {
        return clientInfoVO;
    }

    @Override
    public boolean modifyClientInfo(UserVO user,String oldUserID) {
        try {
            userDAO.updateUser(new UserPO(user), "原");
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
