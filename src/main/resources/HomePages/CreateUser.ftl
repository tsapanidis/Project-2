!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1" name="viewport">

    <meta content="Short website description" name="description">
    <link href="/Bootstrap/favicon.png" rel="icon">


    <title>Add Owner</title>

    <!-- Bootstrap core CSS -->
    <link href="/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/Bootstrap/css/dashboard.css" rel="stylesheet">


    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css" rel="stylesheet">

</head>

<body>

<#include "Partials/navbar.ftl">

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/Owners">Home Page</a></li>
                <#--<li><a href="./create-user.html">Add User</a></li>-->
            </ul>
            <ul class="nav nav-sidebar">
                <#--<li><a href="./listings.html">Listing</a></li>-->
                <#--<li><a href="./create-listing.html">Add listing</a></li>-->
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Add Owner</h1>
            <div class="error-message">${errorMessage!""}</div>

            <form action="${action!""}" method="post" name="registerForm" class="form-horizontal" id="create-user">
                <input type="hidden" id="id" name="id" value="${registerForm.getId()!""}"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="vat">Vat</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="vat" name="vat" placeholder="Vat" required  pattern="[0-9]{9}" title="Please Enter 9 digits"  type="text" value=${registerForm.getVat()!""}>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="firstName">First name</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="firstName" name="firstName" placeholder="First name" required type="text" value="${registerForm.getFirstName()!""}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="lastName">Last name</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="lastName" name="lastName" placeholder="Last name" required type="text" value="${registerForm.getLastName()!""}""/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="address">Address</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="address" name="address" placeholder="Address" required pattern="[A-Za-z]+\s[0-9]+" type="text" value="${registerForm.getAddress()!""}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="email">Email</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="email" name="email" placeholder="Email" required type="email" value="${registerForm.getEmail()!""}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="password">Password</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="password" name="password" placeholder="Password"
                               required minlength="6" type="password" value="${registerForm.getPassword()!""}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="brand">Brand</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="brand" name="brand" placeholder="Brand" type="text" value="${registerForm.getBrand()!""}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="plate">Plate</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="plate" name="plate" placeholder="Plate" required pattern="[A-Z]{3}-[0-9]{4}" title="Please enter this type AAA-1234" type="text" value="${registerForm.getPlate()!""}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="userRole">Role</label>
                    <div class="col-sm-11">
                        <select class="form-control" id="${registerForm.getUsertype()!""}" name="usertype"/>
                            <option value="ADMIN">Admin</option>
                            <option value="USER">User</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-11">
                        <button class="btn btn-default" type="reset">Reset</button>
                        <button class="btn btn-primary" type="submit">${button}</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>

<script src="/Bootstrap/js/bootstrap.min.js"></script>
<script src="/Bootstrap/js/app.js"></script>
<script src="/Bootstrap/js/form.js"></script>

</body>
</html>

