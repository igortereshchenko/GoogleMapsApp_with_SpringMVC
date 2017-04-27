package com.dao;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-04-26.
 */
public interface PlacePointDao{

   public void addPlacePoint(String addres_str, double lat_double, double long_double, int amount_int, String tagNameFk, String tagName, Date date_sql);
}
