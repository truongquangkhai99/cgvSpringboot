<%@page import="com.cgv.daoImpl.Admin.AdminScheduleDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="com.cgv.daoImpl.Admin.AdminFilmDaoImpl" %> 
<%@page import="com.cgv.models.*" %> 
    <!DOCTYPE html>
<html lang="en">

<%@ include file="/admin/head/head.jsp"  %>

<body class="sb-nav-fixed">
    <%@ include file="/admin/header/header.jsp"  %>
    <div id="layoutSidenav">
        <%@ include file="/admin/menu/menu.jsp"  %>
       <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Lịch chiếu</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        <li class="breadcrumb-item active">Lịch chiếu</li>
                    </ol>

                    <div class="card mb-4">
                        <div class="card-header">

                            <button type="button" class="btn btn-success" data-bs-toggle="modal"
                                data-bs-target="#exampleModalAdd">
                                Thêm mới
                            </button>
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Film</th>
                                        <th>Date</th>
                                        <th>Action</th>

                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>STT</th>
                                        <th>Name</th>
                                        <th>Date</th>
                                        <th>Action</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                <%  long millis=System.currentTimeMillis();   java.sql.Date dated=new java.sql.Date(millis);  %>
                               
                                 <c:forEach var="item" items="${list}" varStatus="index">
                                    <tr>
                                        <td>${index.index +1 }</td>
                                        <td>
                                        <c:forEach var="item1" items="${lfilm}" varStatus="index">
                                        ${item.filmId == item1.id?item1.filmName:null}
                                        </c:forEach>
                                        </td>
                                        <td>${item.dateschedule }</td>
                                        <td>
                                            <button type="button" class="btn btn-success" data-bs-toggle="modal"
                                                data-bs-target="#exampleModalAddS${item.id }">
                                                Add showtime
                                            </button>
                                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal${item.id }">
                                                Update
                                            </button>
                                              <form action="<%= request.getContextPath() %>/admin/delete-schedule" class="btn btn-danger" method="post">
                                          <input type="hidden" class="form-control" id="id" name="id" value="${item.id}" >
                                          <button type="submit" style="background:none;border:none;color:white"> Delete</button>
                                            </form>
                                        </td>

                                    </tr>
                                    <!-- Modal AddShow-->
                                    <div class="modal fade" id="exampleModalAddS${item.id }" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Thêm mới</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="<%= request.getContextPath() %>/admin/add-showtime"  method="post">
                                                    <input type="hidden" class="form-control"
                                                                    id="idsche" name="idsche" value="${item.id}" >
                                                        <div class="mb-3">
                                                            <div class="mb-3">
                                                                <label for="idschea" class="col-form-label">Ngày
                                                                    chiếu:</label>
                                                                <input type="input" class="form-control" required
                                                                    id="idschea"  value="${item.dateschedule}" disabled >
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="start" class="col-form-label">Bắt
                                                                    đầu:</label>
                                                                <input type="time" class="form-control" required
                                                                    id="start" name="start">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="end" class="col-form-label">Kết
                                                                    thúc:</label>
                                                                <input type="time" class="form-control" required
                                                                    id="end" name="end">
                                                            </div>
                                                        </div>
														<button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Save </button>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Modal Show-->
                                    
                                    <!-- Modal Update-->
                                    <div class="modal fade" id="exampleModal${item.id }" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Cập nhập</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="<%= request.getContextPath() %>/admin/update-schedule"  method="post">
                                                    <input type="hidden" class="form-control" id="id" name="id" value="${item.id}" >
                                                        <div class="mb-3">
                                                            <label for="film"
                                                                class="col-form-label">Phim:</label>
                                                            <select class="form-select" name="film" required
                                                                aria-label="Default select example">
                                                                <option value="${item.filmId }" selected >
                                                                <c:forEach var="item1" items="${lfilm}" varStatus="index">
							                                        ${item.filmId == item1.id?item1.filmName:null}
							                                        </c:forEach>
                                                                </option>
                                                                <c:forEach var="item1" items="${lfilm}" varStatus="index">
                                                                <option value="${item1.id }">${item1.filmName }</option>
                                                               
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="date-film" class="col-form-label">Ngày chiếu:</label>
                                                            <input type="date" name="date-film" required class="form-control" id="date-film" value="${item.dateschedule}" min="<%=dated %>">
                                                        </div>
                                                        <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Modal Update-->
									</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
            <!-- Modal Add-->
                                    <div class="modal fade" id="exampleModalAdd" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Thêm mới</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                     <form action="<%= request.getContextPath() %>/admin/add-schedule"  method="post">
                                                        <div class="mb-3">
                                                            <label for="category-film"
                                                                class="col-form-label">Phim:</label>
                                                            <select class="form-select" name="film" required
                                                                aria-label="Default select example">
                                                                <option selected>Chọn phim</option>
                                                                <c:forEach var="item" items="${lfilm}" varStatus="index">
                                                                <option value="${item.id }">${item.filmName }</option>
                                                               
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="date-film" class="col-form-label">Ngày
                                                                chiếu:</label>
                                                            <input type="date" name="date-film" required class="form-control" id="date-film" min="<%=dated %>">
                                                        </div>
                                                        <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Save </button>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Modal Update-->
            <%@ include file="/admin/footer/footer.jsp"  %>
        </div>
    </div>
    <script>

        ClassicEditor.create(document.querySelector('#editor')).then(eidt => {
            console.log("da" + eidt);
        })
            .catch(error => {
                console.error(error);
            });

    </script>
    <script>

        ClassicEditor.create(document.querySelector('#editor1')).then(eidt => {
            console.log("da" + eidt);
        })
            .catch(error => {
                console.error(error);
            });

    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
</body>

</html>