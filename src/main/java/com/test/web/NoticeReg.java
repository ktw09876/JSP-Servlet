package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������̼����� url�� �����ϸ� .xml ���Ͽ��� �������� �ʴ��� ���� �����ϴ�.
@WebServlet("/notice-reg") //response()
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //����ڿ��� ������ ���ڵ� ��� ���� 
		response.setContentType("text/html; charset=UTF-8"); //���������� �̴�� �ؼ��ض�
//		request.setCharacterEncoding("UTF-8"); //����ڿ��� �Է� �޴� ���� ���ڵ� ����
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title"); //����ڿ��� �Է� ���� �� cnt�� cnt_(�ӽú���) �� ���� 
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
		
	}
}







