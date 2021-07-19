
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <title>Đăng nhập</title>
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
      
      <!-- Sign up form -->
      <section class="sign-in">
        <div class="container">
            <div class="signin-content" style="margin-top: 170px;">
                <div class="signin-image">
                    <figure><img src="images/signin.jpg" alt="sing up image"></figure>
                    <a href="dangki.html" class="signup-image-link" style="color: #D42304;">Create an account</a>
                </div>
                <div class="signin-form">
                    <h2 class="form-title" style="color: #D42304;">Sign In</h2>
                    <form method="POST" action="<%=request.getContextPath()%>/user/login" class="register-form" id="login-form">
                        <div class="form-group">
                            <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="email" id="your_name" placeholder="Email" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="pass" id="your_pass" placeholder="Password" required="required"/>
                        </div>
                        <p style="color: red">${mess != null ? mess :null}</p>
                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <!--footer------------------>
    <%@ include file="/user/footer/footer.jsp"  %>
</body>

</html>