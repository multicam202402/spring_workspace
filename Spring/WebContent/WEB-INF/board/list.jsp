<%@ page contentType="text/html;charset=UTF-8"%>
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
	                <th>Firstname</th>
	                <th>Lastname</th>
	                <th>Email</th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr>
	                <td>John</td>
	                <td>Doe</td>
	                <td>john@example.com</td>
	            </tr>
	            <tr>
	                <td>Mary</td>
	                <td>Moe</td>
	                <td>mary@example.com</td>
	            </tr>
	            <tr>
	                <td>July</td>
	                <td>Dooley</td>
	                <td>july@example.com</td>
	            </tr>
	        </tbody>
	    </table>
	</div>
</body>
</html>