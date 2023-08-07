<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<nav class="site-nav">
      <div class="container">
        <div class="menu-bg-wrap">
          <div class="site-navigation">
            <a href="${contextPath }" class="logo m-0 float-start">Property</a>
            <ul
              class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end"
            >
              <c:if test="${user == null }">
              <li><a href="login">로그인</a></li>
              <li><a href="signup">회원가입</a></li>
              </c:if>
              <c:if test="${user != null }">
              <li><a href="logout">로그아웃</a></li>
              <li class="has-children">
              <a href="edit">내 정보 수정</a>
                <ul class="dropdown">
                  <li><a href="revlistPage">내 예약조회</a></li>
                  <li><a href="jjimlistPage">내 찜목록</a></li>
                  <li><a href="reviewlistPage">내 리뷰목록</a></li>
                  <li><a href="couponlistPage">내 쿠폰함</a></li>

                </ul>
              </li>
              <li><a href="coupon_user">쿠폰목록</a></li>
              <li class="has-children">
              <a>고객센터</a>
              <ul class = "dropdown">
              	  <li><a href ="onetoone/list1">1대1 문의사항</a></li>
              	  <li><a href ="onetoone_reply/list2">1대1 문의사항 답변</a></li>
              </ul>
              </li>
              
              </c:if>
              <li><a href="camping/list">캠핑장</a></li>
              <li><a href="review">리뷰</a></li>
              <li><a href ="notice/list">공지사항</a></li>
               <c:if test="${user.admin == 1}">
             	 <li><a href="coupon">쿠폰</a></li>
              </c:if>

            </ul>

            <a
              href="#"
              class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none"
              data-toggle="collapse"
              data-target="#main-navbar"
            >
              <span></span>
            </a>
          </div>
        </div>
      </div>
    </nav>