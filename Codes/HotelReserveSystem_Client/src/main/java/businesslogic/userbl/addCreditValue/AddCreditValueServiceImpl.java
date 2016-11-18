package businesslogic.userbl.addCreditValue;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.AddCreditValueService;
import data_Stub.UserDAOImpl_Stub;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserType;
import vo.ClientInfoVO;

public class AddCreditValueServiceImpl implements AddCreditValueService {
    ClientInfoVO clientInfoVO;
    String userID;
    String password;
    String telNum;
    UserType userType;
    int creditValue;
    String[] creditRecord;
    private UserDAO userDAO;
    
    @Override
    public boolean addCreditValue(String userID, int creditAdded) {
        this.userID = userID;
        this.clientInfoVO = new ClientInfoVO(userID, password, telNum, userType, creditValue, creditRecord); 
        ClientInfoPO clientInfoPO = new ClientInfoPO(clientInfoVO);
        this.userDAO = new UserDAOImpl_Stub(userID, password, telNum);
        creditValue = clientInfoPO.getCreditValue();
        this.creditValue = creditValue + creditAdded;
        try {
            userDAO.update(new ClientInfoPO(this.userID, password, telNum, userType, this.creditValue, creditRecord));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
	

}
