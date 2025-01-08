<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Admin Dashboard</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">


                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <!-- <link href="/css/demo.css" rel="stylesheet"> -->
                <link rel="stylesheet" href="/css/styles.css">

            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Product Detail</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item "><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">product-detail</li>
                                </ol>

                                <body>

                                    <body>
                                        <div class="container mt-5">
                                            <div class="row">
                                                <div class="col-12 mx-auto">
                                                    <div class="d-flex justify-content-between">
                                                        <h3>TABLE PRODUCT DETAILS ${id}</h3>
                                                    </div>
                                                    <hr />
                                                    <div class="card mb-3">
                                                        <div class="row g-0">
                                                            <div class="col-md-4">
                                                                <img src="/images/product/${product.image}"
                                                                    class="img-fluid rounded-start" alt="${products}">
                                                            </div>
                                                            <div class="col-md-8">
                                                                <div class="card-body">
                                                                    <div class="card">
                                                                        <div class="card-header">
                                                                            Product information
                                                                        </div>
                                                                        <ul class="list-group list-group-flush">
                                                                            <li class="list-group-item">ID:
                                                                                ${product.id}
                                                                            </li>
                                                                            <li class="list-group-item">name:
                                                                                ${product.name}</li>
                                                                            <li class="list-group-item">Price:
                                                                                ${product.price}</li>

                                                                            <li class="list-group-item">DECS:
                                                                                ${product.detailDesc}</li>
                                                                            <li class="list-group-item">Quantity:
                                                                                ${product.quantity}</li>
                                                                            <li class="list-group-item">Factory:
                                                                                ${product.factory}</li>
                                                                        </ul>
                                                                    </div>
                                                                    <h5 class="card-title mt-4">Card title</h5>
                                                                    <p class="card-text">This is a wider card with
                                                                        supporting text below as a
                                                                        natural lead-in to additional content. This
                                                                        content is a little bit
                                                                        longer.</p>
                                                                    <p class="card-text"><small
                                                                            class="text-body-secondary">Last updated 3
                                                                            mins
                                                                            ago</small></p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                            <a href="/admin/product/update/${product.id}"
                                                class="btn btn-warning mx-2">Update</a>
                                            <a href="/admin/product/delete/${product.id}"
                                                class="btn btn-danger">Delete</a>
                                            <a href="/admin/product" class="btn btn-secondary col-3 float-end">BACK</a>
                                        </div>

                                    </body>
                                </body>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
            </body>