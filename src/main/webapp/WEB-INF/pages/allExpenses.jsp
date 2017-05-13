<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ichanskiy
  Date: 2017-05-02
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>InfoDataPage</title>

    <style type="text/css">


        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9;
        }
    </style>

</head>
<body>
<br>
<br>
<center><h1>Всі витрати</h1></center>

<center>
<c:if test="${!empty allExpensesClassesList}">
    <table class="tg">
        <tr>
            <th width="80">Тип витрат</th>
            <th width="120">Адреса</th>
            <th width="120">Дата</th>

        </tr>
        <c:forEach items="${allExpensesClassesList}" var="allExpensesClassesList">
            <tr>
                <td>${allExpensesClassesList.tag}</td>
                <td>${allExpensesClassesList.address}</td>
                <td>${allExpensesClassesList.date}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</center>
</body>
</html>
