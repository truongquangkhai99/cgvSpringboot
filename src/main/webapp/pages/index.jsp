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
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
  <link rel="shortcut icon" href="<c:url value="/user/images/favicon.png" />
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
 <nav>
    <!--logo--------------->
    <a href="phim.html" class="logo">
      <img src="<c:url value="/user/images/logo.png"/>" />
    </a>
    <!--menu--btn----------------->
    <input type="checkbox" class="menu-btn" id="menu-btn" />
    <label class="menu-icon" for="menu-btn">
      <span class="nav-icon"></span>
    </label>
    <!--menu-------------->
    <ul class="menu">
      <li><a href="Introduce1.html">Giới Thiệu</a></li>
      <li><a href="phim.html">Phim</a></li>
      <li><a href="dangnhap.html">Đăng Nhập</a></li>
      <li><a href="dangki.html">Đăng Kí</a></li>
    </ul>
    <!--search------------->
    <div class="search">
      <input type="text" placeholder="Find Your Favourtie Movies" />
      <!--search-icon----------->
      <i class="fas fa-search"></i>
    </div>
  </nav>
  <section id="main">
    <!--showcase----------------------->
    <!--heading------------->
    <h1 class="showcase-heading">Phim Sắp Chiếu</h1>

    <ul id="autoWidth" class="cs-hidden">
      <!--box-1--------------------------->
      <li class="item-a">
        <!--showcase-box------------------->
        <div class="showcase-box">
          <a href="#"><img src="<c:url value="/user/images/venom2.jpg"/>" /></a>
        </div>
      </li>
      <!--box-2--------------------------->
      <li class="item-b">
        <!--showcase-box------------------->
        <div class="showcase-box">
          <a href="#"><img src="<c:url value="/user/images/camtu.jpg"/>"  /></a>
          
        </div>
      </li>
      <!--box-3--------------------------->
      <li class="item-c">
        <!--showcase-box------------------->
        <div class="showcase-box">
          <a href="#"> <img src="images/hotel.jpg" /></a>
         
        </div>
      </li>
      <!--box-4--------------------------->
      <li class="item-d">
        <!--showcase-box------------------->
        <div class="showcase-box">
          <a href="#"><img src="images/kinhdi.jpg" /></a>
          
        </div>
      </li>
      <!--box-5--------------------------->
      <li class="item-e">
        <div class="showcase-box">
          <a href="#"><img src="images/baby.jpg" /></a>
          
        </div>
      </li>
    </ul>
  </section>

  <!--latest-movies---------------------->
  <section id="latest">
    <h2 class="latest-heading">KHUYẾN MÃI</h2>
    <!--slider------------------->
    <ul id="autoWidth2" class="cs-hidden">
      <!--slide-box-1------------------>
      <li class="item-a">
        <div class="latest-box">
          <!--img-------->
          <div class="latest-b-img">
            <a href="./Event/event1.html">
              <img src="./images/event1.PNG" /></a>
          </div>
          <!--text---------->
          <div class="latest-b-text">
            <strong><i class="fab fa-hotjar"></i></strong>
            <p>Ưu đãi Hot</p>
          </div>
        </div>
      </li>
      <!--slide-box-2------------------>
      <li class="item-b">
        <div class="latest-box">
          <!--img-------->
          <div class="latest-b-img">
            <a href="./Event/event2.html"><img src="./images/event2.PNG" /></a>
          </div>
          <!--text---------->
          <div class="latest-b-text">
            <strong><i class="fab fa-hotjar"></i></strong>
            <p>Ưu đãi Hot</p>
          </div>
        </div>
      </li>
      <!--slide-box-3------------------>
      <li class="item-c">
        <div class="latest-box">
          <!--img-------->
          <div class="latest-b-img">
            <a href="./Event/event3.html">
              <img src="./images/event3.PNG" /></a>
          </div>
          <!--text---------->
          <div class="latest-b-text">
            <strong><i class="fab fa-hotjar"></i></strong>
            <p>Ưu đãi Hot</p>
          </div>
        </div>
      </li>
      <!--slide-box-4------------------>
      <li class="item-d">
        <div class="latest-box">
          <!--img-------->
          <div class="latest-b-img">
            <a href="./Event/event4.html"><img src="./images/event4.PNG" /></a>
          </div>
          <!--text---------->
          <div class="latest-b-text">
            <strong><i class="fab fa-hotjar"></i></strong>
            <p>Ưu đãi Hot</p>
          </div>
        </div>
      </li>
      <!--slide-box-5------------------>
      <li class="item-e">
        <div class="latest-box">
          <!--img-------->
          <div class="latest-b-img">
            <a href="./Event/event5.html"><img src="./images/event5.PNG" /></a>
          </div>
          <!--text---------->
          <div class="latest-b-text">
            <strong><i class="fab fa-hotjar"></i></strong>
            <p>Ưu đãi Hot</p>
          </div>
        </div>
      </li>
      <!--slide-box-6------------------>
      <li class="item-f">
        <div class="latest-box">
          <!--img-------->
          <div class="latest-b-img">
            <a href="./Event/event6.html"><img src="./images/event6.PNG" /></a>
          </div>
          <!--text---------->
          <div class="latest-b-text">
            <strong><i class="fab fa-hotjar"></i></strong>
            <p>Ưu đãi Hot</p>
          </div>
        </div>
      </li>
      <!--slide-box-7------------------>
      <li class="item-g">
        <div class="latest-box">
          <!--img-------->
          <div class="latest-b-img">
            <a href="./Event/event7.html"><img src="./images/event7.PNG" /></a>
          </div>
          <!--text---------->
          <div class="latest-b-text">
            <strong><i class="fab fa-hotjar"></i></strong>
            <p>Ưu đãi Hot</p>
          </div>
        </div>
      </li>
    </ul>
  </section>

  <!--movies---------------------------->
  <div class="movies-heading">
    <h2>Phim Đang Chiếu</h2>
  </div>
  <section id="movies-list">
    <!--box-1------------------------>
    <div class="movies-box">
      <!--img------------>
      <div class="movies-img">
        <div class="quality">4K</div>
        <img src="images/bogia.jpg" />
      </div>
      <!--text--------->
      <a href="#"> Bố Già </a>
      <!-- Button trigger modal -->
      <div class="button--movie">
        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal1"
          style="margin-right: 20px">
          Trailer
        </button>
        <button type="button" class="btn btn-danger">Đặt Vé</button>
      </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-xl">
        <div class="modal-content">
          <div class="modal-body">
            <iframe width="1104" height="621" src="https://www.youtube.com/embed/jluSu8Rw6YE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>
    <!--box-2------------------------>
    <div class="movies-box">
      <!--img------------>
      <div class="movies-img">
        <div class="quality">4K</div>
        <img src="images/minion.jpg" />
      </div>
      <!--text--------->
      <a href="#"> Minions - Sự Trỗi Dậy Của Gru </a>
      <!-- Button trigger modal -->
      <div class="button--movie">
        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal2"
          style="margin-right: 20px">
          Trailer
        </button>
        <button type="button" class="btn btn-danger">Đặt Vé</button>
      </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-xl">
        <div class="modal-content">
          <div class="modal-body">
            <iframe width="1104" height="621" src="https://www.youtube.com/embed/54yAKyNkK7w" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>

    <!--box-3------------------------>
    <div class="movies-box">
      <!--img------------>
      <div class="movies-img">
        <div class="quality">4K</div>
        <img src="images/rom.jpg" />
      </div>
      <!--text--------->
      <a href="#"> Ròm </a>
      <!-- Button trigger modal -->
      <div class="button--movie">
        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal3"
          style="margin-right: 20px">
          Trailer
        </button>
        <button type="button" class="btn btn-danger">Đặt Vé</button>
      </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-xl">
        <div class="modal-content">
          <div class="modal-body">
            <iframe width="1104" height="621" src="https://www.youtube.com/embed/XRm1P7oGpMQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>
    <!--box-4------------------------>
    <div class="movies-box">
      <!--img------------>
      <div class="movies-img">
        <div class="quality">4K</div>
        <img src="images/anquy.jpg" />
      </div>
      <!--text--------->
      <a href="#"> Ấn Quỷ </a>
      <!-- Button trigger modal -->
      <div class="button--movie">
        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal4"
          style="margin-right: 20px">
          Trailer
        </button>
        <button type="button" class="btn btn-danger">Đặt Vé</button>
      </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal4" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-xl">
        <div class="modal-content">
          <div class="modal-body">
            <iframe width="1104" height="621" src="https://www.youtube.com/embed/NmQiJPLYzPI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>
    <!--box-5------------------------>
    <!-- <div class="movies-box">
      <div class="movies-img">
        <div class="quality">Full HD</div>
        <img src="images/l-5.jpg" />
      </div>
      <a href="#">
        Tin (2018) Full Movie[In English] With English Subtitles | HDRip 1080p
        HD
      </a>
    </div> -->
    <!-- box6 -->
    <!-- <div class="movies-box">
      <div class="movies-img">
        <div class="quality">4K</div>
        <img src="images/l-6.jpg" />
      </div>
      <a href="#">
        Tin (2018) Full Movie[In English] With English Subtitles | HDRip 1080p
        HD
      </a>
    </div> -->
    <!--box-7------------------------>
    <!-- <div class="movies-box">
      <div class="movies-img">
        <div class="quality">4K</div>
        <img src="images/l-7.jpg" />
      </div>
      <a href="#">
        Tin (2018) Full Movie[In English] With English Subtitles | HDRip 1080p
        HD
      </a>
    </div> -->
    <!--box-8------------------------>
    <!-- <div class="movies-box"> 
      <div class="movies-img">
        <div class="quality">4K</div>
        <img src="images/l-8.jpg" />
      </div>
      <a href="#">
        Tin (2018) Full Movie[In English] With English Subtitles | HDRip 1080p
        HD
      </a>
    </div> -->
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
  <footer>
    <div class="footer--info">
      <div class="footer--item">
        <img src="./images/logo.png" alt="" class="footer--logo" />
      </div>
      <div class="footer--item">
        <iframe
          src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15335.564408777373!2d108.2238517!3d16.0711398!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xbb4619d455ec4348!2zUuG6oXAgQ2hp4bq_dSBwaGltIEzDqiDEkOG7mQ!5e0!3m2!1sen!2s!4v1622430693961!5m2!1sen!2s"
          width="300" height="200" style="border: 0" allowfullscreen="" loading="lazy"></iframe>
      </div>
      <div class="footer--item">
        Contact:

        <a href="https://www.facebook.com/">
          <i class="fab fa-facebook-f footer--media"></i></a>
        <a href="https://www.instagram.com/">
          <i class="fab fa-instagram footer--media"></i></a>
        <a href="https://www.youtube.com/">
          <i class="fab fa-youtube footer--media"></i></a>
        <a href="https://www.google.com/">
          <i class="fab fa-google footer--media"></i></a>
      </div>
      <div class="footer--item">
        <div class="footer--support">
          <span style="text-transform: uppercase; color: #d42304">Chăm sóc khách hàng:</span>
          <br />
          <br />
          Hotline: 1900 112 113<br />
          <br />
          Giờ làm việc: 8:00 - 22:00 (Tất cả các ngày bao gồm cả Lễ Tết)<br />
          <br />
          Email hỗ trợ:<span style="color: #d42304"> hoidap@ledo.vn</span>

          <br />
          Bản quyền thuộc @
          <span style="color: #d42304">Dang Khoa.author</span>
        </div>
      </div>
    </div>
  </footer>
</body>

</html>