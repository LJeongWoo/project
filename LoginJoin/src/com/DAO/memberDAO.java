package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class memberDAO {
	Connection conn;
	ResultSet rs;
	PreparedStatement ps;
		
public void connect() {	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "hr";
		String db_pw = "hr";

		conn = DriverManager.getConnection(db_url, db_id, db_pw);

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void close() {
	try {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	
}
