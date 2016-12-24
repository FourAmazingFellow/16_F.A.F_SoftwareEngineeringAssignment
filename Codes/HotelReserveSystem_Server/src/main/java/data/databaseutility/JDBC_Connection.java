package data.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {
	//数据库连接所需要的数据
	private static String drivername = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/reserveHotel?useSSL=false";
	private static String username = "root";
	private static String password = "ty13655258245.";
	static {
		try {
			Class.forName(drivername);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 与数据库建立连接
	 * @return
	 * @see
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 执行数据库资源的释放操作
	 * @param rs
	 * @param conn
	 * @param stmt
	 * @see
	 */
	public static void free(ResultSet rs, Connection conn, Statement stmt) {
		try {
			if(rs != null)
				rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(stmt != null)
						stmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void freeResultSetAndStatement(ResultSet rs, Statement statement) {
		try {
			if(rs != null)
				rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
