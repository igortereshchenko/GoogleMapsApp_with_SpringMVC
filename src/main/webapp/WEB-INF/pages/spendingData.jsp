<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>

   <title>SpendingData</title>

  <style type="text/css">

    #spending_list{

    }

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
      background-color: #f9f9f9
    }
  </style>

</head>
<body>
<br>
<br>
<center><h1>Spending Details</h1></center>

<c:if test="${!empty spendingList}">
  <center>
  <div id="spending_list">
    <table class="tg">
      <tr>
        <th width="80">ID</th>
        <th width="120">address</th>
        <th width="120">amount</th>
        <th width="120">types</th>
      </tr>
      <c:forEach items="${spendingList}" var="spending">
        <tr>
          <td>${spending.id}</td>
          <td>${spending.address}</td>
          <td>${spending.amount}</td>
          <td>${spending.types}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
  </center>
</c:if>
</body>
</html>