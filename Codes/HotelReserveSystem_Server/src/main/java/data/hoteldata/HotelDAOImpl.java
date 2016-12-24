package data.hoteldata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import data.databaseutility.JDBC_Connection;
import dataservice.hotelDAO.HotelDAO;
import po.BriefHotelInfoPO;
import po.BriefOrderInfoPO;
import po.BusinessDistrictPO;
import po.HotelPO;
import po.RoomType;

public class HotelDAOImpl implements HotelDAO {

	
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
	
	//将HotelPO中储存房间类型的RoomType型转换成int型
	private int convertFromRoomTypeToInt(RoomType roomType) {
		if(roomType == RoomType.SINGLE_ROOM)
			return 0;
		else if(roomType == RoomType.STANDARD_ROOM)
			return 1;
		else if(roomType == RoomType.TRIBLE_ROOM)
			return 2;
		else
			return 3;
	}
	
	//判断一个hotel是否在用户预订列表中
	private boolean isExist(BriefHotelInfoPO hotelInfoPO, ArrayList<BriefOrderInfoPO> orderedHotelList) {
		boolean result = false;
		for(BriefOrderInfoPO order : orderedHotelList) {
			if(hotelInfoPO.getHotelAddress().equals(order.getHotelAddress())) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
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
				briefHotelInfoPO.setBusinessDistrict(rs.getString("tradeArea"));
				briefHotelInfoPO.setHotelAddress(rs.getString("hotelAddress"));
				briefHotelInfoPO.setStarLevel(rs.getInt("starLevel"));
				briefHotelInfoPO.setMark(rs.getFloat("mark"));
				briefHotelInfoPO.setCity(rs.getString("city"));
				briefHotelInfoPO.setMin_Price(rs.getInt("min_Price"));
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
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListBySearching(String[] condition,
			ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BriefHotelInfoPO> briefHotelInfoPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			if(condition[2].length() == 0) {
				pstmt = conn.prepareStatement("select * from hotel where city = ? and tradeArea = ? and  min_Price < ? and starLevel between ? and ? and mark between ? and ? and max_Price > ?");
				pstmt.setString(1, condition[0]);
				pstmt.setString(2, condition[1]);
				pstmt.setInt(3, Integer.parseInt(condition[4]));
				pstmt.setInt(4, Integer.parseInt(condition[5]));
				pstmt.setInt(5, Integer.parseInt(condition[6]));
				pstmt.setFloat(6, Float.parseFloat(condition[7]));
				pstmt.setFloat(7, Float.parseFloat(condition[8]));
				pstmt.setInt(8, Integer.parseInt(condition[3]));
			}
			else {
				pstmt = conn.prepareStatement("select * from hotel where city = ? and tradeArea = ? and hotelName = ? and  min_Price < ? and starLevel between ? and ? and mark between ? and ? and max_Price > ?");
				pstmt.setString(1, condition[0]);
				pstmt.setString(2, condition[1]);
				pstmt.setString(3, condition[2]);
				pstmt.setInt(4, Integer.parseInt(condition[4]));
				pstmt.setInt(5, Integer.parseInt(condition[5]));
				pstmt.setInt(6, Integer.parseInt(condition[6]));
				pstmt.setFloat(7, Float.parseFloat(condition[7]));
				pstmt.setFloat(8, Float.parseFloat(condition[8]));
				pstmt.setInt(9, Integer.parseInt(condition[3]));
			}
			
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				BriefHotelInfoPO briefHotelInfoPO = new BriefHotelInfoPO();
				briefHotelInfoPO.setHotelName(rs.getString("hotelName"));
				briefHotelInfoPO.setBusinessDistrict(rs.getString("tradeArea"));
				briefHotelInfoPO.setHotelAddress(rs.getString("hotelAddress"));
				briefHotelInfoPO.setStarLevel(rs.getInt("starLevel"));
				briefHotelInfoPO.setMark(rs.getFloat("mark"));
				briefHotelInfoPO.setCity(rs.getString("city"));
				briefHotelInfoPO.setMin_Price(rs.getInt("min_Price"));
				briefHotelInfoPOs.add(briefHotelInfoPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		ArrayList<BriefHotelInfoPO> result = new ArrayList<>();
		
		//筛选预订过的酒店
		if(condition[9].equals("1")) {
			for(BriefHotelInfoPO hotelInfoPO : briefHotelInfoPOs) {
				if(isExist(hotelInfoPO, orderedHotelList))
					result.add(hotelInfoPO);
			}
		}
		else {
			result = briefHotelInfoPOs;
		}
		
		return result;
	}

	@Override
	public ArrayList<BriefHotelInfoPO> getHotelBriefInfoListByQuerying(String[] condition,
			ArrayList<BriefOrderInfoPO> orderedHotelList) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BriefHotelInfoPO> briefHotelInfoPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from hotel where city = ? and tradeArea = ? order by " + condition[2]);
			pstmt.setString(1, condition[0]);
			pstmt.setString(2, condition[1]);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并添加到列表中
			while(rs.next()) {
				BriefHotelInfoPO briefHotelInfoPO = new BriefHotelInfoPO();
				briefHotelInfoPO.setHotelName(rs.getString("hotelName"));
				briefHotelInfoPO.setBusinessDistrict(rs.getString("tradeArea"));
				briefHotelInfoPO.setHotelAddress(rs.getString("hotelAddress"));
				briefHotelInfoPO.setStarLevel(rs.getInt("starLevel"));
				briefHotelInfoPO.setMark(rs.getFloat("mark"));
				briefHotelInfoPO.setCity(rs.getString("city"));
				briefHotelInfoPO.setMin_Price(rs.getInt("min_Price"));
				briefHotelInfoPOs.add(briefHotelInfoPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		ArrayList<BriefHotelInfoPO> result = new ArrayList<>();
		
		//筛选预订过的酒店
		if(condition[3].equals("1")) {
			for(BriefHotelInfoPO hotelInfoPO : briefHotelInfoPOs) {
				if(isExist(hotelInfoPO, orderedHotelList))
					result.add(hotelInfoPO);
			}
		}
		else {
			result = briefHotelInfoPOs;
		}
		
		return result;
	}

	@Override
	public HotelPO getHotelDetails(String address) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt_Hotel = null;
		ResultSet rs_Hotel = null;
		PreparedStatement pstmt_Room = null;
		ResultSet rs_Room = null;
		PreparedStatement pstmt_Comments = null;
		ResultSet rs_Comments = null;
		HotelPO hotelPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt_Hotel = conn.prepareStatement("select * from hotel where hotelAddress = ?");
			pstmt_Hotel.setString(1, address);
			pstmt_Room = conn.prepareStatement("select * from roomtypeandprice where address = ?");
			pstmt_Room.setString(1, address);
			pstmt_Comments = conn.prepareStatement("select * from comments where hotelAddress = ?");
			pstmt_Comments.setString(1, address);
			rs_Hotel = pstmt_Hotel.executeQuery();
			rs_Room = pstmt_Room.executeQuery();
			rs_Comments = pstmt_Comments.executeQuery();
			
			//遍历结果，构造hotelPO，并为其赋值
			while(rs_Hotel.next()) {
				hotelPO = new HotelPO();
				hotelPO.setHotelName(rs_Hotel.getString("hotelName"));
				hotelPO.setBusinessDistrict(rs_Hotel.getString("tradeArea"));
				hotelPO.setHotelAddress(rs_Hotel.getString("hotelAddress"));
				hotelPO.setStarLevel(rs_Hotel.getInt("starLevel"));
				hotelPO.setMark(rs_Hotel.getFloat("mark"));
				hotelPO.setCity(rs_Hotel.getString("city"));
				hotelPO.setMin_Price(rs_Hotel.getInt("min_Price"));
				hotelPO.setBriefIntroduction(rs_Hotel.getString("briefIntroduction"));
				hotelPO.setFacilityAndService(rs_Hotel.getString("facilityAndService"));
				
				//为hotelPO中的roomtype、price、nums赋值
				HashMap<RoomType, Integer> roomTypeAndPrice = new HashMap<>();
				HashMap<RoomType, Integer> roomTypeAndNums = new HashMap<>();
				while(rs_Room.next()) {
					roomTypeAndPrice.put(convertFromIntToRoomType(rs_Room.getInt("roomType")), rs_Room.getInt("price"));
					roomTypeAndNums.put(convertFromIntToRoomType(rs_Room.getInt("roomType")), rs_Room.getInt("nums"));
				}
				hotelPO.setRoomTypeAndPrice(roomTypeAndPrice);
				hotelPO.setRoomTypeAndNums(roomTypeAndNums);
				
				//为hotelPO中的comments赋值
				HashMap<String, String> comments = new HashMap<>();
				while(rs_Comments.next()) {
					comments.put(rs_Comments.getString("clientName"), rs_Comments.getString("comment"));
				}
				hotelPO.setComments(comments);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs_Hotel, conn, pstmt_Hotel);
			JDBC_Connection.free(rs_Room, conn, pstmt_Room);
			JDBC_Connection.free(rs_Comments, conn, pstmt_Comments);
		}
		
		return hotelPO;
	}

	@Override
	public boolean updateHotel(HotelPO po) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt_Hotel = null;
		String sql_Hotel = "update hotel set hotelName = ?, starLevel = ?, mark = ?, briefIntroduction = ?, facilityAndService = ?, city = ?, min_Price = ?, max_Price = ? where hotelAddress = ?";
		PreparedStatement pstmt_DeleteRoom = null;
		String sql_DeleteRoom = "delete from roomtypeandprice where address = ?";
		PreparedStatement pstmt_AddRoom = null;
		String sql_AddRoom = "insert into roomtypeandprice(address, roomType, price, nums) values(?,?,?,?)";
		PreparedStatement pstmt_DeleteComments = null;
		String sql_DeleteComments = "delete from comments where hotelAddress = ?";
		PreparedStatement pstmt_AddComments = null;
		String sql_AddComments = "insert into comments(hotelAddress, clientName, comment) values(?,?,?)";
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			
			//更新酒店基本信息
			pstmt_Hotel = conn.prepareStatement(sql_Hotel);
			pstmt_Hotel.setString(1, po.getHotelName());
			pstmt_Hotel.setInt(2, po.getStarLevel());
			pstmt_Hotel.setFloat(3, po.getMark());
			pstmt_Hotel.setString(4, po.getBriefIntroduction());
			pstmt_Hotel.setString(5, po.getFacilityAndService());
			pstmt_Hotel.setString(6, po.getCity());
			pstmt_Hotel.setInt(7, po.getMin_Price());
			pstmt_Hotel.setInt(8, po.getMax_Price());
			pstmt_Hotel.setString(9, po.getHotelAddress());
			pstmt_Hotel.executeUpdate();
			
			//删除酒店原来所有的房间信息
			pstmt_DeleteRoom = conn.prepareStatement(sql_DeleteRoom);
			pstmt_DeleteRoom.setString(1, po.getHotelAddress());
			pstmt_DeleteRoom.executeUpdate();
			
			//增加酒店现有所有的房间信息
			pstmt_AddRoom = conn.prepareStatement(sql_AddRoom);
			HashMap<RoomType, Integer> roomTypeAndPrice = po.getRoomTypeAndPrice();
			HashMap<RoomType, Integer> roomTypeAndNums = po.getRoomTypeAndNums();
			Set<RoomType> roomTypes = roomTypeAndPrice.keySet();
			for(RoomType roomType : roomTypes) {
				pstmt_AddRoom.setString(1, po.getHotelAddress());
				pstmt_AddRoom.setInt(2, convertFromRoomTypeToInt(roomType));
				pstmt_AddRoom.setInt(3, roomTypeAndPrice.get(roomType));
				pstmt_AddRoom.setInt(4, roomTypeAndNums.get(roomType));
				pstmt_AddRoom.executeUpdate();
			}
			
			//删除酒店原来所有的评论
			pstmt_DeleteComments = conn.prepareStatement(sql_DeleteComments);
			pstmt_DeleteComments.setString(1, po.getHotelAddress());
			pstmt_DeleteComments.executeUpdate();
			
			//增加酒店现有所有的评论
			pstmt_AddComments = conn.prepareStatement(sql_AddComments);
			HashMap<String, String> comments = po.getComments();
			Set<String> clientNames = comments.keySet();
			for(String clientName : clientNames) {
				pstmt_AddComments.setString(1, po.getHotelAddress());
				pstmt_AddComments.setString(2, clientName);
				pstmt_AddComments.setString(3, comments.get(clientName));
				pstmt_AddComments.executeUpdate();
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBC_Connection.free(null, conn, pstmt_Hotel);
			JDBC_Connection.free(null, null, pstmt_DeleteRoom);
			JDBC_Connection.free(null, null, pstmt_AddRoom);
			JDBC_Connection.free(null, null, pstmt_DeleteComments);
			JDBC_Connection.free(null, null, pstmt_AddComments);
		}
	}

	@Override
	public boolean insertHotel(HotelPO po) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstm_Hotel = null;
		PreparedStatement pstm_Room = null;
		ResultSet rs = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//插入酒店信息
			String sql_Hotel = "insert into hotel(hotelName, tradeArea, hotelAddress, starLevel, mark, briefIntroduction, facilityAndService, city, min_Price) values(?,?,?,?,?,?,?,?,?)";
			pstm_Hotel = conn.prepareStatement(sql_Hotel);
			pstm_Hotel.setString(1, po.getHotelName());
			pstm_Hotel.setString(2, po.getTradeArea());
			pstm_Hotel.setString(3, po.getHotelAddress());
			pstm_Hotel.setInt(4, po.getStarLevel());
			pstm_Hotel.setFloat(5, po.getMark());
			pstm_Hotel.setString(6, po.getBriefIntroduction());
			pstm_Hotel.setString(7, po.getFacilityAndService());
			pstm_Hotel.setString(8, po.getCity());
			pstm_Hotel.setInt(9, po.getMin_Price());
			pstm_Hotel.executeUpdate();
			
			//插入酒店房间信息
			String sql_Room = "insert into roomtypeandprice(address, roomType, price, nums) values(?,?,?,?)";
			pstm_Room = conn.prepareStatement(sql_Room);
			HashMap<RoomType, Integer> roomTypeAndPrice = po.getRoomTypeAndPrice();
			HashMap<RoomType, Integer> roomTypeAndNums = po.getRoomTypeAndNums();
			Set<RoomType> roomTypes = roomTypeAndPrice.keySet();
			for(RoomType roomType : roomTypes) {
				pstm_Room.setString(1, po.getHotelAddress());
				pstm_Room.setInt(2, convertFromRoomTypeToInt(roomType));
				pstm_Room.setInt(3, roomTypeAndPrice.get(roomType));
				pstm_Room.setInt(4, roomTypeAndNums.get(roomType));
				pstm_Room.executeUpdate();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBC_Connection.free(rs, conn, pstm_Hotel);
			JDBC_Connection.free(rs, conn, pstm_Room);
		}
	}

	@Override
	public ArrayList<BusinessDistrictPO> getBusinessDistrictList(String city) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BusinessDistrictPO> businessDistrictPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from businessdistrict where city = ?");
			pstmt.setString(1, city);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefHotelInfoPO，并为其赋值
			while(rs.next()) {
				BusinessDistrictPO businessDistrictPO = new BusinessDistrictPO(rs.getString("businessDistrictName"), city);
				businessDistrictPOs.add(businessDistrictPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		return businessDistrictPOs;
	}

}
