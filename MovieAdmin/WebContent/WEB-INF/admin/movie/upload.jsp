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
  
	<%@ include file="../inc/footer.jsp" %>  

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
	
<%@ include file="../inc/footer_link.jsp" %>	


</body>
</html>
<script type="text/javascript">
	function movieRender(movieList){
		let tag="<option>영화 선택 ▼</option>";
		
		for(let i=0;i<movieList.length;i++){
			let movie = movieList[i]; //영화 한편 꺼내기
			tag +="<option value='"+movie.movieCd+"'>"+movie.movieNm+"</option>";
		}
		
		$("#bt_search span").toggleClass("spinner-border spinner-border-sm"); //제거
		
		$("#movie_name").prop("disabled", false);
		
		$("#movie_name").html(tag);
	}
	
	//비동기로 ,선택한 국가 및 영화유형 정보에 맞는 영화목록 가져오기 
	function searchMovie(){
		$.ajax({
			url:"/search/movie",
			type:"get",
			data:$("form").serialize() ,
			success: function(result, status, xhr){
				//영화 select 박스에 동적으로 채우기 
				movieRender(result);			
			},
			error:function(xhr, status, err){
				
			}
		});	
	}
	
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
	
	
	//팝업 창 띄우기 
	function openWin(){
		//자바스크립트의 객체 중, 가장 상위의 최상위 객체인 window 객체를 이용하여 팝업 창을 띄운다
		//팝업의 이름이 있어야, 중복 새창이 뜨지 않음
		window.open("url", "pop", "width=350, height=175");
	}
	
	$(function(){
		$("#movie_name").prop("disabled", true);
		
		$("#bt_search").click(function(){
			
			//검색토글
			$("#bt_search span").toggleClass("spinner-border spinner-border-sm");
			
			$("#movie_name").prop("disabled", true); //비활성화
			
			searchMovie();
		});
		
		$("#bt_regist").click(function(){
			regist();
		});
		
		$("#bt_excel").click(function(){
			openWin(); //업로드 창 띄우기
		});
		
	});
</script>










