<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${Mode}</title>
    <link href="/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/Bootstrap/css/dashboard.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <link href="/Bootstrap/favicon.png" rel="icon">
</head>
<body>
<#include "Partials/navbar.ftl">
<div class="container-fluid">
    <div class="row">
        <input type="hidden" id="Secret" value="${Secret!""}">
        <#if Secret??>
        <div class="col-sm-3 col-md-2 sidebar">

            <#include "Partials/sidebar.ftl">
        </div>
        </#if>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Homepage</h1>
            <div class="bs-example">
                <form id="search" name="SearchForm">
                    <div class="row">
                        <div class="col-xs-3">
                            <div class="input-group">
                                <input type="text"  id="term" name="term" class="form-control">
                                <div class="col-sm-11" >
                                    <select class="form-control" id="type" name="type"/>
                                        <#list SEARCH as option>
                                            <option value="${option}">${option}</option>
                                        </#list>
                                    </select>
                                </div>
                                <button class="btn btn-primary" type="submit">Search</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <table id="data" class="table table-striped">
                <thead>
                <tr>
                    <#list HEAD as info>
                        <th>${info}</th>
                    </#list>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
<script src="/Bootstrap/js/ajax_main.js"></script>
<script src="/Bootstrap/js/ajax_search.js"></script>
<script src="/Bootstrap/js/delete.js"></script>
</body>
</html>