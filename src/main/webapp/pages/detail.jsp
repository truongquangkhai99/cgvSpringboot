<%@page import="com.cgv.models.Film"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<c:url value="/user/Event/table.css"/>"   rel="stylesheet" type="text/css"/>
	  <link rel="stylesheet" href="<c:url value="/user/css/phim.css"/>" />
	  <link rel="stylesheet" href="<c:url value="/user/css/lightslider.css"/>" />
	  <script src="<c:url value="/user/js/JQuery3.3.1.js"/>" type="text/javascript"></script>
	  <script src="<c:url value="/user/js/lightslider.js"/>" type="text/javascript"></script>
	  	<script src="<c:url value="/user/js/video.js"/>" type="text/javascript"></script>
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
      
        <p class="head3" style="font-size:40px">${detailfilm.filmName }</p>
        <div class="row container" style="border: 1px solid #d42304;margin: 0 auto;padding: 10px 0">
        <div class="col-4">
         <img class="image3" src="<c:url value="/user/images/${detailfilm.image }"/>" alt=""/>
        </div>
        <div class="col-6">
         <p ><span style="font-weight:bold">Diễn viên : </span>${detailfilm.actor } </p><br>
            <p ><span style="font-weight:bold">Đạo diễn : </span>${detailfilm.director } </p><br>
            <p ><span style="font-weight:bold">Thể loại : </span>${cfilm.name } </p><br>
            <p ><span style="font-weight:bold">Thời lượng : </span>${detailfilm.duration } </p><br>
            <p ><span style="font-weight:bold">Nội dung : </span>${detailfilm.description } </p><br>
             <div class="button--movie">
        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal"
          style="margin-right: 20px">
          Trailer
        </button>
        <input type="hidden" class="form-control" name="idFilmT" id="idFilmT" value="${detailfilm.id}" placeholder="Password">
        <button onclick="getSchedule(${detailfilm.id});" type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModa${detailfilm.id}" data-bs-whatever="@mdo">Đặt Vé</button>
        
        </div>
           
         <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-xl">
        <div class="modal-content">
          <div class="modal-body">
            <iframe width="1104" height="621"  src="${detailfilm.trailer}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>
    <!--  Modak Booking -->
	<div class="modal fade" id="exampleModa${detailfilm.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">${detailfilm.filmName}</h5>
        <button type="button" id="btn-close${detailfilm.id}" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form >
          <div class="mb-3">
         
            <label for="schedule" class="col-form-label">Lịch chiếu:</label>
            <select required  class="form-select" onchange="getShowtime(${ detailfilm.id})" id="schedule${ detailfilm.id}" name="schedule" aria-label="Default select example">
			  <option value="0">Chọn lịch chiếu</option>
			  <option value="1">One</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
			</select>
          </div>
          <div class="mb-3">
          <label for="showtime" class="col-form-label">Suất chiếu:</label>
          <select class="form-select" onchange="getRoom(${ detailfilm.id})"  id="showtime${ detailfilm.id}"  name="showtime" aria-label="Default select example">
			  <option value="0">Chọn suất chiếu</option>			  		  
			</select>
          </div>
          <div class="mb-3">
          <label for="room" class="col-form-label">Phòng chiếu:</label>
          <select onchange="getSeat(${detailfilm.id})" class="form-select" id="room${ detailfilm.id}" name="room" aria-label="Default select example">
			  <option  value="0">Chọn phòng</option>
			</select>
          </div>
          <div class="mb-3">
          <label for="seat" class="col-form-label">Ghế ngồi:</label>
          <select  multiple="multiple" class="form-select" id="seat${ detailfilm.id}" name="seat" aria-label="Default select example">
			  <option  value="0">Chọn ghế</option>
			  
			</select>
          </div>
          <p style="color: red" id="resultError${ detailfilm.id}"></p>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
        <button onclick="bookticket(${detailfilm.id})" type="button" class="btn btn-danger">Đặt vé</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="exampleModaltest" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Hóa đơn</h5>
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
      </div>
        </div>
        <div>
        <div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div  class="col-md-8">
        <div id="responeAjax">
        <div class="headings d-flex justify-content-between align-items-center mb-3">
                <h5> Comments ${ listRating.size()}</h5>
             
            </div>
           
             <c:forEach var="item" items="${ listRating	}" varStatus="index">
              <div class="card p-3">
                <div class="d-flex justify-content-between align-items-center">
                	
                    	<div class="user d-flex flex-row align-items-center"> <img src="https://i.imgur.com/hczKIze.jpg" width="30" class="user-img rounded-circle mr-2"> <span><c:forEach var="item1" items="${User}" varStatus="index"><h5 style="margin-left: 10px">${item.userId == item1.id ? item1.username:null}</h5> </c:forEach></div> <small>${item.created_time}</small>
                    
                </div>
                <div class="action d-flex justify-content-between mt-2 align-items-center">
                    <div class="reply px-4"> <p>${item.rate}</p></div>
                    <div class="icons align-items-center"> <i class="fa fa-star text-warning"></i> <i class="fa fa-check-circle-o check-icon"></i> </div>
                </div>
             	
            </div>
              </c:forEach>
               <div class="card p-3">
               <form class="form-inline">
					<div class="row">
					 <div class="form-group  col-10">
		
				    <input type="text" class="form-control" name="comment" id="comment" placeholder="commnet">
				    <p style="color: red;margin-top: 10px" id="error"></p>
				  </div>
				  <div class="col-2">
				    <button type="button" onclick="postComment()" class="btn btn-primary mb-2">Post</button>
				  </div>
					</div>
				 
				
				</form>
            </div>
          </div>
            
            
           
            
           <script type="text/javascript">
		           function postComment(){
		        	var idFilm = document.getElementById("idFilmT").value;
		        	var comment = document.getElementById("comment").value;
		        	var row1 = document.getElementById("error");
		        	 var row = document.getElementById("responeAjax");
		   	    	$.ajax({
		   	    		  url: "/user/comment",
		   	    		  type:"post",
		   	    		  data:{
		   	    			idFilm:idFilm,
		   	    			textComment:comment
		   	    		  },
		   	    		  success: function(data){
		   	    			 if(data.status == "ErrorEmpty"){
			    				  row1.innerHTML=data.message
			    			  }else if(data.status == "Success"){
			    				  var number = data.data.length
								  var htmlData = `<div class="headings d-flex justify-content-between align-items-center mb-3">
						                <h5> Comments `+data.data.length+`</h5>
						                <div class="buttons"> <span class="badge bg-white d-flex flex-row align-items-center"> <span class="text-primary">Comments "ON"</span>
						                        <div class="form-check form-switch"> <input class="form-check-input" type="checkbox" id="flexSwitchCheckChecked" checked> </div>
						                    </span> </div>
						            </div>`
			    				  for(var i = 0; i<data.data.length;i++){
			    					  
			    					  htmlData +=` <div class="card p-3">
			    			                <div class="d-flex justify-content-between align-items-center">
			    		                	
			    	                    	<div class="user d-flex flex-row align-items-center"> <img src="https://i.imgur.com/hczKIze.jpg" width="30" class="user-img rounded-circle mr-2"> <span>
			    	                    	<h5 style="margin-left: 10px">`+data.data[i].name_user+`</h5></div> <small>`+data.data[i].created_time+`</small>
			    	                    
			    	                </div>
			    	                <div class="action d-flex justify-content-between mt-2 align-items-center">
			    	                    <div class="reply px-4"> <p>`+data.data[i].rate+`</p></div>
			    	                    <div class="icons align-items-center"> <i class="fa fa-star text-warning"></i> <i class="fa fa-check-circle-o check-icon"></i> </div>
			    	                </div>
			    	             	
			    	            </div>
			    	         		`
			    				  }
			    	            htmlData += `<div class="card p-3">
				    	               <form class="form-inline">
			    						<div class="row">
			    						 <div class="form-group  col-10">
			    					    <label for="inputPassword2" class="sr-only">Password</label>
			    					    <input type="text" class="form-control" name="comment" id="comment" placeholder="Password">
			    					    <p style="color: red;margin-top: 10px" id="error"></p>
			    					  </div>
			    					  <div class="col-2">
			    					    <button type="button" onclick="postComment()" class="btn btn-primary mb-2">Post</button>
			    					  </div>
			    						</div>
			    					 
			    					
			    					</form>
			    	            </div>`
			    				  row.innerHTML = htmlData
			    				  row1.innerHTML=""
			    			  }else if(data.status == "ErrorLogin"){
			    				  row1.innerHTML=data.message
			    			  }
		   	    		  }
		   	    		});
		   	    	
		   	    }
           </script>
           
        </div>
    </div>
</div>
<script type="text/javascript">
	$("#exampleModal").on("hidden.bs.modal", function () {
	    $("#exampleModal iframe").attr(
	      "src",
	      $("#exampleModal iframe").attr("src")
	    );
	  });

	</script>
        </div>
       <%@ include file="/user/footer/footer.jsp"  %>
    </body>
</html>
