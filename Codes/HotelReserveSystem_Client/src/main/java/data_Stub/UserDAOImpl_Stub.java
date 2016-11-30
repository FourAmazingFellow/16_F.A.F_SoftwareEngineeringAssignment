package data_Stub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.HotelStaffInfoPO;
import po.RegularVipPO;
import po.UserPO;
import po.UserType;

public class UserDAOImpl_Stub implements UserDAO{
    
    public String userID;
    public String password;
    public String telNum;
    public int creditValue;
    public ArrayList<CreditRecordPO> creditRecord;
    public String hotelAddress;
    public Date birth;
    public int vipRank;
    public String enterpriseID;
    public String enterprisePassword;
    public UserType userType;
    
    public UserDAOImpl_Stub(String userID, String password, String telNum) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
    }
    
    public UserDAOImpl_Stub(String userID, String password, String telNum, int creditValue,
            ArrayList<CreditRecordPO> creditRecord) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
    }

    public UserDAOImpl_Stub(String userID, String password, String telNum, String hotelAddress) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.hotelAddress = hotelAddress;
    }

    public UserDAOImpl_Stub(String userID, String password, String telNum, int creditValue,
            ArrayList<CreditRecordPO> creditRecord, Date birth, int vipRank) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
        this.birth = birth;
        this.vipRank = vipRank;
    }

    public UserDAOImpl_Stub(String userID, String password, String telNum, int creditValue,
            ArrayList<CreditRecordPO> creditRecord, String enterpriseID, String enterprisePassword) {
        super();
        this.userID = userID;
        this.password = password;
        this.telNum = telNum;
        this.creditValue = creditValue;
        this.creditRecord = creditRecord;
        this.enterpriseID = enterpriseID;
        this.enterprisePassword = enterprisePassword;
    }
    
    @Override
    public UserPO getUserInfo(String userID) throws RemoteException {
        return new UserPO(userID, password, telNum, userType);
    }
    @Override
    public ArrayList<CreditRecordPO> queryCreditRecord(String userID) throws RemoteException {
        return new ArrayList<>(creditRecord);
    }
    @Override
    public int getCreditValue(String userID) throws RemoteException {
        return creditValue;
    }
    @Override
    public void insertUser(UserPO po) throws RemoteException {
        System.out.println("Insert Succeed!\n");
    }
    @Override
    public void updateUser(UserPO po, String oldUserID) throws RemoteException {
        System.out.println("Update Succeed!\n");      
    }	
    @Override
    public void insertClient(ClientInfoPO clientInfoPO) throws RemoteException {
        System.out.println("Insert Succeed!\n");     
    }
    @Override
    public void insertHotelStaff(HotelStaffInfoPO hotelStaffInfoPO) throws RemoteException {
        System.out.println("Insert Succeed!\n");      
    }
    @Override
    public ClientInfoPO getClientInfo(String userID) throws RemoteException {
        return new ClientInfoPO(userID, password, telNum, userType, creditValue, creditRecord);
    }
    @Override
    public HotelStaffInfoPO getHotelStaffInfo(String userID) throws RemoteException {
        return new HotelStaffInfoPO(userID, password, telNum, userType, hotelAddress);
    }
    @Override
    public void updateClient(ClientInfoPO clientInfoPO, String oldUserID) throws RemoteException {
        System.out.println("Update Succeed!\n");
    }
    @Override
    public void signRegularVip(RegularVipPO regularVipPO) throws RemoteException {
        System.out.println("Sign Succeed!\n");
        
    }
    @Override
    public void signEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
        System.out.println("Sign Succeed!\n");
        
    }
    @Override
    public RegularVipPO getRegularVipInfo(String userID) {
        return new RegularVipPO(userID, password, telNum, userType, creditValue, creditRecord, birth, vipRank);
    }
    @Override
    public EnterpriseVipPO getEnterpriseVipInfo(String userID) {
        return new EnterpriseVipPO(userID, password, telNum, userType, creditValue, creditRecord, enterpriseID, enterprisePassword);
    }
    
}
