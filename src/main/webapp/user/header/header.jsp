<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@page import="com.cgv.models.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <!--navigation-------------->
 <nav>
    <!--logo--------------->
    <a href="<%= request.getContextPath() %>/home" class="logo">
      <img src="<c:url value="/user/images/logo.png"/>" />
    </a>
    <!--menu--btn----------------->
  <%   User userInfo =(User) session.getAttribute("user"); %>
    <!--menu-------------->
    <ul class="menu">
      <li><a href="<%= request.getContextPath() %>/user/gioithieu">Giới Thiệu</a></li>
      <li class="active"><a  href="<%= request.getContextPath() %>/user/phim">Phim</a></li>
      <%if(userInfo != null) {%>
      	<li><a href="#"><%=userInfo.getUsername()%></a></li>
      	<li><a href="<%= request.getContextPath() %>/user/logout">Đăng Xuất</a></li>
      <%} else{%>
         <li><a href="<%= request.getContextPath() %>/user/login">Đăng Nhập</a></li>
      	<li><a href="<%= request.getContextPath() %>/user/register">Đăng Kí</a></li>
      <%} %>
   
    </ul>
    <!--search------------->
    <div class="search">
      <input type="text" placeholder="Find Your Favourtie Movies" />
      <!--search-icon----------->
      <i class="fas fa-search"></i>
      
    </div>
    
  </nav>
