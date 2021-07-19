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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
       <%@ include file="/user/header/header.jsp"  %>
      
        <p class="head3">${postdetail.title }</p>
        <div class="event3">
            <img class="image3" src="<c:url value="/user/images/${postdetail.image }"/>" alt=""/>
            <p class="cmt3">${postdetail.description } </p>
            
        </div>
       <%@ include file="/user/footer/footer.jsp"  %>
    </body>
</html>
