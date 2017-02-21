package ru.kabatov.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.kabatov.models.User;
import ru.kabatov.store.UserCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by Кабатов on 21.02.2017.
 */
public class UserEditServletTest extends Mockito {
    final UserCache userCache = UserCache.getInstance();

    @Test
    public void doGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");

        assertTrue(userCache.values().isEmpty());

        new UserCreateServlet().doPost(request, response);


        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");

        assertFalse(userCache.values().isEmpty());

        new UserEditServlet().doGet(request,response);
        assertEquals(verify(request).getParameter("id"),Integer.toString(userCache.findByLogin("test").getId()));
        verify(request).getParameter("id");
        when(request.getParameter("login")).thenReturn("test1");
        when(request.getParameter("email")).thenReturn("test1");
        userCache.delete(userCache.findByLogin("test1").getId());

    }

    @Test(expected = Exception.class)
    public void doPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");

        assertTrue(userCache.values().isEmpty());
        new UserCreateServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");

        assertFalse(userCache.values().isEmpty());

        when(request.getParameter("login")).thenReturn("test1");
        when(request.getParameter("email")).thenReturn("test1");

        new UserEditServlet().doPost(request, response);

        User user = userCache.findByLogin("test1");
        assertEquals(user.getLogin(), "test1");
        userCache.delete(userCache.findByLogin("test1").getId());

    }

}