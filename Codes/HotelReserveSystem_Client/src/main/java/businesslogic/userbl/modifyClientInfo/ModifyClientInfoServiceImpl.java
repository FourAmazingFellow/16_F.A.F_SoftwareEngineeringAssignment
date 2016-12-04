package businesslogic.userbl.modifyClientInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyClientInfoService;
import dataservice.userDAO.UserDAO;
import po.UserPO;
import rmi.RemoteHelper;
import vo.ClientInfoVO;
import vo.UserVO;

public class ModifyClientInfoServiceImpl implements ModifyClientInfoService{

    private UserDAO userDAO;
    private String userID;
    private ClientInfoVO ClientInfoVO;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    public ModifyClientInfoServiceImpl(String userID) {
    }
    
    @Override
    public ClientInfoVO getClientInfo(String userID) {
        this.userDAO =RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        try {
            this.ClientInfoVO = new ClientInfoVO(userDAO.getClientInfo(this.userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return ClientInfoVO;
    }

    @Override
    public boolean modifyClientInfo(UserVO user, String oldUserID) {
        this.userDAO =RemoteHelper.getInstance().getUserDAO();
        try {
            userDAO.updateUser(new UserPO(user), oldUserID);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}
