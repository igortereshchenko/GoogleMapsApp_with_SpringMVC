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
            margin-left: 30%;
            margin-right: 30%;
            border: solid 1px black;
            padding: 3%;
            float: inherit;
            background-color: lemonchiffon;
        }
    </style>
</head>
<body>
<br/><br/>
<center><h3>Test project</h3></center>

<div id="div_reg">
    <c:url var="addAction" value="/registration"/>
    <form:form action="${addAction}">

        <div class="form-group">
            <label for="names">Ім'я</label>
            <input name="name_user" type="text" class="form-control" id="names" placeholder="Ім'я" required pattern="[A-Za-zА-Яа-я_-]{2,30}[А-Яа-яA-Za-z]{2,30}">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input name="email_user" type="email" class="form-control" id="email" placeholder="Введіть email" required pattern="(\W|^)[\w.+\-]{0,25}@(yahoo|hotmail|gmail|i)\.com(\W|$)">
        </div>

        <div class="form-group">
            <label for="email">Номер телефону</label>
            <input name="tel_user" type="tel" <%--id="tel"--%> class="form-control" placeholder="Мобільний телефон" required>
        </div>

        <div class="form-group">
            <label for="date">День народження</label>
            <input name="birthday_user" type="date" id="date" class="form-control" placeholder="День народження" required>
        </div>

        <%--
                <a href="<c:url value="/spending"/>" ><button type="button" class="btn btn-success">Приклад</button></a>
        --%>
        <a href="<c:url value="/LogIn"/>" ><button type="button" class="btn btn-success">Увійти</button></a>
        <button type="submit" class="btn btn-success">Реєстрація</button>
    </form:form>
</div>

<%-- <br/>
 <a href="<c:url value="/spending"/>" target="_blank"><button type="button" class="btn btn-danger btn-lg">book list</button></a>
 <br/>--%>

</body>
</html>