package com.luxoft.financemanager.controllers;

import com.luxoft.financemanager.model.City;
import com.luxoft.financemanager.model.ShoppingItem;
import com.luxoft.financemanager.service.CityService;
import com.luxoft.financemanager.service.FinanceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FinanceManagerController {
    @Autowired(required = true)
    @Qualifier(value = "financeManagerService")
    private FinanceManagerService service;

    public void setService(FinanceManagerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/shoplist.html", method = RequestMethod.GET)
    public String listCities(Model model) {
        model.addAttribute("shopping_item", new ShoppingItem());
        return "shoplist";
    }

    @RequestMapping(value = "/shoplist.html", method = RequestMethod.POST)
    public String addShoppingItem(@ModelAttribute("shopping_item")ShoppingItem shoppingItem) {
        if (shoppingItem.getId() == 0) {
            this.service.addShoppingItemToDB(shoppingItem);
        }
        return "shoplist";
    }
}
