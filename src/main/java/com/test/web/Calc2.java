package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션으로 url을 설정하면 .xml 파일에서 설정하지 않더라도 실행 가능하다.
@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext(); //application 객체 생성
		
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
			
			int x = (Integer)application.getAttribute("value"); //value로 저장하고있던 값을 형변환해서 대입
			int y = v; //두번째 입력 받은 값
			String operator = (String)application.getAttribute("op");
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			out.println("계산 결과는 "+result+"입니다");
		}else { //값을 저장
			application.setAttribute("value", v); //31행에거 v 로 대입했던 값을 value 로 저장
			application.setAttribute("op", op);
		}
		
			
		
		}
	}
}







