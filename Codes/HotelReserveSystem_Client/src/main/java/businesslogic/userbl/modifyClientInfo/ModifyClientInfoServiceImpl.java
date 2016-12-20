package businesslogic.userbl.modifyClientInfo;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyClientInfoService;
import dataservice.userDAO.UserDAO;
import factory.FactoryService;
import factory.FactoryServiceImpl;
import po.ClientInfoPO;
import po.UserType;
import vo.ClientInfoVO;
import vo.UserVO;

public class ModifyClientInfoServiceImpl implements ModifyClientInfoService{

    private UserDAO userDAO;
    private String userID;
    private ClientInfoVO clientInfoVO;
    
    private FactoryService factoryService;
    
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    
    public ModifyClientInfoServiceImpl() {
    	this.factoryService = new FactoryServiceImpl();
    	this.userDAO = factoryService.getUserDAO();
    }
    
    @Override
    public ClientInfoVO getClientInfo(String userID) throws RemoteException {
        this.userID = userID;
        this.clientInfoVO = new ClientInfoVO(userDAO.getClientInfo(this.userID));
        return clientInfoVO;
    }

    @Override
    public boolean modifyClientInfo(UserVO user, String oldUserID) throws RemoteException {
        this.clientInfoVO = getClientInfo(oldUserID);
        ClientInfoVO modified = new ClientInfoVO(user.userID, user.password, user.telNum, UserType.Client, clientInfoVO.creditValue, clientInfoVO.creditRecord);
        userDAO.updateClient(new ClientInfoPO(modified), oldUserID);
        return true;
    }
    
    
}
