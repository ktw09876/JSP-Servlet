package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션으로 url을 설정하면 .xml 파일에서 설정하지 않더라도 실행 가능하다.
@WebServlet("/notice-reg") //response()
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //사용자에게 보내는 인코딩 방식 설정 
		response.setContentType("text/html; charset=UTF-8"); //브라우저에게 이대로 해석해라
//		request.setCharacterEncoding("UTF-8"); //사용자에게 입력 받는 값의 인코딩 설정
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title"); //사용자에게 입력 받은 값 cnt를 cnt_(임시변수) 에 대입 
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
		
	}
}







