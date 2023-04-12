package com.test.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") //.xml뿐만 아니라 어노테이션으로도 지정 가능
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8"); //사용자에게 입력 받는 값의 인코딩 설정
		
		chain.doFilter(request, response);
		

	}

}
