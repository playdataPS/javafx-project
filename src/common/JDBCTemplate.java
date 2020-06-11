package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

////// Connection & Close & Commit & rollback  4媛쒕쭔 user媛� �젣�뼱�븷 �닔 �엳寃� 留뚮뱾�뼱�몺
public class JDBCTemplate {
	// �뿰寃고븳 �긽�깭濡� 由ы꽩�빐二쇨쿋�떎.
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@192.168.0.249:1521:XE";
		String id = "sminifx";
		String pwd = "admin1234";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// �뿰寃� 媛앹껜瑜� 諛쏆븘�꽌(�뿰寃고븳 �긽�깭瑜�) close()�븯寃좊떎.
	public static void Close(Connection con) {
		try {
			if (!con.isClosed() && con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Commit(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Rollback(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
