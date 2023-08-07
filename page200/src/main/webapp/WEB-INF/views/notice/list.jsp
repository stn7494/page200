<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="true"%>
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
					<h1 class="heading" data-aos="fade-up">공지사항</h1>

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
			<div>
				<table class="table">
					<tr>
						<th>글코드</th>
						<th>글제목</th>
						<th>글내용</th>
						<th>작성일</th>
						<th>작성자</th>
					</tr>
					<c:forEach items="${list }" var="list">
						<tr>
							<td><a href="selectOne?n_code=${list.n_code}">${list.n_code }
							</a></td>
							<td>${list.n_title }</td>
							<td>${list.n_content }</td>
							<td>${list.n_w_date }</td>
							<td>${list.n_writer }</td>
					</c:forEach>
				</table>
			</div>
			<div class="box">
				<div class="box-header with-border">
				
							<c:choose>
								<c:when test="${admin == null }">
									관리자만 답변 가능
								</c:when>
								<c:otherwise>
									관리자님 환영합니다
									<a href="insert" type=button><h6>글쓰기</h6></a>
								</c:otherwise>
							</c:choose>	
				</div>
			</div>
		</div>
	</div>
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
