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

//������̼����� url�� �����ϸ� .xml ���Ͽ��� �������� �ʴ��� ���� �����ϴ�.
@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext(); //application ��ü ����
		HttpSession session = request.getSession();//session ��ü ����
		Cookie[] cookies = request.getCookies();
		
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
			
//			int x = (Integer)application.getAttribute("value"); //value�� �����ϰ��ִ� ���� ����ȯ�ؼ� ����
//			int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) 
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			
			
			
			int y = v; //�ι�° �Է� ���� ��
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
			
			out.println("��� ����� "+result+"�Դϴ�");
		}else { //���� ����
//			application.setAttribute("value", v); //v �� �����ߴ� ���� value �� ����
//			application.setAttribute("op", op);
			
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/calc2"); //��� url�� �� ��Ű�� �����Ͷ�
			valueCookie.setMaxAge(24*60*60); //���ᳯ¥ ����, �� ������ �⺻, valueCookie �� ��Ű�� 24�ð� ���� �ȴ�
			opCookie.setPath("/calc2"); //opCookie �� ����ð��� �������� �ʾұ� ������ �������� ������ ��� ����ȴ�
			
			response.addCookie(valueCookie);//Ŭ���̾�Ʈ���� ����
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html"); //calc2 �������� ��ȯ
		}
		
			
		
		}
	}
}







