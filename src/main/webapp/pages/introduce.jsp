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
    <link href="Event/table.css" rel="stylesheet" type="text/css" />
    <link rel="shortcut icon" href="./images/fav icon.png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/phim.css">
	    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body>
    <%@ include file="/user/header/header.jsp"  %>
    <div class="container ">
        <div class="row">
            <div class="col-4" style="height: 400px;margin-top: 140px;">
                <ul class="nav flex-column nav-pills mb-3 justify-content-center" id="pills-tab" role="tablist"
                    style="margin-bottom: 100px;border: 1px solid #D42304;padding-top: 20px;padding-bottom: 20px;">
                    <li class="nav-item">
                        <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab"
                            aria-controls="pills-home" aria-selected="true">${listInfor.get(0).title } <span class="pull-right hidden-xs showopacity fa fa-th-large" style="margin-left: 225px;"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pills-home2-tab" data-toggle="pill" href="#pills-home4" role="tab"
                            aria-controls="pills-home2" aria-selected="false">${listInfor.get(1).title }<span class="pull-right hidden-xs showopacity fa fa-flag-checkered" style="margin-left: 175px;"></span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pills-home3-tab" data-toggle="pill" href="#pills-home3" role="tab"
                            aria-controls="pills-home3" aria-selected="false">${listInfor.get(2).title } <span class="pull-right hidden-xs showopacity fa fa-unlock-alt" style="margin-left: 158px;"></span>
                            </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pills-home4-tab" data-toggle="pill" href="#pills-home2" role="tab"
                            aria-controls="pills-home4" aria-selected="false">${listInfor.get(3).title }<span class="pull-right hidden-xs showopacity fa fa-users" style="margin-left: 73px;"></span></a>
                    </li>
                </ul>
            </div>
            <div class="col-8" >
                <div class="tab-content" id="pills-tabContent" style="margin-top: 140px;">
                    <div class="tab-pane fade show active" id="pills-home" role="tabpanel"
                        aria-labelledby="pills-home-tab" style=" text-align: justify;">
                        <h4 style="color:brown;text-transform: uppercase;">${listInfor.get(0).title }</h4>
                        ${listInfor.get(0).description }
                    </div>
                    <div class="tab-pane fade" id="pills-home2" role="tabpanel" aria-labelledby="pills-home2-tab" style=" text-align: justify;">
                        <h4 style="color:brown;text-transform: uppercase;">${listInfor.get(1).title }</h4>
                        ${listInfor.get(1).description }
                    </div>
                    <div class="tab-pane fade" id="pills-home3" role="tabpanel" aria-labelledby="pills-home3-tab" style=" text-align: justify;">
                        <h4 style="color:brown;text-transform: uppercase;">${listInfor.get(2).title }</h4>
                        ${listInfor.get(2).description }
                    </div>
                    <div class="tab-pane fade" id="pills-home4" role="tabpanel" aria-labelledby="pills-home4-tab" style=" text-align: justify;">
                        <h4 style="color:brown;text-transform: uppercase;">${listInfor.get(3).title }</h4>
                        ${listInfor.get(3).description }
                    </div>
                </div>
            </div>
        
        
    
    

       <%@ include file="/user/footer/footer.jsp"  %>
</body>

</html>