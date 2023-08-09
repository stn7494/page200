<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <%@ include file="/WEB-INF/views/include/head.jsp" %>

    <title>
    	main템플렛
    </title>
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
    <%@ include file="/WEB-INF/views/include/top_menu.jsp" %>
	
	
	

    <div
      class="hero page-inner overlay"
      style="background-image: url('${contextPath}/resources/images/hero_bg_1.jpg')"
    >
      <div class="container">
        <div class="row justify-content-center align-items-center">
          <div class="col-lg-9 text-center mt-5">
            <h1 class="heading" data-aos="fade-up">매인템플렛</h1>

            <nav
              aria-label="breadcrumb"
              data-aos="fade-up"
              data-aos-delay="200"
            >
              <ol class="breadcrumb text-center justify-content-center">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li
                  class="breadcrumb-item active text-white-50"
                  aria-current="page"
                >
                  Properties
                </li>
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
      				<th>회원 아이디</th>
      				<th>회원 닉네임</th>
      				<th>회원 정지여부</th>
      				<th>체크박스</th>
      			</tr>
      			<c:forEach items="${list }" var="list">
      			<tr>
      				<td>${list.id }</td>
      				<td>${list.nick }</td>
      				<c:choose>
      					<c:when test="${list.stop == 1 }">
      						<td colspan="2" style="color: red; font-weight: bold;">회원정지</td>
      					</c:when>
      					<c:when test="${list.stop == 0 }">
      						<td style="color: green; font-weight: bold;">이용가능</td>
      						<td><input type="checkbox" name="chk" value="${list.id }"></td>
      					</c:when>
      				</c:choose>
      			</tr>
      			</c:forEach>
      			<tr>
      			</tr>
      		</table>
      		<input class="btn btn-outline-danger" type="button" id="stop" value="회원정지">
      	</div>
      </div>
    </div>
	<script type="text/javascript">
		$("#stop").click(function(){
			var arr = [];
			$("input[name=chk]:checked").each(function(){
				arr.push($(this).val());
			});
			if(arr == ""){
				alert("선택된 회원이 없습니다");
			}else{
			var data = {"userList":arr}
				$.ajax({
					url:"${contextPath}/userStop",
					data:data,
					dataType:"json",
					type:"POST",
					success:function(result){
						if(result != null){
							alert(result.result);
							location.href="${contextPath}/userList";
						}
					},
					error:function(){
						alert("실패");
					}
				});
			}
		});
	</script>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
    <!-- /.site-footer -->

    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
      <div class="spinner-border" role="status">
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>

	<!-- 플러그인 -->
    <%@ include file="/WEB-INF/views/include/plugin.jsp" %>
  </body>
</html>