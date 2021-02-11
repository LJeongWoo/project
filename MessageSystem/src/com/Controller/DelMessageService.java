package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.messageDAO;
import com.DTO.memberDTO;

@WebServlet("/DelMessageService")
public class DelMessageService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cnt = 0;

		HttpSession session = request.getSession();

		memberDTO dto = (memberDTO) session.getAttribute("member");

		messageDAO dao = new messageDAO();
		
		cnt=dao.deleteMessage(dto);
		
	
		
		if (cnt > 0) {
			System.out.println("삭제 성공");
			response.sendRedirect("main.jsp");
		} else {
			System.out.println("삭제실패");
			response.sendRedirect("main.jsp");
		}

	}

}
