package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션으로 url을 설정하면 .xml 파일에서 설정하지 않더라도 실행 가능하다.
@WebServlet("/hi") //response("hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //사용자에게 보내는 인코딩 방식 설정 
		response.setContentType("text/html; charset=UTF-8"); //브라우저에게 이대로 해석해라
		
		PrintWriter out = response.getWriter();
		
		String cnt_ = request.getParameter("cnt"); //사용자에게 입력 받은 값 cnt를 cnt_(임시변수) 에 대입 
		
		int cnt = 100; //int 타입 cnt 의 기본값은 100 사용자에게 입력 받은 값이 null or "" 인 경우 에러가 나지 않도록 하기 위해 기본값을 설정 
		//26행 데
		if(cnt_ != null && !cnt_.equals("")) //만약 사용자에게 넘겨 받은 정보가 null 또는 "" 이 아니면(값이 있다면)
			cnt = Integer.parseInt(cnt_); //cnt_ 로 요청 받은 값을 정수형으로 형변환해서 cnt 변수에 대입 
		
		for(int i = 0; i<cnt; i++) // 0 부터 요청 받은 cnt 만큼 i 반복
		{
			out.println((i+1)+":안녕 servlet <br >");
		}
	}
}







