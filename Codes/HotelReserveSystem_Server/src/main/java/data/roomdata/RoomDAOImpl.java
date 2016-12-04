package data.roomdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import data.databaseutility.JDBC_Connection;

import java.util.ArrayList;
import java.util.Calendar;

import dataservice.roomDAO.RoomDAO;
import po.CheckInPO;
import po.CheckOutPO;
import po.RoomPO;
import po.RoomType;

public class RoomDAOImpl implements RoomDAO {

	//将数据库中储存房间类型的int型转换成RoomType型
	private RoomType convertFromIntToRoomType(int roomType) {
		switch(roomType) {
		case 0:
			return RoomType.SINGLE_ROOM;
		case 1:
			return RoomType.STANDARD_ROOM;
		case 2:
			return RoomType.TRIBLE_ROOM;
		default:
			return RoomType.KING_SIZE_ROOM;
		}
	}	
	
	//将RoomPO中储存房间类型的RoomType型转换成int型
	private int convertFromRoomTypeToInt(Enum<RoomType> roomType) {
		if(roomType == RoomType.SINGLE_ROOM)
			return 0;
		else if(roomType == RoomType.STANDARD_ROOM)
			return 1;
		else if(roomType == RoomType.TRIBLE_ROOM)
			return 2;
		else
			return 3;
	}	
	
    @SuppressWarnings("deprecation")
	@Override
    public ArrayList<RoomPO> getSpareRoomInfoList(String address, Date day) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RoomPO> roomPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from room" + String.format("%02d", day.getMonth() + 1) + String.format("%02d", day.getDate())+ " where hotelAddress = ?");
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				RoomPO roomPO = new RoomPO(convertFromIntToRoomType(rs.getInt("roomType")), rs.getInt("roomNum"), rs.getInt("roomPrice"), address);
				roomPOs.add(roomPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return roomPOs;
    }

