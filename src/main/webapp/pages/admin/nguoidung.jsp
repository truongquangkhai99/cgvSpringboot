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
                <p style="color: red">${mess != null ? mess :null}</p>
                    <h1 class="mt-4">Người dùng</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        <li class="breadcrumb-item active">Người dùng</li>
                    </ol>
                       <% String mes = (String)request.getParameter("mess"); %>
                          <%if(mes == null){  %>
                          <%}else{ %>
                         <div class="alert alert-danger" role="alert">
					<%= mes %>
					</div>
                          <%} %>
                          <% String mes1 = (String)request.getParameter("mess1"); %>
                          <%if(mes1 == null){  %>
                          <%}else{ %>
                         <div class="alert alert-success" role="alert">
					<%= mes1 %>
					</div>
                          <%} %>
					
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
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Password</th>
                                        <th>Role</th>
                                        <th>Action</th>

                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>STT</th>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Password</th>
                                        <th>Role</th>
                                        <th>Action</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                 <c:forEach var="item" items="${list}" varStatus="index">
                                    <tr>
                                        <td>${index.index+1 }</td>
                                        <td>${item.username }</td>
                                        <td>${item.email }</td>
                                        <td>${item.password }</td>
                                        <td><c:forEach var="item1" items="${listR}" varStatus="index">
                                        ${item.roleId == item1.id?item1.roleName:null }
                                        </c:forEach></td>
                                        <td>
                                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal${item.id }">
                                                Update
                                            </button>
                                             <form action="<%= request.getContextPath() %>/admin/delete-user" class="btn btn-danger" method="post">
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
                                                    <form action="<%= request.getContextPath() %>/admin/update-user"  method="post">
                                                     <input type="hidden" class="form-control" id="id" name="id" value="${item.id}" >
                                                        <div class="mb-3">
                                                            <label for="name"
                                                                class="col-form-label">Username:</label>
                                                            <input type="text" class="form-control" id="name" name="name" value="${item.username }">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="email"
                                                                class="col-form-label">Email:</label>
                                                            <input type="email" class="form-control" id="email" name="email" value="${item.email }">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="phone"
                                                                class="col-form-label">Số điện thoại</label>
                                                            <input type="text" class="form-control" id="phone" name="phone" value="${item.phoneNumber }">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="pass"
                                                                class="col-form-label">Password:</label>
                                                            <input type="password" class="form-control"
                                                                id="pass" name="pass" value="${item.password }">
                                                        </div>
                                                        
                                                        <div class="mb-3">
                                                            <label for="idrole"
                                                                class="col-form-label">Role:</label>
                                                            <select class="form-select"
                                                                aria-label="Default select example" name="idrole">
                                                                 <option value="${item.roleId }" selected >
                                                                <c:forEach var="item1" items="${listR}" varStatus="index">
							                                        ${item.roleId == item1.id?item1.roleName:null}
							                                        </c:forEach>
                                                                </option>
                                                                <c:forEach var="item1" items="${listR}" varStatus="index">
                                                                <option value="${item1.id }">${item1.roleName }</option>
                                                               
                                                                </c:forEach>
                                                                
                                                                
                                                            </select>
                                                        </div>
                                                        <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Save change</button>
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
                                                    <form action="<%= request.getContextPath() %>/admin/add-user"  method="post">
                                                        <div class="mb-3">
                                                            <label for="name"
                                                                class="col-form-label">Username:</label>
                                                            <input type="text" class="form-control" id="name" name="name">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="email"
                                                                class="col-form-label">Email:</label>
                                                            <input type="email" class="form-control" id="email" name="email">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="phone"
                                                                class="col-form-label">Số điện thoại:</label>
                                                            <input type="number" class="form-control" id="phone" name="phone">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="pass"
                                                                class="col-form-label">Password:</label>
                                                            <input type="password" class="form-control"
                                                                id="pass" name="pass">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="re_pass"
                                                                class="col-form-label">Password:</label>
                                                            <input type="password" class="form-control"
                                                                id="re_pass" name="re_pass">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="idrole"
                                                                class="col-form-label">Role:</label>
                                                            <select class="form-select"
                                                                aria-label="Default select example" name="idrole">
                                                                <option value="1">Admin</option>
                                                                <option value="2">Nhân viên</option>
                                                                <option value="3">Khách hàng</option>
                                                            </select>
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