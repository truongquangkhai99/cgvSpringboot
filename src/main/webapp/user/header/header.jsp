<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@page import="com.cgv.models.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <!--navigation-------------->
 <nav>
    <!--logo--------------->
    <a href="<%= request.getContextPath() %>/user/home" class="logo">
      <img src="<c:url value="/user/images/logo.png"/>" />
    </a>
    <!--menu--btn----------------->
  <%   User userInfo =(User) session.getAttribute("user"); %>
    <!--menu-------------->
    <ul class="menu">
      <li><a style="font-size: 18px" href="<%= request.getContextPath() %>/user/gioithieu">Giới Thiệu</a></li>
      <li ><a style="font-size: 18px" href="<%= request.getContextPath() %>/user/phim">Phim</a></li>
      <%if(userInfo != null) {%>
      	
      	<li><a style="font-size: 18px" href="<%= request.getContextPath() %>/user/lichsu">Lịch sử đặt vé</a></li>
      	
      <%} else{%>
         <li><a style="font-size: 18px" href="<%= request.getContextPath() %>/user/login">Đăng Nhập</a></li>
      	<li><a style="font-size: 18px" href="<%= request.getContextPath() %>/user/register">Đăng Kí</a></li>
      <%} %>
   
    </ul>
    <!--search------------->
   <div>
   
   	<ul class="menu" style="align-items: center;">
   	<%if(userInfo != null) {%>
      	<li><a style="font-size: 18px" href="#"><%=userInfo.getUsername()%></a></li>
   	<li><a style="font-size: 18px" href="<%= request.getContextPath() %>/user/logout">Đăng Xuất</a></li>
      <%} else{%>
       
      <%} %>
   	</ul>
   	<ul class="menu" >
	   	<li>
	   	 <form style="width: 280px" class="search" action="<%=request.getContextPath()%>/user/search" method="post">
	     <input style="width: 280px" type="text" name="keySearch" placeholder="Find Your Favourtie Movies" /> 
	      <!--search-icon----------->
	      <button style="border: none;background-color: #f6f5f0" type="submit" >  <i type="submit" name="signin" class="fas fa-search"></i></button>
	
	    </form>
	   	</li>
   	</ul>
   
   </div>
   

    
  </nav>
