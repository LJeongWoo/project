package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.memberDAO;

@WebServlet("/deleteService")
public class deletService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");

		String email = request.getParameter("email");

		memberDAO dao = new memberDAO();

		int cnt = dao.deleteMember(email);

		if (cnt > 0) {
			System.out.println("삭제 성공");
			response.sendRedirect("select.jsp");
		} else {
			System.out.println("삭제 실패");
		}

	}

}
