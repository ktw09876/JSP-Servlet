package com.test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������̼����� url�� �����ϸ� .xml ���Ͽ��� �������� �ʴ��� ���� �����ϴ�.
@WebServlet("/calc")
public class Calc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //����ڿ��� ������ ���ڵ� ��� ���� 
		response.setContentType("text/html; charset=UTF-8"); //���������� �̴�� �ؼ��ض�
		
		PrintWriter out = response.getWriter();
		
		String x_ = request.getParameter("x");  
		String y_ = request.getParameter("y");
		String op = request.getParameter("operator");
		
		int x = 0;
		int y = 0;
		
		if(!x_.equals("")) { //����ڿ��� �Է� ���� ���� ���ǰ˻�, ���� x ���� ""(����)�� �ƴ϶��
			if(y_.equals("")) { //���� y ���� ""(����)�̶�� 
				out.println("y ���� �Է����ּ���");
			}else { //���ǿ� �´ٸ� ���������� ��ȯ�ؼ� ��� ���
				x = Integer.parseInt(x_);
				y = Integer.parseInt(y_);
				int result = 0;
				
				if(op.equals("����")) //���� �Ѱܹ��� ���� �����̶��
					result = x+y;
				if(op.equals("����")) //���� �Ѱܹ��� ���� �����̶��
					result = x-y;
				
				out.println("��� ����� "+result+"�Դϴ�");

			}
		}else if(!y_.equals("")){ //29�� ������ �������� �ʰ� y ���� ""(����) �� �ƴ϶��
			out.println("x ���� �Է����ּ���");			
		}else { // 29��, 45�� ������ �� �������� �ʴ´ٸ� --> x, y �� �� �����̶��
			out.println("���� �Է����ּ���");
		}
		
		
	
	}
}







