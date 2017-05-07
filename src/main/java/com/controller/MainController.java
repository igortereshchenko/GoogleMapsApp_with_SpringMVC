package com.controller;

import com.dao.ExpensesForTagDAOImpl;
import com.dao.PlacePointDao;
import com.dao.PlacePointDaoImpl;
import com.dao.UserFunctionDaoImpl;
import com.model.AllExpensesClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static com.Math.Mamdani.Mamdani.getEconomy;


/**
 * Created by Ichanskiy on 2017-04-26.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/LogIn", method = RequestMethod.GET)
    public String LogIn(Model model) {
        return "LogIn";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "Registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(Model model, HttpServletRequest request) {
        Object name_user = request.getParameter("name_user");
        Object email_user = request.getParameter("email_user");
        Object tel_user = request.getParameter("tel_user");
        Object birthday_user = request.getParameter("birthday_user");

        String name_user_str = String.valueOf(name_user);
        String email_user_str = String.valueOf(email_user);
        String tel_user_str = String.valueOf(tel_user);
        int tel_user_int = Integer.parseInt(tel_user_str);
        String birthday_user_str = String.valueOf(birthday_user);
        Date birthday_user_date = Date.valueOf(birthday_user_str);

        System.out.println("n = " + name_user_str);
        System.out.println("e = " + email_user_str);
        System.out.println("t = " + tel_user_str);
        System.out.println("b = " + birthday_user_date);

        UserFunctionDaoImpl userFunctionDao = new UserFunctionDaoImpl();
        boolean a  =  userFunctionDao.addUser(name_user_str, email_user_str,tel_user_int,birthday_user_date);
        if (a) {
            return "Error";
        }
        System.out.println("finish");

        return "LogIn";
    }

    @RequestMapping(value = "expenses", method = RequestMethod.GET)
    public String listExpensess(Model model, HttpServletRequest request) {
        return "Expenses";
    }

    //реєструємо в сесії користувача
    @RequestMapping(value = "expenses", method = RequestMethod.POST)
    public String listExpenses(Model model, HttpServletRequest request) {
        Object tel_reg_obj = request.getParameter("tel_reg");
        String phone_str = (String) tel_reg_obj;
        int phone = Integer.parseInt((String) tel_reg_obj);

        Object email_obj = request.getParameter("email");
        String email = String.valueOf(email_obj);
        UserFunctionDaoImpl userFunctionDao = new UserFunctionDaoImpl();

        if (!userFunctionDao.LogInUser(email, phone)) {
            return "Error";
        }
        request.getSession().setAttribute("phone", phone_str);
        System.out.println( "set session phone " + request.getSession().getAttribute("phone"));
        return "Expenses";
    }

    //додаємо покупки
    @RequestMapping(value = "/expenses/add", method = RequestMethod.POST)
    public String addExpenses(Model model, HttpServletRequest request){
        Object add = request.getParameter("address");
        Object lat = request.getParameter("lat");
        Object longg = request.getParameter("long");
        Object amount = request.getParameter("amount");
        Object dates = request.getParameter("date_name");
        Object parentTag = request.getParameter("parentTag");
        Object childrenTag = request.getParameter("childrenTag");

        Object o = request.getSession().getAttribute("phone");
        String phone_str = (String) o;
        System.out.println("phonnnnn " + phone_str);
        System.out.println("000");
        String addres_str = (String) add;
        System.out.println("1");
        String lat_str = (String) lat;
        System.out.println("2");
        double lat_double = Double.parseDouble(lat_str);
        System.out.println("3");
        String longg_str = (String) longg;
        System.out.println("4");
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
        //int phone = 777;
        int phone = Integer.parseInt(phone_str);
        PlacePointDao placePointDao = new PlacePointDaoImpl();
        placePointDao.addPlacePoint(addres_str, lat_double, long_double, amount_int, TagNameFk, TagName, date_sql, phone);
        System.out.println("finish");
        return "redirect:/expenses";
    }

    //показуємо перод з  - до
    @RequestMapping(value = "/expenses/possibility", method = RequestMethod.GET)
    public String showInfoPage(){

        return "possibilityUser";
    }

    // Мамдані і шлях
    @RequestMapping(value = "/expenses/possibility/dateInfo", method = RequestMethod.POST)
    public String showInfoDate(HttpServletRequest request, Model model){
        Object firstDateObj = request.getParameter("date_first");
        Object secondDateObj = request.getParameter("date_second");

        Object o = request.getSession().getAttribute("phone");
        String phone_str = (String) o;

        String date_first_str = (String) firstDateObj;
        String date_second_str = (String) secondDateObj;
        Date date_first = Date.valueOf(date_first_str);
        Date date_second = Date.valueOf(date_second_str);

        //System.out.println("F = " + date_first);
        //System.out.println("S = " + date_second);
        ExpensesForTagDAOImpl expensesForTagDAO = new ExpensesForTagDAOImpl();

        int phone = Integer.parseInt(phone_str);
        System.out.println("phone = " + phone);
        //int phone = 777;

        //////////МАМДАНІ
        Map<String, Double> hashMapTegExpenses;
        Map<String, Double> removeTag;
        hashMapTegExpenses =  expensesForTagDAO.getExpensesForTag(date_first, date_second , phone);
        System.out.println("removeTag");
        removeTag = getEconomy(hashMapTegExpenses);
        model.addAttribute("hashMap", hashMapTegExpenses);
        model.addAttribute("removeTag", removeTag);
        System.out.println(removeTag);
        //////////МАМДАНІ

        /////шлях

        /////////шлях
        return "infoDatePage";
    }


    @RequestMapping(value = "/expenses/possibility/allExpenses", method = RequestMethod.GET)
    public String showInfoDate(Model model, HttpServletRequest request) {

        //int phone = 777;
        Object o = request.getSession().getAttribute("phone");
        String phone_str = (String) o;
        int phone = Integer.parseInt(phone_str);
        System.out.println("phone " + phone);
        ExpensesForTagDAOImpl expensesForTagDAO = new ExpensesForTagDAOImpl();
        List<AllExpensesClass> allExpensesClassesList = expensesForTagDAO.getAllExpenses(phone);
        model.addAttribute("allExpensesClassesList",allExpensesClassesList);
        return "allExpenses";
    }

}
