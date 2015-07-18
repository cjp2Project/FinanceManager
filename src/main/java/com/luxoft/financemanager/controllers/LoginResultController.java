package com.luxoft.financemanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginResultController {

//    @RequestMapping(value = "/loginresult.html", method = RequestMethod.POST)
    @RequestMapping(value = "/admin/welcomePage.html", method = RequestMethod.GET)
    public ModelAndView getAdminWelcomePage() {
        return new ModelAndView("adminWelcomePage");
    }

    @RequestMapping(value = "/user/welcomePage.html", method = RequestMethod.GET)
    public ModelAndView getUserWelcomePage() {
        return new ModelAndView("userWelcomePage");
    }
}