    @SuppressWarnings("deprecation")
	@Override
    public RoomPO getSpareRoomInfo(String address, Enum<RoomType> roomType, Date day) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RoomPO roomPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from room" + String.format("%02d", day.getMonth() + 1) + String.format("%02d", day.getDate())+ " where hotelAddress = ? and roomType = ?");
			pstmt.setString(1, address);
			pstmt.setInt(2, convertFromRoomTypeToInt(roomType));
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				roomPO = new RoomPO(convertFromIntToRoomType(rs.getInt("roomType")), rs.getInt("roomNum"), rs.getInt("roomPrice"), address);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return roomPO;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfoList(String address) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RoomPO> checkInPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from checkin where hotelAddress = ?");
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				CheckInPO checkInPO = new CheckInPO(convertFromIntToRoomType(rs.getInt("roomType")), rs.getInt("roomNum"), address, rs.getTimestamp("checkInTime"), rs.getTimestamp("expDepartTime"));
				checkInPOs.add(checkInPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return checkInPOs;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfo(String address, Enum<RoomType> roomType) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RoomPO> checkInPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from checkin where hotelAddress = ? and roomType = ?");
			pstmt.setString(1, address);
			pstmt.setInt(2, convertFromRoomTypeToInt(roomType));
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				CheckInPO checkInPO = new CheckInPO(convertFromIntToRoomType(rs.getInt("roomType")), rs.getInt("roomNum"), address, rs.getTimestamp("checkInTime"), rs.getTimestamp("expDepartTime"));
				checkInPOs.add(checkInPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return checkInPOs;
    }

    @Override
    public ArrayList<RoomPO> getCheckInInfo(String address, Date startTime, Date endTime) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RoomPO> checkInPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from checkin where hotelAddress = ? and checkInTime between ? and ?");
			pstmt.setString(1, address);
			pstmt.setTimestamp(2, (new java.sql.Timestamp(startTime.getTime())));
			pstmt.setTimestamp(3, (new java.sql.Timestamp(endTime.getTime())));
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				CheckInPO checkInPO = new CheckInPO(convertFromIntToRoomType(rs.getInt("roomType")), rs.getInt("roomNum"), address, rs.getTimestamp("checkInTime"), rs.getTimestamp("expDepartTime"));
				checkInPOs.add(checkInPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return checkInPOs;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfoList(String address) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RoomPO> checkOutPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from checkout where hotelAddress = ?");
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				CheckOutPO checkOutPO = new CheckOutPO(convertFromIntToRoomType(rs.getInt("roomType")), rs.getInt("roomNum"), address, rs.getTimestamp("actDepartTime"));
				checkOutPOs.add(checkOutPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return checkOutPOs;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfo(String address, Date startTime, Date endTime) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RoomPO> checkOutPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from checkout where hotelAddress = ? and actDepartTime between ? and ?");
			pstmt.setString(1, address);
			pstmt.setTimestamp(2, (new java.sql.Timestamp(startTime.getTime())));
			pstmt.setTimestamp(3, (new java.sql.Timestamp(endTime.getTime())));
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				CheckOutPO checkOutPO = new CheckOutPO(convertFromIntToRoomType(rs.getInt("roomType")), rs.getInt("roomNum"), address, rs.getTimestamp("actDepartTime"));
				checkOutPOs.add(checkOutPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return checkOutPOs;
    }

    @Override
    public ArrayList<RoomPO> getCheckOutInfo(String address, Enum<RoomType> roomType) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RoomPO> checkOutPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from checkout where hotelAddress = ? and roomType = ?");
			pstmt.setString(1, address);
			pstmt.setInt(2, convertFromRoomTypeToInt(roomType));
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				CheckOutPO checkOutPO = new CheckOutPO(convertFromIntToRoomType(rs.getInt("roomType")), rs.getInt("roomNum"), address, rs.getTimestamp("actDepartTime"));
				checkOutPOs.add(checkOutPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
        return checkOutPOs;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void updateRoom(RoomPO po, Date day) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("update room" + String.format("%02d", day.getMonth() + 1) + String.format("%02d", day.getDate())+ " set roomNum = ?, roomPrice = ? where hotelAddress = ? and roomType = ?");
			pstmt.setInt(1, po.getRoomNum());
			pstmt.setInt(2, po.getRoomPrice());
			pstmt.setString(3, po.getAddress());
			pstmt.setInt(4, convertFromRoomTypeToInt(po.getRoomType()));
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public void insertRoom(RoomPO po) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			for(int i = 0; i < 7; i++){
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, i);
				String day = "" + String.format("%02d", calendar.get(Calendar.MONTH) + 1) + String.format("%02d", calendar.get(Calendar.DATE));
				pstmt = conn.prepareStatement("insert into room" + day + "(hotelAddress, roomType, roomNum, roomPrice) values(?,?,?,?)");
				pstmt.setString(1, po.getAddress());
				pstmt.setInt(2, convertFromRoomTypeToInt(po.getRoomType()));
				pstmt.setInt(3, po.getRoomNum());
				pstmt.setInt(4, po.getRoomPrice());
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
    public void insertCheckIn(CheckInPO po) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("insert into checkin(hotelAddress, roomType, roomNum, checkInTime, expDepartTime) values(?,?,?,?,?)");
			pstmt.setString(1, po.getAddress());
			pstmt.setInt(2, convertFromRoomTypeToInt(po.getRoomType()));
			pstmt.setInt(3, po.getRoomNum());
			pstmt.setTimestamp(4, new java.sql.Timestamp(po.getCheckInTime().getTime()));
			pstmt.setTimestamp(5, new java.sql.Timestamp(po.getExpDepartTime().getTime()));
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

    @Override
    public void insertCheckOut(CheckOutPO po) throws RemoteException {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("insert into checkout(hotelAddress, roomType, roomNum, actDepartTime) values(?,?,?,?)");
			pstmt.setString(1, po.getAddress());
			pstmt.setInt(2, convertFromRoomTypeToInt(po.getRoomType()));
			pstmt.setInt(3, po.getRoomNum());
			pstmt.setTimestamp(4, new java.sql.Timestamp(po.getActDepartTime().getTime()));
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
    }

}
