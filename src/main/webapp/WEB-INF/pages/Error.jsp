<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ichanskiy
  Date: 2017-05-04
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<center>
    <br>
    <h1>Упс :(</h1>
    <h1>Виникла одна з помилок</h1>
    <h1>користувач з такими даними вже інсує</h1>
    <h1>чи</h1>
    <h1>Ви ввели не вірно логін чи пароль</h1>
    <br>
    <br>
    <a href="<c:url value="/LogIn"/>" ><h2>Можете спробувати ще</h2></a>
    <h1></h1></center>
</body>
</html>
