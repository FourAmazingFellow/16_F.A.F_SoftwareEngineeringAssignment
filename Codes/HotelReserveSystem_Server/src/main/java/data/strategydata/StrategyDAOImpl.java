package data.strategydata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import data.databaseutility.JDBC_Connection;
import po.StrategyPO;
import po.StrategyType;

public class StrategyDAOImpl implements dataservice.strategyDAO.StrategyDAO {

	private static String[] tableNames = {"birthdayPromotion", "MultiRoomPromotionandMemberRankMarket", "cooperativeEnterprise",
								   "specificTimePromotion", "specificTimePromotion", "vipTradeAreaMarket", "MultiRoomPromotionandMemberRankMarket"
								  };
	
	private int convertFromStrategyTypeToInt(Enum<StrategyType> strategyType) {
		if(strategyType == StrategyType.BirthdayPromotion)
			return 0;
		else if(strategyType == StrategyType.MultiRoomPromotion)
			return 1;
		else if(strategyType == StrategyType.CooperationEnterprisePromotion)
			return 2;
		else if(strategyType == StrategyType.SpecificTimePromotion)
			return 3;
		else if(strategyType == StrategyType.SpecificTimeMarket)
			return 4;
		else if(strategyType == StrategyType.VipTradeAreaMarket)
			return 5;
		else
			return 6;
	}
	
	
	@Override
	public ArrayList<StrategyPO> getStrategyList(String address, Enum<StrategyType> strategyType)
			throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StrategyPO> strategyPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址和策略类型获得数据库数据
			pstmt = conn.prepareStatement("select * from " + tableNames[convertFromStrategyTypeToInt(strategyType)] + " where hotelAddress = ? and strategyType = ?");
			pstmt.setString(1, address);
			pstmt.setInt(2, convertFromStrategyTypeToInt(strategyType));
			rs = pstmt.executeQuery();
			
