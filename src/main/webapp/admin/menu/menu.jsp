<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.cgv.models.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div id="layoutSidenav_nav">
 <%   User user =(User) session.getAttribute("userAdmin"); %>
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                <%if(user.getRoleId() == 1){ %>
                    <div class="nav">

                        <a class="nav-link" href="<%= request.getContextPath() %>/admin/home">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Bảng điều khiển
                        </a>

                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            Quản lý Phim
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="<%= request.getContextPath() %>/admin/theloai">Thể loại </a>
                                <a class="nav-link" href="<%= request.getContextPath() %>/admin/phim">Thông tin</a>
                                <a class="nav-link" href="<%= request.getContextPath() %>/admin/lichchieu">Lịch chiếu</a>
                                <a class="nav-link" href="<%= request.getContextPath() %>/admin/suatchieu">Suất chiếu</a>
                                <a class="nav-link" href="<%= request.getContextPath() %>/admin/phong">Phòng chiếu</a>
                                <a class="nav-link" href="<%= request.getContextPath() %>/admin/ghe">Ghế ngồi</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages"
                            aria-expanded="false" aria-controls="collapsePages">
                            <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                            Bài viết
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapsePages" aria-labelledby="headingTwo"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="<%= request.getContextPath() %>/admin/loaibaiviet">Thể loại </a>
                                <a class="nav-link" href="<%= request.getContextPath() %>/admin/baiviet">Thông tin</a>
                            </nav>
                        </div>
                        <a class="nav-link" href="<%= request.getContextPath() %>/admin/nguoidung">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            Người dùng
                        </a>

                        <a class="nav-link" href="<%= request.getContextPath() %>/admin/booking">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            Booking
                        </a>
                        

                    </div>
                    <%} else{ %>
                    <div class="nav">

                        <a class="nav-link" href="<%= request.getContextPath() %>/admin/home">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Bảng điều khiển
                        </a>

               

                        <a class="nav-link" href="<%= request.getContextPath() %>/admin/booking">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            Booking
                        </a>
                        

                    </div>
                    <%} %>
                </div>

            </nav>
        </div>