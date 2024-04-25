<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

	<%@ include file="./inc/header_link.jsp" %>
	
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
	<!-- Content Wrapper. Contains page content -->
	
		<div class="card card-danger mt-5 ml-5 mr-5">
		    <div class="card-header">
		        <h3 class="card-title">관리자 가입</h3>
		    </div>
		    <!-- /.card-header -->
		    <!-- form start -->
		    <form class="form-horizontal">
		        <div class="card-body">
		            <div class="form-group row">
		                <label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
		                <div class="col-sm-10">
		                    <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
		                </div>
		            </div>
		            <div class="form-group row">
		                <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
		                <div class="col-sm-10">
		                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
		                </div>
		            </div>
		            <div class="form-group row">
		                <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
		                <div class="col-sm-10">
		                    <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
		                </div>
		            </div>
		            
		            
		        </div>
		        <!-- /.card-body -->
		        <div class="card-footer">
		            <button type="submit" class="btn btn-info">로그인</button>
		            <button type="submit" class="btn btn-info">관리자 등록</button>
		            
		        </div>
		        <!-- /.card-footer -->
		    </form>
		</div>		
	
	<!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->
	
<%@ include file="./inc/footer_link.jsp" %>	

</body>
</html>
