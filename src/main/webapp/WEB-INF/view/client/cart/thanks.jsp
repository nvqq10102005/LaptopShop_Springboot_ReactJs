<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ThankYou!</title>
</head>

<body>
    <jsp:include page="../layout/header.jsp" />

    <div class="container" style="margin-top: 100px;">
        <div class="row">
            <div class="col-md-12">
                <h1>Thank you for your order!</h1>
                <p>Your order has been placed successfully. Your order number is <strong>${order.orderNumber}</strong>.
                    We will send you an email with your order details.</p>
                <p>Click <a href="${pageContext.request.contextPath}/client/home">here</a> to continue shopping.</p>
            </div>
        </div>
    </div>
    <jsp:include page="../layout/featurs.jsp" />
    <jsp:include page="../layout/footer.jsp" />
</body>

</html>