package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.DTO.MessageDTO;
import com.DTO.memberDTO;

public class messageDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	memberDAO dao = new memberDAO();

	// sql - insert into web_message values(num_message.nextval,?,?,?,sysdate)

	public int insertMessage(MessageDTO dto) {
		// 반환값 : 몇개의 레코드가 삽입되었는지

		int cnt = 0;

		try {
			dao.connect();

			String sql = "insert into web_message values(num_message.nextval,?,?,?,sysdate)";

			ps = dao.conn.prepareStatement(sql);

			ps.setString(1, dto.getSendemail());
			ps.setString(2, dto.getReceiveemail());
			ps.setString(3, dto.getMessage());

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.close();
		}

		return cnt;
	}

	public ArrayList<MessageDTO> selectMessage(String email) {

		ArrayList<MessageDTO> adto = new ArrayList<MessageDTO>();
		int num = 0;
		String get_sendemail = null;
		String get_receiveemail = null;
		String get_message = null;
		MessageDTO dto = null;
		String get_date = null;

		try {
			dao.connect();

			String sql = "select * from web_message where receiveEmail=?";

			ps = dao.conn.prepareStatement(sql);

			ps.setString(1, email);

			rs = ps.executeQuery();

			while (rs.next()) {
				num = rs.getInt("num");
				get_sendemail = rs.getString("sendname");
				get_receiveemail = rs.getString("receiveEmail");
				get_message = rs.getString("message");
				get_date = rs.getString("m_date");

				dto = new MessageDTO(num, get_sendemail, get_receiveemail, get_message, get_date);

				adto.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.close();
		}

		return adto;
	}

	public int deleteMessage(memberDTO dto) {

		int cnt = 0;

		try {
			dao.connect();

			String sql = "delete from web_message where receiveEmail=?";

			ps = dao.conn.prepareStatement(sql);

			ps.setString(1, dto.getEmail());

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cnt;

	}
}
