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

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public String addShoppingItem(Model model, Principal principal) {
        User user = service.getUserByUserName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("shops", service.listShops());
        model.addAttribute("shoppingCategories", service.listCategories());
        model.addAttribute("currencies", service.listCurrencies());

        return "addshoppingitem";
    }

    @RequestMapping(value = "/user/afteraddingItem.html", method = RequestMethod.POST)
    public ModelAndView afterAddingShoppingItem(Principal principal,
                                                   @RequestParam("shoppingCategory") String shoppingCategoryId,
                                                   @RequestParam("currency") String currencyId,
                                                   @RequestParam("amount") String amount,
                                                   @RequestParam("shop") String shopId,
                                                   @RequestParam("date") String date,
                                                   @RequestParam("description") String description
    ) {
        ShoppingItem item = new ShoppingItem();

        // user
        item.setUser(service.getUserByUserName(principal.getName()));

        // shopping category
        ShoppingCategory shoppingCategory = service.getShoppingCategoryById(Integer.parseInt(shoppingCategoryId));
        item.setShoppingCategory(shoppingCategory);

        // currency
        Currency currency = service.getCurrencyById(Integer.parseInt(currencyId));
        item.setCurrency(currency);

        // amount
        float cash = Float.parseFloat(amount);
        item.setAmount(cash);

        // shop
        Shop shop = service.getShopById(Integer.parseInt(shopId));
        item.setShop(shop);

        // date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date shoppingItemDate = null;
        try {
            shoppingItemDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        item.setDate(shoppingItemDate);

        // description
        item.setDescription(description);

        // receipt -> null so far
        item.setReceipt(null);

        service.addShoppingItemToDB(item);

        ModelAndView model = new ModelAndView("afteraddingshoppingitemstatus");

        return model;
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