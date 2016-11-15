package data.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {
	static String drivername = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
	static String username = "root";
	static String password = "ty13655258245.";
	static {
		try {
			Class.forName(drivername);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("连接数据库成功");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void free(ResultSet rs, Connection conn, Statement stmt) {
		try {
			if(rs != null)
				rs.close();
		} catch(SQLException e) {
			System.out.println("关闭ResultSet失败!");
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch(SQLException e) {
				System.out.println("关闭Connection失败！");
				e.printStackTrace();
			} finally {
				try {
					if(stmt != null)
						stmt.close();
				} catch(SQLException e) {
					System.out.println("关闭Statement失败！");
					e.printStackTrace();
				}
			}
		}
	}
}
