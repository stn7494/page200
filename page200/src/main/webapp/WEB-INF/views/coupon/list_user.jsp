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

<title>쿠폰목록</title>
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
					<h1 class="heading" data-aos="fade-up">매인템플렛</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item"><a href="${contextPath }">Home</a></li>
							<li class="breadcrumb-item active text-white-50"
								aria-current="page">쿠폰목록</li>
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
				<form id="couponform">
					<div>${msg}</div>
					<strong><h3>▶ 쿠폰 리스트</h3></strong><br>
					<table class="table">
						<tr>
							<td>쿠폰코드</td>
							<td>쿠폰이름</td>
							<td>쿠폰내용</td>
							<td>수량</td>
							<td>할인율</td>
							<td>사용시작일</td>
							<td>사용마감일</td>
							<td>발급받기</td>
						</tr>

						<c:forEach var="coupon" items="${listAll }" varStatus="num">
							<tr>
								<td id="couponid${num.count }">${coupon.cp_code}</td>
								<td id="data${num.count}">${coupon.cp_name}</td>
								<td>${coupon.cp_content}</td>
								<td id="amount${num.count }">${coupon.cp_amount}</td>
								<td>${coupon.cp_sale}</td>
								<td>${coupon.cp_start_date}</td>
								<td>${coupon.cp_end_date}</td>
								<td colspan="5" align="center">
								<input class="btn btn-but" type="button" value="발급받기" id="but${num.count}" />
								
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5" align="center">
							<input class="btn btn-success" type="button" value="홈으로" id="main" />
							
						</tr>
					</table>
				</form>
			</div>
			<script>
				//홈으로 버튼을 눌렀을 때 처리
				$("#main").click(function() {
					location.href = "${contextPath }";
				});
				//발급받기 버튼을 눌렀을 때 처리(cp001)
				$("#but1").click(function() {
					var couponid = $("#couponid1").text();
					//var data = $("#data1").text();
					var cp_code = $("#couponid1").text();
					
					var cp_amount = $("#amount1").text();
					//alert(cp_code);
					var insertData = {"cp_code":cp_code, "cp_amount":cp_amount};
					//location.href = "/page/mypage/couponlistPage"
					$.ajax({
						url:"${contextPath}/couponchk",
						data:insertData,
						dataType:"json",
						type:"POST",
						success:function(map){ // 컨트롤러에 성공 메세지가 뜸.
							alert(map.msg);
						},
						error:function(){
							alert("실패");
						}
						
					});
				});
				
				//발급받기 버튼을 눌렀을 때 처리(cp002)
				$("#but2").click(function() {
					var couponid = $("#couponid2").text();
					
					var cp_code = $("#couponid2").text();
					
					var cp_amount = $("#amount2").text();

					var insertData = {"cp_code":cp_code, "cp_amount":cp_amount};

					$.ajax({
						url:"${contextPath}/couponchk",
						data:insertData,
						dataType:"json",
						type:"POST",
						success:function(map){ 
							alert(map.msg);
						},
						error:function(){
							alert("실패");
						}
						
					});
				});
				
				//발급받기 버튼을 눌렀을 때 처리(cp003)
				$("#but3").click(function() {
					var couponid = $("#couponid3").text();
					
					var cp_code = $("#couponid3").text();
					
					var cp_amount = $("#amount3").text();

					var insertData = {"cp_code":cp_code, "cp_amount":cp_amount};

					$.ajax({
						url:"${contextPath}/couponchk",
						data:insertData,
						dataType:"json",
						type:"POST",
						success:function(map){ 
							alert(map.msg);
						},
						error:function(){
							alert("실패");
						}
						
					});
				});
				
			</script>
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