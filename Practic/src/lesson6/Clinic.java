package lesson6;

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
        this.clients = new ArrayList<>();
    }

    /**
     * Add client
     *
     * @param position
     * @param client
     */
    public void addClient(final int position, final Client client) {
        clients.add(position, client);
    }

    /**
     * Find client of his name
     * if not found that throw ClientNotFound
     *
     * @param name
     */
    public Client findNameClient(final String name) throws ClientNotFound {
        Client client = null;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == name)
                client = clients.get(i);
        }
        if (client == null)
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
    public Client findByPetName(final String name) throws ClientNotFound{
        Client client = null;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getPet().getName() == name)
                client = clients.get(i);
        }
        if (client == null)
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
}
