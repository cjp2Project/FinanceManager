package com.luxoft.financemanager.controllers;

import com.luxoft.financemanager.dao.FinanceManagerDAOImpl;
import com.luxoft.financemanager.model.User;
import com.luxoft.financemanager.service.FinanceManagerService;
import com.luxoft.financemanager.service.FinanceManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoginResultController {
    @Autowired(required = true)
    @Qualifier(value = "financeManagerService")
    private FinanceManagerService service;

    public void setService(FinanceManagerService service) {
        this.service = service;
    }

    //    @RequestMapping(value = "/loginresult.html", method = RequestMethod.POST)
    @RequestMapping(value = "/admin/welcomePage.html", method = RequestMethod.GET)
    public ModelAndView getAdminWelcomePage(Principal principal) {
        String userName = principal.getName();
        User user = service.getUserByUserName(userName);
        ModelAndView model = new ModelAndView("adminWelcomePage");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/user/welcomePage.html", method = RequestMethod.GET)
    public ModelAndView getUserWelcomePage(Principal principal) {
        String userName = principal.getName();
        User user = service.getUserByUserName(userName);
        ModelAndView model = new ModelAndView("userWelcomePage");
        model.addObject("user", user);
        return model;
    }
}
