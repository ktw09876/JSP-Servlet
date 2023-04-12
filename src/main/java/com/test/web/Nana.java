package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������̼����� url�� �����ϸ� .xml ���Ͽ��� �������� �ʴ��� ���� �����ϴ�.
@WebServlet("/hi") //response("hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //����ڿ��� ������ ���ڵ� ��� ���� 
		response.setContentType("text/html; charset=UTF-8"); //���������� �̴�� �ؼ��ض�
		
		PrintWriter out = response.getWriter();
		
		String cnt_ = request.getParameter("cnt"); //����ڿ��� �Է� ���� �� cnt�� cnt_(�ӽú���) �� ���� 
		
		int cnt = 100; //int Ÿ�� cnt �� �⺻���� 100 ����ڿ��� �Է� ���� ���� null or "" �� ��� ������ ���� �ʵ��� �ϱ� ���� �⺻���� ���� 
		//26�� ��
		if(cnt_ != null && !cnt_.equals("")) //���� ����ڿ��� �Ѱ� ���� ������ null �Ǵ� "" �� �ƴϸ�(���� �ִٸ�)
			cnt = Integer.parseInt(cnt_); //cnt_ �� ��û ���� ���� ���������� ����ȯ�ؼ� cnt ������ ���� 
		
		for(int i = 0; i<cnt; i++) // 0 ���� ��û ���� cnt ��ŭ i �ݺ�
		{
			out.println((i+1)+":�ȳ� servlet <br >");
		}
	}
}







