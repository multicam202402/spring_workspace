<%@page import="com.sds.spring.domain.Board"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Board board =(Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header_link.jsp" %>
<script type="text/javascript">

$(function(){
	$('#content').summernote({
		height:200, 
		placeholder:"내용입력.."
	});
});

</script>
</head>
<body>
	
	<div class="container mt-5">
		<form>
		    <div class="form-group">
		        <input type="text" class="form-control" value="<%=board.getTitle() %>" name="title">
		    </div>
		    
		    <div class="form-group">
		        <input type="text" class="form-control" value="<%=board.getWriter() %>" name="writer">
		    </div>

		    <div class="form-group">
		        <textarea class="form-control" name="content" id="content"><%=board.getContent() %></textarea>
		    </div>
		    
		    <div class="form-group">
		    	<button type="button" class="btn btn-primary" id="bt_regist">전송</button>
		    </div>
		</form>	
	</div>
	
</body>
</html>