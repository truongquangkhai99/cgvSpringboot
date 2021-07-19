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
    <title>Thông tin</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/user/Event/table.css"/>"rel="stylesheet" type="text/css" />
    <link rel="shortcut icon" href="<c:url value="/user/images/fav icon.png"/>"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="<c:url value="/user/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/user/css/phim.css"/>">
    <script src="<c:url value="/user/js/jquery-3.6.0.min.js"/>"></script>
    <script src="<c:url value="/user/js/popper.min.js"/>"></script>
    <script src="<c:url value="/user/js/bootstrap.min.js"/>"></script>
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
    <div style="margin-top: 200px;">

<c:forEach var="item" items="${ listInfor}" varStatus="index">

    <button class="accordion">${item.title }</button>
    <div class="panel">
      <p>${item.description }</p>
    </div>
  
    </c:forEach>

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