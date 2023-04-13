package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//어노테이션으로 url을 설정하면 .xml 파일에서 설정하지 않더라도 실행 가능하다.
@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext(); //application 객체 생성
		HttpSession session = request.getSession();//session 객체 생성
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8"); //사용자에게 보내는 인코딩 방식 설정 
		response.setContentType("text/html; charset=UTF-8"); //브라우저에게 이대로 해석해라
		
		PrintWriter out = response.getWriter();
		
		String v_ = request.getParameter("v"); //사용자에게 입력 받은 값을 저장
		String op = request.getParameter("operator"); //사용자에게 입력 받은 연산자를 저장
		
		int v = 0;
		
		if(!v_.equals("")) { //사용자에게 입력 받은 값을 조건검사, 만약 v_ 값이 ""(공백)이 아니라면
			v = Integer.parseInt(v_);
		
		//계산
		if(op.equals("=")) {
			
//			int x = (Integer)application.getAttribute("value"); //value로 저장하고있던 값을 형변환해서 대입
//			int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) 
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			
			
			
			int y = v; //두번째 입력 받은 값
//			String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			
			String operator = "";
			for(Cookie c : cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			out.println("계산 결과는 "+result+"입니다");
		}else { //값을 저장
//			application.setAttribute("value", v); //v 로 대입했던 값을 value 로 저장
//			application.setAttribute("op", op);
			
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2"); //모든 url에 이 쿠키를 가져와라
			valueCookie.setMaxAge(24*60*60); //만료날짜 설정, 초 단위가 기본, valueCookie 는 쿠키가 24시간 유지 된다
			opCookie.setPath("/calc2"); //opCookie 는 만료시간을 설정하지 않았기 때문에 브라우저를 닫으면 즉시 만료된다
			
			response.addCookie(valueCookie);//클라이언트에게 보냄
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html"); //calc2 페이지로 전환
		}
		
			
		
		}
	}
}







