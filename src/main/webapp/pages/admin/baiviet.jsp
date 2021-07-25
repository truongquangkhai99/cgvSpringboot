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
                    <h1 class="mt-4">Danh sách bài viết</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        <li class="breadcrumb-item active">Bài viết</li>
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
                                        <th>Image</th>
                                        <th>Title</th>
                                        <th>Category</th>
                                        <th>Description</th>
                                        <th>Created at</th>
                                        <th>Action</th>

                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>STT</th>
                                        <th>Image</th>
                                        <th>Title</th>
                                        <th>Category</th>
                                        <th>Description</th>
                                        <th>Created at</th>
                                        <th>Action</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                 <input type="hidden" value="${list.size()}" id="dodai">
                                 <c:forEach var="item" items="${list}" varStatus="index10">
                                
                                    <tr>
                                        <td>${index10.index +1}</td>
                                        <td>
                                             <a href="" data-bs-toggle="modal" data-bs-target="#exampleModalImg${item.id }"><img
                          style="width: 120px !important;height: 150px !important;" src="<c:url value="/user/images/${item.image}"/>" class="img-fluid"></a>
                                        </td>
                                        <td>${item.title }</td>
                                        <td><c:forEach var="item1" items="${clist}" varStatus="index">
                    ${item.id_cpost == item1.id?item1.name:null }
                    </c:forEach></td>
                                        <td><a href="" data-bs-toggle="modal" data-bs-target="#exampleModalDes${item.id }">Chi tiết</a>
                                        </td>
                                        <td>${item.created_at }</td>
                                        <td>
                                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal${item.id }">
                                                Update
                                            </button>
                                           <form action="<%= request.getContextPath() %>/admin/delete-post" class="btn btn-danger" method="post">
                                          <input type="hidden" class="form-control" id="id" name="id" value="${item.id}" >
                                          <button type="submit" style="background:none;border:none;color:white"> Delete</button>
                                            </form>
                                        </td>

                                    </tr>
                                    <!-- Modal img-->
                                    <div class="modal fade" id="exampleModalImg${item.id }" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-m">
                                            <div class="modal-content">
                                                <div class="modal-body">
                                                    <img style="width: 460px !important;height: 580px !important;"
                                                        src="<c:url value="/user/images/${item.image}"/>" class="img-fluid">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Modal img-->

                                    <!-- Modal Descrip-->
                                    <div class="modal fade" id="exampleModalDes${item.id }" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">${item.title }</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <p>${item.description }</p>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- Modal Descrup-->
                                   	
                                    <!-- Modal Update-->
                                    <div class="modal fade" id="exampleModal${item.id }" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Cập nhập</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form enctype="multipart/form-data" action="<%=request.getContextPath()%>/admin/update-post" method="post">
                                                    <input type="hidden" value="${item.id }" name="idPost">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <div class="">
                                                                    <label for="category-film"
                                                                        class="col-form-label">Tiêu đề:</label>
                                                                    <input type="text" class="form-control"
                                                                      name="title" value="${item.title }"  id="category-film" required>
                                                                </div>

                                                            </div>
                                                            <div class="col-6 ">
                                                                <div class="">
                                                                    <label for="category-film"
                                                                        class="col-form-label">Thể loại:</label>
                                                                    <select name="theloai" class="form-select"
                                                                        aria-label="Default select example" required>
                                                           
                                                                        <c:forEach var="item1" items="${clist}" varStatus="index">
									                                      <option value="${item1.id }">${item1.name }</option>
									                                    </c:forEach>
                                                           
                                                                    </select>
                                                                </div>

                                                            </div>
                                                        </div>
                                                        <div class="mb-4 mt-4">
                                                            <label for="exampleFormControlFile1">Ảnh
                                                                Thumbnail</label><br>
                                                            <input type="file" class="form-control-file"
                                                               name="file" id="exampleFormControlFile1" required>
                                                        </div>
                                                        <div class="">
							                              <label for="category-film" class="col-form-label">Nội dung:</label>
							                              <textarea   name="noidung" id="editor${index10.index}" cols="30" rows="30">${item.description}</textarea>
							                            </div>
							                            <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                                </div>
                                                    </form>
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
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Thêm mới</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="<%=request.getContextPath()%>/admin/insert-post" method="post" enctype="multipart/form-data">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <div class="">
                                                                    <label for="category-film"
                                                                        class="col-form-label">Tiêu đề:</label>
                                                                    <input type="text" class="form-control"
                                                                       name="title"  id="category-film" required>
                                                                </div>

                                                            </div>
                                                            <div class="col-6 ">
                                                                <div class="">
                                                                    <label for="category-film"
                                                                        class="col-form-label">Thể loại:</label>
                                                                    <select name="theloai" class="form-select"
                                                                        aria-label="Default select example" required>
                                                                        <option selected>Open this select menu</option>
                                                                         <c:forEach var="item1" items="${clist}" varStatus="index">
									                                      <option value="${item1.id }">${item1.name }</option>
									                                    </c:forEach>
                                                                    </select>
                                                                </div>

                                                            </div>
                                                        </div>
                                                        <div class="mb-4 mt-4">
                                                            <label for="exampleFormControlFile1">Ảnh
                                                                Thumbnail</label><br>
                                                            <input type="file" class="form-control-file"
                                                                name ="file" id="exampleFormControlFile1" required>
                                                        </div>
                                                        <div class="">
                                                            <label for="category-film" class="col-form-label">Nội
                                                                dung:</label>
                                                            <textarea name="noidung" name="description" id="editor" cols="30"
                                                                rows="30" ></textarea>
                                                        </div>
                                                        <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Add </button>
                                                </div>
                                                    </form>
                                                </div>
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Modal Add-->
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
    	
    	var dodai = document.getElementById("dodai").value;
    
    	for(var i = 0;i<dodai;i++){
    		var name = "#editor"  + i
    		 ClassicEditor.create(document.querySelector(name)).then(eidt => {
    	            console.log("da" + eidt);
    	        })
    	            .catch(error => {
    	                console.error(error);
    	            });
    	}
       

    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
</body>

</html>