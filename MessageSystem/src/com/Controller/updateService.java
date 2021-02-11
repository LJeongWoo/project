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


@WebServlet("/updateService")
public class updateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 값 받아오기
		HttpSession session = request.getSession();
		memberDTO dto = (memberDTO)session.getAttribute("member");
		String email = dto.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		
		memberDTO dto1 = new memberDTO(email, pw, tel, address);
		//2. 모든 주소 수정
		//3. dao 객체 생성
		
		memberDAO dao = new memberDAO();
		
		// updateMember()메소드 호출
		// 반환값(-> 테이블상에서 변화가 일어난 레코드 수)
		
		int cnt = dao.updateMember(dto1);
			
		//반환값이 0보다 크면 콘솔창에 "수정성공"
		// 안되면 "수정 실패" 출력
		
		
		
		if(cnt>0) {
			System.out.println("수정성공");
			
			memberDTO dto2 = dao.loginMember(email, pw);
					
			
			//session = request.getSession();			
			session.setAttribute("member", dto2);															
			response.sendRedirect("main.jsp");
										
		}else {
			System.out.println("수정실패");
		}						
	}
}
