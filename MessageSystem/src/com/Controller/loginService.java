package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.memberDAO;
import com.DTO.memberDTO;


@WebServlet("/loginService")
public class loginService extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 값 받아주기
		request.setCharacterEncoding("EUC-KR");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		
		
		//데이터베이스 연동
		//dao객체 생성
		//loginMember 호출
		
		memberDAO dao = new memberDAO();
		
		memberDTO dto = dao.loginMember(email, pw);
		//반환값은 전화번호 		
		//반환 되는 번호가 있을 경우 콘솔창에 전화번호 출력
		//안되면 로그인 실패 콘솔창에 출력
		
		if(dto !=null) {
			
			System.out.println("로그인 성공");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("member", dto);
			
			response.sendRedirect("main.jsp");
			
		}else {
			System.out.println("로그인실패");
			
			response.sendRedirect("main.jsp");
		}
		
		
	}

}
