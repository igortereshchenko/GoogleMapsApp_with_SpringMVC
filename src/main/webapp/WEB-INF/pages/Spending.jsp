<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <title>Google Maps : Sample 5 : WebCoding Solutions</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
        #map-canvas {
            margin: 5%;
            padding: 16%;
            float: left;
            border: solid 1px black;
        }
        #field_div{
            margin: 5%;
            border: solid 1px black;
            padding: 5%;
            float: right;
            background-color: lemonchiffon;
        }
        body{
            background-color: beige; /* Цвет фона веб-страницы */
        }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDLg8g0NKwIwwgCCkd26kRe4ZLS0dpIg7A&sensor=false"></script>
    <script>
        var map;
        var geocoder;
        var infowindow;

       /* $(() => {
            $('#infoSelect').attr("value", "Їжа");
            console.log($('#infoSelect'));
        });*/


        function addAdresFild(adr) {
            $('#text_adres').val(adr);
        }

        function checkedSelect() {
            var s = $('#clr :selected').text();
            $('#infoSelect').attr("value", s);
        }

        function initialize() {
            var mapOptions = {
                zoom: 8,
                center: new google.maps.LatLng(50.450100, 30.5234)
            };
            map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
            geocoder = new google.maps.Geocoder();
            google.maps.event.addListener(map, 'click', function(event) {
                addMarker(event.latLng);
            });
        }

        function addMarker(location) {
            if(!location) return;
            if(infowindow) infowindow.close();
            var marker = new google.maps.Marker({
                position: location,
                map: map
            });
            geocoder.geocode({latLng:location}, function (results, status) {
                var addr = '';
                if(status == 'OK') {
                    if(results.length == 0) {
                        addr = 'None';
                    } else {
                        addr = results[0].formatted_address;
                    }
                    addAdresFild(addr);
                    var text = 'Адрес: <br>' + addr;
                    infowindow = new google.maps.InfoWindow({ content: text });
                    infowindow.open(map,marker);

                    google.maps.event.addListener(marker, 'click', function () {
                        if(infowindow) infowindow.close();
                        infowindow = new google.maps.InfoWindow({ content: text });
                        infowindow.open(map, this);
                    });
                }
            });
        }
        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>
<body >
<h1 align="center">Дипломна робота</h1>
<div id="map-canvas"></div>


<div id= "field_div">

    <c:url var="addAction" value="/spending/add"/>
    <form:form action="${addAction}" commandName="spending">


        <div class="form-group">
            <label for="text">Адреса</label>
            <form:input path="address" type="text" class="form-control" id="text_adres" placeholder="Введіть адресу"/>
        </div>

        <div class="form-group">
            <label for="text">Кількість потрачених грошей</label>
            <form:input path="amount" type="number" class="form-control" id="money" value="0" min="1" max="40000" step="1" />
        </div>



        <select class="form-control" id="clr" onchange="checkedSelect()">
            <option selected>Їжа</option>
            <option>Одяг</option>
            <option>Розваги</option>
            <option>Подарунки</option>
        </select>
        <form:input path="types" type="hidden" class="form-control" id="infoSelect"/>

        <br>
        <button type="submit" class="btn btn-success" >Додати</button>

    </form:form>
</div>
</body>
</html>