<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>LaptopNow</title>

                    <!-- Google Web Fonts -->
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link
                        href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                        rel="stylesheet">

                    <!-- Icon Font Stylesheet -->
                    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                        rel="stylesheet">

                    <!-- Libraries Stylesheet -->
                    <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
                    <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


                    <!-- Customized Bootstrap Stylesheet -->
                    <link href="/client/css/bootstrap.min.css" rel="stylesheet">

                    <!-- Template Stylesheet -->
                    <link href="/client/css/style.css" rel="stylesheet">
                </head>

                <body>

                    <!-- Spinner Start -->
                    <div id="spinner"
                        class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
                        <div class="spinner-grow text-primary" role="status"></div>
                    </div>
                    <!-- Spinner End -->

                    <jsp:include page="../layout/header.jsp" />



                    <!-- Hero Start -->
                    <jsp:include page="../layout/banner.jsp" />
                    <!-- Hero End -->

                    <!-- Featurs Section Start -->
                    <jsp:include page="../layout/featurs.jsp" />
                    <!-- Featurs Section End -->


                    <!-- Fruits Shop Start-->
                    <div class="container-fluid fruite py-5">
                        <div class="container py-5">
                            <div class="tab-class text-center">
                                <div class="row g-4">
                                    <div class="col-lg-4 text-start">
                                        <h1>Our Organic Products</h1>
                                    </div>
                                    <div class="col-lg-8 text-end">
                                        <ul class="nav nav-pills d-inline-flex text-center mb-5">
                                            <li class="nav-item">
                                                <a class="d-flex m-2 py-2 bg-light rounded-pill active"
                                                    href="/products">
                                                    <span class="text-dark" style="width: 130px;">All Products</span>
                                                </a>

                                        </ul>
                                    </div>
                                </div>
                                <div class="tab-content">
                                    <div id="tab-1" class="tab-pane fade show p-0 active">
                                        <div class="row g-4">
                                            <div class="col-lg-12">
                                                <div class="row g-4">
                                                    <c:forEach var="product" items="${products}">
                                                        <div class="col-md-6 col-lg-3 col-xl-4">
                                                            <div class="rounded position-relative fruite-item">
                                                                <div class="fruite-img">
                                                                    <img src="/images/product/${product.image}"
                                                                        class="img-fluid w-100 rounded-top" alt="">
                                                                </div>
                                                                <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                    style="top: 10px; left: 10px;">Fruits</div>
                                                                <div
                                                                    class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                    <h4><a href="/product/${product.id}">
                                                                            ${product.name}
                                                                        </a></h4>
                                                                    <p>${product.shortDesc}</p>
                                                                    <div
                                                                        class="d-flex flex-lg-wrap justify-content-center flex-column">
                                                                        <p style="text-align:center; width: 100%;"
                                                                            class="text-dark fs-5 fw-bold mb-0 ">
                                                                            <fmt:formatNumber type="number"
                                                                                value="${product.price}" /> $

                                                                        </p>
                                                                        <form
                                                                            action="/add-product-to-cart/${product.id}"
                                                                            method="post">
                                                                            <input type="hidden"
                                                                                name="${_csrf.parameterName}"
                                                                                value="${_csrf.token}" />

                                                                            <button
                                                                                class="mx-auto btn border border-secondary rounded-pill px-3 text-primary">
                                                                                <i
                                                                                    class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                                Add to cart
                                                                            </button>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="tab-2" class="tab-pane fade show p-0">
                                        <div class="row g-4">
                                            <div class="col-lg-12">
                                                <div class="row g-4">
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-5.png"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Grapes</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-2.png"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Raspberries</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="tab-3" class="tab-pane fade show p-0">
                                        <div class="row g-4">
                                            <div class="col-lg-12">
                                                <div class="row g-4">
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-1.png"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Oranges</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-6.png"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Apple</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="tab-4" class="tab-pane fade show p-0">
                                        <div class="row g-4">
                                            <div class="col-lg-12">
                                                <div class="row g-4">
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-5.png"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Grapes</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-4.jpg"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Apricots</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="tab-5" class="tab-pane fade show p-0">
                                        <div class="row g-4">
                                            <div class="col-lg-12">
                                                <div class="row g-4">
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-3.png"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Banana</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-2.png"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Raspberries</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-lg-3 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/client/img/fruite-item-1.png"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">Fruits</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <h4>Oranges</h4>
                                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing
                                                                    elit
                                                                    sed do eiusmod te incididunt</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">$4.99 / kg
                                                                    </p>
                                                                    <a href="#"
                                                                        class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                                            class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                        Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Fruits Shop End-->





                    <!-- Banner Section Start-->
                    <div class="container-fluid banner bg-secondary my-5">
                        <div class="container py-5">
                            <div class="row g-4 align-items-center">
                                <div class="col-lg-6">
                                    <div class="py-4">
                                        <h1 class="display-3 text-white">Discover Cutting-Edge Laptops</h1>
                                        <p class="fw-normal display-3 text-dark mb-4">At Our Store</p>
                                        <p class="mb-4 text-dark">Explore the latest in laptop technology with sleek
                                            designs, unmatched performance, and advanced features. Whether you’re a
                                            gamer, a
                                            professional, or a student, our collection offers something for everyone.
                                        </p>
                                        <a href="#"
                                            class="banner-btn btn border-2 border-white rounded-pill text-dark py-3 px-5">BUY</a>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="position-relative">
                                        <img src="/client/img/baner-1.png" class="w-100 rounded" alt="">
                                        <div class="d-flex align-items-center justify-content-center bg-white rounded-circle position-absolute"
                                            style="width: 140px; height: 140px; top: 0; left: 0;">
                                            <h1 style="font-size: 100px;">1</h1>
                                            <div class="d-flex flex-column">
                                                <span class="h2 mb-0">500$</span>
                                                <span class="h4 text-muted mb-0"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Banner Section End -->



                    <!-- Fact Start -->
                    <div class="container-fluid py-5">
                        <div class="container">
                            <div class="bg-light p-5 rounded">
                                <div class="row g-4 justify-content-center">
                                    <div class="col-md-6 col-lg-6 col-xl-3">
                                        <div class="counter bg-white rounded p-5">
                                            <i class="fa fa-users text-secondary"></i>
                                            <h4>satisfied customers</h4>
                                            <h1>1963</h1>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-lg-6 col-xl-3">
                                        <div class="counter bg-white rounded p-5">
                                            <i class="fa fa-users text-secondary"></i>
                                            <h4>quality of service</h4>
                                            <h1>99%</h1>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-lg-6 col-xl-3">
                                        <div class="counter bg-white rounded p-5">
                                            <i class="fa fa-users text-secondary"></i>
                                            <h4>quality certificates</h4>
                                            <h1>33</h1>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-lg-6 col-xl-3">
                                        <div class="counter bg-white rounded p-5">
                                            <i class="fa fa-users text-secondary"></i>
                                            <h4>Available Products</h4>
                                            <h1>789</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Fact Start -->


                    <!-- Tastimonial Start -->
                    <div class="container-fluid testimonial py-5">
                        <div class="container py-5">
                            <div class="testimonial-header text-center">
                                <h4 class="text-primary">Our Testimonial</h4>
                                <h1 class="display-5 mb-5 text-dark">Our Client Saying!</h1>
                            </div>
                            <div class="owl-carousel testimonial-carousel">
                                <div class="testimonial-item img-border-radius bg-light rounded p-4">
                                    <div class="position-relative">
                                        <i class="fa fa-quote-right fa-2x text-secondary position-absolute"
                                            style="bottom: 30px; right: 0;"></i>
                                        <div class="mb-4 pb-4 border-bottom border-secondary">
                                            <p class="mb-0">Lorem Ipsum is simply dummy text of the printing Ipsum has
                                                been
                                                the industry's standard dummy text ever since the 1500s,
                                            </p>
                                        </div>
                                        <div class="d-flex align-items-center flex-nowrap">
                                            <div class="bg-secondary rounded">
                                                <img src="/client/img/testimonial-1.jpg" class="img-fluid rounded"
                                                    style="width: 100px; height: 100px;" alt="">
                                            </div>
                                            <div class="ms-4 d-block">
                                                <h4 class="text-dark">Client Name</h4>
                                                <p class="m-0 pb-3">Profession</p>
                                                <div class="d-flex pe-5">
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="testimonial-item img-border-radius bg-light rounded p-4">
                                    <div class="position-relative">
                                        <i class="fa fa-quote-right fa-2x text-secondary position-absolute"
                                            style="bottom: 30px; right: 0;"></i>
                                        <div class="mb-4 pb-4 border-bottom border-secondary">
                                            <p class="mb-0">Lorem Ipsum is simply dummy text of the printing Ipsum has
                                                been
                                                the industry's standard dummy text ever since the 1500s,
                                            </p>
                                        </div>
                                        <div class="d-flex align-items-center flex-nowrap">
                                            <div class="bg-secondary rounded">
                                                <img src="/client/img/testimonial-1.jpg" class="img-fluid rounded"
                                                    style="width: 100px; height: 100px;" alt="">
                                            </div>
                                            <div class="ms-4 d-block">
                                                <h4 class="text-dark">Client Name</h4>
                                                <p class="m-0 pb-3">Profession</p>
                                                <div class="d-flex pe-5">
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="testimonial-item img-border-radius bg-light rounded p-4">
                                    <div class="position-relative">
                                        <i class="fa fa-quote-right fa-2x text-secondary position-absolute"
                                            style="bottom: 30px; right: 0;"></i>
                                        <div class="mb-4 pb-4 border-bottom border-secondary">
                                            <p class="mb-0">Lorem Ipsum is simply dummy text of the printing Ipsum has
                                                been
                                                the industry's standard dummy text ever since the 1500s,
                                            </p>
                                        </div>
                                        <div class="d-flex align-items-center flex-nowrap">
                                            <div class="bg-secondary rounded">
                                                <img src="/client/img/testimonial-1.jpg" class="img-fluid rounded"
                                                    style="width: 100px; height: 100px;" alt="">
                                            </div>
                                            <div class="ms-4 d-block">
                                                <h4 class="text-dark">Client Name</h4>
                                                <p class="m-0 pb-3">Profession</p>
                                                <div class="d-flex pe-5">
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                    <i class="fas fa-star text-primary"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Tastimonial End -->

                    <jsp:include page="../layout/footer.jsp" />

                    <!-- Back to Top -->
                    <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
                            class="fa fa-arrow-up"></i></a>


                    <!-- JavaScript Libraries -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="/client/lib/easing/easing.min.js"></script>
                    <script src="/client/lib/waypoints/waypoints.min.js"></script>
                    <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
                    <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>

                    <!-- Template Javascript -->
                    <script src="/client/js/main.js"></script>
                </body>

                </html>