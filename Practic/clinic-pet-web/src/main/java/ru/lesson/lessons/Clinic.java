package ru.lesson.lessons;

import java.util.ArrayList;

/**
 * Created by Йотун on 09.01.2017.
 */
public class Clinic {
    /**
     * List of the clients
     */
    private ArrayList<Client> clients;

    /**
     * Constructor
     */
    public Clinic() {
        this.clients = new ArrayList<Client>();
    }

    /**
     * Add client
     *
     * @param position
     * @param client
     */
    public void addClient(final int position, final Client client) {
        synchronized (this.clients) {
            clients.add(position, client);
        }
    }

    /**
     * Find client of his name
     * if not found that throw ClientNotFound
     *
     * @param name
     */
    public ArrayList<Client> findNameClient(final String name) throws ClientNotFound {
        ArrayList<Client> client = new ArrayList<Client>();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId().equals(name))
                client.add(clients.get(i));
        }
        if (client.size()==0)
            throw new ClientNotFound(name);
        else
            return client;
    }

    /**
     * Find client by his pet's name
     * @param name
     * @return
     * @throws ClientNotFound
     */
    public ArrayList<Client> findByPetName(final String name) throws ClientNotFound{
        ArrayList<Client> client = new ArrayList<Client>();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getPet().getName().equals(name))
                client.add(clients.get(i));
        }
        if (client.size()==0)
            throw new ClientNotFound(name);
        else
            return client;
    }

    /**
     * delete client
     * @param client
     */
    public void deleteClient(final Client client){
        clients.remove(client);
    }
    public ArrayList<Client> getClients(){
        return clients;
    }
}
