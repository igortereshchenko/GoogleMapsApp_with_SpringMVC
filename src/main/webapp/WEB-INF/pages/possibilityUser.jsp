<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ichanskiy
  Date: 2017-04-29
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Функції користувача</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style>
        #field_div{
            margin: 5%;
            margin-left: 15%;
            margin-right: 35%;
            float: left;
            border: solid 1px black;
            padding: 3%;
            background-color: lemonchiffon;
        }
        body{
            background-color: beige; /* Цвет фона веб-страницы */
        }
    </style>
</head>
<body>

<h1 align="center">Можливості користувача</h1>

<div id= "field_div">
    <label>Переглянути витрати за період: </label>
    <br>
    <br>
    <br>

<c:url var="addAction3" value="/expenses/possibility/dateInfo"/>
<form:form action="${addAction3}">
    <div class="form-group">
        <label for="date_first">Період з: </label>
        <input type="date" name="date_first" id="date_first"  class="form-control" placeholder="Дата події" />
    </div>

    <div class="form-group">
        <label for="date_second">по: </label>
        <input type="date" name="date_second" id="date_second"  class="form-control" placeholder="Дата події" />
    </div>
    <br>
    <a href="" target="_blank">
        <button type="submit" class="btn btn-success">Переглянути</button>
    </a>

    </form:form>

    <a href="<c:url value="/expenses/possibility/allExpenses"/>" target="_blank" ><button type="button" class="btn btn-success">Переглянути всі витрати</button></a>

</div>


</body>
</html>
