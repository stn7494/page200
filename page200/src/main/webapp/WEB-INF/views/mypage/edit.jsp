<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="true" %>
<!-- /*
* Template Name: Property
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!DOCTYPE html>
<html lang="ko">
  <head>
    <%@ include file="../include/head.jsp" %>

    <title>
      Property &mdash; Free Bootstrap 5 Website Template by Untree.co
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
    <%@ include file="../include/top_menu.jsp" %>
	
	
	

    <div
      class="hero page-inner overlay"
      style="background-image: url('${contextPath}/resources/images/hero_bg_1.jpg')"
    >
      <div class="container">
        <div class="row justify-content-center align-items-center">
          <div class="col-lg-9 text-center mt-5">
            <h1 class="heading" data-aos="fade-up">회원정보수정</h1>

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
      		<form method="post" id="data">
      		<table class="table">
      			<tr>
      				<th>아이디 : <input type="text" id="id" name="id" readonly="readonly" value="${user.id}"></th>
      			</tr>
      			<tr>
      				<th>이름 : <input type="text" name="name" value="${user.name }"></th>
      			</tr>
      			<tr>
      				<th>닉네임 : <input type="text" name="nick" value="${user.nick }"></th>
      			</tr>
      			<tr>
      				<th>생일 : <input type="text" name="birth" value="${user.birth }"></th>
      			</tr>
      			<tr>
      				<th>연락처 : <input type="text" name="phone" value="${user.phone }"></th>
      			</tr>
      			<tr>
      				<th>이메일 : <input type="text" name="email" value="${user.email }"></th>
      			</tr>
      		</table>
      		<button type="button" id="btn">수정완료</button>
      	</form>
      	<form action="editpasswordform" method="post" id="word">
      			<tr>
      				<td><input type="hidden" name="id"  value="${user.id}"></td>
      				<th><button type="button" id="btn2">비밀번호 변경</button></th>
      			</tr>
      	</form>
      	</div>
      </div>
    </div>
    <script>
    	$("#btn").click(function(){
    		$("#data").submit();
    	});
    	$("#btn2").click(function(){
    		$("#word").submit();
    	});
    </script>

	
	<%@ include file="../include/footer.jsp" %>
    <!-- /.site-footer -->

    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
      <div class="spinner-border" role="status">
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>

	<!-- 플러그인 -->
    <%@ include file="../include/plugin.jsp" %>
  </body>
</html>
