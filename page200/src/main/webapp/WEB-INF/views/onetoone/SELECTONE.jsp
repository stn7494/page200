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
					<h1 class="heading" data-aos="fade-up">내 문의 조회</h1>

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
						<h3 class="box-title">내 문의 조회</h3>
					</div>
					<div class="box-body">
					<div>
				<table class="table">
					<tr>
						<th>글번호</th>
						<th>회원아이디</th>
						<th>글제목</th>
						<th>글내용</th>
						<th>작성일</th>
					</tr>
					<c:forEach items="${onetoone}" var="oto">
					<tr>
					<td><a href="selectOne1?o_code=${oto.o_code}">${oto.o_code }
							</a></td>
						<td>${oto.id }</td>
						<td>${oto.o_title }</td>
						<td>${oto.o_content }</td>
						<td>${oto.o_w_date }</td>
					</tr>
					</c:forEach>
				</table>
			</div>
					</div>
				</div>
		</div>

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
