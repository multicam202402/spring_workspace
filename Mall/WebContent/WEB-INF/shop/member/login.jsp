<%@ page contentType="text/html;charset=UTF-8"%>
<%

%>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ashion | Template</title>
	
	<%@ include file="../inc/header_link.jsp" %>	
	
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
	
	<%@ include file="../inc/header.jsp" %>
	

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="#">로그인 </a>                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
					<div class="card card-info">
					    <div class="card-header">
					        <h3 class="card-title">회원 로그인</h3>
					    </div>
					    <!-- /.card-header -->
					    <!-- form start -->
					    <form class="form-horizontal">
					        <div class="card-body">
					            <div class="form-group row">
					                <label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
					                <div class="col-sm-10">
					                    <input type="email" class="form-control" id="inputEmail3" placeholder="Your ID...">
					                </div>
					            </div>
					            <div class="form-group row">
					                <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
					                <div class="col-sm-10">
					                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
					                </div>
					            </div>
					            <div class="form-group row">
					                <div class="offset-sm-2 col-sm-10">
					                    <button>Google 로그인</button>
					                    <button>Naver 로그인</button>
					                    <button>Kakao 로그인</button>
					                </div>
					            </div>
					        </div>
					        <!-- /.card-body -->
					        <div class="card-footer">
					            <button type="submit" class="btn btn-info">로그인</button>
					            <button type="submit" class="btn btn-info">회원가입</button>
					        </div>
					        <!-- /.card-footer -->
					    </form>
					</div>                	
                </div>
            </div>

        </div>
    </section>
    <!-- Product Details Section End -->

	

	<%@ include file="../inc/insta.jsp" %>
	
	<!-- Footer Section Begin -->
	<%@ include file="../inc/footer.jsp" %>
	<!-- Footer Section End -->
	
	<!-- Search Begin -->
	<%@ include file="../inc/search.jsp" %>
	<!-- Search End -->
	
	<!-- Js Plugins -->
	<%@ include file="../inc/footer_link.jsp" %>
</body>

</html>