<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>

<%--Angular WebApp--%>
<html ng-app="myApp" ng-controller="myCtl">

<head>
    <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Angular/jsp 1st webapp!</title>

    <%--Włączanie resource-ów zapisanych lokalnie na serwerze--%>
    <%--<link href="${pageContext.request.contextPath}/myresources/css/bootstrap.min.css" rel="stylesheet">--%>
    <!--<link href="css/style.css" rel="stylesheet">-->
    <script src="${pageContext.request.contextPath}/myresources/simpleAngularController.js"></script>

</head>

<body>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            Lorem ipsum...  (from server model: ${message})
        </div>
        <div class="col-md-8 well" style="border: 1px solid; border-radius: 5px; margin-top: 15px">
            Lorem ipsum... (from angular: {{ user }})
        </div>
        <div class="col-md-2">
            Lorem ipsum...  (from server model: ${message})
        </div>
    </div>
</div>
</body>
