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
		//1. �� �޾ƿ���
		HttpSession session = request.getSession();
		memberDTO dto = (memberDTO)session.getAttribute("member");
		String email = dto.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		
		memberDTO dto1 = new memberDTO(email, pw, tel, address);
		//2. ��� �ּ� ����
		//3. dao ��ü ����
		
		memberDAO dao = new memberDAO();
		
		// updateMember()�޼ҵ� ȣ��
		// ��ȯ��(-> ���̺�󿡼� ��ȭ�� �Ͼ ���ڵ� ��)
		
		int cnt = dao.updateMember(dto1);
			
		//��ȯ���� 0���� ũ�� �ܼ�â�� "��������"
		// �ȵǸ� "���� ����" ���
		
		
		
		if(cnt>0) {
			System.out.println("��������");
			
			memberDTO dto2 = dao.loginMember(email, pw);
					
			
			//session = request.getSession();			
			session.setAttribute("member", dto2);															
			response.sendRedirect("main.jsp");
										
		}else {
			System.out.println("��������");
		}						
	}
}
