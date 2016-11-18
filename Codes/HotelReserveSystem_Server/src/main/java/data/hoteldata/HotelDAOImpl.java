package data.hoteldata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.databaseutility.JDBC_Connection;
import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.HotelPO;

public class HotelDAOImpl implements HotelDAO {

	@Override
	public BriefHotelInfoPO getHotelBriefInfo(String address) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BriefHotelInfoPO briefHotelInfoPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from hotel where hotelAddress = ?");
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并为其赋值
			while(rs.next()) {
				briefHotelInfoPO = new BriefHotelInfoPO();
				briefHotelInfoPO.setHotelName(rs.getString("hotelName"));
				briefHotelInfoPO.setBusinessDistrict(rs.getString("businessDistrict"));
				briefHotelInfoPO.setHotelAddress(rs.getString("hotelAddress"));
				briefHotelInfoPO.setStarLevel(rs.getInt("starLevel"));
				briefHotelInfoPO.setMark(rs.getFloat("mark"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		return briefHotelInfoPO;
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListBySearching(String[] condition) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition,
			ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException {
		return null;
	}

	@Override
	public HotelPO getHotelDetails(String address) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HotelPO hotelPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from hotel where hotelAddress = ?");
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并为其赋值
			while(rs.next()) {
				hotelPO = new HotelPO();
				hotelPO.setHotelName(rs.getString("hotelName"));
				hotelPO.setBusinessDistrict(rs.getString("businessDistrict"));
				hotelPO.setHotelAddress(rs.getString("hotelAddress"));
				hotelPO.setStarLevel(rs.getInt("starLevel"));
				hotelPO.setMark(rs.getFloat("mark"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		return hotelPO;
	}

	@Override
	public void update(HotelPO po) throws RemoteException {

	}

	@Override
	public void insert(HotelPO po) throws RemoteException {

	}

	@Override
	public void init() throws RemoteException {

	}

	@Override
	public void finish() throws RemoteException {

	}

}
