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
 <title>Giới thiệu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<c:url value="/user/Event/table.css"/>"   rel="stylesheet" type="text/css"/>
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
    <style>
.accordion {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  
  height: 40px;
  margin-bottom: 20px;
  border: none;
  text-align: center;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
}

.active, .accordion:hover {
  background-color: #d42304; 
  color:white;
}

.panel {
  margin: 0 auto;
  width: 70%;
  display: none;
  background-color: white;
  overflow: hidden;
}
</style>
</head>

<body>
    <%@ include file="/user/header/header.jsp"  %>
    <div class="container" style="margin-top: 200px">
     <div style="margin: 0 auto">
 		<c:forEach var="item" items="${ listInfor}" varStatus="index">
			
			    <button style="margin-left: 100px" class="accordion">${item.title }</button>
			    <div class="panel">
			      <p>${item.description }</p>
			    </div>
			
    </c:forEach>
  </div>
    </div>
  
<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>
    
        
        
    
    

       <%@ include file="/user/footer/footer.jsp"  %>
</body>

</html>