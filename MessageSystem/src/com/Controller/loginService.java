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
		//����ڰ� �Է��� �� �޾��ֱ�
		request.setCharacterEncoding("EUC-KR");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		
		
		//�����ͺ��̽� ����
		//dao��ü ����
		//loginMember ȣ��
		
		memberDAO dao = new memberDAO();
		
		memberDTO dto = dao.loginMember(email, pw);
		//��ȯ���� ��ȭ��ȣ 		
		//��ȯ �Ǵ� ��ȣ�� ���� ��� �ܼ�â�� ��ȭ��ȣ ���
		//�ȵǸ� �α��� ���� �ܼ�â�� ���
		
		if(dto !=null) {
			
			System.out.println("�α��� ����");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("member", dto);
			
			response.sendRedirect("main.jsp");
			
		}else {
			System.out.println("�α��ν���");
			
			response.sendRedirect("main.jsp");
		}
		
		
	}

}
