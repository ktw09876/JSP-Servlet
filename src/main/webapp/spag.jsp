<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	pageContext.setAttribute("result", "Hello");
%>
<body>
	<%=request.getAttribute("result") %> 입니다.
	${requestScope.result }<br >
	${names[1] }<br >
	${notice.title }<br >
	${result }<br >
	${param.n/2}<br > <!-- 정수를 정수로 나눠도 정수가 나오는게 아닌 소수점이 나온다 -->
	${header.accept }
</body>
</html>