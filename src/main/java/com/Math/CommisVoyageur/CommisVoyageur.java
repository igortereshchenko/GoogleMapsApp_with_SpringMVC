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
        List<String> sortList = p1();
        int sizeList = pointList.size();
        System.out.println(sizeList);

       double C[][] = new double[sizeList][sizeList];

        for (int i = 1; i < sizeList; i++) {
            for (int j = 1; j < sizeList ; j++) {
                if (i==j){
                    C[i][j] = 0;
                }

                if(i<j){
                    String a = String.valueOf(pointList.get(i));
                    String b = String.valueOf(pointList.get(j));
                    //System.out.println(getDistanse(a,b));
                    double d = getDistanse(a,b);
                    C[i][j] = d;
                }

                if (j<i){
                    String a = String.valueOf(pointList.get(j));
                    String b = String.valueOf(pointList.get(i));
                    //System.out.println(getDistanse(a,b));
                    double d = getDistanse(a,b);
                    C[i][j] = d;
                }
            }
        }

        for (int i = 1; i < sizeList; i++) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 1; j < sizeList; j++) {
                // Используем оператор print - без перехода на следующую строку
                System.out.print(C[i][j] + "         ");
            }
            // Переход на следующую строку
            System.out.println();
        }

        Route tspNearestNeighbour = new Route();
        List<Integer> rout = tspNearestNeighbour.tsp(C);
       // System.out.println(rout);
        pointList.remove(0);
        sortList.remove(0);


        System.out.println("rout");
            for (int i = 0; i < pointList.size()-1; i++) {
            System.out.println("i = " + i + "-->" + rout.get(i));
        }

        System.out.println("point");
        for (int i = 0; i < rout.size(); i++) {
            System.out.println("i = " + i + "-->" + pointList.get(i));
        }

       /* System.out.println(pointList.size());
        System.out.println(rout.size());
        System.out.println(sortList.size());*/



        for (int i = 0;  i < pointList.size(); i++) {
            int key = rout.get(i) - 1;
            System.out.println("k " + key);
            if (key == pointList.size()){
                continue;
            }
            String value = pointList.get(i);
            System.out.println("v " + value);
            sortList.set(key,value);
            //System.out.println(sortList);
        }

        System.out.println("sort");
        for (int i = 0; i < sortList.size(); i++) {
            System.out.println("i = " + i + " --> " + sortList.get(i));
        }    }

    public static List<String> p1() {
        List<String> pointList = new ArrayList<String>();
        pointList.add(0,"0");
        pointList.add(1,"вулиця Героїв Севастополя, 65, Київ, Украина");
        pointList.add(2,"вулиця Сергія Колоса, 2А, Київ, Украина");
        pointList.add(3,"вулиця Верховинна, 68, Київ, Украина");
        pointList.add(4,"вулиця Михайла Ломоносова, 40-42, Київ, Украина");
        pointList.add(5,"Брянська вулиця, 15, Київ, Украина");
        return pointList;
    }



}
