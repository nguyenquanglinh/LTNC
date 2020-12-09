<%-- 
    Document   : product-details
    Created on : Sep 14, 2020, 11:04:26 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html class="no-js" lang="en">


<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Ruiz - Watch Store HTML Template</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.ico">

    <!-- CSS
	============================================ -->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../jsp/assets/css/vendor/bootstrap.min.css">
    <!-- Icon Font CSS -->
    <link rel="stylesheet" href="../jsp/assets/css/vendor/font-awesome.min.css">
    <link rel="stylesheet" href="../jsp/assets/css/vendor/simple-line-icons.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="../jsp/assets/css/plugins/animation.css">
    <link rel="stylesheet" href="../jsp/assets/css/plugins/slick.css">
    <link rel="stylesheet" href="../jsp/assets/css/plugins/animation.css">
    <link rel="stylesheet" href="../jsp/assets/css/plugins/nice-select.css">
    <link rel="stylesheet" href="../jsp/assets/css/plugins/fancy-box.css">
    <link rel="stylesheet" href="../jsp/assets/css/plugins/jqueryui.min.css">

    <!-- Vendor & Plugins CSS (Please remove the comment from below vendor.min.css & plugins.min.css for better website load performance and remove css files from avobe) -->
    <!--
    <script src="assets/js/vendor/vendor.min.js"></script>
    <script src="assets/js/plugins/plugins.min.js"></script>
    -->

    <!-- Main Style CSS (Please use minify version for better website load performance) -->
    <link rel="stylesheet" href="../jsp/assets/css/style.css">
    <!--<link rel="stylesheet" href="assets/css/style.min.css">-->

</head>

