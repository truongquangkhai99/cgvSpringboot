<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">


  <head>
   <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Cinema</title>
  <link rel="stylesheet" href="<c:url value="/user/css/phim.css"/>" />
  <link rel="stylesheet" href="<c:url value="/user/css/lightslider.css"/>" />
  <script src="<c:url value="/user/js/JQuery3.3.1.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/user/js/lightslider.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/user/js/booking.js"/>" type="text/javascript"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
  <link rel="shortcut icon" href="<c:url value="/user/images/fav icon.png"/>"/>
  <script src="https://kit.fontawesome.com/c8e4d183c2.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
    integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
    crossorigin="anonymous"></script>
</head>


<body>
 
  <%@ include file="/user/header/header.jsp"  %>
  <section style="margin-top: 50px" id="main">
   
  </section>
  <!--movies---------------------------->
  <div class="movies-heading">
    <h2>Kết quả tìm kiếm</h2>
  </div>
  <section id="movies-list">
  <c:if test="${listSearch.size() == 0}"> 
		<h2 class="text-danger">Không tìm thấy kết quả </h2>
</c:if> 
    <!--box-1------------------------>
    <c:forEach var="item" items="${ listSearch}" varStatus="index">
    <div>
    <div class="movies-box">
      <!--img------------>
      <div class="movies-img">
        <div class="quality">4K</div>
         <img src="<c:url value="/user/images/${item.image}"/>" />
      </div>
      <!--text--------->
      <a href="<%= request.getContextPath() %>/detail/${item.id }/${item.id_cfilm }" style="font-size:120%">${item.filmName } </a>
      <!-- Button trigger modal -->
       <div style="margin-bottom: 15px" class="button--movie">
        <button  type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${item.id}"
          style="margin-right: 20px">
          Trailer
        </button>
        <button onclick="getSchedule(${item.id});" type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModa${item.id}" data-bs-whatever="@mdo">Đặt Vé</button>
        
      </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal${item.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-xl">
        <div class="modal-content">
          <div class="modal-body">
            <iframe width="1104" height="621"  src="${item.trailer}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>
    </div>
	  	<div class="modal fade" id="exampleModa${item.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">${item.filmName}</h5>
        <button type="button" id="btn-close${item.id}" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form >
          <div class="mb-3">
         
            <label for="schedule" class="col-form-label">Lịch chiếu:</label>
            <select required  class="form-select" onchange="getShowtime(${ item.id})" id="schedule${ item.id}" name="schedule" aria-label="Default select example">
			  <option value="0">Chọn lịch chiếu</option>
			  <option value="1">One</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
			</select>
          </div>
          <div class="mb-3">
          <label for="showtime" class="col-form-label">Suất chiếu:</label>
          <select class="form-select" onchange="getRoom(${ item.id})"  id="showtime${ item.id}"  name="showtime" aria-label="Default select example">
			  <option value="0">Chọn suất chiếu</option>			  		  
			</select>
          </div>
          <div class="mb-3">
          <label for="room" class="col-form-label">Phòng chiếu:</label>
          <select onchange="getSeat(${item.id})" class="form-select" id="room${ item.id}" name="room" aria-label="Default select example">
			  <option  value="0">Chọn phòng</option>
			</select>
          </div>
          <div class="mb-3">
          <label for="seat" class="col-form-label">Ghế ngồi:</label>
          <select  multiple="multiple" class="form-select" id="seat${ item.id}" name="seat" aria-label="Default select example">
			  <option  value="0">Chọn ghế</option>
			  
			</select>
          </div>
          <p style="color: red" id="resultError${ item.id}"></p>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
        <button onclick="bookticket(${item.id})" type="button" class="btn btn-danger">Đặt vé</button>
      </div>
    </div>
  </div>
</div> 
	</c:forEach>
<div class="modal fade" id="exampleModaltest" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Notification</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div id="result" class="modal-body">
        
      </div>
      <div class="modal-footer">
        <button  onclick="closeModel()" type="button" class="btn btn-danger" >OK</button>
 
      </div>
    </div>
  </div>
</div>
  </section>
  <script>
    $(document).ready(function () {
      $("#autoWidth,#autoWidth2").lightSlider({
        autoWidth: true,
        loop: true,
        onSliderLoad: function () {
          $("#autoWidth,#autoWidth2").removeClass("cS-hidden");
        },
      });
    });
  </script>
  <!--btns--------------->
  <!-- <div class="btns">
    <a href="#">Previous</a>
    <a href="#">Next</a>
  </div> -->
  <!--stopplaying--------------->
  <script>
    $("#exampleModal1").on("hidden.bs.modal", function (e) {
      $("#exampleModal1 iframe").attr(
        "src",
        $("#exampleModal1 iframe").attr("src")
      );
    });
  </script>
   <script>
    $("#exampleModal2").on("hidden.bs.modal", function (e) {
      $("#exampleModal2 iframe").attr(
        "src",
        $("#exampleModal2 iframe").attr("src")
      );
    });
  </script>
   <script>
    $("#exampleModal3").on("hidden.bs.modal", function (e) {
      $("#exampleModal3 iframe").attr(
        "src",
        $("#exampleModal3 iframe").attr("src")
      );
    });
  </script>
   <script>
    $("#exampleModal4").on("hidden.bs.modal", function (e) {
      $("#exampleModal4 iframe").attr(
        "src",
        $("#exampleModal4 iframe").attr("src")
      );
    });
  </script>
  <!--footer------------------>
  
   <%@ include file="/user/footer/footer.jsp"  %>

</body>

</html>