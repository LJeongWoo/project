package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DTO.memberDTO;

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

	public memberDTO FindSystem(String Email, String Id, String Nick) {
		
		String get_Email = null;
		String get_Id = null;
		String get_Address = null;
		String get_Nick = null;
		memberDTO dto = null;
		
		try {
			connect();

			String sql = "select * from members where Email=? and Id=? and Nick=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, Email);
			ps.setString(2, Id);
			ps.setString(3, Nick);

			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				get_Email = rs.getString("Email");
				get_Id = rs.getString("Id");
				get_Address = rs.getString("Address");
				get_Nick = rs.getString("Nick");
				
				dto = new memberDTO(get_Email, get_Id, get_Nick, get_Address);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}return dto;

	}
}
