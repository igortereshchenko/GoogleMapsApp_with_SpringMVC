/*
package com.controller;

import com.model.Spending;
import com.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

*/
/**
 * Created by Ichanskiy on 2017-04-20.
 *//*
*/
/**//*

@Controller
public class SpendingController {

    private SpendingService spendingService;

    @Autowired(required = true)
    @Qualifier(value = "spendingService")
    public void setSpendingService(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @RequestMapping(value = "spending", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("spending", new Spending());
        model.addAttribute("listSpending", this.spendingService.listSpending());
        return "Spending";
    }

    @RequestMapping(value = "/spending/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("spending") Spending spending){

        System.out.println(spending);
        this.spendingService.addSpending(spending);

        return "redirect:/spending";
    }

    @RequestMapping("sendingData")
    public String bookData(Model model){

        model.addAttribute("spendingList", this.spendingService.listSpending());
        return "spendingData";
    }
}
*/
