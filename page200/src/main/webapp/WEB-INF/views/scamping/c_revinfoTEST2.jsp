<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>캠핑장 예약 정보</title>

<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.search_area{
	display: inline-block;
	margin-top: 30px;
	margin-left: 260px;
}
.search_area input{
	height: 30px;
	width: 250px;
}
.search_area button{
	width: 100px;
	height: 36px;
}
  

.tooltip {
  position: relative;
  display: inline-block;
  border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 120px;
  background-color: black;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;
  
  /* Position the tooltip */
  position: absolute;
  z-index: 1;
  top: 100%;
  left: 50%;
  margin-left: -60px;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
}
</style>

</head>

<!-- 플러그인 -->
<%@ include file="../include/plugin.jsp"%>

  <form role="form" method="post">
  	<input type='hidden' name='cam_code' value="${c_revinfo.cam_code}" >
  </form> 
  
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
					<h1 class="heading" data-aos="fade-up">CAMPING</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item"><a href="${contextPath }">Home</a></li>
							<li class="breadcrumb-item active text-white-50"
								aria-current="page">캠핑장</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
		<div class="container">
			<!-- 여기에 내용을 작성 -->
			
			<section class="content container-fluid">
				<div class="box-header">
					<h3 class="box-title">
					<input type="text" name="cam_code" class="form-control" value="${c_revinfo.cam_code}" readonly="readonly" />
					캠핑장 예약정보</h3>
				</div>
								

				<table class="table">
					<tr>
						<td>캠핑장구역</td>
						<td>최대인원</td>
						<td>가격</td>
					</tr>

		<!-- 페이징 추가 -->
					<c:forEach var="c_revinfo" items="${c_revinfo }">
						<tr>
							<td class="tooltip">
								<a href='/page/reservation${pageMaker.makeQuery(pageMaker.cri.page)}
								&cri_area_code=${c_revinfo.cri_area_code }'>${c_revinfo.cri_area_code}</a>
								<span class="tooltiptext">예약하기</span>
							</td>
							
							<td>${c_revinfo.cri_max}</td>
							<td>${c_revinfo.cri_price}</td>
						</tr>
					</c:forEach>
					
				</table>
				
		<!-- 검색기능 추가 -->
   			 
		   	<div class="search_wrap">
		        <div class="search_area">
		            <input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
		            <button id='searchBtn'>Search</button>
		        </div>
		    </div>  
 	
			<div class="text-center">
				<input class="btn btn-success"
					type="button" value="홈으로" id="main" />
					
				
			</div>
			</section>
		</div>
		
	<!-- 검색기능 추가 수정 -->
		<div class="text-center">
			<ul class="pagination">
			
				<c:if test="${pageMaker.prev && pageMaker.startPage > 0 }">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class=active':'' }"/>>
						<a href="list${pageMaker.makeSearch(idx) }">${idx }</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
					<li><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
		
			<form role="moveForm" action="modifyPage" method="post">
				<input type='hidden' name='page' value="${cri.page }">
				<input type='hidden' name='perPageNum' value="${cri.perPageNum }">
				<input type='hidden' name='searchType' value="${cri.searchType }">
				<input type='hidden' name='keyword' value="${cri.keyword }">
			</form>
		
		
		<!-- 검색script -->
		<script>
		
			$(document).ready(function(){
				
				$('#searchBtn').on("click", function(event){
					
					self.location = "list" 
						+ '${pageMaker.makeQuery(1)}'
						+ "&keyword=" + encodeURIComponent($('#keywordInput').val());
				});
				
				$('#newBtn').on("click", function(evt){
				
					self.location = "register";
				});
			});
		
		</script>

		<script>
			$("#main").click(function() {
				location.href = "${contextPath }";
			});

			
		</script>
		<script>
			var result = '${msg}';

			if (result == 'SUCCESS') {
				alert("처리가 완료되었습니다.")
			}
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

</body>
</html>