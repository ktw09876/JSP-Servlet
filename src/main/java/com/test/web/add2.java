package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������̼����� url�� �����ϸ� .xml ���Ͽ��� �������� �ʴ��� ���� �����ϴ�.
@WebServlet("/add2") //response()
public class add2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //����ڿ��� ������ ���ڵ� ��� ���� 
		response.setContentType("text/html; charset=UTF-8"); //���������� �̴�� �ؼ��ض�
//		request.setCharacterEncoding("UTF-8"); //����ڿ��� �Է� �޴� ���� ���ڵ� ����
		
		PrintWriter out = response.getWriter();
		
		String[] num_ = request.getParameterValues("num"); //�Է� �޴� ���� ������ �迭�� �޾Ƽ� ó���Ѵ� 
		
		int result = 0;
		
		for(int i=0; i<num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result += num;
		}
						
		out.println("��� ����� "+result+"�Դϴ�");

		
		
	
	}
}







