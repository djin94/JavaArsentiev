package ru.kabatov.store;


import org.junit.Ignore;
import org.junit.Test;
import ru.kabatov.models.Message;
import ru.kabatov.models.Role;
import ru.kabatov.models.User;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by Кабатов on 11.07.2017.
 */
public class HibernateStorageTest {

    @Ignore
    @Test
    public void testCreate() throws Exception {
       /* //public User(final int id, String login, String email, String city, String sex, String agree, Role role)
        final HibernateStorage storage = new HibernateStorage();
        Role role = new Role();
        role.setId(2);
        role.setName("User");
        final int id = storage.add(new User(-1, "hibenate", "jgfjfg", "sdhsh", "m","true",role));
        final User user = storage.get(id);
        assertEquals(id, user.getId());
        assertEquals(id, storage.findByLogin("hibenate").getId());
        storage.delete(id);
        assertNull(storage.get(id));
        storage.close();*/
    }

    @Test
    public void testCreateUser() throws Exception {
        /*final HibernateStorage storage = new HibernateStorage();
        Role role = new Role();
        role.setName("admin");
        User user = new User();
        user.setLogin("test");
        user.setEmail("test@test");
        user.setRole(role);
        final int id = storage.add(user);
        user = storage.get(id);
        Message message = new Message();
        message.setUser(user);
        message.setText("text");
        HashSet<Message> messages = new HashSet<Message>();
        messages.add(message);
        user.setMessages(messages);
        storage.edit(user);
        assertEquals(1, storage.get(id).getMessages().size());
        //storage.delete(id);
        storage.close();*/
    }

    @Test
    public void testUserValues() throws Exception {
        /*HibernateStorage storage = new HibernateStorage();
        ArrayList<User> users = new ArrayList<>(storage.values());*/

    }

    @Test
    public void testDelete() throws Exception {
       /* HibernateStorage storage = new HibernateStorage();
        storage.delete(7);
        storage.delete(8);
        storage.delete(9);
        storage.delete(10);
        storage.delete(11);
        storage.delete(12);
        storage.delete(13);
        storage.delete(14);
        storage.delete(15);
        storage.delete(16);
        storage.delete(17);*/
    }
}