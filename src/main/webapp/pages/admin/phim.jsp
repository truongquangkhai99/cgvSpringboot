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
          <h1 class="mt-4">Danh sách phim</h1>
          <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
            <li class="breadcrumb-item active">Phim</li>
          </ol>

          <div class="card mb-4">
            <div class="card-header">

              <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModalAdd">
                Thêm mới
              </button>
            </div>
            <div class="card-body">
              <table id="datatablesSimple">
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>Film</th>
                    <th>Name</th>
                    <th>Actor</th>
                    <th>Director</th>
                    <th>Duration</th>
                    <th>Category</th>
                    <th>Description</th>
                    <th>Trailer</th>
                    <th>Action</th>

                  </tr>
                </thead>
                <tfoot>
                  <tr>
                    <th>STT</th>
                    <th>Film</th>
                    <th>Name</th>
                    <th>Actor</th>
                    <th>Director</th>
                    <th>Duration</th>
                    <th>Category</th>
                    <th>Description</th>
                    <th>Trailer</th>
                    <th>Action</th>
                  </tr>
                </tfoot>
                <tbody>
                 <input type="hidden" value="${listF.size()}" id="dodai">
                <c:forEach var="item" items="${listF}" varStatus="index10">
                 
                  <tr>
                    <td>${index10.index +1}</td>
                    <td>
                   
                      <a href="" data-bs-toggle="modal" data-bs-target="#exampleModalImg${item.id }"><img
                          style="width: 120px !important;height: 150px !important;" src="<c:url value="/user/images/${item.image}"/>" class="img-fluid"></a>

                    </td>
                    <td>${item.filmName }</td>
                    <td>${item.actor }</td>
                    <td>${item.director }</td>
                    <td>${item.duration }</td>
                    <td>
                    <c:forEach var="item1" items="${cfilm}" varStatus="index">
                    ${item.id_cfilm == item1.id?item1.name:null }
                    </c:forEach>
                    </td>
                    <td><a href="" data-bs-toggle="modal" data-bs-target="#exampleModalDes${item.id }">${item.description }</a></td>
                    <td> <a href="" data-bs-toggle="modal" data-bs-target="#exampleModalView${item.id }">Link</a></td>
                    <td>
                      <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                        data-bs-target="#exampleModal${item.id }">
                        Update
                      </button>
                      <form class="btn btn-danger" action="<%= request.getContextPath()%>/admin/delete" method="post">
                      	  <input type="hidden" name="id" value="${item.id }">
	                      <button type="submit" style="background: none;border: none;color: white">
	                        Delete
	                      </button>
                      </form>
                      
                    </td>

                  </tr>
                  <!-- Modal img-->
                  <div class="modal fade" id="exampleModalImg${item.id }" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-m">
                      <div class="modal-content">
                        <div class="modal-body">
                          <img style="width: 460px !important;height: 580px !important;" src="<c:url value="/user/images/${item.image}"/>" class="img-fluid">
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- Modal img-->
                  <div class="modal fade" id="exampleModalView${item.id }" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                      <div class="modal-content">
                        <div class="modal-body">
                          <iframe width="1104" height="621" src="${item.trailer }"
                            title="YouTube video player" frameborder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen></iframe>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- Modal view-->
                  <!-- Modal Descrip-->
                  <div class="modal fade" id="exampleModalDes${item.id }" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-l">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">${item.filmName }</h5>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                          <p>${item.description }</p>
                        </div>

                      </div>
                    </div>
                  </div>
                  <!-- Modal Descrup-->
                  
                  <!-- Modal Update-->
                  <div class="modal fade" id="exampleModal${item.id }" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">Cập nhập</h5>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                          <form action="<%= request.getContextPath()%>/admin/update-film" method="post" enctype="multipart/form-data">
                          <input type="hidden"  value="${item.id }" name="idFilm">
                            <div class="row">
                              <div class="col-6">
                                <div class="">
                                  <label for="film-name" class="col-form-label">Tên Phim:</label>
                                  <input required="required" name ="nameFilm" type="text" class="form-control" id="film-name" value="${item.filmName }">
                                </div>
                                <div class="">
                                  <label for="actor" class="col-form-label">Diễn viên:</label>
                                  <input required="required" name="actorFilm" type="text" class="form-control" id="actor" value="${item.actor }">
                                </div>
                                <div class="">
                                  <label for="director" class="col-form-label">Đạo diễn:</label>
                                  <input required="required" name="directorFilm" type="text" class="form-control" id="director" value="${item.director }">
                                </div>
                                <div class="">
                                  <label for="duration" class="col-form-label">Thời lượng:</label>
                                  <input required="required" name="durationFilm" type="text" class="form-control" id="duration" value="${item.duration }">
                                </div>
                              </div>
                              <div class="col-6 ">
                                <div class="">
                                  <label for="category-film" class="col-form-label">Thể loại:</label>
                                  <select required="required" name="idCfilm" class="form-select" aria-label="Default select example" >
                                    <option selected value="${item.id_cfilm}">Open this select menu</option>
                                     <c:forEach var="item1" items="${cfilm}" varStatus="index">
                                      <option value="${item1.id }">${item1.name }</option>
                                    </c:forEach>
                                  </select>
                                </div>
                                <div class="mb-4 mt-4">
                                  <label for="exampleFormControlFile1">Ảnh Thumbnail</label>
                                  <input required="required" type="file" name ="file" class="form-control-file" id="exampleFormControlFile1">
                                </div>
                                <div class="">
                                  <label for="category-film" class="col-form-label">Trailer:</label>
                                  <input required="required" name="trailerFilm" value="${item.trailer}" type="text" class="form-control" id="category-film">
                                </div>
                              </div>
                            </div>
                            <div class="">
                              <label for="category-film" class="col-form-label">Nội dung:</label>
                              <textarea  name="description" id="editor${index10.index}" cols="30" rows="30">${item.description}</textarea>
                            </div>
                            <div class="modal-footer">
		                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
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
                  <div class="modal fade" id="exampleModalAdd" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">Thêm mới</h5>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                          <form action="<%=request.getContextPath() %>/admin/insert" method="post" enctype="multipart/form-data"  >
                            <div class="row">
                              <div class="col-6">
                                <div class="">
                                  <label for="category-film" class="col-form-label">Tên Phim:</label>
                                  <input required="required" type="text" name ="nameFilm" class="form-control" id="category-film">
                                </div>
                                <div class="">
                                  <label for="category-film" class="col-form-label">Diễn viên:</label>
                                  <input required="required" type="text" name="actorFilm" class="form-control" id="category-film">
                                </div>
                                <div class="">
                                  <label for="category-film" class="col-form-label">Đạo diễn:</label>
                                  <input required="required" type="text" name="directorFilm" class="form-control" id="category-film">
                                </div>
                                <div class="">
                                  <label for="category-film" class="col-form-label">Thời lượng:</label>
                                  <input required="required" type="text" name="durationFilm" class="form-control" id="category-film">
                                </div>
                              </div>
                              <div class="col-6 ">
                                <div class="">
                                  <label for="category-film" class="col-form-label">Thể loại:</label>
                                  <select required="required" name="idCfilm" class="form-select" aria-label="Default select example" >
                                    <option selected >Open this select menu</option>
                                     <c:forEach var="item" items="${cfilm}" varStatus="index">
                                      <option value="${item.id }">${item.name }</option>
                                    </c:forEach>
                                  </select>
                                </div>
                                <div class="mb-4 mt-4">
                                  <label for="exampleFormControlFile1">Ảnh Thumbnail</label>
                                  <input required="required" type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                                </div>
                                <div class="">
                                  <label for="category-film" class="col-form-label">Trailer:</label>
                                  <input  type="text" name="trailerFilm" class="form-control" id="category-film">
                                </div>
                              </div>
                            </div>
                            <div class="">
                              <label for="category-film" class="col-form-label">Nội dung:</label>
                              <textarea  name="description" id="editor" cols="30" rows="30"></textarea>
                            </div>
                             <div class="modal-footer">
	                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	                          <button  type="submit" class="btn btn-primary">Save </button>
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