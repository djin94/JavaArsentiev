package ru.lesson.lessons;

import org.junit.Assert;
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
        clinic.addClient(0, new Client("Ivan", new Dog(new Animal("Rex"))));
        clinic.addClient(0, new Client("Kevin", new Cat(new Animal("Devil"))));
        assertFalse(clinic.getClients().isEmpty());
        assertEquals(clinic.getClients().size(),2);
        clinic.deleteClient(clinic.findNameClient("Ivan").get(0));
        clinic.deleteClient(clinic.findNameClient("Kevin").get(0));
        assertEquals(clinic.getClients().size(),0);
    }

    @Test(expected = ClientNotFound.class)
    public void findNameClient() throws Exception {
        clinic.addClient(0, new Client("Ivan", new Dog(new Animal("Rex"))));
        clinic.addClient(0, new Client("Kevin", new Cat(new Animal("Devil"))));
        List<Client> clients = clinic.findNameClient("Ivan");
        assertEquals(clients.size(), 1);
        Assert.assertEquals(clients.get(0).getId(), "Ivan");
        clients = clinic.findNameClient("Bruce");
        clinic.deleteClient(clinic.findNameClient("Ivan").get(0));
        clinic.deleteClient(clinic.findNameClient("Kevin").get(0));
        assertEquals(clinic.getClients().size(),0);
    }

    @Test(expected = ClientNotFound.class)
    public void findByPetName() throws Exception {
        clinic.addClient(0, new Client("Ivan", new Dog(new Animal("Rex"))));
        clinic.addClient(0, new Client("Kevin", new Cat(new Animal("Devil"))));
        List<Client> clients = clinic.findByPetName("Rex");
        assertEquals(clients.size(), 1);
        assertEquals(clients.get(0).getPet().getName(), "Rex");
        clients = clinic.findByPetName("Ivan");
        clinic.deleteClient(clinic.findNameClient("Ivan").get(0));
        clinic.deleteClient(clinic.findNameClient("Kevin").get(0));
        assertEquals(clinic.getClients().size(),0);
    }

    @Test
    public void getClients() throws Exception {
        clinic.addClient(0, new Client("Ivan", new Dog(new Animal("Rex"))));
        clinic.addClient(0, new Client("Kevin", new Cat(new Animal("Devil"))));
        assertEquals(clinic.getClients().size(),2);
        clinic.deleteClient(clinic.findNameClient("Ivan").get(0));
        clinic.deleteClient(clinic.findNameClient("Kevin").get(0));
        assertEquals(clinic.getClients().size(),0);
    }

}