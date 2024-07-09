<%-- 
    Document   : category
    Created on : Mar 2, 2024, 11:03:34 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.Product" %>
<%@page import="Model.Category" %>
<%@page import="Model.Color" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="CodePixar">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Phone Shop</title>

        <!--
            CSS
            ============================================= -->
        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/nouislider.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">

        <style>
            .single-product img {
                margin-bottom: 20px;
                width: 100%;
                border: 1px solid;
                box-shadow: 1px 1px 1px #b7aaaa;
            }
            .category-list .single-product {
                margin-top: 30px;
                border-bottom: 1px solid;
            }
            img.img_week {
                width: 70px;
                height: 70px;
            }
            .ma{
                color: #ffba00 !important;
            }
            .cate {
                color:  #777777;
            }
            .filter-list {
                transition: right linear 0.1s;
            }
            .filter-list:hover {
                right: -5px;
                color: #ffba00 !important;
            }
            button.btn {
                margin-right: 20px;
                margin-top: 8px;
            }
            button.btn {
                background: #828bb3;
                color: #fff;
                border-radius: 50%;
            }
            button.btn:hover{
                background: #ff6c00
            }
            form.form_add {
                display: inline;
            }
            button.btn {
                margin-left: 5px;
                margin-top: -3px;
            }
        </style>
    </head>

    <body id="category">

        <!-- Start Header Area -->
        <header class="header_area sticky-header">
            <div class="main_menu">
                <nav class="navbar navbar-expand-lg navbar-light main_box">
                    <div class="container">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <a class="navbar-brand logo_h" href="home"><img src="img/logo.png" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                            <ul class="nav navbar-nav menu_nav ml-auto">
                                <li class="nav-item active"><a class="nav-link" href="home">Home</a></li>
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Shop</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item"><a class="nav-link" href="single_product">Product Details</a></li>

                                        <li class="nav-item"><a class="nav-link" href="cart">Shopping Cart</a></li>

                                    </ul>
                                </li>


                                <% if (session.getAttribute("account") == null) { %>

                                <li class="nav-item submenu dropdown">
                                    <a href="login" class="nav-link dropdown-toggle" >Login</a>
                                </li>
                                <% } else { %>

                                <li class="nav-item submenu">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Welcome ${sessionScope.account.getUserName()}</a>
                                    <ul class="dropdown-menu">
                                        <% if (session.getAttribute("role") != null && (int) session.getAttribute("role") == 0) { %>

                                        <li class="nav-item"><a class="nav-link" href="manager">Manager</a></li>
                                            <% } %>
                                        <li class="nav-item"><a class="nav-link" href="user_profile">Profile</a></li>

                                        <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
                                    </ul>
                                </li>
                                <% } %>



                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li class="nav-item"><a href="cart" class="cart"><span class="ti-bag"></span></a></li>
                                <li class="nav-item">
                                    <button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="search_input" id="search_input_box">
                <div class="container">
                    <form class="d-flex justify-content-between" method="post">
                        <input type="text" class="form-control" id="search_input" placeholder="Search Here" name="searchProductName">
                        <input type="hidden" name="index" value="${requestScope.indexPage}">
                        <input type="hidden" name="cate" value="${requestScope.cateId}">
                        <input type="hidden" name="color" value="${requestScope.colorId}">
                        <button type="submit" class="btn"><span class="lnr lnr-magnifier" id="search"></span></button>
                        <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
                    </form>
                </div>

            </div>
        </header>
        <!-- End Header Area -->

        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Shop Category page</h1>
                        <nav class="d-flex align-items-center">
                            <a href="home">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                            <a href="category.html">Fashon Category</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-lg-4 col-md-5">
                    <div class="sidebar-filter mt-50">
                        <div class="top-filter-head">Product Filters</div>
                        <div class="common-filter">
                            <div class="head">Brands</div>

                            <ul>
                                <c:forEach items="${requestScope.categorys}" var="c">
                                    <li class="filter-list">
                                        <a href="home?index=${requestScope.indexPage}&cate=${c.getCategoryId()}" class="cate ${requestScope.cateId == c.getCategoryId() ? 'ma' : ''}">
                                            ${c.getCategoryName()}<span>(${c.getTotalProduct()})</span>
                                        </a>
                                    </li>
                                </c:forEach>


                            </ul>



                        </div>
                        <!-- Existing code... -->

                        <div class="common-filter">
                            <div class="head">Color</div>

                            <ul>
                                <c:forEach items="${requestScope.colors}" var="c">
                                    <li class="filter-list">
                                        <a href="home?index=${requestScope.indexPage}&color=${c.getColorId()}" class="cate ${requestScope.colorId == c.getColorId() ? 'ma' : ''}">
                                            ${c.getName()}<span>(${c.getTotalColor()})</span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>

                        </div>

                        <!-- Existing code... -->

                        <div class="common-filter">


                        </div>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-8 col-md-7">
                    <!-- Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-center">
                        <form action="home" method="get" id="sortForm">
                            <div class="sorting">
                                <!--                                <form action="home" method="get" id="sortForm">
                                                                    <select name="sortOption" id="sortOption" onchange="submitForm()">
                                                                        <option value="default">Default sorting</option>
                                                                        <option value="asc">Price from low to high</option>
                                                                        <option value="desc">Price from high to low</option>
                                                                    </select>
                                                                    <input type="hidden" name="cate" value="${requestScope.cateId}" />
                                                                </form>-->

                            </div>
                        </form>

                        <div class="sorting mr-auto">

                        </div>
                        <div class="pagination">
                            <c:if test="${requestScope.indexPage > 1}">
                                <a href="home?index=${requestScope.indexPage - 1}&sortOption=${requestScope.sortOption}&cate=${requestScope.cateId}" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
                                </c:if>

                            <c:forEach begin="1" end="${requestScope.numberPage}" var="i">
                                <c:url value="home" var="pageUrl">
                                    <c:param name="index" value="${i}" />
                                    <c:param name="cate" value="${requestScope.cateId}" />
                                    <c:param name="color" value="${requestScope.colorId}" />
                                    <c:param name="searchProductName" value="${requestScope.searchProductName}" />
                                </c:url>
                                <a href="${pageUrl}" class="${requestScope.indexPage == i ? 'active' : ''}">${i}</a>
                            </c:forEach>

                            <c:if test="${requestScope.indexPage < requestScope.numberPage}">
                                <a href="home?index=${requestScope.indexPage + 1}&cate=${requestScope.cateId}" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
                                </c:if>

                        </div>

                    </div>
                    <!-- End Filter Bar -->
                    <!-- Start Best Seller -->

                    <section class="lattest-product-area pb-40 category-list">
                        <div class="row">

                            <!-- single product -->
                            <%
                                 ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
                                 for(Product p : products) {
                            %>
                            <div class="col-lg-4 col-md-6">
                                <div class="single-product">
                                    <img class="img-fluid" src="<%=p.getImagePath()%>" alt="">
                                    <div class="product-details">
                                        <h6><%=p.getProductName()%></h6>
                                        <div class="price">
                                            <h6>$<%=p.getOriginalPrice()%></h6>
                                            <h6 class="l-through">$<%=p.getPrice()%></h6>
                                        </div>
                                        <div class="prd-bottom">
                                            <form action="home" method="post" class="form_add">
                                                <button type="submit" class="btn" value="buy item">

                                                    Add cart
                                                    <input type="hidden" value="<%=p.getProductId()%>" name="pId"/>
                                                    <input type="hidden" value="1" name="num"/>
                                                    <input type="hidden" value="${sessionScope.uId}" name="uId"/>
                                                </button>


                                            </form>                      
                                            <button onclick="location.href = 'single_product?productId=<%=p.getProductId()%>'" class="btn">

                                                View more
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>
                    </section>

                    <!-- End Best Seller -->

                    <!-- Start Filter Bar -->

                    <!-- End Filter Bar -->
                </div>
            </div>
        </div>

        <!-- Start related-product Area -->
        <section class="related-product-area section_gap">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6 text-center">
                        <div class="section-title">
                            <h1>Deals of the Week</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-9">
                        <div class="row">
                            <%
                                
                                for (int p = 0; p < Math.min(products.size(), 9); p++) {
                                    Product product = products.get(p);
                            %>
                            <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                                <div class="single-related-product d-flex">
                                    <a  href="#"><img class="img_week" src="<%= product.getImagePath() %>" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title"><%= product.getProductName() %></a>
                                        <div class="price">
                                            <h6>$<%= product.getOriginalPrice() %></h6>
                                            <h6 class="l-through">$<%= product.getPrice() %></h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ctg-right">
                            <a href="#" target="_blank">
                                <img class="img-fluid d-block mx-auto" src="img/category/c5.jpg" alt="">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- End related-product Area -->

        <!-- start footer Area -->
        <footer class="footer-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>About Us</h6>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore
                                magna aliqua.
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-4  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Newsletter</h6>
                            <p>Stay update with our latest</p>
                            <div class="" id="mc_embed_signup">

                                <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                      method="get" class="form-inline">

                                    <div class="d-flex flex-row">

                                        <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '"
                                               required="" type="email">


                                        <button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button>
                                        <div style="position: absolute; left: -5000px;">
                                            <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                                        </div>

                                        <!-- <div class="col-lg-4 col-md-4">
                                                                        <button class="bb-btn btn"><span class="lnr lnr-arrow-right"></span></button>
                                                                </div>  -->
                                    </div>
                                    <div class="info"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget mail-chimp">
                            <h6 class="mb-20">Instragram Feed</h6>
                            <ul class="instafeed d-flex flex-wrap">
                                <li><img src="img/i1.jpg" alt=""></li>
                                <li><img src="img/i2.jpg" alt=""></li>
                                <li><img src="img/i3.jpg" alt=""></li>
                                <li><img src="img/i4.jpg" alt=""></li>
                                <li><img src="img/i5.jpg" alt=""></li>
                                <li><img src="img/i6.jpg" alt=""></li>
                                <li><img src="img/i7.jpg" alt=""></li>
                                <li><img src="img/i8.jpg" alt=""></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Follow Us</h6>
                            <p>Let us be social</p>
                            <div class="footer-social d-flex align-items-center">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-dribbble"></i></a>
                                <a href="#"><i class="fa fa-behance"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
                    <p class="footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                </div>
            </div>
        </footer>
        <!-- End footer Area -->

        <!-- Modal Quick Product View -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="container relative">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <div class="product-quick-view">
                        <div class="row align-items-center">
                            <div class="col-lg-6">
                                <div class="quick-view-carousel">
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="quick-view-content">
                                    <div class="top">
                                        <h3 class="head">Mill Oil 1000W Heater, White</h3>
                                        <div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span></div>
                                        <div class="category">Category: <span>Household</span></div>
                                        <div class="available">Availibility: <span>In Stock</span></div>
                                    </div>
                                    <div class="middle">
                                        <p class="content">Mill Oil is an innovative oil filled radiator with the most modern technology. If you are
                                            looking for something that can make your interior look awesome, and at the same time give you the pleasant
                                            warm feeling during the winter.</p>
                                        <a href="#" class="view-full">View full Details <span class="lnr lnr-arrow-right"></span></a>
                                    </div>
                                    <div class="bottom">
                                        <div class="color-picker d-flex align-items-center">Color:
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                        </div>
                                        <div class="quantity-container d-flex align-items-center mt-15">
                                            Quantity:
                                            <input type="text" class="quantity-amount ml-15" value="1" />
                                            <div class="arrow-btn d-inline-flex flex-column">
                                                <button class="increase arrow" type="button" title="Increase Quantity"><span class="lnr lnr-chevron-up"></span></button>
                                                <button class="decrease arrow" type="button" title="Decrease Quantity"><span class="lnr lnr-chevron-down"></span></button>
                                            </div>

                                        </div>
                                        <div class="d-flex mt-20">
                                            <a href="#" class="view-btn color-2"><span>Add to Cart</span></a>
                                            <a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
                                            <a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <!--gmaps Js-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
        <script src="js/gmaps.min.js"></script>
        <script src="js/main.js"></script>
    </body>
    <script type="text/javascript">
                            function submitForm() {
                                document.getElementById("sortForm").submit();
                            }
                            function submitCate() {
                                document.getElementById("sortCate").submit();
                            }
                            function buy(id) {
                                document.f.action = "home?pId=" + id;
                                document.f.submit();
                            }  
    </script>

</html>
