<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title>Accueil</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Poppins:300,300i,400,500,600,700,800,900,900i%7CPT+Serif:400,700">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/style.css">
    <style>.ie-panel{display: none;background: #212121;padding: 10px 0;box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3);clear: both;text-align:center;position: relative;z-index: 1;} html.ie-10 .ie-panel, html.lt-ie-10 .ie-panel {display: block;}</style>
  </head>
  <body>
    <div class="preloader">
      <div class="preloader-body">
        <div class="cssload-container">
          <div class="cssload-speeding-wheel"></div>
        </div>
        <p>Loading...</p>
      </div>
    </div>
    <div class="page">
    <!-- Page Header-->
      <header class="section page-header">
        <!-- RD Navbar-->
        <div class="rd-navbar-wrap">
          <nav class="rd-navbar rd-navbar-classic" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-static" data-xl-layout="rd-navbar-static" data-xl-device-layout="rd-navbar-static" data-lg-stick-up-offset="46px" data-xl-stick-up-offset="46px" data-xxl-stick-up-offset="46px" data-lg-stick-up="true" data-xl-stick-up="true" data-xxl-stick-up="true">
            <div class="rd-navbar-main-outer">
              <div class="rd-navbar-main">
                <!-- RD Navbar Panel-->
                <div class="rd-navbar-panel"> 
                  <!-- RD Navbar Toggle-->
                  <!-- RD Navbar Brand-->
                </div>
                <div class="rd-navbar-main-element">
                  <div class="rd-navbar-nav-wrap">
                    <!-- RD Navbar Nav-->
                    <ul class="rd-navbar-nav">
                      <li class="rd-nav-item active"><a class="rd-nav-link" href="index.html">Accueil</a>
                      </li>
                      <li class="rd-nav-item"><a class="rd-nav-link" href="about-us.html">About</a>
                      </li>
                      <li class="rd-nav-item"><a class="rd-nav-link" href="typography.html">Nos repas</a>
                      </li>
                      
                      </li>
                    </ul>
                  </div>
                </div><a class="button button-white button-sm" href="#">Créer un Compte</a>
                      <a class="button button-white button-sm" href="#">Se Connecter</a>
              </div>
            </div>
          </nav>
        </div>
      </header>
      <!-- Swiper-->
      <section class="section section-lg section-main-bunner section-main-bunner-filter text-center">
        <div class="main-bunner-img" style="background-image: url(&quot;images/bg-bunner-2.jpg&quot;); background-size: cover;"></div>
        <div class="main-bunner-inner">
          <div class="container">
            <div class="box-default">
              <h1 class="box-default-title">Bienvenu </h1>
              <div class="box-default-decor"></div>
              <p class="big box-default-text">Nos plats marocains à emporter!</p>
            </div>
          </div>
        </div>
       
      </section>
      
         
        <section class="section section-lg section-inset-1 bg-gray-1 pt-lg-0">
          <div class="container">
            <div class="row row-50 justify-content-xl-between align-items-lg-center">
              <div class="col-lg-6 wow fadeInLeft">
                <div class="box-image"><img class="box-image-static" src="images/signature-1-140x50.png" alt="" width="483" height="327"/>
                <img class="box-image-position" src="images/home-3-1-483x327.jpg" alt="" width="341" height="391"/>
                </div>
              </div>
              <div class="col-lg-6 col-xl-5 wow fadeInRight">
                <h2>Nos repas traditionnels</h2>
                <p>Nous sommes heureux de vous accueillir dans une ambiance conviviale et chaleureuse et pour vous faire découvrir une cuisine marocaine (beldi) qui allie originalité et raffinement. La direction et toute l’équipe du restaurant L'ARGANIER 
                vous souhaitent la bienvenue. On vous souhaite une agréable visite. Soyer le Bienvenue.</p>
                <img src="images/signature-1-140x50.png" alt="" width="140" height="50"/>
              </div>
            </div>
          </div>
        </section>
      </div>
      <!-- Featured Offers-->
      <section class="section section-lg bg-default">
        <div class="container">
        <h2 style="text-align:center">Decouvrez nos plats</h2>
          <div class="row justify-content-center text-center">
          <%@ page import="dao.RepasDao,dao.DaoFactory, model.Repas,java.util.*" %>
                     <% 
                     RepasDao repasDao;
                    
                     DaoFactory daoFactory = DaoFactory.getInstance();
                     repasDao = daoFactory.getRepasDao();
            		List<Repas> listrepas =  repasDao.lister();
            		Iterator<Repas> iter = listrepas.iterator();
            		%>
          
              <% while(iter.hasNext()){
                    	Repas repas = iter.next();
                    	int id=repas.getId();
                    	%>
                    	
                       
           
           
            <div class="col-md-6 col-lg-4 wow-outer">
              <div class="wow fadeInUp">
                <div class="product-featured">
                  <div class="product-featured-figure"><img src="<%=repas.getUrl()%>" alt="" width="300" height="300"/>
                    <div class="product-featured-button"><a class="button button-primary" href="<%= request.getContextPath() %>/CommandeServlet?id=<%=repas.getId()%>">order now</a></div>
                  </div>
                  <div class="product-featured-caption">
                    <h4><a class="product-featured-title" href="#"><%=repas.getTitre() %></a></h4>
                    <p class="big"><%=repas.getPrix() %> Dh</p>
                  </div>
                </div>
              </div>
            </div>
             <% } %>
           
          </div>
        </div>
      </section>
      
     
      <!-- Page Footer-->
      <footer class="section footer-minimal context-dark">
        <div class="container wow-outer">
          <div class="wow fadeIn">
            <div class="row row-60">
              <div class="col-12"><a href="index.html"><img src="images/logo-default1-140x57.png" alt="" width="140" height="57" srcset="images/logo-default-280x113.png 2x"/></a></div>
              <div class="col-12">
                <ul class="footer-minimal-nav">
                  <li><a href="#">Menu</a></li>
                  <li><a href="#">Blog</a></li>
                  <li><a href="contacts.html">Contacts</a></li>
                  <li><a href="#">Gallery</a></li>
                  <li><a href="about-us.html">About</a></li>
                </ul>
              </div>
              <div class="col-12">
                <ul class="social-list">
                  <li><a class="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-facebook" href="#"></a></li>
                  <li><a class="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-instagram" href="#"></a></li>
                  <li><a class="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-twitter" href="#"></a></li>
                  <li><a class="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-youtube-play" href="#"></a></li>
                  <li><a class="icon icon-sm icon-circle icon-circle-md icon-bg-white fa-pinterest-p" href="#"></a></li>
                </ul>
              </div>
            </div>
            <p class="rights"><span>&copy;&nbsp; </span><span class="copyright-year"></span><span>&nbsp;</span><span>Pesto</span><span>.&nbsp;</span><span>All Rights Reserved.</span><span>&nbsp;</span><a href="#">Privacy Policy</a>. Design&nbsp;by&nbsp;<a href="https://www.templatemonster.com">Templatemonster</a></p>
          </div>
        </div>
      </footer>
    </div>
    <div class="snackbars" id="form-output-global"></div>
    <script src="js/core.min.js"></script>
    <script src="js/script.js"></script>
  </body>

</html>