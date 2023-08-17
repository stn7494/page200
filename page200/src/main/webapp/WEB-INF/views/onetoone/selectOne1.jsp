<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!-- /*
* Template Name: Property
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="../include/head.jsp"%>
<title>Property &mdash; Free Bootstrap 5 Website Template by
	Untree.co</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
	console.log("ajax test");
	
	replylist();
	
	$(document).on('click','#btnReplySave',function(){
		var rememo = $("#rememo").val();
		var rewriter = $("rewriter").val();
		
		var url = "${pageContext.request.contextPath}/onetoonereply/reply2";
		var paramDate = {
				"rewriter" : rewriter,
				"rememo" : rememo,
				"o_code" : '${onetoone.o_code}'
		};
		$.ajax({
			type : "POST",
			url : url
			date = paramDate
			datetype : 'json',
			success:function(result){
				replylist();
				$("#rememo").val('');
				$("#rewriter").val('');
			},
			error:function(date){
				console.log(date);
				alert("에러가 발생했습니다.");
			}
		});
	});
});

</script>






<body>
	<div class="site-mobile-menu site-navbar-target">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close">
				<span class="icofont-close js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>

	<!-- 상단에 네비게이션 -->
	<%@ include file="../include/top_menu.jsp"%>




	<div class="hero page-inner overlay"
		style="background-image: url('${contextPath}/resources/images/hero_bg_1.jpg')">
		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading" data-aos="fade-up">상세보기</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item"><a href="index.html">Home</a></li>
							<li class="breadcrumb-item active text-white-50"
								aria-current="page">Properties</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
		<div class="container">
			<!-- 여기에 내용을 작성 -->
			<!-- Main content -->
			<section class="content container-fluid">
				<div class="box-head with-notice"></div>
				<div class="box">
					<div class="box-head">
						<h3 class="box-title">상세보기</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<labal>회원 아이디</labal>
							<input type="text" name="id" class="form-control"
								value="${onetoone.id }" readonly="readonly" />
						</div>
						<div class="form-group">
							<label>제목</label> <input type="text" name="n_title"
								class="form-control" value="${onetoone.o_title}"
								readonly="readonly" />
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="n_content" rows="5" readonly="readonly"
								class="form-control">${onetoone.o_content}</textarea>
						</div>
						<div class="form-group">
							<label>작성일</label> <input type="text" name="o_w_date"
								class="form-control" value="${onetoone.o_w_date}"
								readonly="readonly" />
						</div>
					</div>
				</div>
		</div>

		<a href="update1?o_code=${onetoone.o_code }" role="button"
			class="btn btnoutline-info">글 수정</a> <a
			href="delete1?o_code=${onetoone.o_code }" role="button"
			class="btn btnoutline-info">글 삭제</a>


		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<%@ include file="../include/footer.jsp"%>
	<!-- /.site-footer -->

	<!-- Preloader -->
	<div id="overlayer"></div>
	<div class="loader">
		<div class="spinner-border" role="status">
			<span class="visually-hidden">Loading...</span>
		</div>
	</div>

	<!-- 플러그인 -->
<%@ include file="../include/plugin.jsp"%>
</body>
</html>
