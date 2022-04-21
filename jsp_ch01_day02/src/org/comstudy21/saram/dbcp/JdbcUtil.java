package org.comstudy21.saram.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.saram.model.SaramDto;

public class JdbcUtil {
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String user = "comstudy22";
	static String password = "comstudy22";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �˻� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(conn);
	}
}
