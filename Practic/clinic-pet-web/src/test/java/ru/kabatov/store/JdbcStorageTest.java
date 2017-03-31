package ru.kabatov.store;

import org.junit.Test;
import ru.kabatov.models.User;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Кабатов on 31.03.2017.
 */
public class JdbcStorageTest {
    @Test
    public void values() throws Exception {
        JdbcStorage jdbcStorage = new JdbcStorage();
        Collection<User> users = jdbcStorage.values();
        for (User user:users){
            System.out.println(user.getId()+" "+user.getLogin()+" "+user.getEmail());
        }
    }

}