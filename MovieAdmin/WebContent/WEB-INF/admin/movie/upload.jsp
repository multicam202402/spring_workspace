<%@page import="com.sds.movieadmin.domain.MovieType"%>
<%@page import="com.sds.movieadmin.domain.Nation"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%

%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

	<%@ include file="../inc/header_link.jsp" %>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
			
			<!-- 카드 영역 begin -->
			<form>
			<div class="card card-default">
				<div class="card-header">
					<h3 class="card-title">Select2 (Default Theme)</h3>
					<div class="card-tools">
					<button type="button" class="btn btn-tool" data-card-widget="collapse">
					<i class="fas fa-minus"></i>
					</button>
					<button type="button" class="btn btn-tool" data-card-widget="remove">
					<i class="fas fa-times"></i>
					</button>
					</div>
				</div>
			
				<!-- 카드의 body 영역 begin -->
				
				<div class="card-body" style="display: block;">
					
					
					<!-- 입력 폼이 나올 row 시작  -->
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<input type="file" class="form-control" name="photo">
							</div>
						</div>
					</div>
					<div class="row">						
						<div class="col-sm-1">
							<button type="button" class="btn btn-primary form-control" id="bt_excel">엑셀등록</button>
						</div>
					</div>
					<!-- 입력 폼이 나올 row 끝  -->
					
					
					<!-- 카드의 푸터 영역 begin -->
					<div class="card-footer" style="display: block;"></div>
					<!-- 카드의 푸터 영역 end -->
					
				</div>
				
				<!-- 카드의 body 영역 end -->			      		
        	</div>
        	<!-- 카드 영역 end -->
        	</form>
        	
        	
      
      
      <!-- /.container-fluid -->
      
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
	
<%@ include file="../inc/footer_link.jsp" %>	


</body>
</html>
<script type="text/javascript">
	
	//비동기 등록 요청 
	function regist(){
		$.ajax({
			url:"/movie",
			type:"post",
			data:$("form").serialize(),
			success:function(result, status, xhr){
				alert("등록 성공");
			},
			error:function(xhr, status, err){
				alert("등록 실패");
			}
		
		});			
	}
	
	
	
	
	$(function(){
	
		$("#bt_regist").click(function(){
			regist();
		});


	});
</script>










