package com.luxoft.financemanager.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {

    HelloController helloController;

    @Mock
    ModelMap model;

    @Before
    public void init() {
        helloController = new HelloController();
    }

    @Test
    public void whenNoNameEnteredShowError() {
        ModelMap myModel = new ModelMap();
        String viewName = helloController.printWelcome(myModel);

        assertEquals(viewName, "hello");
    }

    @Test
    public void testAddAttributeTwoTimesExecutions() throws Exception {
        helloController.printWelcome(model);

        verify(model).addAttribute("message", "Finance Manager");
        verify(model).addAttribute("intro", "The Spending Money Supporter");
    }

    @Test
    public void modelGetAttributeOfStringMessageShouldReturnStringFinanceManager() throws Exception {
        ModelMap dummyModel = new ModelMap();
        helloController.printWelcome(dummyModel);

        assertEquals(dummyModel.get("message"), "Finance Manager");
    }

    @Test
    public void modelGetAttributeOfStringIntroShouldReturnStringTheSpendingMoneySupporter() throws Exception {
        ModelMap dummyModel = new ModelMap();
        helloController.printWelcome(dummyModel);

        assertEquals(dummyModel.get("intro"), "The Spending Money Supporter");
    }
}