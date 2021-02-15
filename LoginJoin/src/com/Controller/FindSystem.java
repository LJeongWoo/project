package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.memberDAO;
import com.DTO.memberDTO;


@WebServlet("/AddFind")
public class FindSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		String Email = request.getParameter(Email);
		String Id = request.getParameter(Id);
		String Nick = request.getParameter(Nick);
	
		
		memberDAO dao = new memberDAO();
		
		memberDTO dto = dao.FindSystem(Email, Id, Nick);
				
		
		if(dto!=null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("members", dto);
			
			response.sendRedirect("https://www.google.co.kr/maps/search/주변+"+dto.getAddress()+"+상담센터");
		}else {
			response.sendRedirect("erro.jsp");
		}
		
		
		
		
	}

}
