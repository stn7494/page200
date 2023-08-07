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
					<h1 class="heading" data-aos="fade-up">글 수정</h1>

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
				<div class="box-header">
					<h3 class="box-title">게시판 글수정</h3>
					<form role="form" method="post">
						<div class="box-body">
							<div class="form-group">
								<label>회원아이디</label> <input type="text" name='id'
									class="form-control" value="${onetoone.id}">
							</div>
							<div class="form-group">
								<label>제목</label> <input type="text" name='o_title'
									class="form-control" value="${onetoone.o_title}">
							</div>
							<div class="form-group">
								<label>내용</label>
								<textarea class="form-control" name="o_content" rows="3">${onetoone.o_content}</textarea>
							</div>

							<div class="form-group">
								<label>작성일</label> <input type="text" name="o_w_date"
									class="form-control" readonly="readonly"
									value="${onetoone.o_w_date}">
							</div>
						</div>

						<div class="box-footer">
							<button type="submit" class="btn btn-primary">수정완료</button>
						</div>
					</form>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
	</div>


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
