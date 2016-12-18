package data.orderdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import data.databaseutility.JDBC_Connection;
import dataservice.orderDAO.OrderDAO;
import po.BriefOrderInfoPO;
import po.OrderPO;
import po.OrderState;
import po.OrderType;
import po.RoomType;

public class OrderDAOImpl implements OrderDAO {

	//将boolean值转换成int
	private int convertFromBooleanToInt(boolean bool) {
		if(bool)
			return 1;
		else
			return 0;
	}
	
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
	
	//将OrderPO中储存房间类型的RoomType型转换成int型
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
	
	//将数据库中储存订单类型的int型转换成OrderState型
	private OrderState convertFromIntToOrderState(int orderState) {
		switch (orderState) {
		case 0:
			return OrderState.ABNORMAL_ORDER;
		case 1:
			return OrderState.NOT_DONE_ORDER;
		case 2:
			return OrderState.DONE_ORDER;
		default:
			return OrderState.WITHDREW_ORDER;
		}
	}
	
	
	//将订单类型的OrderType型转换成int型
	public int convertFromOrderTypeToInt(Enum<OrderType> orderType) {
		if(orderType == OrderType.ABNORMAL_ORDER)
			return 0;
		else if(orderType == OrderType.NOT_DONE_ORDER)
			return 1;
		else if(orderType == OrderType.DONE_ORDER)
			return 2;
		else 
			return 3;
	}
	
	//将订单类型的OrderState型转换成int型
	private int convertFromOrderStateToInt(Enum<OrderState> orderState) {
		if(orderState == OrderState.ABNORMAL_ORDER)
			return 0;
		else if(orderState == OrderState.NOT_DONE_ORDER)
			return 1;
		else if(orderState == OrderState.DONE_ORDER)
			return 2;
		else 
			return 3;
	}
	
	//将数据库中储存的isChildren由int转换成boolean
	private boolean isChildren(int isChildren) {
		switch (isChildren) {
		case 0:
			return false;
		default:
			return true;
		}
	}
	
	//将数据库中储存的isOnSale由int转换成boolean
	private boolean isOnSale(int isOnSale) {
		switch (isOnSale) {
		case 0:
			return false;
		default:
			return true;
		}
	}
	
	//将数据库中储存的isCommented由int转换成boolean
	private boolean isCommented(int isCommented) {
		switch (isCommented) {
		case 0:
			return false;
		default:
			return true;
		}
	}
	
