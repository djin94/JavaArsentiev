package ru.kabatov.servlets;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by Йотун on 24.02.2017.
 */
public class UserViewServletTest extends Mockito{
    @Test
    public void doGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getRequestDispatcher("/views/user/UserView.jsp")).thenReturn(mock(RequestDispatcher.class));
        UserViewServlet uvs = new UserViewServlet();
        uvs.doGet(request, response);
        uvs.destroy();
    }

}