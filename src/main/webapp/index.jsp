<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diplom</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/maskinput.js"></script>



    <style>
        #div_reg{
            margin-top: 2%;
            margin-left: 25%;
            margin-right: 25%;
            border: solid 1px black;
            padding: 3%;
            float: inherit;
            background-color: lemonchiffon;
        }
        #ppp{
            font-family:Lobster, cursive; Font-size:30px;
        }

    </style>
</head>
<body>
<br/><br/>
<center><h3>Ічанський Олександр</h3></center>

<div id="div_reg">
    <form role="form">

        <div class="form-group">
            <center>
            <span id="ppp">Дипломна робота на тему:
                <br>
            Математичне і програмне забезпечення
                <br>
            для аналізу витрат користувача</span>
            <br><br>
<%--
        <a href="<c:url value="/spending"/>" ><button type="button" class="btn btn-success">Приклад</button></a>
--%>
        <a href="<c:url value="/LogIn"/>" ><button type="button" class="btn btn-success">Старт</button></a>
            </center>
    </form>
</div>

<%-- <br/>
 <a href="<c:url value="/spending"/>" target="_blank"><button type="button" class="btn btn-danger btn-lg">book list</button></a>
 <br/>--%>

</body>
</html>