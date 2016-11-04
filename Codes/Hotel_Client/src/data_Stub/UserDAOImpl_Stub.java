package data_Stub;

import java.rmi.RemoteException;
import java.sql.Date;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.UserPO;
import po.UserType;

public class UserDAOImpl_Stub implements UserDAO{
    
    public String userID;
    public String passpord;
    public String telNum;
    
    public int creditValue;
    public String[] creditRecord;
    
    public String enterpriseName;

    public Date birth;
    public String enterpriseID;
    public String enterprisePasspord;
    
    public UserType userType;
    
    public UserDAOImpl_Stub(String userID, String passpord, String telNum) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
    }
    public UserDAOImpl_Stub(String userID, String passpord, String telNum, int creditValue, String[] creditRecord) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }
    public UserDAOImpl_Stub(String userID, String passpord, String telNum, int creditValue, String[] creditRecord,
            Date birth) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
        this.birth = birth;
    }
    public UserDAOImpl_Stub(String userID, String passpord, String telNum, String enterpriseName) {
        super();
        this.userID = userID;
        this.passpord = passpord;
        this.telNum = telNum;
        this.enterpriseName = enterpriseName;
    }

    
    @Override
    public UserPO getUserInfo(String userID, UserType userType) throws RemoteException {
        return new UserPO(userID, passpord, telNum, userType);
    }
    @Override
    public UserPO queryCredit(String userID) throws RemoteException {
        return new ClientInfoPO(userID, passpord, telNum, userType, creditValue, creditRecord);
    }
    @Override
    public int getCreditValue(String userID) throws RemoteException {
        return 0;
    }
    @Override
    public void insert(UserPO po) throws RemoteException {
        System.out.println("Insert Succeed!\n");
    }
    @Override
    public void delete(UserPO po) throws RemoteException {
        System.out.println("Delete Succeed!\n");
        
    }
    @Override
    public void update(UserPO po) throws RemoteException {
        System.out.println("Update Succeed!\n");
        
    }
    @Override
    public void finish() throws RemoteException {   
        System.out.println("Finish succeed!\n");
        
    }
    
}
