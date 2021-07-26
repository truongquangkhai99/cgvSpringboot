
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <title>Lịch sử đặt vé</title>
     <link rel="stylesheet" href="<c:url value="/user/css/phim.css"/>" />
  <link rel="stylesheet" href="<c:url value="/user/css/lightslider.css"/>" />
  <script src="<c:url value="/user/js/JQuery3.3.1.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/user/js/lightslider.js"/>" type="text/javascript"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
  <link rel="shortcut icon" href="<c:url value="/user/images/fav icon.png"/>"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
    crossorigin="anonymous" />
    <link rel="stylesheet" href="<c:url value="/user/css/style.css"/>" />
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
</head>

<body>
     <%@ include file="/user/header/header.jsp"  %>
       <section class="sign-in">
        <div class="container">
        <div class="signin-content" style="margin-top: 170px;">
      <!-- Sign up form -->
     <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">STT</th>
      <th scope="col">Phim</th>
      <th scope="col">Ngày chiếu</th>
      <th scope="col">Suất chiếu</th>
      <th scope="col">Room</th>
      <th scope="col">Ghế ngồi</th>
      <th scope="col">Giá tiền</th>
      <th scope="col">Trạng thái</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${listb}" varStatus="index">
                                    <tr>
                                        <th scope="row">${index.index+1 }</th>
      
                                        <td>
                                        <c:forEach var="item2" items="${listf}" varStatus="index">
						                    ${item.filmId == item2.id?item2.filmName:null }
						                 </c:forEach>
                    					</td>
                                        <td>
                                        <c:forEach var="item3" items="${listsc}" varStatus="index">
						                    ${item.scheduleId == item3.id?item3.dateschedule:null }
						                 </c:forEach>
                    					</td>
                                        <td>
                                        <c:forEach var="item4" items="${listsh}" varStatus="index">
		                                        <c:if test="${item.showtimeId == item4.id}"> 
												    ${item4.startTime} - ${item4.endTime}
												</c:if> 
						                    
						                 </c:forEach>
                    					</td>
                                        <td>
                                        <c:forEach var="item5" items="${listr}" varStatus="index">
						                    ${item.roomId == item5.id?item5.roomName:null }
						                 </c:forEach>
                    					</td>
                                        <td>
                                        <c:forEach var="item6" items="${lists}" varStatus="index">
						                    ${item.seatId == item6.id?item6.seatName:null }
						                 </c:forEach>
                    					</td>
                                        <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.amount }" /> VND</td>
                                        <td>
                                        <c:if test="${item.status == 1}"> 
										Đã xác nhận
										</c:if> 
										<c:if test="${item.status != 1}"> 
										 Chưa xác nhận
										</c:if> 
                                        </td>
                                       

                                    </tr>
</c:forEach>
    
    
    
  </tbody>
</table>
</div>
</div>
    </section>
    <!--footer------------------>
    <%@ include file="/user/footer/footer.jsp"  %>
</body>

</html>