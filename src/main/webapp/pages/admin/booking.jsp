<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                    <h1 class="mt-4">Danh sách vé đã đặt</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        <li class="breadcrumb-item active">Booking</li>
                    </ol>

                    <div class="card mb-4">

                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Username</th>
                                        <th>Film's Name</th>
                                        <th>Schedule</th>
                                        <th>Showtime</th>
                                        <th>Room</th>
                                        <th>Seat</th>
                                        <th>Amount</th>
                                        <th>Status</th>
                                        

                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>STT</th>
                                        <th>Username</th>
                                        <th>Film's Name</th>
                                        <th>Schedule</th>
                                        <th>Showtime</th>
                                        <th>Room</th>
                                        <th>Seat</th>
                                        <th>Amount</th>
                                        <th>Status</th>
                                        
                                    </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach var="item" items="${listb}" varStatus="index">
                                    <tr>
                                        <td>${index.index+1 }</td>
                                        <td>
                                        <c:forEach var="item1" items="${listu}" varStatus="index">
						                    ${item.userId == item1.id?item1.username:null }
						                 </c:forEach>
                    					</td>
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
                                        <td><fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${item.amount }" /> VND</td>
                                        <td>
                                        <c:if test="${item.status == 1}"> 
										Đã xác nhận
										</c:if> 
										<c:if test="${item.status != 1}"> 
										 <form action="<%= request.getContextPath() %>/admin/update-booking" class="btn btn-danger" method="post">
                                          <input type="hidden" class="form-control" id="id" name="id" value="${item.id}" >
                                          <button type="submit" style="background:none;border:none;color:white"> Accept</button>
                                            </form>
										</c:if> 
                                        </td>
                                       

                                    </tr>
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