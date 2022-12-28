<!DOCTYPE html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <head>
       
        <title>korean liquor project</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Simple line icons-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="styles.css" rel="stylesheet" />
    </head>
    <style>
    #input1{
    	width:600px;
    	height:50px;
    	opacity:0.5;
    	border-radius:5px;
    	outline: none;
    	border: none;
    	border: 1.5px solid black;
    	border-radius:20px;
    	}
    
#input2{
   		width:100px;
   		height:50px;
   		border-radius:20px;
   		outline: none;
    	border: none;
    	border: 1.5px solid black;
    	background-color: black;
    	color: white;
   		
   		}
    </style>
    <body id="page-top">
        <!-- Navigation-->
        <a class="menu-toggle rounded" href="#"></a>
        <nav id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand"><a href="#page-top"><i class="fa-solid fa-magnifying-glass"></i></a></li>
                <li class="sidebar-nav-item"><a href="#about">Home</a></li>
                <li class="sidebar-nav-item"><a href="#liquor">Liquor</a></li>
                <li class="sidebar-nav-item"><a href="#services">about us</a></li>
                <li class="sidebar-nav-item"><a href="./login/login.jsp">Login</a></li>
            </ul>
        </nav>
        <!-- Header-->
        <header class="masthead d-flex align-items-center">
            <div class="container px-4 px-lg-5 text-center">
                <h1 class="mb-1">Korea Liquor</h1>
                <br><br>
                <div class="search-form">
				<form action="" method="post">
				<input id="input1" type="text" name="" placeholder="Search" >
				<input id="input2" type="submit" value="검색">
				</form>
                <br><br><br>
                <a class="btn btn-primary btn-xl" href="#about">Learn More</a>
            </div>
        </header>
        <!-- About-->
        <section class="content-section bg-light" id="about">
            <div class="container px-4 px-lg-5 text-center">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-10">
                        <h2>TRADITIONAL LIQUORS & WINES!</h2>
                        <p class="lead mb-5">
                            한국인에게 술은 무병장수와 건강을 원하는 염원이 담겨있습니다. 그래서 예부터 가정마다 술을 빚었고 그로 인해 '가양주'란 전통이 생겨났습니다. 현대사회로 접어들면서 가양주의 전통은 찾아보기 힘들지만 지방마다 한국의 아름다운 풍습을 반영한 전통적인 술 문화는 살아남았습니다. 특히 깨끗한 물과 정성으로 빚은 약주, 탁주, 증류 소주가 한국을 대표하는 술입니다. 술은 제사, 손님접대, 부모 봉양, 농사일 등의 행사에 늘 함께했고 특히 찾아오는 손님을 물리치지 않는 우리 풍속에 따라 주인은 늘 손님에게 술을 권하고 손님은 주인과 식사를 나누며 함께 다정하게 시간을 보내는 것이 일반적이었습니다.
                            <a href="https://thesool.com/front/contents/M000000074/view.do">전통주갤러리</a>
                            
                        </p>
                        <a class="btn btn-dark btn-xl" href="#liquor">What We Offer</a>
                    </div>
                </div>
            </div>
        </section>
        
        <!-- Portfolio-->
        <section class="content-section" id="liquor">
            <div class="container px-4 px-lg-5">
                <div class="content-section-heading text-center">
                    <h3 class="text-secondary mb-0">Liquor</h3>
                    <h2 class="mb-5">categorize</h2>
                </div>
                <div class="row gx-0">
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="index.jsp?center=DrinkListCon.do">
                            <div class="caption">
                                <div class="caption-content">
                                    <div class="h2">Soju</div>
                                    <p class="mb-0">Soju is traditionally made from the grain of rice, wheat, or barley, modern producers often replace rice with other starches, such as potato and sweet potato!</p>
                                </div>
                            </div>
                            <img class="img-fluid" src="img/isback.jpg" alt="..." />
                        </a>
                    </div>
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="index.jsp?center=DrinkListCon.do">
                            <div class="caption">
                                <div class="caption-content">
                                    <div class="h2">Liquor</div>
                                    <p class="mb-0">Liquor is an alcoholic drink produced by distillation of grains, fruits, vegetables, or sugar, that have already gone through alcoholic fermentation. Other terms for liquor include: spirit drink, distilled beverage or hard liquor.!</p>
                                </div>
                            </div>
                            <img class="img-fluid" src="img/one.jpg" alt="..." />
                        </a>
                    </div>
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="index.jsp?center=DrinkListCon.do">
                            <div class="caption">
                                <div class="caption-content">
                                    <div class="h2">Makgeolli(Takju)</div>
                                    <p class="mb-0">Makgeolli, sometimes anglicized to makkoli, is a Korean alcoholic beverage!</p>
                                </div>
                            </div>
                            <img class="img-fluid" src="img/makgeoli.jpg" alt="..." />
                        </a>
                    </div>
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="index.jsp?center=DrinkListCon.do">
                            <div class="caption">
                                <div class="caption-content">
                                    <div class="h2">Wine</div>
                                    <p class="mb-0">Wine is an alcoholic drink typically made from fermented grapes. Yeast consumes the sugar in the grapes and converts it to ethanol and carbon dioxide, releasing heat in the process.</p>
                                </div>
                            </div>
                            <img class="img-fluid" src="img/wine.jpg" alt="..." />
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services-->
        <section class="content-section bg-primary text-white text-center" id="services">
            <div class="container px-4 px-lg-5">
                <div class="content-section-heading">
                    <h3 class="text-secondary mb-0">Team</h3>
                    <h2 class="mb-5">Who we are</h2>
                </div>
                <div class="row gx-4 gx-lg-5">
                    <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
                        <img class="service-icon rounded-circle mx-auto mb-3" src="img/sehwon.jpg" alt="..." />
                        <h4><strong>Sehwan Yum</strong></h4>
                        <p class="text-faded mb-0">Head of Team<br>BACKEND</p>
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
                        <img class="service-icon rounded-circle mx-auto mb-3" src="img/jinwoo.PNG" alt="..." />
                        <h4><strong>Jinu Park</strong></h4>
                        <p class="text-faded mb-0">Team member<br>BACKEND</p>
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
                        <img class="service-icon rounded-circle mx-auto mb-3" src="img/miseon.png" alt="..." />
                        <h4><strong>miseon Park</strong></h4>
                        <p class="text-faded mb-0">Team member<br>BACKEND</p>
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-0">
                        <img class="service-icon rounded-circle mx-auto mb-3" src="img/ye.jpeg" alt="..." />
                        <h4><strong>Ungbin Gim</strong></h4>
                        <p class="text-faded mb-0">Team member<br>FRONTEND</p>
                    </div>
                    
                </div>
            </div>
        </section>
        <!-- Callout-->
        <section class="callout">
            <div class="container px-4 px-lg-5 text-center">
                <h2 class="mx-auto mb-5">
                    Share
                    <em>your</em>
                    Liquor Life!
                </h2>
                <a class="btn btn-primary btn-xl" href="https://startbootstrap.com/theme/stylish-portfolio/">Click Me!</a>
            </div>
        </section>

        <!-- Footer-->
       <!--  <footer class="footer text-center">
            <div class="container px-4 px-lg-5">
                <ul class="list-inline mb-5">
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white mr-3" href="#!"><i class="icon-social-facebook"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white mr-3" href="#!"><i class="icon-social-twitter"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white" href="#!"><i class="icon-social-github"></i></a>
                    </li>
                </ul>
                <p class="text-muted small mb-0">Copyright &copy; Your Website 2022</p>
            </div>
        </footer> -->
        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top"><i class="fas fa-angle-up"></i></a>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
