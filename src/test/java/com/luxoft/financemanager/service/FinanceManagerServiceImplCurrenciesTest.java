package com.luxoft.financemanager.service;

import com.luxoft.financemanager.dao.FinanceManagerDAO;
import com.luxoft.financemanager.model.Currency;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by jkacki on 2015-07-24.
 */
@RunWith(Parameterized.class)
public class FinanceManagerServiceImplCurrenciesTest {

    @Parameterized.Parameter(value = 0)
    public int id;
    @Parameterized.Parameter(value = 1)
    public String currentName;

    @Parameterized.Parameters
    public static Collection<Object[]> dataForTest() {
        Object[][] array = new Object[][]{{1, "PLN"}, {2, "EUR"}, {3, "USD"}};
        return Arrays.asList(array);
    }

    private FinanceManagerDAO financeManagerDAO;
    private String userName;
    private FinanceManagerServiceImpl financeManagerServiceImpl;

    @Before
    public void setUp() {
        financeManagerDAO = Mockito.mock(FinanceManagerDAO.class);
        financeManagerServiceImpl = new FinanceManagerServiceImpl();
        financeManagerServiceImpl.setFinanceManagerDAO(financeManagerDAO);
    }

    @Test
    public void shouldReturnNullWhenNegativeValuePassedAsParameter() throws Exception {
        int currencyID = -1;

        when(financeManagerDAO.getCurrencyById(currencyID)).thenReturn(null);

        assertNull("Negative ID passed returns null", financeManagerServiceImpl.getCurrencyById(currencyID));
    }

    @Test
    public void allGivenParametersShouldReturnProperValues() throws Exception {
        Currency c = new Currency();
        c.setCurrencyName(currentName);
        when(financeManagerDAO.getCurrencyById(id)).thenReturn(c);
        assertEquals("proper currency name returned", currentName, financeManagerServiceImpl.getCurrencyById(id).getCurrencyName());
    }

    @Test
    public void shouldReturnNullWhenZeroPassedAsParameter() throws Exception {
        int currencyID = 0;

        when(financeManagerDAO.getCurrencyById(currencyID)).thenReturn(null);

        assertNull("Zero passed as parameter returns null", financeManagerServiceImpl.getCurrencyById(currencyID));
    }
}