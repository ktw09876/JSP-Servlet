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

		String num_ = request.getParameter("n"); //���� ���� n �� num_ �� ����
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num%2 != 0)
			result = "Ȧ��";
		else
			result = "¦��";
		
		request.setAttribute("result", result); //result ��� ��Ҵ� ���� "result" ��� �̸����� �����Ѵ�(html ���� ������ �� ���Ǵ� �̸�)
		
		String[] names = {"test", "test1"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL �� ���ƿ�");
		request.setAttribute("notice", notice);
		
		//Java �ڵ�� html �� �����ϴ� �����
		//redirect ���ο� �������� ��û�� �� ���
		//forward ������ ó���� ������ �̾ �� ���
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("spag.jsp"); //spag.jsp �� �Ѱ��ش�
		dispatcher.forward(request, response); //������ ó���ߴ� ������ ����
	}
}





