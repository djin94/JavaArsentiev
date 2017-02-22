package ru.lesson.lessons;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Кабатов on 22.02.2017.
 */
public class ClinicTest {
    Clinic clinic = new Clinic();

    @Before
    @Test
    public void addClient() throws Exception {
        //assertTrue(clinic.getClients().isEmpty());
        clinic.addClient(0, new Client("Ivan", new Dog(new Animal("Rex"))));
        clinic.addClient(0, new Client("Kevin", new Cat(new Animal("Devil"))));
        assertFalse(clinic.getClients().isEmpty());
    }

    @Test
    public void findNameClient() throws Exception {
        List<Client> clients = clinic.findNameClient("Ivan");
        assertEquals(clients.size(), 1);
        assertEquals(clients.get(0).getId(), "Ivan");
        clients = clinic.findNameClient("Bruce");
    }

    @Test
    public void findByPetName() throws Exception {
        List<Client> clients = clinic.findByPetName("Rex");
        assertEquals(clients.size(), 1);
        assertEquals(clients.get(0).getId(), "Ivan");
    }

    @Test
    public void deleteClient() throws Exception {

    }

    @Test
    public void countClients() throws Exception {

    }

    @Test
    public void getClients() throws Exception {

    }

}