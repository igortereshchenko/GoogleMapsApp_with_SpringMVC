package com.controller;

import com.dao.PlacePointDao;
import com.dao.PlacePointDaoImpl;
import com.model.Spending;
import com.model.UserExpenses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-04-26.
 */
@Controller
public class MainController {

    @RequestMapping(value = "expenses", method = RequestMethod.GET)
    public String listExpenses(Model model) {
        //model.addAttribute("spending", new Spending());
        return "Expenses";
    }


    @RequestMapping(value = "/expenses/add", method = RequestMethod.POST)
    public String addExpenses(HttpServletRequest request){

        Object add = request.getParameter("address");
        Object lat = request.getParameter("lat");
        Object longg = request.getParameter("long");
        Object amount = request.getParameter("amount");
        Object dates = request.getParameter("date_name");
        Object parentTag = request.getParameter("parentTag");
        Object childrenTag = request.getParameter("childrenTag");

        String addres_str = (String) add;
        String lat_str = (String) lat;
        double lat_double = Double.parseDouble(lat_str);
        String longg_str = (String) longg;
        double long_double = Double.parseDouble((String) longg);
        String amount_str = (String) amount;
        String TagNameFk = (String) parentTag;
        String TagName = (String) childrenTag;
        String date = (String) dates;
        Date date_sql = Date.valueOf(date);
        int amount_int = Integer.parseInt(amount_str);

        System.out.println("C " + addres_str);
        System.out.println("C " + lat_double);
        System.out.println("C " + long_double);
        System.out.println("C " + amount_int);
        System.out.println("C TGNFK" + TagNameFk);
        System.out.println("C TGN" + TagName);
        System.out.println("C date" + date_sql);

        PlacePointDao placePointDao = new PlacePointDaoImpl();
        placePointDao.addPlacePoint(addres_str, lat_double, long_double, amount_int, TagNameFk, TagName, date_sql);

        System.out.println("finish");
        return "redirect:/expenses";
    }

}
