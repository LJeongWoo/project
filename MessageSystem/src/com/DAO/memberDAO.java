package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.memberDTO;

public class memberDAO {
	// DB¿¬°á

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

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
	
	public int joinMember(String email, String pw, String tel, String address) {
		int cnt = 0;

		try {
			connect();
			String sql = "INSERT INTO web_member VALUES(?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, pw);
			ps.setString(3, tel);
			ps.setString(4, address);

			cnt = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
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
		return cnt;
	}

	public memberDTO loginMember(String email, String pw) {
		String get_email = null;
		String get_pw = null;
		String get_address = null;
		String get_tel = null;
		memberDTO dto = null;
		try {
			connect();
			String sql = "select * from web_member where email=? and pw=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, pw);

			rs = ps.executeQuery();

			if (rs.next()) {
				get_email = rs.getString("email");
				get_pw = rs.getString("pw");
				get_address = rs.getString("address");
				get_tel = rs.getString("tel");

				dto = new memberDTO(get_email, get_pw, get_tel, get_address);

			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();

		}
		return dto;

	}

	public int updateMember(memberDTO dto) {
		int cnt = 0;
		try {
			connect();
			String sql = "update web_member set pw=?,tel=?,address=? where email=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getTel());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getEmail());

			cnt = ps.executeUpdate();

		} catch (SQLException e) {

		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

			}
		}
		return cnt;
	}

	public ArrayList<memberDTO> selectMember() {
		String get_email = null;
		String get_address = null;
		String get_tel = null;
		memberDTO dto = null;
		ArrayList<memberDTO> arr = new ArrayList<memberDTO>();
		try {
			connect();

			String sql = "select * from web_member where email != 'admin'";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				get_email = rs.getString("email");
				get_address = rs.getString("address");
				get_tel = rs.getString("tel");

				dto = new memberDTO(get_email, get_tel, get_address);

				arr.add(dto);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();

		}

		return arr;

	}

	public int deleteMember(String email) {
		
		int cnt = 0;
		
		try {
			connect();
			
			String sql = "delete from web_member where email=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,email);
			
			cnt=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();

		}return cnt;
				
		
	}

	public boolean idCheck(String email) {
		
		boolean check = true;
		
		try {
			
			connect();
			
			String sql = "select * from web_member where email=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,email);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				check=true;
			}else {
				check=false;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return check;
		
	}

}
