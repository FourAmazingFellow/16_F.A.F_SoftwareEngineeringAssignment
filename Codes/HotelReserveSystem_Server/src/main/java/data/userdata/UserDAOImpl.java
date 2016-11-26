package data.userdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.databaseutility.JDBC_Connection;
import dataservice.userDAO.UserDAO;
import po.ClientInfoPO;
import po.CreditRecordPO;
import po.EnterpriseVipPO;
import po.HotelStaffInfoPO;
import po.RegularVipPO;
import po.UserPO;
import po.UserType;

public class UserDAOImpl implements UserDAO {

	private UserType convertFromIntToUserType(int userType) {
		switch (userType) {
		case 0:
			return UserType.Client;
		case 1:
			return UserType.HotelStaff;
		case 2:
			return UserType.WebMarketStaff;
		default:
			return UserType.WebManageStaff;
		}
	}
	
	private int convertFromUserTypeToInt(Enum<UserType> userType) {
		if(userType == UserType.Client)
			return 0;
		else if(userType == UserType.HotelStaff)
			return 1;
		else if(userType == UserType.WebMarketStaff)
			return 2;
		else
			return 3;
	}
	
    @Override
    public UserPO getUserInfo(String userID) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserPO userPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址、策略类型、策略名称获得数据库数据
			pstmt = conn.prepareStatement("select * from webStaff where userID = ?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userPO = new UserPO(userID, rs.getString("password"), rs.getString("telNum"), convertFromIntToUserType(rs.getInt("userType")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return userPO;
    }

    @Override
    public ClientInfoPO getClientInfo(String userID) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClientInfoPO clientInfoPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址、策略类型、策略名称获得数据库数据
			pstmt = conn.prepareStatement("select * from client where userID = ?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				clientInfoPO = new ClientInfoPO(userID, rs.getString("password"), rs.getString("telNum"), UserType.Client, rs.getInt("creditValue"), null);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return clientInfoPO;
    }

    @Override
    public HotelStaffInfoPO getHotelStaffInfo(String userID) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HotelStaffInfoPO hotelStaffInfoPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址、策略类型、策略名称获得数据库数据
			pstmt = conn.prepareStatement("select * from hotelStaff where userID = ?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hotelStaffInfoPO = new HotelStaffInfoPO(userID, rs.getString("password"), rs.getString("telNum"), UserType.HotelStaff, rs.getString("hotelAddress"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return hotelStaffInfoPO;
    }

    @Override
    public int getCreditValue(String userID) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int creditValue = -1;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址、策略类型、策略名称获得数据库数据
			pstmt = conn.prepareStatement("select * from client where userID = ?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				creditValue = rs.getInt("creditValue");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return creditValue;
    }

    @Override
    public void insertUser(UserPO userPO) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("insert into webStaff(userID, telNum, password, userType) values(?,?,?,?)");
			pstmt.setString(1, userPO.getUserID());
			pstmt.setString(2, userPO.getTelNum());
			pstmt.setString(3, userPO.getpassword());
			pstmt.setInt(4, convertFromUserTypeToInt(userPO.getUserType()));
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public void insertClient(ClientInfoPO clientInfoPO) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("insert into client(userID, telNum, password, creditValue) values(?,?,?,?)");
			pstmt.setString(1, clientInfoPO.getUserID());
			pstmt.setString(2, clientInfoPO.getTelNum());
			pstmt.setString(3, clientInfoPO.getpassword());
			pstmt.setInt(4, clientInfoPO.getCreditValue());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public void insertHotelStaff(HotelStaffInfoPO hotelStaffInfoPO) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("insert into hotelStaff(userID, telNum, password, hotelAddress) values(?,?,?,?)");
			pstmt.setString(1, hotelStaffInfoPO.getUserID());
			pstmt.setString(2, hotelStaffInfoPO.getTelNum());
			pstmt.setString(3, hotelStaffInfoPO.getpassword());
			pstmt.setString(4, hotelStaffInfoPO.getEnterpriseName());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public void updateUser(UserPO userPO, String OldUserID) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			String sql = null;
			if(userPO.getUserType() == UserType.HotelStaff) {
				sql = "update hotelStaff set userID = ?, password = ?, telNum = ? where userID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userPO.getUserID());
				pstmt.setString(2, userPO.getpassword());
				pstmt.setString(3, userPO.getTelNum());
				pstmt.setString(4, OldUserID);
				pstmt.executeUpdate();
			}
			else {
				sql = "update webStaff set userID = ?, password = ?, telNum = ? where userID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userPO.getUserID());
				pstmt.setString(2, userPO.getpassword());
				pstmt.setString(3, userPO.getTelNum());
				pstmt.setString(4, OldUserID);
				pstmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public void updateClient(ClientInfoPO clientInfoPO, String oldUserID) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void signRegularVip(RegularVipPO regularVipPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void signEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<CreditRecordPO> queryCreditRecord(String userID) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RegularVipPO getRegularVipInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EnterpriseVipPO getEnterpriseVipInfo(String userID) {
        // TODO Auto-generated method stub
        return null;
    }

   
}
