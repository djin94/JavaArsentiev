package ru.kabatov.servlets;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import ru.kabatov.form.UserForm;
import ru.kabatov.models.User;
import ru.kabatov.store.UserCache;
import ru.kabatov.store.UserCacheHbn;
import ru.kabatov.store.UserCacheJdbc;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 25.04.2015
 */
@JsonAutoDetect
public class CreateUserJsonServlet extends HttpServlet {

    private final UserCacheHbn USER_CACHE = UserCacheHbn.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        final ServletOutputStream out = resp.getOutputStream();
        //req.setAttribute("users",this.USER_CACHE.values());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
// do various things, perhaps:
        String someJsonString = mapper.writeValueAsString(USER_CACHE);
        UserCacheHbn someClassInstance = mapper.readValue(someJsonString, UserCacheHbn.class);
        out.print(mapper.writeValueAsString(USER_CACHE.values()));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        final UserForm form = new ObjectMapper().readValue(req.getInputStream(), UserForm.class);
        USER_CACHE.add(new User(USER_CACHE.generateId(), form.getLogin(), form.getEmail(), form.getCity()));
        resp.getOutputStream().write("{'result' : 'true'}".getBytes());
        read();
    }

    public void read() {
        for (User user : USER_CACHE.values())
            System.out.println(user.getId());
    }
}