package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.messageDAO;
import com.DTO.MessageDTO;

@WebServlet("/MessageSerivce")
public class MessageSerivce extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//값 받아오기(3개)
		int cnt=0;
		
		request.setCharacterEncoding("EUC-KR");
		
		String sendemail = request.getParameter("sendemail");
		String receiveemail = request.getParameter("receiveemail");
		String message = request.getParameter("message");
				
		//MessageDTO -보내는사람, 받는 사람, 메세지
		MessageDTO dto = new MessageDTO(sendemail, receiveemail, message);
		
		//MessageDAO - insertMessage()
		messageDAO dao = new messageDAO();
		
		
		cnt=dao.insertMessage(dto);
		
		if(cnt>0) {
			System.out.println("전송성공");
			
			response.sendRedirect("main.jsp");			
		}else {
			System.out.println("전송실패");
			
			response.sendRedirect("main.jsp");			
		}
		
			
		
	}

}
