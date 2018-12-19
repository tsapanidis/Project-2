<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1" name="viewport">

    <meta content="Short website description" name="description">
    <link href="/Bootstrap/favicon.png" rel="icon">

    <title>Add Repair</title>

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
                <li><a href="/Repairs">Home Page </a></li>
                <#--<li><a href="./create-user.html">Add User</a></li>-->
            </ul>
            <ul class="nav nav-sidebar">
                <#--<li><a href="./listings.html">Listing</a></li>-->
                <#--<li><a href="./create-listing.html">Add listing</a></li>-->
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Add Repair</h1>
            <div class="error-message">${errorMessage!""}</div>
            <form action="${action!""}" method="post" name="createRepairForm" class="form-horizontal" id="create-listing">
                <input type="hidden" id="RepairID" name="RepairID" value="${createRepairForm.getRepairID()!""}"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="dateListing">Date</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="date" name="date" placeholder="Date" type="text" value="${createRepairForm.getDate()!""}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="status">Status</label>
                    <div class="col-sm-11">
                        <select class="form-control" name="status" id="${createRepairForm.getStatus()!""}">
                            <option value="PENDING">Pending</option>
                            <option value="INPROGRESS">Processed</option>
                            <option value="COMPLETE">Completed</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="type">Repair Type</label>
                    <div class="col-sm-11">
                        <select class="form-control" name="repairType" id="${createRepairForm.getRepairType()!""}">
                            <option value="SMALL">Small</option>
                            <option value="MEDIUM">Medium</option>
                            <option value="LARGE">Large</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="price">Price</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="price" name="price" placeholder="Price" type="number" value="${createRepairForm.getPrice()!""}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="vat">Vat</label>
                    <div class="col-sm-11">
                        <input class="form-control" id="vat" name="vat" placeholder="Vat" required  pattern="[0-9]{9}" title="Please Enter 9 digits" type="text"  value=${createRepairForm.getVat()!""}>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="description">Description</label>
                    <div class="col-sm-11">
                        <textarea class="form-control" cols="30" id="description" name="description" placeholder="Description"
                                  rows="10" >${createRepairForm.getDescription()!""}</textarea>
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
