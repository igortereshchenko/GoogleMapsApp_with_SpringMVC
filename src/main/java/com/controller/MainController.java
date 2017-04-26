package com.controller;

import com.model.Spending;
import com.model.UserExpenses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

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
        Object types = request.getParameter("types");

        String addres_str = (String) add;
        String lat_str = (String) lat;
        String longg_str = (String) longg;
        String amount_str = (String) amount;
        int amount_int = Integer.parseInt(amount_str);
        String types_str = (String) types;

        System.out.println(addres_str);
        System.out.println(lat_str);
        System.out.println(longg_str);
        System.out.println(amount_int);
        System.out.println(types_str);
        return "redirect:/expenses";
    }

}
