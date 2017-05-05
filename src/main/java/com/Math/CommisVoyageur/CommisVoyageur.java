package com.Math.CommisVoyageur;

import com.model.PlacePoint;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.Math.DistanseGoogleApi.DistanceClass.getDistanse;

/**
 * Created by Ichanskiy on 2017-05-05.
 */
public class CommisVoyageur {
    public static void main(String[] args) throws IOException, JSONException {
       // System.out.println(p());

        List<String> pointList = p1();
        for (int i = 0; i < pointList.size(); i++) {
            String a = String.valueOf(pointList.get(0));
            String b = String.valueOf(pointList.get(1));
            System.out.println(getDistanse(a,b));
        }
    }

    public static List<String> p1() {
        List<String> pointList = new ArrayList<String>();
        pointList.add("вулиця Героїв Севастополя, 65, Київ, Украина");
        pointList.add("вулиця Сергія Колоса, 2А, Київ, Украина");
        pointList.add("вулиця Верховинна, 68, Київ, Украина");
        pointList.add("вулиця Михайла Ломоносова, 40-42, Київ, Украина");
        return pointList;
    }


    public static List<PlacePoint> p(){

        List<PlacePoint> pointList = new ArrayList<PlacePoint>();

        PlacePoint placePoint = new PlacePoint();
        placePoint.setPlacepoint_address("вулиця Героїв Севастополя, 65, Київ, Украина");
        placePoint.setPlacepoint_lat(50.4275495535948);
        placePoint.setPlacepoint_long(30.435733795166016);

        pointList.add(placePoint);

        PlacePoint placePoint1 = new PlacePoint();
        placePoint1.setPlacepoint_address("вулиця Сергія Колоса, 2А, Київ, Украина");
        placePoint1.setPlacepoint_lat(50.39254223184437);
        placePoint1.setPlacepoint_long(30.463199615478516);
        pointList.add(placePoint1);


        PlacePoint placePoint2 = new PlacePoint();
        placePoint2.setPlacepoint_address("вулиця Верховинна, 68, Київ, Украина");
        placePoint2.setPlacepoint_lat(50.452039290959505);
        placePoint2.setPlacepoint_long(30.358829498291016);
        pointList.add(placePoint2);


        PlacePoint placePoint3 = new PlacePoint();
        placePoint3.setPlacepoint_address("вулиця Михайла Ломоносова, 40-42, Київ, Украина");
        placePoint3.setPlacepoint_lat(50.38904007706254);
        placePoint3.setPlacepoint_long(30.468692779541016);
        pointList.add(placePoint3);

        return pointList;
    }
}
