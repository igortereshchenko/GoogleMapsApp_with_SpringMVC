<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
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
            padding: 7%;
            float: right;
            background-color: lemonchiffon;
        }
        body{
            background-color: beige; /* Цвет фона веб-страницы */
        }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>
        var map;
        var geocoder;
        var infowindow;
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
    <form role="form">
        <div class="form-group">
            <label for="text">Адреса</label>
            <input type="text" class="form-control" id="text_adres" placeholder="Введіть адресу">
        </div>

        <div class="form-group">
            <label for="text">Кількість потрачених грошей</label>
            <input type="number" class="form-control" id="money" value="0" min="1" max="40000" step="0.5" >
        </div>


        <select class="form-control">
            <option>Їжа</option>
            <option>Одяг</option>
            <option>Розваги</option>
            <option>Подарунки</option>
        </select>
        <br>
        <button type="submit" class="btn btn-success">Додати</button>

    </form>
</div>
</body>
</html>