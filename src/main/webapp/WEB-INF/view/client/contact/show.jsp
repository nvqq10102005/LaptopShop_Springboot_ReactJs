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




                    <!-- Contact Start -->
                    <div class="container-xxl py-5 mt-5">
                        <div class="container mt-5">
                            <div class="text-center mb-5">
                                <h1 class="mb-3">Contact Us</h1>
                                <p>If you have any questions, feel free to reach out to us.</p>
                            </div>
                            <div class="row g-4">
                                <div class="col-lg-6">
                                    <div class="d-flex align-items-center mb-4">
                                        <div class="btn-lg-square bg-primary rounded-circle">
                                            <i class="fa fa-map-marker-alt text-white"></i>
                                        </div>
                                        <div class="ms-3">
                                            <h5 class="mb-2">Our Office</h5>
                                            <p class="mb-0">NinhKieu, CanTho, VietNam</p>
                                        </div>
                                    </div>
                                    <div class="d-flex align-items-center mb-4">
                                        <div class="btn-lg-square bg-primary rounded-circle">
                                            <i class="fa fa-phone-alt text-white"></i>
                                        </div>
                                        <div class="ms-3">
                                            <h5 class="mb-2">Call Us</h5>
                                            <p class="mb-0">+012 345 67890</p>
                                        </div>
                                    </div>
                                    <div class="d-flex align-items-center mb-4">
                                        <div class="btn-lg-square bg-primary rounded-circle">
                                            <i class="fa fa-envelope text-white"></i>
                                        </div>
                                        <div class="ms-3">
                                            <h5 class="mb-2">Email Us</h5>
                                            <p class="mb-0">nvqq43@gmail.com</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <form>
                                        <div class="row g-3">
                                            <div class="col-12">
                                                <input type="text" class="form-control" placeholder="Your Name"
                                                    required>
                                            </div>
                                            <div class="col-12">
                                                <input type="email" class="form-control" placeholder="Your Email"
                                                    required>
                                            </div>
                                            <div class="col-12">
                                                <input type="text" class="form-control" placeholder="Subject" required>
                                            </div>
                                            <div class="col-12">
                                                <textarea class="form-control" rows="5" placeholder="Message"
                                                    required></textarea>
                                            </div>
                                            <div class="col-12 text-center">
                                                <button class="btn btn-primary w-100 py-3" type="submit">Send
                                                    Message</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- About Section Start -->
                    <div class="container-xxl py-5">
                        <div class="container">
                            <div class="text-center mb-5">
                                <h1 class="mb-3">About LaptopNow</h1>
                                <p>Welcome to LaptopNow, your number one source for all things laptops. We're dedicated
                                    to giving you the very best of laptops, with a focus on quality, customer service,
                                    and uniqueness.</p>
                            </div>
                            <div class="row g-4">
                                <div class="col-lg-6">
                                    <h5 class="mb-3">Our Story</h5>
                                    <p>Founded in 2023 by John Doe, LaptopNow has come a long way from its beginnings in
                                        a home office. When John first started out, his passion for providing the best
                                        equipment for his fellow tech enthusiasts drove him to do intense research, and
                                        gave him the impetus to turn hard work and inspiration into a booming online
                                        store. We now serve customers all over the world, and are thrilled to be a part
                                        of the tech industry.</p>
                                </div>
                                <div class="col-lg-6">
                                    <h5 class="mb-3">Tools and Technologies Used</h5>
                                    <ul>
                                        <li>Spring Boot</li>
                                        <li>ReactJS</li>
                                        <li>Bootstrap</li>
                                        <li>JSP</li>
                                        <li>JavaScript</li>
                                        <li>HTML & CSS</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- About Section End -->













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