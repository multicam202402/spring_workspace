<%@page import="com.sds.spring.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Board> boardList = (List)request.getAttribute("boardList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ include file="../inc/header_link.jsp" %>

</head>
<body>
	<div class="container">
	    <h2>Hoverable Dark Table</h2>
	    <p>The .table-hover class adds a hover effect (grey background color) on table rows:</p>
	    <table class="table table-dark table-hover">
	        <thead>
	            <tr>
	                <th>No</th>
	                <th>제목</th>
	                <th>작성자</th>
	                <th>등록일</th>
	                <th>조회수</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<%for(int i=0;i<boardList.size();i++){ %>
	        	<%Board board = boardList.get(i); %>
	            <tr>
	                <td><%=i %></td>
	                <td><%=board.getTitle() %></td>
	                <td><%=board.getWriter() %></td>
	                <td><%=board.getRegdate()%></td>
	                <td><%=board.getHit() %></td>
	            </tr>
	            <%} %>
	        </tbody>
	    </table>
	</div>
</body>
</html>