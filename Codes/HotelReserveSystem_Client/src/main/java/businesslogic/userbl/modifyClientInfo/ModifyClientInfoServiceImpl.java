package businesslogic.userbl.modifyClientInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyClientInfoService;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;
import rmi.RemoteHelper;
import vo.ClientInfoVO;
import vo.UserVO;

public class ModifyClientInfoServiceImpl implements ModifyClientInfoService{

    private UserDAO userDAO;
    private String userID;
    private ClientInfoVO clientInfoVO;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    public ModifyClientInfoServiceImpl() {
    }
    
    @Override
    public ClientInfoVO getClientInfo(String userID) {
        this.userDAO =RemoteHelper.getInstance().getUserDAO();
        this.userID = userID;
        try {
            this.clientInfoVO = new ClientInfoVO(userDAO.getClientInfo(this.userID));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return clientInfoVO;
    }

    @Override
    public boolean modifyClientInfo(UserVO user, String oldUserID) {
        this.userDAO =RemoteHelper.getInstance().getUserDAO();
        this.clientInfoVO = getClientInfo(oldUserID);
        ClientInfoVO modified = new ClientInfoVO(user.userID, user.password, user.telNum, UserType.Client, clientInfoVO.creditValue, clientInfoVO.creditRecord);
        try {
            userDAO.updateClient(new ClientInfoPO(modified), oldUserID);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}
