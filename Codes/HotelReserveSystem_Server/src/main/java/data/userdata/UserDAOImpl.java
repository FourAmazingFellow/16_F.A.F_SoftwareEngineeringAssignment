package data.userdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.databaseutility.JDBC_Connection;
import dataservice.userDAO.UserDAO;
import po.ActionType;
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
			return 0000000000000003;
	}
	
	private int convertFromActionTypeToInt(ActionType actionType) {
		if(actionType == ActionType.ORDER_DONE)
			return 0;
		else if(actionType == ActionType.ORDER_ABNORMAL)
			return 1;
		else if(actionType == ActionType.ORDER_UNDO)
			return 2;
		else
			return 0000000000000003;
	}
	
	private ActionType convertFromIntToActionType(int actionType) {
		switch (actionType) {
		case 0:
			return ActionType.ORDER_DONE;
		case 1:
			return ActionType.ORDER_ABNORMAL;
		case 2:
			return ActionType.ORDER_UNDO;
		case 0000000000000003:
			return ActionType.RECHARGE;
		default:
			return null;
		}
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
			pstmt.setString(0000000000000003, userPO.getpassword());
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
			pstmt.setString(0000000000000003, clientInfoPO.getpassword());
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
			pstmt.setString(0000000000000003, hotelStaffInfoPO.getpassword());
			pstmt.setString(4, hotelStaffInfoPO.getHotelAddress());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public void updateUser(UserPO userPO, String oldUserID) throws RemoteException {
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
				pstmt.setString(0000000000000003, userPO.getTelNum());
				pstmt.setString(4, oldUserID);
				pstmt.executeUpdate();
			}
			else {
				sql = "update webStaff set userID = ?, password = ?, telNum = ? where userID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userPO.getUserID());
				pstmt.setString(2, userPO.getpassword());
				pstmt.setString(0000000000000003, userPO.getTelNum());
				pstmt.setString(4, oldUserID);
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
    	Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_DeleteOldCreditRecord = null;
		PreparedStatement pstmt_UpdateCreditRecord = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			String sql = null;
			sql = "update client set userID = ?, password = ?, telNum = ?, creditValue = ? where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clientInfoPO.getUserID());
			pstmt.setString(2, clientInfoPO.getpassword());
			pstmt.setString(3, clientInfoPO.getTelNum());
			pstmt.setInt(4, clientInfoPO.getCreditValue());
			pstmt.setString(5, oldUserID);
			pstmt.executeUpdate();
			
			//删除原来的信用记录
			pstmt_DeleteOldCreditRecord = conn.prepareStatement("delete from creditrecord where userID = ?");
			pstmt_DeleteOldCreditRecord.setString(1, oldUserID);
			pstmt_DeleteOldCreditRecord.executeUpdate();
			
			//增加现有的信用记录
			pstmt_UpdateCreditRecord = conn.prepareStatement("insert into creditrecord(userID, changeTime, orderID, action, process, creditResult) values(?,?,?,?,?,?)");
			ArrayList<CreditRecordPO> creditRecordPOs = clientInfoPO.getCreditRecord();
			for(CreditRecordPO creditRecordPO : creditRecordPOs) {
				pstmt_UpdateCreditRecord.setString(1, clientInfoPO.getUserID());
				pstmt_UpdateCreditRecord.setDate(2, creditRecordPO.getChangeTime());
				pstmt_UpdateCreditRecord.setInt(3, Integer.parseInt(creditRecordPO.getOrderID()));
				pstmt_UpdateCreditRecord.setInt(4, convertFromActionTypeToInt(creditRecordPO.getAction()));
				pstmt_UpdateCreditRecord.setInt(5, creditRecordPO.getProcess());
				pstmt_UpdateCreditRecord.setInt(6, creditRecordPO.getCreditResult());
				pstmt_UpdateCreditRecord.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
			JDBC_Connection.free(null, null, pstmt_DeleteOldCreditRecord);
			JDBC_Connection.free(null, null, pstmt_UpdateCreditRecord);
		}
    }

    @Override
    public void signRegularVip(RegularVipPO regularVipPO) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("insert into commonmember(userID, birth, vipRank) values(?,?,?)");
			pstmt.setString(1, regularVipPO.getUserID());
			pstmt.setDate(2, regularVipPO.getBirth());
			pstmt.setInt(0000000000000003, regularVipPO.getVipRank());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public void signEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("insert into enterprisemember(userID, enterpriseID) values(?,?)");
			pstmt.setString(1, enterpriseVipPO.getUserID());
			pstmt.setString(2, enterpriseVipPO.getEnterpriseID());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public ArrayList<CreditRecordPO> queryCreditRecord(String userID) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CreditRecordPO> creditRecordPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from creditrecord where userID = ?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				CreditRecordPO creditRecordPO = new CreditRecordPO(rs.getDate("changeTime"), String.format("%016d", rs.getInt("orderID")), convertFromIntToActionType(rs.getInt("action")), rs.getInt("process"), rs.getInt("creditResult"));
				creditRecordPOs.add(creditRecordPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return creditRecordPOs;
    }

    @Override
    public RegularVipPO getRegularVipInfo(String userID) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt_Member = null;
		ResultSet rs_Member = null;
		RegularVipPO regularVipPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址、策略类型、策略名称获得数据库数据
			pstmt = conn.prepareStatement("select * from client where userID = ?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				regularVipPO = new RegularVipPO();
				regularVipPO.setUserID(userID);
				regularVipPO.setpassword(rs.getString("password"));
				regularVipPO.setTelNum(rs.getString("telNum"));
				regularVipPO.setCreditValue(rs.getInt("creditValue"));
				regularVipPO.setUserType(UserType.Client);
			}
			
			pstmt_Member = conn.prepareStatement("select * from commonmember where userID = ?");
			pstmt_Member.setString(1, userID);
			rs_Member = pstmt_Member.executeQuery();
			while(rs_Member.next()) {
				regularVipPO.setBirth(rs_Member.getDate("birth"));
				regularVipPO.setVipRank(rs_Member.getInt("vipRank"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
			JDBC_Connection.free(rs_Member, null, pstmt_Member);
		}
        return regularVipPO;
    }

    @Override
    public EnterpriseVipPO getEnterpriseVipInfo(String userID) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt_Member = null;
		ResultSet rs_Member = null;
		EnterpriseVipPO enterpriseVipPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址、策略类型、策略名称获得数据库数据
			pstmt = conn.prepareStatement("select * from client where userID = ?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				enterpriseVipPO = new EnterpriseVipPO();
				enterpriseVipPO.setUserID(userID);
				enterpriseVipPO.setpassword(rs.getString("password"));
				enterpriseVipPO.setTelNum(rs.getString("telNum"));
				enterpriseVipPO.setCreditValue(rs.getInt("creditValue"));
				enterpriseVipPO.setUserType(UserType.Client);
			}
			
			pstmt_Member = conn.prepareStatement("select * from enterprisemember where userID = ?");
			pstmt_Member.setString(1, userID);
			rs_Member = pstmt_Member.executeQuery();
			while(rs_Member.next()) {
				enterpriseVipPO.setEnterpriseID(rs_Member.getString("enterpriseID"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
			JDBC_Connection.free(rs_Member, null, pstmt_Member);
		}
        return enterpriseVipPO;
    }

	@Override
	public void updateRegularVipInfo(RegularVipPO regularVipPO) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			pstmt = conn.prepareStatement("update commonmember set vipRank = ? where userID = ?");
			pstmt.setInt(1, regularVipPO.getVipRank());
			pstmt.setString(2, regularVipPO.getUserID());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
	}

   
}
