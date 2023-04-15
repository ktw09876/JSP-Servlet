<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	String cnt_ = request.getParameter("cnt"); //사용자에게 입력 받은 값 cnt를 cnt_(임시변수) 에 대입 
	
	int cnt = 100; 
	if(cnt_ != null && !cnt_.equals("")) 
		cnt = Integer.parseInt(cnt_);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%for(int i=0; i<cnt; i++){ %>
	안녕 servlet <br >
	<%}  %>
</body>
</html>