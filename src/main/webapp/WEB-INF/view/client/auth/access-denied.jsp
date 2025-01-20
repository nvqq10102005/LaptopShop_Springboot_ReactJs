<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 Not Found</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }

        h1 {
            font-size: 200px;
        }

        p {
            font-size: 20px;
        }

        a {
            color: #007BFF;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <h1>404</h1>
    <p>Page Not Found</p>
    <p>Sorry, the page you are looking for does not exist.</p>
    <p><a href="/">Go to Homepage</a></p>
</body>

</html>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const h1 = document.querySelector('h1');
        h1.style.transition = 'transform 0.5s';
        h1.style.transform = 'rotate(0deg)';

        setInterval(() => {
            h1.style.transform = h1.style.transform === 'rotate(0deg)' ? 'rotate(10deg)' : 'rotate(0deg)';
        }, 1000);
    });
</script>