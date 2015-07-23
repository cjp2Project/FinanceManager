package com.luxoft.financemanager.service;

import com.luxoft.financemanager.dao.FinanceManagerDAO;
import com.luxoft.financemanager.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by bszewczyk on 2015-07-22.
 */
public class FinanceManagerServiceImplTest {

    private FinanceManagerDAO financeManagerDAO;
    private String userName;
    private FinanceManagerServiceImpl financeManagerServiceImpl;

    @Before
    public void setUp() {
        financeManagerDAO = Mockito.mock(FinanceManagerDAO.class);
        financeManagerServiceImpl = new FinanceManagerServiceImpl();
        financeManagerServiceImpl.setFinanceManagerDAO(financeManagerDAO);
    }

    // Test comment
    @Test
    public void shouldReturnNullWhenEmptyUserNamePassedAsParameter() {

        userName = "";
        when(financeManagerDAO.getUserByUserName(userName)).thenReturn(null);

        assertNull("Empty >>user name<< returns null", financeManagerServiceImpl.getUserByUserName(userName));
    }

    @Test
    public void shouldReturnNullWheNullAsUserNamePassedAsParameter() {
        String userName = null;
        when(financeManagerDAO.getUserByUserName(userName)).thenReturn(null);

        assertNull("Null as >>user name<< returns null", financeManagerServiceImpl.getUserByUserName(userName));
    }

    @Test
    public void shouldReturnUserAccordingToGivenUserNameIfUserExists() {
        String userName = "Joh Doe";
        User user = new User();
        user.setUserName(userName);
        when(financeManagerDAO.getUserByUserName(userName)).thenReturn(user);

        assertEquals("Real user found by user name", user, financeManagerServiceImpl.getUserByUserName(userName));
    }

    @Test
    public void shouldReturnNullWhenGivenUserNameDoesntExistsInDatabase() {
        String nonExistingUserName = "Joh Doe";

        when(financeManagerDAO.getUserByUserName(nonExistingUserName)).thenReturn(null);

        assertNull("User not found", financeManagerServiceImpl.getUserByUserName(nonExistingUserName));
    }
}