<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


            <html lang="en">

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
                <jsp:include page="../layout/header.jsp"/>
                <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp"/>
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manager Orders</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item "><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Orders</li>
                                </ol>
                                                                <hr />
                                <table class="table table-hover table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Factory</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%-- <c:forEach var="user" items="${users}">
                                        <tr>
                                            <th>${user.id}</th>
                                            <td>${user.email}</td>
                                            <td>${user.fullName}</td>
                                            <td>${user.role.name}</td>
                                            <td>
                                                <a href="/admin/user/${user.id}" class="btn btn-success">View
                                                    Details</a>
                                                <a href="/admin/user/update/${user.id}"
                                                    class="btn btn-warning mx-2">Update</a>
                                                <a href="/admin/user/delete/${user.id}"
                                                    class="btn btn-danger">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach> --%>
                                </tbody>
                            </table>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp"/>
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
            </body>

            </html>