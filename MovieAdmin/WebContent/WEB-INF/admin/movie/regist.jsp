<%@page import="com.sds.movieadmin.domain.MovieType"%>
<%@page import="com.sds.movieadmin.domain.Nation"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Nation> nationList = (List)request.getAttribute("nationList");
	List<MovieType> movieTypeList = (List)request.getAttribute("movieTypeList");
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

	<!-- Preloader -->
	<%@ include file="../inc/preloader.jsp" %>
	
  <!-- Navbar -->
  <%@ include file="../inc/navi.jsp" %>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
	<%@ include file="../inc/sidebar.jsp" %>
  
  <!-- /.sidebar -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">상품등록</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">상품관리</a></li> 
              <li class="breadcrumb-item active">상품등록</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

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
					
					<!-- 카드안의 행 begin -->
					<div class="row">
						<!-- 카드안의 열 begin -->	
						<div class="col-md-5" data-select2-id="30">
							<div class="form-group" data-select2-id="29">
								
								<select name="top" class="form-control select2 select2-hidden-accessible" style="width: 100%;" data-select2-id="1" tabindex="-1" aria-hidden="true">
									<option value="0">국가 선택 ▼</option>
									<%for(Nation nation : nationList){ %>
									<option value="<%=nation.getFullCd()%>"><%=nation.getKorNm() %></option>
									<%}%>
								</select>
							</div>
						</div>
						<!-- 카드안의 열 end -->
						<!-- 카드안의 열 begin -->	
						<div class="col-md-5" data-select2-id="30">
							<div class="form-group" data-select2-id="29">
								
								<select id="sub" name="subCategory.subcategory_idx" class="form-control select2 select2-hidden-accessible" style="width: 100%;" data-select2-id="1" tabindex="-1" aria-hidden="true">
									<option value="0">영화 유형 선택 ▼</option>
									<%for(MovieType movieType : movieTypeList){ %>
									<option value="<%=movieType.getFullCd()%>"><%=movieType.getKorNm() %></option>
									<%} %>
								</select>
							</div>
						</div>
						<!-- 카드안의 열 end -->
						<!-- 카드안의 열 begin -->	
						<div class="col-md-2" data-select2-id="30">
							<div class="form-group" data-select2-id="29">
								<button type="button" class="btn btn-primary">검색</button>
							</div>
						</div>
						<!-- 카드안의 열 end -->
						
					</div>
					
					<!-- 카드안의 행 end -->
					
					<!-- 입력 폼이 나올 row 시작  -->
					<div class="row">
						
						<div class="col-md-12">
							<div class="form-group">
								<select name="color_name"  class="form-control select2 select2-hidden-accessible" style="width: 100%;" data-select2-id="1" tabindex="-1" aria-hidden="true">
									<option value="Black">영화 선택 ▼</option>
									<option value="White">White</option>
								</select>
							</div>
						</div>
					
						<div class="col-md-12">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="상품명" name="product_name">
							</div>
						</div>
						
						<div class="col-md-12">
							<div class="form-group">
								<input type="file" class="form-control" name="photo">
							</div>
						</div>
						
					</div>
						
					<div class="row">						
						<div class="col-sm-1">
							<button class="btn btn-primary form-control" id="bt_regist">등록</button>
						</div>
						<div class="col-sm-1">
							<button class="btn btn-primary form-control" id="bt_list">목록</button>
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
	function getSubCategoryList(topcategory_idx){
		//서버에 하위 카테고리 목록을 요청하되, 비동기 방식으로 요청하자
		//select * from subcategory where topcategory_idx=3
		$.ajax({
			url:"/admin/subcategory/list?topcategory_idx="+topcategory_idx, 
			type:"GET", 
			success:function(result, status, xhr){
				console.log("서버의 응답 정보는 " ,  result);
				
				//하위컨트롤러 sub라는 아이디를 갖느 select 박스에 채우자
				let op="<option value=\"0\">하위 카테고리 선택 ▼</option>";
				
				//서버에서 전송받은 json 배열을 이용하여 아래의 option을 채우자
				for(let i=0; i<result.length;i++){
					let json = result[i];
					op += "<option value=\""+json.subcategory_idx+"\">"+json.subname+"</option>";
				}
				$("#sub").html(op); //innerHTML
				
			}			
		});		
	} 
	
	//상품 입력 정보 전송 
	function regist(){
		$("form").attr({
			action:"/admin/product/regist",
			method:"post",
			/*텍스트 데이터와 바이너리 데이터가 섞여 있는 복합 데이터를 전송하는 경우 반드시 enctype을 multipart/form-data*/
			enctype:"multipart/form-data"
		});
		$("form").submit(); //전송
	}
	
	$(function(){
		
		$("#content").summernote({
			height:200, 
			placehodel:"상품 상세 설명 입력"
		});
		
		//상위 카테고리의 아이템을 변경하면... 서브 카테고리 목록 가져오기 
		$("select[name='top']").change(function(){
			
			console.log($(this).val());
			
			getSubCategoryList($(this).val());			
		});
		
		$("#bt_regist").click(function(){
			regist();
		});
		
	});
</script>










