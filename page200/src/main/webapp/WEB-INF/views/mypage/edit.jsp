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
      		<form method="post" id="data" enctype="multipart/form-data">
      		<table class="table">
      			<tr>
      				<th>프로필 사진 : <input type="file" name="file"></th>
      			</tr>
      			<tr>
      				<th>아이디 : <input type="text" id="id" name="id" readonly="readonly" value="${user.id}"></th>
      			</tr>
      			<tr>
      				<th>이름 : <input type="text" name="name" value="${user.name }"></th>
      			</tr>
      			<tr>
      				<th>닉네임 : <input type="text" id="nick" name="nick" value="${user.nick }"></th>
      				<td><input type="button" id="nickcheck" value="닉네임 중복 체크"></td>
      			</tr>
      			<tr>
      				<th>생일 : <input type="text" id="birth" name="birth" value="${user.birth }" readonly="readonly"></th>
      			</tr>
      			<tr>
      				<th>연락처 : <input type="text" id="phone" name="phone" value="${user.phone }">" - "하이픈은 제외하고 입력해주세요.</th>
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
      	<form action="freedom" method="post" id="out"></form>
      			<th><input type="button" id="btn3" value="회원탈퇴">회원탈퇴 동의<input type="checkbox" name="getout" id="free"></th>
      	</div>
      </div>
    </div>
    <script>
    	$("#btn2").click(function(){
    		$("#word").submit();
    	});
    	$("#btn3").click(function(){
    		if($("#free").is(":checked") == true) {
    			$("#out").submit();
    		}else {
    			alert("체크해주셈.");
    		}
    	});
    	var nickck = 0;
    	$("#nickcheck").click(function(){
    		var usernick = $("#nick").val();
    		var url = "nickcheck";
    		var paramData = {
    				"nick" : "${user.nick}"
    		}
    		$.ajax({
    			url : url,
    			data : usernick,
    			dataType : "json",
    			type : "POST",
    			contentType: "application/json; charset=UTF-8",
    			success : function(result) {
    				if(result.cnt > 0) {
    					alert("닉네임이 존재합니다. 다른 닉네임을 입력해주세요.");
    					$("#nick").focus();
    				}else {
    					alert("사용가능한 닉네임입니다.");
    					
    					nickck = 1;
    				}
    			},
    			error : function(error) {
    				alert("error : " + error);
    			}
    			
    		});
    	});
    	$("#btn").click(function(){
    		checkBirth();
    		
    	});
    	function checkBirth() {
    		var phone = $("#phone").val();
    		var phoneRules = /^01([0|1|6|7|8|9])([0-9]{3,4})([0-9]{4})$/;
	    	if(!(phoneRules.test(phone))) {
				alert("핸드폰번호를 잘못입력하였습니다.")
	    		
	    		return false;
	    	}
	    		$("#data").submit();
    	}

    	console.log(passwordRules .test(password));
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