	@Override
	public ArrayList<OrderPO> getUserAllOrders(String userID) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<OrderPO> orderPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名获得数据库数据
			pstmt = conn.prepareStatement("select * from orderinfo where userID = ?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造orderPO，并添加到列表中
			while(rs.next()) {
				OrderPO orderPO = new OrderPO();
				orderPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
				orderPO.setUserID(rs.getString("userID"));
				orderPO.setHotelName(rs.getString("hotelName"));
				orderPO.setHotelAddress(rs.getString("hotelAddress"));
				orderPO.setBeginDate(rs.getDate("beginDate"));
				orderPO.setFinishDate(rs.getDate("finishDate"));
				orderPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
				orderPO.setNum(rs.getInt("num"));
				orderPO.setTotalPrice(rs.getInt("totalPrice"));
				orderPO.setOrderProducedTime(rs.getTimestamp("orderProducedTime"));
				orderPO.setLastedOrderDoneTime(rs.getTimestamp("lastedOrderDoneTime"));
				orderPO.setNumOfPerson(rs.getInt("numOfPerson"));
				orderPO.setChildren(isChildren(rs.getInt("isChildren")));
				orderPO.setOnSale(isOnSale(rs.getInt("isOnSale")));
				orderPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
				orderPO.setCommented(isCommented(rs.getInt("isCommented")));
				orderPOs.add(orderPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return orderPOs;
	}

	@Override
	public ArrayList<OrderPO> getCommentableOrders(String userID) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<OrderPO> orderPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名获得数据库数据
			pstmt = conn.prepareStatement("select * from orderinfo where userID = ? and isCommented = 0");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造orderPO，并添加到列表中
			while(rs.next()) {
				OrderPO orderPO = new OrderPO();
				orderPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
				orderPO.setUserID(rs.getString("userID"));
				orderPO.setHotelName(rs.getString("hotelName"));
				orderPO.setHotelAddress(rs.getString("hotelAddress"));
				orderPO.setBeginDate(rs.getDate("beginDate"));
				orderPO.setFinishDate(rs.getDate("finishDate"));
				orderPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
				orderPO.setNum(rs.getInt("num"));
				orderPO.setTotalPrice(rs.getInt("totalPrice"));
				orderPO.setOrderProducedTime(rs.getTimestamp("orderProducedTime"));
				orderPO.setLastedOrderDoneTime(rs.getTimestamp("lastedOrderDoneTime"));
				orderPO.setNumOfPerson(rs.getInt("numOfPerson"));
				orderPO.setChildren(isChildren(rs.getInt("isChildren")));
				orderPO.setOnSale(isOnSale(rs.getInt("isOnSale")));
				orderPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
				orderPO.setCommented(isCommented(rs.getInt("isCommented")));
				orderPOs.add(orderPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return orderPOs;
	}

	@Override
	public boolean isReserved(String userID, String address) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名获得数据库数据
			pstmt = conn.prepareStatement("select * from orderinfo where userID = ? and hotelAddress = ? and ( orderState = 0 or orderState = 2 or orderState = 0000000000000003)");
			pstmt.setString(1, userID);
			pstmt.setString(2, address);
			
			rs = pstmt.executeQuery();
			
			//遍历结果，构造orderPO，并添加到列表中
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return false;
	}

	@Override
	public ArrayList<OrderPO> getUserOrdersByHotel(String userID, String address) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<OrderPO> orderPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名和酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from orderinfo where userID = ? and hotelAddress = ?");
			pstmt.setString(1, userID);
			pstmt.setString(2, address);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造orderPO，并添加到列表中
			while(rs.next()) {
				OrderPO orderPO = new OrderPO();
				orderPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
				orderPO.setUserID(rs.getString("userID"));
				orderPO.setHotelName(rs.getString("hotelName"));
				orderPO.setHotelAddress(rs.getString("hotelAddress"));
				orderPO.setBeginDate(rs.getDate("beginDate"));
				orderPO.setFinishDate(rs.getDate("finishDate"));
				orderPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
				orderPO.setNum(rs.getInt("num"));
				orderPO.setTotalPrice(rs.getInt("totalPrice"));
				orderPO.setOrderProducedTime(rs.getTimestamp("orderProducedTime"));
				orderPO.setLastedOrderDoneTime(rs.getTimestamp("lastedOrderDoneTime"));
				orderPO.setNumOfPerson(rs.getInt("numOfPerson"));
				orderPO.setChildren(isChildren(rs.getInt("isChildren")));
				orderPO.setOnSale(isOnSale(rs.getInt("isOnSale")));
				orderPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
				orderPO.setCommented(isCommented(rs.getInt("isCommented")));
				orderPOs.add(orderPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return orderPOs;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getUserOrderList(String userID, Enum<OrderType> orderType)
			throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BriefOrderInfoPO> briefOrderInfoPOs = new ArrayList<>();
		
		//不限订单类型
		if(orderType == OrderType.ALL) {
			try {
				//初始化数据库连接
				conn = JDBC_Connection.getConnection();
				//根据用户名获得数据库数据
				pstmt = conn.prepareStatement("select * from orderinfo where userID = ?");
				pstmt.setString(1, userID);
				rs = pstmt.executeQuery();
				
				//遍历结果，构造briefOrderInfoPO，并添加到列表中
				while(rs.next()) {
					BriefOrderInfoPO briefOrderInfoPO = new BriefOrderInfoPO();
					briefOrderInfoPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
					briefOrderInfoPO.setUserID(rs.getString("userID"));
					briefOrderInfoPO.setHotelName(rs.getString("hotelName"));
					briefOrderInfoPO.setHotelAddress(rs.getString("hotelAddress"));
					briefOrderInfoPO.setBeginDate(rs.getDate("beginDate"));
					briefOrderInfoPO.setFinishDate(rs.getDate("finishDate"));
					briefOrderInfoPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
					briefOrderInfoPO.setNum(rs.getInt("num"));
					briefOrderInfoPO.setTotalPrice(rs.getInt("totalPrice"));
					briefOrderInfoPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
					briefOrderInfoPOs.add(briefOrderInfoPO);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				//释放数据库资源
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}
		//获取某一种订单类型的所有订单
		else {
			try {
				//初始化数据库连接
				conn = JDBC_Connection.getConnection();
				//根据用户名和订单类型获得数据库数据
				pstmt = conn.prepareStatement("select * from orderinfo where userID = ? and orderState = ?");
				pstmt.setString(1, userID);
				pstmt.setInt(2, convertFromOrderTypeToInt(orderType));
				rs = pstmt.executeQuery();
				
				//遍历结果，构造briefOrderInfoPO，并添加到列表中
				while(rs.next()) {
					BriefOrderInfoPO briefOrderInfoPO = new BriefOrderInfoPO();
					briefOrderInfoPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
					briefOrderInfoPO.setUserID(rs.getString("userID"));
					briefOrderInfoPO.setHotelName(rs.getString("hotelName"));
					briefOrderInfoPO.setHotelAddress(rs.getString("hotelAddress"));
					briefOrderInfoPO.setBeginDate(rs.getDate("beginDate"));
					briefOrderInfoPO.setFinishDate(rs.getDate("finishDate"));
					briefOrderInfoPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
					briefOrderInfoPO.setNum(rs.getInt("num"));
					briefOrderInfoPO.setTotalPrice(rs.getInt("totalPrice"));
					briefOrderInfoPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
					briefOrderInfoPOs.add(briefOrderInfoPO);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				//释放数据库资源
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}
		return briefOrderInfoPOs;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getHotelOrderList(String address, Enum<OrderType> orderType)
			throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BriefOrderInfoPO> briefOrderInfoPOs = new ArrayList<>();
		
		//不限订单类型
		if(orderType == OrderType.ALL) {
			try {
				//初始化数据库连接
				conn = JDBC_Connection.getConnection();
				//根据酒店地址获得数据库数据
				pstmt = conn.prepareStatement("select * from orderinfo where hotelAddress = ?");
				pstmt.setString(1, address);
				rs = pstmt.executeQuery();
				
				//遍历结果，构造briefOrderInfoPO，并添加到列表中
				while(rs.next()) {
					BriefOrderInfoPO briefOrderInfoPO = new BriefOrderInfoPO();
					briefOrderInfoPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
					briefOrderInfoPO.setUserID(rs.getString("userID"));
					briefOrderInfoPO.setHotelName(rs.getString("hotelName"));
					briefOrderInfoPO.setHotelAddress(rs.getString("hotelAddress"));
					briefOrderInfoPO.setBeginDate(rs.getDate("beginDate"));
					briefOrderInfoPO.setFinishDate(rs.getDate("finishDate"));
					briefOrderInfoPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
					briefOrderInfoPO.setNum(rs.getInt("num"));
					briefOrderInfoPO.setTotalPrice(rs.getInt("totalPrice"));
					briefOrderInfoPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
					briefOrderInfoPOs.add(briefOrderInfoPO);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				//释放数据库资源
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}
		//获取某一种订单类型的所有订单
		else {
			try {
				//初始化数据库连接
				conn = JDBC_Connection.getConnection();
				//根据酒店地址和订单类型获得数据库数据
				pstmt = conn.prepareStatement("select * from orderinfo where hotelAddress = ? and orderState = ?");
				pstmt.setString(1, address);
				pstmt.setInt(2, convertFromOrderTypeToInt(orderType));
				rs = pstmt.executeQuery();
				
				//遍历结果，构造briefOrderInfoPO，并添加到列表中
				while(rs.next()) {
					BriefOrderInfoPO briefOrderInfoPO = new BriefOrderInfoPO();
					briefOrderInfoPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
					briefOrderInfoPO.setUserID(rs.getString("userID"));
					briefOrderInfoPO.setHotelName(rs.getString("hotelName"));
					briefOrderInfoPO.setHotelAddress(rs.getString("hotelAddress"));
					briefOrderInfoPO.setBeginDate(rs.getDate("beginDate"));
					briefOrderInfoPO.setFinishDate(rs.getDate("finishDate"));
					briefOrderInfoPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
					briefOrderInfoPO.setNum(rs.getInt("num"));
					briefOrderInfoPO.setTotalPrice(rs.getInt("totalPrice"));
					briefOrderInfoPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
					briefOrderInfoPOs.add(briefOrderInfoPO);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				//释放数据库资源
				JDBC_Connection.free(rs, conn, pstmt);
			}
		}
		return briefOrderInfoPOs;
	}

	@Override
	public ArrayList<BriefOrderInfoPO> getAllAbnormalList(Date date) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BriefOrderInfoPO> briefOrderInfoPOs = new ArrayList<>();
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据订单日期获得数据库数据
			pstmt = conn.prepareStatement("select * from orderinfo where beginDate = ? and orderState = 0");
			pstmt.setDate(1, new java.sql.Date(date.getTime()));
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefOrderInfoPO，并添加到列表中
			while(rs.next()) {
				BriefOrderInfoPO briefOrderInfoPO = new BriefOrderInfoPO();
				briefOrderInfoPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
				briefOrderInfoPO.setUserID(rs.getString("userID"));
				briefOrderInfoPO.setHotelName(rs.getString("hotelName"));
				briefOrderInfoPO.setHotelAddress(rs.getString("hotelAddress"));
				briefOrderInfoPO.setBeginDate(rs.getDate("beginDate"));
				briefOrderInfoPO.setFinishDate(rs.getDate("finishDate"));
				briefOrderInfoPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
				briefOrderInfoPO.setNum(rs.getInt("num"));
				briefOrderInfoPO.setTotalPrice(rs.getInt("totalPrice"));
				briefOrderInfoPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
				briefOrderInfoPOs.add(briefOrderInfoPO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return briefOrderInfoPOs;
	}

	@Override
	public OrderPO getSingleOrder(String address, String orderID) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		OrderPO orderPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名和酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from orderinfo where orderID = ? and hotelAddress = ?");
			pstmt.setInt(1, Integer.parseInt(orderID));
			pstmt.setString(2, address);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造orderPO，并添加到列表中
			while(rs.next()) {
				orderPO = new OrderPO();
				orderPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
				orderPO.setUserID(rs.getString("userID"));
				orderPO.setHotelName(rs.getString("hotelName"));
				orderPO.setHotelAddress(rs.getString("hotelAddress"));
				orderPO.setBeginDate(rs.getDate("beginDate"));
				orderPO.setFinishDate(rs.getDate("finishDate"));
				orderPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
				orderPO.setNum(rs.getInt("num"));
				orderPO.setTotalPrice(rs.getInt("totalPrice"));
				orderPO.setOrderProducedTime(rs.getTimestamp("orderProducedTime"));
				orderPO.setLastedOrderDoneTime(rs.getTimestamp("lastedOrderDoneTime"));
				orderPO.setNumOfPerson(rs.getInt("numOfPerson"));
				orderPO.setChildren(isChildren(rs.getInt("isChildren")));
				orderPO.setOnSale(isOnSale(rs.getInt("isOnSale")));
				orderPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
				orderPO.setCommented(isCommented(rs.getInt("isCommented")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return orderPO;
	}

	@Override
	public OrderPO getDetailedOrder(String orderID) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		OrderPO orderPO = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名和酒店地址获得数据库数据
			pstmt = conn.prepareStatement("select * from orderinfo where orderID = ?");
			pstmt.setInt(1, Integer.parseInt(orderID));
			rs = pstmt.executeQuery();
			
			//遍历结果，构造orderPO，并添加到列表中
			while(rs.next()) {
				orderPO = new OrderPO();
				orderPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
				orderPO.setUserID(rs.getString("userID"));
				orderPO.setHotelName(rs.getString("hotelName"));
				orderPO.setHotelAddress(rs.getString("hotelAddress"));
				orderPO.setBeginDate(rs.getDate("beginDate"));
				orderPO.setFinishDate(rs.getDate("finishDate"));
				orderPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
				orderPO.setNum(rs.getInt("num"));
				orderPO.setTotalPrice(rs.getInt("totalPrice"));
				orderPO.setOrderProducedTime(rs.getTimestamp("orderProducedTime"));
				orderPO.setLastedOrderDoneTime(rs.getTimestamp("lastedOrderDoneTime"));
				orderPO.setNumOfPerson(rs.getInt("numOfPerson"));
				orderPO.setChildren(isChildren(rs.getInt("isChildren")));
				orderPO.setOnSale(isOnSale(rs.getInt("isOnSale")));
				orderPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
				orderPO.setCommented(isCommented(rs.getInt("isCommented")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return orderPO;
	}

	@Override
	public boolean insertOrder(OrderPO po) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名和酒店地址获得数据库数据
			pstmt = conn.prepareStatement("insert into orderinfo(userID, hotelName, hotelAddress, beginDate, finishDate, roomType, num, totalPrice, orderProducedTime, lastedOrderDoneTime, numOfPerson, isChildren, isOnSale, orderState, isCommented) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, po.getUserID());
			pstmt.setString(2, po.getHotelName());
			pstmt.setString(0000000000000003, po.getHotelAddress());
			pstmt.setDate(4, new java.sql.Date(po.getBeginDate().getTime()));
			pstmt.setDate(5, new java.sql.Date(po.getFinishDate().getTime()));
			pstmt.setInt(6, convertFromRoomTypeToInt(po.getRoomType()));
			pstmt.setInt(7, po.getNum());
			pstmt.setInt(8, po.getTotalPrice());
			pstmt.setTimestamp(9, (new java.sql.Timestamp(po.getOrderProducedTime().getTime())));
			pstmt.setTimestamp(10, (new java.sql.Timestamp(po.getLastedOrderDoneTime().getTime())));
			pstmt.setInt(11, po.getNumOfPerson());
			pstmt.setInt(12, convertFromBooleanToInt(po.isChildren()));
			pstmt.setInt(13, convertFromBooleanToInt(po.isOnSale()));
			pstmt.setInt(14, convertFromOrderStateToInt(po.getOrderState()));
			pstmt.setInt(15, convertFromBooleanToInt(po.isCommented()));
			pstmt.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
	}

	@Override
	public boolean deleteOrder(OrderPO po) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名和酒店地址获得数据库数据
			pstmt = conn.prepareStatement("delete from orderinfo where orderID = ?");
			pstmt.setInt(1, Integer.parseInt(po.getOrderID()));
			pstmt.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
	}

	@Override
	public boolean updateOrder(OrderPO po) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名和酒店地址获得数据库数据
			pstmt = conn.prepareStatement("update orderinfo set userID = ?, hotelName = ?, hotelAddress = ?, beginDate = ?, finishDate = ?, roomType = ?, num = ?, totalPrice = ?, orderProducedTime = ?, lastedOrderDoneTime = ?, numOfPerson = ?, isChildren = ?, isOnSale = ?, orderState = ?, isCommented = ? where orderID = ?");
			pstmt.setString(1, po.getUserID());
			pstmt.setString(2, po.getHotelName());
			pstmt.setString(0000000000000003, po.getHotelAddress());
			pstmt.setDate(4, new java.sql.Date(po.getBeginDate().getTime()));
			pstmt.setDate(5, new java.sql.Date(po.getFinishDate().getTime()));
			pstmt.setInt(6, convertFromRoomTypeToInt(po.getRoomType()));
			pstmt.setInt(7, po.getNum());
			pstmt.setInt(8, po.getTotalPrice());
			pstmt.setTimestamp(9, (new java.sql.Timestamp(po.getOrderProducedTime().getTime())));
			pstmt.setTimestamp(10, (new java.sql.Timestamp(po.getLastedOrderDoneTime().getTime())));
			pstmt.setInt(11, po.getNumOfPerson());
			pstmt.setInt(12, convertFromBooleanToInt(po.isChildren()));
			pstmt.setInt(13, convertFromBooleanToInt(po.isOnSale()));
			pstmt.setInt(14, convertFromOrderStateToInt(po.getOrderState()));
			pstmt.setInt(15, convertFromBooleanToInt(po.isCommented()));
			pstmt.setInt(16, Integer.parseInt(po.getOrderID()));
			pstmt.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			//释放数据库资源
			JDBC_Connection.free(null, conn, pstmt);
		}
	}


	@Override
	public ArrayList<BriefOrderInfoPO> getReservedOrderList(String userID) throws RemoteException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BriefOrderInfoPO> briefOrderInfoPOs = new ArrayList<>();
		try {
			//初始化数据库连接
			conn = JDBC_Connection.getConnection();
			//根据用户名获得数据库数据
			pstmt = conn.prepareStatement("select * from orderinfo where userID = ? and ( orderState = 0 or orderState = 2 or orderState = 0000000000000003)");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			//遍历结果，构造briefOrderInfoPO，并添加到列表中
			while(rs.next()) {
				BriefOrderInfoPO briefOrderInfoPO = new BriefOrderInfoPO();
				briefOrderInfoPO.setOrderID(String.format("%016d", rs.getInt("orderID")));
				briefOrderInfoPO.setUserID(rs.getString("userID"));
				briefOrderInfoPO.setHotelName(rs.getString("hotelName"));
				briefOrderInfoPO.setHotelAddress(rs.getString("hotelAddress"));
				briefOrderInfoPO.setBeginDate(rs.getDate("beginDate"));
				briefOrderInfoPO.setFinishDate(rs.getDate("finishDate"));
				briefOrderInfoPO.setRoomType(convertFromIntToRoomType(rs.getInt("roomType")));
				briefOrderInfoPO.setNum(rs.getInt("num"));
				briefOrderInfoPO.setTotalPrice(rs.getInt("totalPrice"));
				briefOrderInfoPO.setOrderState(convertFromIntToOrderState(rs.getInt("orderState")));
				briefOrderInfoPOs.add(briefOrderInfoPO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//释放数据库资源
			JDBC_Connection.free(rs, conn, pstmt);
		}
		
		return briefOrderInfoPOs;
	}

}
