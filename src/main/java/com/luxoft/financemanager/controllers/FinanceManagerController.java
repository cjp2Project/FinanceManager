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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class FinanceManagerController {
    @Autowired(required = true)
    @Qualifier(value = "financeManagerService")
    private FinanceManagerService service;

    public void setService(FinanceManagerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/user/addshoppingitem.html", method = RequestMethod.GET)
    public String listShoppingItemValues(Model model) {
        User user = service.getUserByUserName("user");
        model.addAttribute("user", user);

        model.addAttribute("shop", new Shop());
        model.addAttribute("shops", service.listShops());

        model.addAttribute("currency", new Currency());
        model.addAttribute("currencies", service.listCurrencies());

        model.addAttribute("category", new ShoppingCategory());
        model.addAttribute("categories", service.listCategories());

        return "addshoppingitem";
    }


    @RequestMapping(value = "/user/addshoppingitemresult.html", method = RequestMethod.GET)
    public String addShoppingItem(@ModelAttribute("shopping_item") ShoppingItem shoppingItem) {
        shoppingItem.setReceipt(null);
        if (shoppingItem.getId() == 0) {
            this.service.addShoppingItemToDB(shoppingItem);
        }
        return "addshoppingitemresult";
    }
}