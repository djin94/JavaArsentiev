package ru.kabatov.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.kabatov.models.User;
import ru.kabatov.store.UserCache;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by Кабатов on 21.02.2017.
 */
public class UserCreateServletTest extends Mockito{
    final UserCache userCache = UserCache.getInstance();
    @Test
    public void createUser() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response= mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");

        assertTrue(userCache.values().isEmpty());

        new UserCreateServlet().doPost(request,response);
        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");


        userCache.delete(userCache.findByLogin("test").getId());
    }

}