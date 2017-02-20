package ru.kabatov.servlets;

import ru.lesson.lessons.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by Кабатов on 10.02.2017.
 */
public class clinicServlets extends HttpServlet {
    Clinic clinic = new Clinic();
    private boolean searcher = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "     <title>Clinic Pets</title>" +
                        "</head>" +
                        "<body>" +
                        "     <form action='" + req.getContextPath() + "/' method='post'>" +
                        "         Client name : <input type='text' name='clientName'>" +
                        "" +
                        "         <br><select size=1 name='typePet'>" +
                        "         <option>Dog</option>" +
                        "         <option>Cat</option>" +
                        "         </select>" +
                        "         Pet name : <input type='text' name='petName'>" +
                        "         <input type='submit' value='Submit' name='addField'>" +
                        "     </form>" +
                        "" +
                        "     <br>Search" +
                        "     <br><form action='" + req.getContextPath() + "/' method='post'>" +
                        "     Client name : <input type='text' name='searchByClientName'>" +
                        "     <br>Pets name : <input type='text' name='searchByPetsName'>" +
                        "     <input type='submit' value='Submit' name='searchField'>" +
                        "</form><br>" +
                        ""
        );
        if (searcher) {
            writer.append(this.viewSearch(req.getParameter("searchByClientName"),
                    req.getParameter("searchByPetsName")));
            searcher=false;
        }
        else writer.append(this.viewPets());
        writer.append(
                "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        searcher = false;
        if (!(req.getParameter("addField")==null)) {
            if ((req.getParameter("clientName").equals("")) | (req.getParameter("petName").equals(""))) {
            } else {
                if (req.getParameter("typePet").equals("Dog")) {
                    clinic.addClient(0, new Client(req.getParameter("clientName"), new Dog(new Animal(req.getParameter("petName")))));
                }
                if (req.getParameter("typePet").equals("Cat")) {
                    clinic.addClient(0, new Client(req.getParameter("clientName"), new Cat(new Animal(req.getParameter("petName")))));
                }
            }

        }
        if (!(req.getParameter("searchField")==null)) {
            searcher = true;
        }
        doGet(req, resp);
    }

    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Clients</p>");
        sb.append("<table style='border : 1px solid black'>");
        sb.append("<tr><td style='border : 1px solid black'>").append("Client name</td>");
        sb.append("<td style='border : 1px solid black'>").append("Pet name</td></tr>");
        for (Client client : clinic.getClients()) {
            sb.append("<tr><td style='border : 1px solid black'>").append(client.getId()).append("</td>");
            sb.append("<td style='border : 1px solid black'>").append(client.getPet().getName()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String viewSearch(String clientName, String petName) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Client> clients = null;
        sb.append("<p>Search Clients</p>");
        try {
            if ((!(clientName.equals(""))) && (!(petName.equals("")))) {
                clients = clinic.findNameClient(clientName);
                for (Client cl : clients) {
                    if (!cl.getPet().getName().equals(petName))
                        clients.remove(cl);
                }
            }
            if ((!(clientName.equals(""))) && (petName.equals(""))) {
                clients=clinic.findNameClient(clientName);
            }
            if ((clientName.equals(""))&&(!(petName.equals("")))){
                clients = clinic.findByPetName(petName);
            }
            if (clients==null) throw new ClientNotFound(clientName + " " + petName);
        } catch (ClientNotFound e) {
            sb.append("<br>Client Not Found");
            return sb.toString();
        }
        catch (Exception e){
            sb.append("<br>Exception");
            sb.append("<br>"+clientName);
            sb.append("<br>" + petName);
            return sb.toString();
        }
        sb.append("<table style='border : 1px solid black'>");
        sb.append("<tr><td style='border : 1px solid black'>").append("Client name</td>");
        sb.append("<td style='border : 1px solid black'>").append("Pet name</td></tr>");
        for (Client client : clients) {
            sb.append("<tr><td style='border : 1px solid black'>").append(client.getId()).append("</td>");
            sb.append("<td style='border : 1px solid black'>").append(client.getPet().getName()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
