package com.model;

/**
 * Created by Ichanskiy on 2017-04-26.
 */
public class PlacePoint {

    private int placepoint_long;
    private int placepoint_lat;
    private String placepoint_address;

    public PlacePoint() {
    }

    public PlacePoint(int placepoint_long, int placepoint_lat, String placepoint_address) {
        this.placepoint_long = placepoint_long;
        this.placepoint_lat = placepoint_lat;
        this.placepoint_address = placepoint_address;
    }

    public int getPlacepoint_long() {
        return placepoint_long;
    }

    public void setPlacepoint_long(int placepoint_long) {
        this.placepoint_long = placepoint_long;
    }

    public int getPlacepoint_lat() {
        return placepoint_lat;
    }

    public void setPlacepoint_lat(int placepoint_lat) {
        this.placepoint_lat = placepoint_lat;
    }

    public String getPlacepoint_address() {
        return placepoint_address;
    }

    public void setPlacepoint_address(String placepoint_address) {
        this.placepoint_address = placepoint_address;
    }

    @Override
    public String toString() {
        return "PlacePoint{" +
                "placepoint_long=" + placepoint_long +
                ", placepoint_lat=" + placepoint_lat +
                ", placepoint_address=" + placepoint_address +
                '}';
    }
}
