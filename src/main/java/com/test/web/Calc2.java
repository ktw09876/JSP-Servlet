package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������̼����� url�� �����ϸ� .xml ���Ͽ��� �������� �ʴ��� ���� �����ϴ�.
@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext(); //application ��ü ����
		
		response.setCharacterEncoding("UTF-8"); //����ڿ��� ������ ���ڵ� ��� ���� 
		response.setContentType("text/html; charset=UTF-8"); //���������� �̴�� �ؼ��ض�
		
		PrintWriter out = response.getWriter();
		
		String v_ = request.getParameter("v"); //����ڿ��� �Է� ���� ���� ����
		String op = request.getParameter("operator"); //����ڿ��� �Է� ���� �����ڸ� ����
		
		int v = 0;
		
		if(!v_.equals("")) { //����ڿ��� �Է� ���� ���� ���ǰ˻�, ���� v_ ���� ""(����)�� �ƴ϶��
			v = Integer.parseInt(v_);
		
		//���
		if(op.equals("=")) {
			
			int x = (Integer)application.getAttribute("value"); //value�� �����ϰ��ִ� ���� ����ȯ�ؼ� ����
			int y = v; //�ι�° �Է� ���� ��
			String operator = (String)application.getAttribute("op");
			int result = 0;
			
			if(operator.equals("+"))
				result = x+y;
			else
				result = x-y;
			
			out.println("��� ����� "+result+"�Դϴ�");
		}else { //���� ����
			application.setAttribute("value", v); //31�࿡�� v �� �����ߴ� ���� value �� ����
			application.setAttribute("op", op);
		}
		
			
		
		}
	}
}