			//遍历结果，构造strategyPO，并添加到列表中
			if(strategyType == StrategyType.BirthdayPromotion) {
				while(rs.next()) {
					StrategyPO strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"));
					strategyPOs.add(strategyPO);
				}
			}
			else if(strategyType == StrategyType.MultiRoomPromotion || strategyType == StrategyType.MemberRankMarket) {
				while(rs.next()) {
					StrategyPO strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"), rs.getInt("minRoomNumOrVipRank"));
					strategyPOs.add(strategyPO);
				}
			}
			else if(strategyType == StrategyType.CooperationEnterprisePromotion) {
				while(rs.next()) {
					StrategyPO strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"), rs.getString("enterpriseName"), rs.getString("securityCode"));
					strategyPOs.add(strategyPO);
				}
			}
			else if(strategyType == StrategyType.SpecificTimePromotion || strategyType == StrategyType.SpecificTimeMarket) {
				while(rs.next()) {
					StrategyPO strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"), rs.getDate("startTime"), rs.getDate("endTime"));
					strategyPOs.add(strategyPO);
				}
			}
			else {
				while(rs.next()) {
					StrategyPO strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"), rs.getInt("vipRank"), rs.getString("tradeArea"));
					strategyPOs.add(strategyPO);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return strategyPOs;
	}

	@Override
	public StrategyPO getStrategyInfo(String address, Enum<StrategyType> strategyType, String strategyName) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StrategyPO strategyPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址、策略类型、策略名称获得数据库数据
			pstmt = conn.prepareStatement("select * from " + tableNames[convertFromStrategyTypeToInt(strategyType)] + " where hotelAddress = ? and strategyType = ? and strategyName = ?");
			pstmt.setString(1, address);
			pstmt.setInt(2, convertFromStrategyTypeToInt(strategyType));
			pstmt.setString(3, strategyName);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造strategyPO
			if(strategyType == StrategyType.BirthdayPromotion) {
				while(rs.next()) {
					strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"));
				}
			}
			else if(strategyType == StrategyType.MultiRoomPromotion || strategyType == StrategyType.MemberRankMarket) {
				while(rs.next()) {
					strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"), rs.getInt("minRoomNumOrVipRank"));
				}
			}
			else if(strategyType == StrategyType.CooperationEnterprisePromotion) {
				while(rs.next()) {
					strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"), rs.getString("enterpriseName"), rs.getString("securityCode"));
				}
			}
			else if(strategyType == StrategyType.SpecificTimePromotion || strategyType == StrategyType.SpecificTimeMarket) {
				while(rs.next()) {
					strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"), rs.getDate("startTime"), rs.getDate("endTime"));
				}
			}
			else {
				while(rs.next()) {
					strategyPO = new StrategyPO(rs.getString("hotelAddress"), strategyType, rs.getString("strategyName"), rs.getFloat("discount"), rs.getInt("vipRank"), rs.getString("tradeArea"));
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return strategyPO;
	}

	@Override
	public void updateStrategy(StrategyPO po) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			String sql = null;
			if(po.getStrategyType() == StrategyType.BirthdayPromotion) {
				sql = "update " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + " set discount = ? where hotelAddress = ? and strategyName = ? and strategyType = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1, po.getDiscount());
				pstmt.setString(2, po.getAddress());
				pstmt.setString(3, po.getStrategyName());
				pstmt.setInt(4, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.executeUpdate();
			}
			else if(po.getStrategyType() == StrategyType.MultiRoomPromotion) {
				sql = "update " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + " set discount = ?, minRoomNumOrVipRank = ? where hotelAddress = ? and strategyName = ? and strategyType = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1, po.getDiscount());
				pstmt.setInt(2, po.getMinRoomNum());
				pstmt.setString(3, po.getAddress());
				pstmt.setString(4, po.getStrategyName());
				pstmt.setInt(5, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.executeUpdate();
			}
			else if(po.getStrategyType() == StrategyType.MemberRankMarket) {
				sql = "update " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + " set discount = ?, minRoomNumOrVipRank = ? where hotelAddress = ? and strategyName = ? and strategyType = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1, po.getDiscount());
				pstmt.setInt(2, po.getVipRank());
				pstmt.setString(3, po.getAddress());
				pstmt.setString(4, po.getStrategyName());
				pstmt.setInt(5, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.executeUpdate();
			}
			else if(po.getStrategyType() == StrategyType.CooperationEnterprisePromotion) {
				sql = "update " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + " set discount = ?, securityCode = ? where hotelAddress = ? and strategyName = ? and strategyType = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1, po.getDiscount());
				pstmt.setString(2, po.getEnterpriseName());
				pstmt.setString(3, po.getAddress());
				pstmt.setString(4, po.getStrategyName());
				pstmt.setInt(5, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.executeUpdate();
			}
			else if(po.getStrategyType() == StrategyType.SpecificTimePromotion || po.getStrategyType() == StrategyType.SpecificTimeMarket) {
				sql = "update " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + " set discount = ?, startTime = ?, endTime = ? where hotelAddress = ? and strategyName = ? and strategyType = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1, po.getDiscount());
				pstmt.setDate(2, new java.sql.Date(po.getStartTime().getTime()));
				pstmt.setDate(3, new java.sql.Date(po.getEndTime().getTime()));
				pstmt.setString(4, po.getAddress());
				pstmt.setString(5, po.getStrategyName());
				pstmt.setInt(6, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.executeUpdate();
			}
			else {
				sql = "update " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + " set discount = ?, vipRank = ? where hotelAddress = ? and strategyName = ? and strategyType = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1, po.getDiscount());
				pstmt.setInt(2, po.getVipRank());
				pstmt.setString(3, po.getAddress());
				pstmt.setString(4, po.getStrategyName());
				pstmt.setInt(5, convertFromStrategyTypeToInt(po.getStrategyType()));
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
	public void insertStrategy(StrategyPO po) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			String sql = null;
			if(po.getStrategyType() == StrategyType.BirthdayPromotion) {
				sql = "insert into " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + "(hotelAddress, strategyName, discount, strategyType) values(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, po.getAddress());
				pstmt.setString(2, po.getStrategyName());
				pstmt.setFloat(3, po.getDiscount());
				pstmt.setInt(4, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.executeUpdate();
			}
			else if(po.getStrategyType() == StrategyType.MultiRoomPromotion) {
				sql = "insert into " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + "(hotelAddress, strategyName, discount, strategyType, minRoomNumOrVipRank) values(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, po.getAddress());
				pstmt.setString(2, po.getStrategyName());
				pstmt.setFloat(3, po.getDiscount());
				pstmt.setInt(4, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.setInt(5, po.getMinRoomNum());
				pstmt.executeUpdate();
			}
			else if(po.getStrategyType() == StrategyType.MemberRankMarket) {
				sql = "insert into " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + "(hotelAddress, strategyName, discount, strategyType, minRoomNumOrVipRank) values(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, po.getAddress());
				pstmt.setString(2, po.getStrategyName());
				pstmt.setFloat(3, po.getDiscount());
				pstmt.setInt(4, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.setInt(5, po.getVipRank());
				pstmt.executeUpdate();
			}
			else if(po.getStrategyType() == StrategyType.CooperationEnterprisePromotion) {
				sql = "insert into " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + "(hotelAddress, strategyName, discount, strategyType, enterpriseName, securityCode) values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, po.getAddress());
				pstmt.setString(2, po.getStrategyName());
				pstmt.setFloat(3, po.getDiscount());
				pstmt.setInt(4, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.setString(5, po.getEnterpriseName());
				pstmt.setString(6, po.getSecurityCode());
				pstmt.executeUpdate();
			}
			else if(po.getStrategyType() == StrategyType.SpecificTimePromotion || po.getStrategyType() == StrategyType.SpecificTimeMarket) {
				sql = "insert into " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + "(hotelAddress, strategyName, discount, strategyType, startTime, endTime) values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, po.getAddress());
				pstmt.setString(2, po.getStrategyName());
				pstmt.setFloat(3, po.getDiscount());
				pstmt.setInt(4, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.setDate(5, new java.sql.Date(po.getStartTime().getTime()));
				pstmt.setDate(6, new java.sql.Date(po.getEndTime().getTime()));
				pstmt.executeUpdate();
			}
			else {
				sql = "insert into " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + "(hotelAddress, strategyName, discount, strategyType, vipRank, tradeArea) values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, po.getAddress());
				pstmt.setString(2, po.getStrategyName());
				pstmt.setFloat(3, po.getDiscount());
				pstmt.setInt(4, convertFromStrategyTypeToInt(po.getStrategyType()));
				pstmt.setInt(5, po.getVipRank());
				pstmt.setString(6, po.getTradeArea());
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
	public void deleteStrategy(StrategyPO po) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			String sql = "delete from " + tableNames[convertFromStrategyTypeToInt(po.getStrategyType())] + " where hotelAddress = ? and strategyType = ? and strategyName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, po.getAddress());
			pstmt.setInt(2, convertFromStrategyTypeToInt(po.getStrategyType()));
			pstmt.setString(3, po.getStrategyName());
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
	}


    @Override
    public boolean verifyEnterpriseMember(String enterpriseName, String securityCode) {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			String sql = "select * from cooperativeenterprise where enterpriseName = ? and securityCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, enterpriseName);
			pstmt.setString(2, securityCode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return true;
			}
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
    }

}
