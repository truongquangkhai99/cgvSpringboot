<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
                    <h1 class="mt-4">Suất chiếu</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        <li class="breadcrumb-item active">Suất chiếu</li>
                    </ol>

                    <div class="card mb-4">
                        <div class="card-header">


                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Film</th>
                                        <th>Date</th>
                                        <th>Showtime</th>
                                        <th>Action</th>

                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>STT</th>
                                       	<th>Film</th>
                                        <th>Date</th>
                                        <th>Showtime</th>
                                        <th>Action</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                 <c:forEach var="item" items="${list}" varStatus="index">
                                    <tr>
                                        <td>${index.index+1 }</td>
                                        <td>
                                        <c:forEach var="item1" items="${listsche}" varStatus="index">
                                        <c:forEach var="item2" items="${listfilm}" varStatus="index">
                                        ${item.scheduleId == item1.id && item1.filmId == item2.id?item2.filmName:null }
                                        </c:forEach>
                                        </c:forEach>
             
                                        </td>
                                        <td><c:forEach var="item1" items="${listsche}" varStatus="index">
                                        ${item.scheduleId == item1.id?item1.dateschedule:null }
                                        </c:forEach></td>
                                        <td>${item.startTime } - ${item.endTime }</td>
                                        <td>

                                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal${item.id }">
                                                Update
                                            </button>
                                            <form action="<%= request.getContextPath() %>/admin/delete-showtime" class="btn btn-danger" method="post">
                                          <input type="hidden" class="form-control" id="id" name="id" value="${item.id}" >
                                          <button type="submit" style="background:none;border:none;color:white"> Delete</button>
                                            </form>
                                        </td>

                                    </tr>

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
                                                    <form action="<%= request.getContextPath() %>/admin/update-showtime"  method="post">
                                                    <input type="hidden" class="form-control" id="id" name="id" value="${item.id}" >
                                                        <div class="mb-3">
                                                            <div class="mb-3">
                                                                <label for="category-film" class="col-form-label">Ngày
                                                                    chiếu:</label>
                                                                <input type="text" class="form-control"
                                                                    id="category-film" value="<c:forEach var="item1" items="${listsche}" varStatus="index">
                                        ${item.scheduleId == item1.id?item1.dateschedule:null }
                                        </c:forEach>" disabled>
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="start" class="col-form-label">Bắt
                                                                    đầu:</label>
                                                                <input type="time" class="form-control"
                                                                    id="start" value="${item.startTime}" name="start">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="end" class="col-form-label">Kết
                                                                    thúc:</label>
                                                                <input type="time" class="form-control"
                                                                    id="end" value="${item.endTime}" name="end">
                                                            </div>
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