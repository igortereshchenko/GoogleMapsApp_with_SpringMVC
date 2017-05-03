<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diplom</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/maskinput.js"></script>
    <script type="text/javascript">
        jQuery(function($){
            $("#tel").mask("+38(999) 999-9999");
        });
    </script>


    <style>
        #div_reg{
            margin-top: 2%;
            margin-left: 35%;
            margin-right: 35%;
            border: solid 1px black;
            padding: 3%;
            float: inherit;
            background-color: lemonchiffon;
        }
    </style>
</head>
<body>
<br/><br/>
<center><h3>Авторизація</h3></center>

<div id="div_reg">
    <c:url var="addAction4" value="/expenses"/>
    <form:form action="${addAction4}">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="email" id="email" value="ichanskiy.olexandr@gmail.com" placeholder="Введіть email" required pattern="(\W|^)[\w.+\-]{0,25}@(yahoo|hotmail|gmail|i)\.com(\W|$)">
        </div>

        <div class="form-group">
            <label for="email">Номер телефону</label>
<%--
            <input type="tel" name="tel_reg" id="tel" class="form-control" placeholder="Мобільний телефон" required>
--%>
            <input type="tel" name="tel_reg" class="form-control" placeholder="Мобільний телефон" required>
        </div>
        <button type="submit" class="btn btn-success">Увійти</button>
        <a href="<c:url value="/registration"/>" ><button type="button" class="btn btn-success">Зареєструватися</button></a>
    </form:form>
</div>

<%-- <br/>
 <a href="<c:url value="/spending"/>" target="_blank"><button type="button" class="btn btn-danger btn-lg">book list</button></a>
 <br/>--%>

</body>
</html>