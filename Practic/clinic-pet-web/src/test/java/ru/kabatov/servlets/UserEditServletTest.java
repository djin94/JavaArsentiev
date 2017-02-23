package ru.kabatov.servlets;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.kabatov.models.User;
import ru.kabatov.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.concurrent.atomic.AtomicInteger;

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
        //assertTrue(userCache.values().isEmpty());
        new UserCreateServlet().doPost(request, response);

        when(request.getRequestDispatcher("/views/user/EditUser.jsp")).thenReturn(mock(RequestDispatcher.class));
        when(request.getParameter("id")).thenReturn("1");
        new UserEditServlet().doGet(request, response);
        verify(request,atLeast(1)).getParameter("id");
        userCache.delete(userCache.findByLogin("test").getId());
    }

    @Test
    public void doPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        /*when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");

        assertTrue(userCache.values().isEmpty());
        new UserCreateServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");*/
        userCache.add(new User(userCache.generateId(), "test", "test"));

        assertFalse(userCache.values().isEmpty());

        when(request.getParameter("login")).thenReturn("test1");
        when(request.getParameter("email")).thenReturn("test1");

        UserEditServlet ues = new UserEditServlet();
        ues.ids.set(userCache.findByLogin("test").getId()-1);
        ues.doPost(request,response);

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");

        User user = userCache.findByLogin("test1");
        assertEquals(user.getLogin(), "test1");
        userCache.delete(userCache.findByLogin("test1").getId());
    }
}