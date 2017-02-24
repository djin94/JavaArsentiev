package ru.kabatov.servlets;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import static org.junit.Assert.*;

/**
 * Created by Йотун on 24.02.2017.
 */
public class clinicServletsTest extends Mockito{
    @Test
    public void doGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        clinicServlets cs = new clinicServlets();
        /*when(request.getParameter("addField")).thenReturn("Submit");
        when(request.getParameter("clientName")).thenReturn("Kevin");
        when(request.getParameter("petName")).thenReturn("Rex");
        when(request.getParameter("typePet")).thenReturn("Dog");
        cs.doPost(request,response);*/

        when(response.getWriter()).thenReturn(mock(PrintWriter.class));
        //when(request.getParameter("searchByClientName")).thenReturn("Kevin");
        cs.doGet(request,response);
        when(request.getParameter("searchField")).thenReturn("Submit");
        when(request.getParameter("searchByClientName")).thenReturn("Ivan");
        when(request.getParameter("searchByPetsName")).thenReturn("Rex");
        cs.doPost(request,response);
    }

    @Test
    public void doPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        clinicServlets cs = new clinicServlets();
        when(response.getWriter()).thenReturn(mock(PrintWriter.class));
        when(request.getParameter("addField")).thenReturn("Submit");
        when(request.getParameter("clientName")).thenReturn("Kevin");
        when(request.getParameter("petName")).thenReturn("Rex");
        when(request.getParameter("typePet")).thenReturn("Dog");
        cs.doPost(request,response);
        when(request.getParameter("addField")).thenReturn("Submit");
        when(request.getParameter("clientName")).thenReturn("Ivan");
        when(request.getParameter("petName")).thenReturn("Devil");
        when(request.getParameter("typePet")).thenReturn("Cat");
        cs.doPost(request,response);
        when(request.getParameter("searchField")).thenReturn("Submit");
        when(request.getParameter("searchByClientName")).thenReturn("Kevin");
        when(request.getParameter("searchByPetsName")).thenReturn("");
        cs.doPost(request,response);
        when(request.getParameter("searchByClientName")).thenReturn("Kevin");
        when(request.getParameter("searchByPetsName")).thenReturn("Rex");
        cs.doPost(request,response);
        when(request.getParameter("searchByClientName")).thenReturn("");
        when(request.getParameter("searchByPetsName")).thenReturn("Rex");
        cs.doPost(request,response);
        when(request.getParameter("searchByClientName")).thenReturn("");
        when(request.getParameter("searchByPetsName")).thenReturn("");
        cs.doPost(request,response);
        when(request.getParameter("searchByClientName")).thenReturn("Dimitri");
        when(request.getParameter("searchByPetsName")).thenReturn("");
        cs.doPost(request,response);
    }

}