package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션으로 url을 설정하면 .xml 파일에서 설정하지 않더라도 실행 가능하다.
@WebServlet("/add") //response()
public class add extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //사용자에게 보내는 인코딩 방식 설정 
		response.setContentType("text/html; charset=UTF-8"); //브라우저에게 이대로 해석해라
//		request.setCharacterEncoding("UTF-8"); //사용자에게 입력 받는 값의 인코딩 설정
		
		PrintWriter out = response.getWriter();
		
		String x_ = request.getParameter("x");  
		String y_ = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(!x_.equals("")) { //사용자에게 입력 받은 값을 조건검사, 만약 x 값이 ""(공백)이 아니라면
			if(y_.equals("")) { //만약 y 값이 ""(공백)이라면 
				out.println("y 값을 입력해주세요");
			}else { //조건에 맞다면 정수형으로 변환해서 결과 출력
				x = Integer.parseInt(x_);
				y = Integer.parseInt(y_);
				
				int result = 0;
				result = x+y;
				
				out.println("계산 결과는 "+result+"입니다");

			}
		}else if(!y_.equals("")){ //26행 조건을 만족하지 않고 y 값이 ""(공백) 이 아니라면
			out.println("x 값을 입력해주세요");			
		}else { // 26행, 37행 조건을 다 만족하지 않는다면 --> x, y 둘 다 공백이라면
			out.println("값을 입력해주세요");
		}
		
		
	
	}
}







