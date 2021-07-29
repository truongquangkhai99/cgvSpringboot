<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Đăng kí</title>
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
      <section class="signup">
        <div class="container">
            <div class="signup-content" style="margin-top: 170px;">
                <div class="signup-form">
                    <h2 class="form-title" style="color: #D42304;">Sign up</h2>
                    <form method="POST" class="register-form" action="<%=request.getContextPath() %>/user/register" id="register-form">
                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="name" id="name" placeholder="Your Username" required="required"/>
                        </div>
                        <div class="form-group">
                          
                              <c:if test="${mess != null }"> 
                                <label for="email"><i style="color: red" class="zmdi zmdi-email"></i></label>
									 <input style="border-bottom-color: red" type="email" name="email" id="email" placeholder="Your Email" required="required"/>
							  </c:if> 
                           <c:if test="${mess == null }"> 
                             <label for="email"><i  class="zmdi zmdi-email"></i></label>
									 <input  type="email" name="email" id="email" placeholder="Your Email" required="required"/>
							  </c:if> 
                        </div>
                         <p style="color: red;font-size: 14px">${mess != null ? mess :null}</p>
                        <div class="form-group">
                          <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                          <input type="tel" name="phone" id="phone" pattern="[0]{1}[0-9]{9}"
                          placeholder="Your Phone" required="required"/>
                      </div>
                      <c:if test="${mess1 != null }"> 
									 <div class="form-group">
                            <label for="pass"><i style="color: red" class="zmdi zmdi-lock"></i></label>
                            <input style="border-bottom-color: red" type="password" name="pass" id="pass" placeholder="Password" required="required"/>
	                        </div>
	                        <div class="form-group">
	                            <label for="re-pass"><i style="color: red"  class="zmdi zmdi-lock-outline"></i></label>
	                            <input style="border-bottom-color: red" type="password" name="re_pass" id="re_pass"  placeholder="Repeat your password" required="required"/>
	                        </div>
							  </c:if> 
                           <c:if test="${mess1 == null }"> 
									  <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="pass" id="pass" placeholder="Password" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password" required="required"/>
                        </div>
							  </c:if> 
                       
                        <p style="color: red;font-size: 14px">${mess1 != null ? mess1 :null}</p>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" value="1" required/>
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup" class="form-submit" style="background-color:#A9A9A9" value="Register"/>
                        </div>
                    </form>
                   	
                </div>
                <div class="signup-image">
                    <figure><img src="images/signup.jpg" alt="sing up image"></figure>
                    <a href="<%= request.getContextPath() %>/user/login" class="signup-image-link" style="color: #D42304;">I am already member</a>
                </div>
            </div>
        </div>
    </section>
     <script language="javascript">
            document.getElementById('agree-term').onclick = function(e){
                if (this.checked){
                	document.getElementById("signup").style.background='#d42304';
                }
                else{
                	document.getElementById("signup").style.background='#A9A9A9';
                }
            };
        </script>
    <!--footer------------------>
    <%@ include file="/user/footer/footer.jsp"  %>
</body>

</html>