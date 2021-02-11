package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.memberDAO;
import com.DTO.memberDTO;

@WebServlet("/joinService")
public class joinService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 2.�� �޾��ֱ�

		request.setCharacterEncoding("EUC-KR");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("address");
		int cnt = 0;
		memberDAO dao = new memberDAO();

		// 3. ������ ���̽� ����

		// 3-1. DAO ��ü ����
		// 3-2. DAO joinMember() �޼ҵ� ȣ��
		// 3-3. ��ȯ��(��� ���ڵ忡�� ��ȭ�� �Ͼ����)�� �޾Ƽ� �� ����
		// 0�ʰ��̸��� �ܼ�â�� "���Լ���"��� �ƴϸ� "���� ����"
		// email �ߺ� ���� �����غ���?

		// ��0��° ȸ�������� �̸��ϰ��� �ֿܼ� ���
		// System.out.print(arr.get(0).getEmail());

		cnt = dao.joinMember(email, pw, tel, addr);

		System.out.println(cnt);

		if (cnt > 0) {
			System.out.println("���� ����");
			// ������ �̵� ���
			// 1. �����̷���(sendRedirect())
			// Ŭ���̾�Ʈ�� ������ �̵� ��û�� �������� url�� ���� �� �ٽ� ������ url�� ��û �� ����
			// ��û ��ü�� ���� ��ü�� ���� �������� �ʴ´�.
			// 2. ������(forward())
			// ��û ��ü�� ���� ��ü�� �����Ѵ�
			request.setAttribute("joinemail", email);
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
			rd.forward(request, response);

		} else {
			response.sendRedirect("join_fail.jsp");
		}

	}
}
