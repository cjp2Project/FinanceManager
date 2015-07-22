package com.luxoft.financemanager.controllers;

import com.luxoft.financemanager.model.Shop;
import com.luxoft.financemanager.model.*;
import com.luxoft.financemanager.model.ShoppingItem;
import com.luxoft.financemanager.service.FinanceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FinanceManagerController {
    @Autowired(required = true)
    @Qualifier(value = "financeManagerService")
    private FinanceManagerService service;

    public void setService(FinanceManagerService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/delete-shopping-item{id}"}, method = RequestMethod.GET)
    public String deleteShoppingItem(@PathVariable String id) {
        service.removeShoppingItemByID(Integer.parseInt(id));
        return "redirect:/user/welcomePage.html";
    }

    @RequestMapping(value = {"/edit-shopping-item{id}"}, method = RequestMethod.GET)
    public String updateShoppingItem(@PathVariable String id) {

       // service.removeShoppingItemByID(Integer.parseInt(id));
        return "redirect:/user/welcomePage.html";
    }
}