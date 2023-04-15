package com.test.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;

		String num_ = request.getParameter("n"); //전달 받은 n 을 num_ 에 대입
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num%2 != 0)
			result = "홀수";
		else
			result = "짝수";
		
		request.setAttribute("result", result); //result 라고 담았던 값을 "result" 라는 이름으로 저장한다(html 에서 꺼내쓸 때 사용되는 이름)
		
		String[] names = {"test", "test1"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL 은 좋아요");
		request.setAttribute("notice", notice);
		
		//Java 코드와 html 을 연결하는 저장소
		//redirect 새로운 페이지를 요청할 때 사용
		//forward 위에서 처리한 내용을 이어갈 때 사용
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("spag.jsp"); //spag.jsp 로 넘겨준다
		dispatcher.forward(request, response); //위에서 처리했던 내용을 저장
	}
}





