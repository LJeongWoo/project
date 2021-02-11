package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.memberDAO;


@WebServlet("/idCheckService")
public class idCheckService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		//System.out.println("사용자가 입력한 값 : "+email);
		
		memberDAO dao = new memberDAO();
		
		boolean check=dao.idCheck(email);
		
		PrintWriter out = response.getWriter();
		
		out.print(check);
	}

}
