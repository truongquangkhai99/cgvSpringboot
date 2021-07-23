<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.cgv.models.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">

<%@ include file="/admin/head/head.jsp"  %>

<body class="sb-nav-fixed">
    <%@ include file="/admin/header/header.jsp"  %>
    <div id="layoutSidenav">
        <%@ include file="/admin/menu/menu.jsp"  %>
        <div id="layoutSidenav_content">
        <%   User userd =(User) session.getAttribute("userAdmin"); %>
            <main>
                <div class="container-fluid px-4">

                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active"></li>
                    </ol>
                    <div class="row">
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-primary text-white mb-4">
                                <div class="card-body">${cf } Phim trong Cinema </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                <%if(userd.getRoleId() == 1){ %>
                                    <a class="small text-white stretched-link" href="phim">View Details</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    <%} else{ %>
                                    <%} %>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-warning text-white mb-4">
                                <div class="card-body">${cu } Người dùng</div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <%if(userd.getRoleId() == 1){ %>
                                    <a class="small text-white stretched-link" href="nguoidung">View Details</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    <%} else{ %>
                                    <%} %>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-success text-white mb-4">
                                <div class="card-body">${cb } Đơn đặt vé</div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link" href="booking">View Details</a>
                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-danger text-white mb-4">
                                <div class="card-body align-items-center justify-content-between" >Tổng thu nhập </div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <p class="small text-white stretched-link" href="">${ct } VND</p>
                                    <div class="small text-danger"><i class="fas fa-angle-right"></i></div>
                                   
                                </div>
                            </div>
                        </div>
                    </div>

            </main>
            <%@ include file="/admin/footer/footer.jsp"  %>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
</body>

</html>