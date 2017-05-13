package com.Math.Mamdani;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ichanskiy on 2017-05-04.
 */
public class Mamdani {
    public static void main(String[] args) {

        Map<String, Double> inputMap = new HashMap<String,Double>();
        inputMap.put("Ресторан", 300.0);
        inputMap.put("Продукти", 800.0);
        inputMap.put("Рубашки", 800.0);
        inputMap.put("Кінотеатр", 800.0);
        System.out.println(getEconomy(inputMap));
    }
    public static Map<String,Double> getEconomy(Map<String, Double> inputMap){

        Map<String, Double> mapImpotence = new HashMap<String, Double>();
        mapImpotence.put("Ресторан", 0.3);
        mapImpotence.put("Продукти", 0.8);
        mapImpotence.put("Взуття", 0.6);
        mapImpotence.put("Штани", 0.7);
        mapImpotence.put("Верхній", 0.6);
        mapImpotence.put("Рубашки", 0.4);
        mapImpotence.put("Іграшки", 0.19);
        mapImpotence.put("Прикраси", 0.1);
        mapImpotence.put("Квіти", 0.18);
        mapImpotence.put("Атракціони", 0.1);
        mapImpotence.put("Кінотеатр", 0.2);



        Map<String, Double> finalMap = new HashMap<String,Double>();
        Map<String, Double> outputMap = new HashMap<String,Double>();


        for (Map.Entry entry : inputMap.entrySet()) {
            for (Map.Entry entrys : mapImpotence.entrySet()) {
                if (entrys.getKey().equals(entry.getKey())){
                    String newKey = String.valueOf(entrys.getKey());
                    String newValue_str = String.valueOf(entrys.getValue());
                    double newValue = Double.parseDouble(newValue_str);
                    finalMap.put(newKey, newValue);
                }
            }
        }

        String key = getKeyMinMapElement(finalMap);
        System.out.println(key);
        if (finalMap.size() <= 2){
            System.out.println("<2");
        }else {
            System.out.println(finalMap.get(key));
            outputMap.put(key, inputMap.get(key));
            finalMap.remove(key);
        }

        System.out.println(outputMap);

        if (finalMap.size() > 2){
            key = getKeyMinMapElement(finalMap);
            System.out.println(finalMap.get(key));
            outputMap.put(key, inputMap.get(key));
            finalMap.remove(key);
        }

        if (finalMap.size() > 5){
            key = getKeyMinMapElement(finalMap);
            System.out.println(finalMap.get(key));
            outputMap.put(key, inputMap.get(key));
            finalMap.remove(key);
        }

       // System.out.println(outputMap);

        return outputMap;
    }

    private static String getKeyMinMapElement(Map<String, Double> inputMap){
        Double min = Collections.min(inputMap.values());
        System.out.println("m = " + min);
        String findKey = null;
        for (Map.Entry entry : inputMap.entrySet()) {
            if (entry.getValue() == min){
                findKey = String.valueOf(entry.getKey());
            }
        }
        return findKey;
    }
}
