<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diplom</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style>
        #div_reg{
            margin-top: 5%;
            margin-left: 30%;
            margin-right: 30%;
            border: solid 1px black;
            padding: 5%;
            float: inherit;
            background-color: lemonchiffon;
        }
    </style>
</head>
<body>
<br/><br/>
<center><h3>Test project</h3></center>

<div id="div_reg">
    <form role="form">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" placeholder="Введіть email">
        </div>
        <div class="form-group">
            <label for="pass">Пароль</label>
            <input type="password" class="form-control" id="pass" placeholder="Пароль">
        </div>
        <a href="<c:url value="/spending"/>" target="_blank"><button type="button" class="btn btn-success">Увійти</button></a>
        <button type="submit" class="btn btn-success">Реєстрація</button>
    </form>
</div>

<%-- <br/>
 <a href="<c:url value="/spending"/>" target="_blank"><button type="button" class="btn btn-danger btn-lg">book list</button></a>
 <br/>--%>

</body>
</html>