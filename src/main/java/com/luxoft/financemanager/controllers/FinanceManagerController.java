package com.luxoft.financemanager.controllers;

import com.luxoft.financemanager.model.*;
import com.luxoft.financemanager.service.FinanceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class FinanceManagerController {
    @Autowired(required = true)
    @Qualifier(value = "financeManagerService")
    private FinanceManagerService service;

    public void setService(FinanceManagerService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/user/delete-shopping-item{id}"}, method = RequestMethod.GET)
    public String deleteShoppingItem(@PathVariable String id) {
        service.removeShoppingItemByID(Integer.parseInt(id));
        return "redirect:/user/welcomePage.html";
    }

    @RequestMapping(value = {"/user/editshoppingitem{id}"}, method = RequestMethod.GET)
    public String updateShoppingItem(@PathVariable String id, Model model, Principal principal) {
        ShoppingItem shoppingItem = service.getShoppingItemByID(Integer.parseInt(id));

        User user = service.getUserByUserName(principal.getName());
        model.addAttribute("shopping_item", shoppingItem);
        model.addAttribute("shopping_item_id", id);
        model.addAttribute("user", user);
        model.addAttribute("shops", service.listShops());
        model.addAttribute("shoppingCategories", service.listCategories());
        model.addAttribute("currencies", service.listCurrencies());

        return "editshoppingitem";
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

    private ModelAndView getAddShoppingItemModel(Principal principal, String errorMessage) {
        ModelAndView model = new ModelAndView("addshoppingitem");
        User user = service.getUserByUserName(principal.getName());
        model.addObject("user", user);
        model.addObject("shops", service.listShops());
        model.addObject("shoppingCategories", service.listCategories());
        model.addObject("currencies", service.listCurrencies());
        model.addObject("errorMessage", errorMessage);
        return model;
    }

    @RequestMapping(value = "/user/afteraddingItem.html", method = RequestMethod.POST)
    public ModelAndView afterAddingShoppingItem(Principal principal,
                                                @RequestParam("date") String date,
                                                @RequestParam("shoppingCategory") String shoppingCategoryId,
                                                @RequestParam("currency") String currencyId,
                                                @RequestParam("amount") String amount,
                                                @RequestParam("shop") String shopId,
                                                @RequestParam("description") String description
    ) {
        StringBuilder sb = new StringBuilder();
        // parsing date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date validDate = null;
        try {
            validDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            sb.append("\nDate is invalid format. Please use format 'yyyy-MM-dd'");

            return getAddShoppingItemModel(principal, sb.toString());
        }

        // parsing amount
//        Pattern pattern = Pattern.compile("^[+-]?[1-9][0-9]+[.]?[0-9]{2}?");
//        Matcher matcher = pattern.matcher(amount);
        if (!amount.matches("^[+]?[1-9][0-9]+[.]?[0-9]{2}?")) {
            sb.append("\nAmount format is bot valid. Please use 'DDDD.DD'");
            return getAddShoppingItemModel(principal, sb.toString());
        }


        ShoppingItem item = new ShoppingItem();

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
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date shoppingItemDate = null;
//        try {
//            shoppingItemDate = dateFormat.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        item.setDate(validDate);

        // description
        item.setDescription(description);

        // receipt -> null so far
        item.setReceipt(null);

        service.addShoppingItemToDB(item);

        ModelAndView model = new ModelAndView("redirect:welcomePage.html");

        return model;
    }

    @RequestMapping(value = "/user/aftereditingItem", method = RequestMethod.POST)
    public ModelAndView afterEditingShoppingItem(Principal principal,
                                                 @RequestParam("shoppingCategory") String shoppingCategoryId,
                                                 @RequestParam("currency") String currencyId,
                                                 @RequestParam("amount") String amount,
                                                 @RequestParam("shop") String shopId,
                                                 @RequestParam("date") String date,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("shopping_item_id") String shoppingItemId
    ) {
        ShoppingItem item = service.getShoppingItemByID(Integer.parseInt(shoppingItemId));
        // service.removeShoppingItemByID(Integer.parseInt(id));
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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

        service.updateShoppingItemToDB(item);

        ModelAndView model = new ModelAndView("redirect:welcomePage.html");

        return model;
    }
}