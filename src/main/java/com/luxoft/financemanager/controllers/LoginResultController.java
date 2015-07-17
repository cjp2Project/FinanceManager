package com.luxoft.financemanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginResultController {

    @RequestMapping(value = "/loginresult.html", method = RequestMethod.POST)
    public ModelAndView getLoginForm() {
        ModelAndView model = new ModelAndView("loginresult");
        return model;
    }
}