<body>

    <div class="main-wrapper">
        
        <!--  Header Start -->
        <%@include file="header.jsp" %>
        <!--  Header Start -->
        
        <!-- breadcrumb-area start -->
        <div class="breadcrumb-area">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <!-- breadcrumb-list start -->
                        <ul class="breadcrumb-list">
                            <li class="breadcrumb-item"><a href="getAll.htm">Home</a></li>
                            <li class="breadcrumb-item active">Product Details</li>
                        </ul>
                        <!-- breadcrumb-list end -->
                    </div>
                </div>
            </div>
        </div>
        <!-- breadcrumb-area end -->

        <!-- main-content-wrap start -->
        <div class="main-content-wrap shop-page section-ptb">
          
            <div class="container">
               
                <div class="row  product-details-inner">
                    
                    <div class="col-lg-5 col-md-6">
                        
                        <!-- Product Details Left -->
                        <div class="product-large-slider">
                            <div class="pro-large-img img-zoom">
                                <img src="${p.imageLink}" alt="product-details" />
                                <a href="${p.imageLink}" data-fancybox="images"><i class="fa fa-search"></i></a>
                            </div>
                              <div class="pro-large-img img-zoom">
                                <img src="${p.imageLink}" alt="product-details" />
                                <a href="${p.imageLink}" data-fancybox="images"><i class="fa fa-search"></i></a>
                        </div>
                            
                            
                            

                        </div>
                        <div class="product-nav">
                            
                            <div class="pro-nav-thumb">
                                <img src="${p.imageLink}" alt="product-details" />
                            </div>
                            <div class="pro-nav-thumb">
                                <img src="${p.imageLink}" alt="product-details" />
                            </div>
                            <div class="pro-nav-thumb">
                                <img src="${p.imageLink}" alt="product-details" />
                            </div>
                            <div class="pro-nav-thumb">
                                <img src="${p.imageLink}" alt="product-details" />
                            </div>
                            <div class="pro-nav-thumb">
                                <img src="${p.imageLink}" alt="product-details" />
                            </div>
                            
                        </div>
                            
                        <!--// Product Details Left -->
                    </div>
                    
                    

                    <div class="col-lg-7 col-md-6">
                        <div class="product-details-view-content">
                            <div class="product-info">
                                
                                <h3>${p.productName}</h3>
                                <div class="product-rating d-flex">
                                    <ul class="d-flex">
                                        
                                       
                                        <li><a href="OneStar.htm"><i class="icon-star"></i></a></li>
                                        <li><a href="#"><i class="icon-star"></i></a></li>
                                        <li><a href="#"><i class="icon-star"></i></a></li>
                                        <li><a href="#"><i class="icon-star"></i></a></li>
                                        <li><a href="#"><i class="icon-star"></i></a></li>
                                    </ul>
                                    <a href="#reviews">(<span class="count">1</span> customer review)</a>
                                </div>
                                <div class="price-box">
                                    <span class="new-price">${p.price}</span>
                                    
                                </div>
                                <p>${p.descriptions}</p>
                           

                                <div class="single-add-to-cart">
                                    
                                    <form action="addCart.htm" class="cart-quantity d-flex">
                                        
                                        <div class="quantity">
                                            <div class="cart-plus-minus">
                                                <input value="1" type="number" class="input-text" name="quantity" title="Qty">
                                            </div>
                                        </div>
                                        <a href="<%=request.getContextPath()%>/cartController/addCart.htm?productId=${p.productId}" class="add-to-cart">Add To Card</a>
                                        
                                    </form>
                                            
                                </div>
                                <ul class="single-add-actions">
                                    <li class="add-to-wishlist">
                                        <a href="#" class="add_to_wishlist"><i class="icon-heart"></i> Add to Wishlist</a>
                                    </li>
                                    <li class="add-to-compare">
                                        <div class="compare-button"><a href="#"><i class="icon-refresh"></i> Compare</a></div>
                                    </li>
                                </ul>
                                <ul class="stock-cont">
                                </ul>
                                
                                
                            </div>
                        </div>
                    </div>
                   
                    
                                    
                </div>

                <div class="product-description-area section-pt">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product-details-tab">
                                <ul role="tablist" class="nav">
                                    <li class="active" role="presentation">
                                        <a data-toggle="tab" role="tab" href="#description" class="active">Description</a>
                                    </li>
                                    <li role="presentation">
                                        <a data-toggle="tab" role="tab" href="#reviews">Reviews</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="product_details_tab_content tab-content">
                                <!-- Start Single Content -->
                                <div class="product_tab_content tab-pane active" id="description" role="tabpanel">
                                    <div class="product_description_wrap  mt-30">
                                        <div class="product_desc mb-30">
                                            <p>${p.descriptions}</p>

                                           
                                        </div>

                                    </div>
                                </div>
                                <!-- End Single Content -->
                                <!-- Start Single Content -->
                                <div class="product_tab_content tab-pane" id="reviews" role="tabpanel">
                                    <div class="review_address_inner mt-30">
                                        <!-- Start Single Review -->
                                        <div class="pro_review">
                                            <div class="review_thumb">
                                                <img alt="review images" src="../jsp/assets/images/other/reviewer-60x60.jpg">
                                            </div>
                                            <div class="review_details">
                                                <div class="review_info mb-10">
                                                    <ul class="product-rating d-flex mb-10">
                                                        <li><span class="icon-star"></span></li>
                                                        <li><span class="icon-star"></span></li>
                                                        <li><span class="icon-star"></span></li>
                                                        <li><span class="icon-star"></span></li>
                                                        <li><span class="icon-star"></span></li>
                                                    </ul>
                                                    <h5>Admin - <span> November 19, 2019</span></h5>

                                                </div>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in viverra ex, vitae vestibulum arcu. Duis sollicitudin metus sed lorem commodo, eu dapibus libero interdum. Morbi convallis viverra erat, et aliquet orci congue vel. Integer in odio enim. Pellentesque in dignissim leo. Vivamus varius ex sit amet quam tincidunt iaculis.</p>
                                            </div>
                                        </div>
                                        <!-- End Single Review -->
                                    </div>
                                    <!-- Start RAting Area -->
                                    <div class="rating_wrap mt-50">
                                        <h5 class="rating-title-1">Add a review </h5>
                                        <p>Your email address will not be published. Required fields are marked *</p>
                                        <h6 class="rating-title-2">Your Rating</h6>
                                        <div class="rating_list">
                                            <div class="review_info mb-10">
                                                <ul class="product-rating d-flex mb-10">
                                                    <li><span class="icon-star"></span></li>
                                                    <li><span class="icon-star"></span></li>
                                                    <li><span class="icon-star"></span></li>
                                                    <li><span class="icon-star"></span></li>
                                                    <li><span class="icon-star"></span></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End RAting Area -->
                                    <div class="comments-area comments-reply-area">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <form action="#" class="comment-form-area">
                                                    <div class="row comment-input">
                                                        <div class="col-md-6 comment-form-author mt-15">
                                                            <label>Name <span class="required">*</span></label>
                                                            <input type="text" required="required" name="Name">
                                                        </div>
                                                        <div class="col-md-6 comment-form-email mt-15">
                                                            <label>Email <span class="required">*</span></label>
                                                            <input type="text" required="required" name="email">
                                                        </div>
                                                    </div>
                                                    <div class="comment-form-comment mt-15">
                                                        <label>Comment</label>
                                                        <textarea class="comment-notes" required="required"></textarea>
                                                    </div>
                                                    <div class="comment-form-submit mt-15">
                                                        <input type="submit" value="Submit" class="comment-submit">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Single Content -->
                            </div>
                        </div>
                    </div>
                </div>

                
                            <!-- single-product-area end -->
                        </div>
           
                    </div>
                
           
        <!-- main-content-wrap end -->

        <!-- footer Start -->
        <%@include file="footer.jsp" %>
        <!-- footer End -->

    </div>

    <!-- JS
============================================ -->

    <!-- Modernizer JS -->
    <script src="../jsp/assets/js/vendor/modernizr-3.6.0.min.js"></script>
    <!-- jQuery JS -->
    <script src="../jsp/assets/js/vendor/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="../jsp/assets/js/vendor/popper.min.js"></script>
    <script src="../jsp/assets/js/vendor/bootstrap.min.js"></script>

    <!-- Plugins JS -->
    <script src="../jsp/assets/js/plugins/slick.min.js"></script>
    
    <script src="../jsp/assets/js/plugins/jquery.nice-select.min.js"></script>
    <script src="../jsp/assets/js/plugins/countdown.min.js"></script>
    <script src="../jsp/assets/js/plugins/image-zoom.min.js"></script>
    <script src="../jsp/assets/js/plugins/fancybox.js"></script>
    <script src="../jsp/assets/js/plugins/scrollup.min.js"></script>
    <script src="../jsp/assets/js/plugins/jqueryui.min.js"></script>
     <script src="../jsp/assets/js/plugins/ajax-contact.js"></script>

    <!-- Vendor & Plugins JS (Please remove the comment from below vendor.min.js & plugins.min.js for better website load performance and remove js files from avobe) -->
    <!--
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
-->

    <!-- Main JS -->
    <script src="../jsp/assets/js/main.js"></script>

</body>

</html>
