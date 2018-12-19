<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/Bootstrap/css/bootstrap-login.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<html>
<head>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="/Bootstrap/css/bootstrap-login.css" rel="stylesheet">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Super Car Repair</title>
    <!------ Include the above in your HEAD tag ---------->
</head>
<body id="LoginForm">
<div class="container">
    <h1 class="form-heading">login Form</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>User Login</h2>
                <p>Please enter your email and password</p>
                <div class="error-message">${message!""}</div>
            </div>
            <form action="/login" name="LoginForm" method="post" id="Login">

                <div class="form-group">


                    <input type="email" class="form-control" name="email" id="email" placeholder="Email Address" value=${LoginForm.getEmail()!""}>

                </div>

                <div class="form-group">

                    <input type="password" class="form-control" name="Pass" id="Pass" placeholder="Password">

                </div>
                <div>

                </div>
                <button type="submit" class="btn btn-primary">Login</button>

            </form>
        </div>
        <p class="botto-text"> Designed NOT by US</p>
    </div></div></div>


</body>
</html>