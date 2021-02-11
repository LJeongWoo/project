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
		// 2.값 받아주기

		request.setCharacterEncoding("EUC-KR");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("address");
		int cnt = 0;
		memberDAO dao = new memberDAO();

		// 3. 데이터 베이스 연동

		// 3-1. DAO 객체 생성
		// 3-2. DAO joinMember() 메소드 호출
		// 3-3. 반환값(몇개의 레코드에서 변화가 일어났는지)을 받아서 그 값이
		// 0초과이면은 콘솔창에 "가입성공"출력 아니면 "가입 실패"
		// email 중복 없이 가입해보기?

		// ㅐ0번째 회원정보중 이메일값만 콘솔에 출력
		// System.out.print(arr.get(0).getEmail());

		cnt = dao.joinMember(email, pw, tel, addr);

		System.out.println(cnt);

		if (cnt > 0) {
			System.out.println("가입 성공");
			// 페이지 이동 방식
			// 1. 리다이렉팅(sendRedirect())
			// 클라이언트가 페이지 이동 요청시 서버에서 url를 응답 후 다시 서버로 url를 요청 후 응답
			// 요청 객체와 응답 객체가 서로 공유하지 않는다.
			// 2. 포워딩(forward())
			// 요청 객체와 응답 객체를 공유한다
			request.setAttribute("joinemail", email);
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
			rd.forward(request, response);

		} else {
			response.sendRedirect("join_fail.jsp");
		}

	}
}
