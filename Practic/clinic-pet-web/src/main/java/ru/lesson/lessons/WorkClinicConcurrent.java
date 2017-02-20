package ru.lesson.lessons;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Кабатов on 09.02.2017.
 */
public class WorkClinicConcurrent extends Thread {
    private Clinic clinic;
    private ArrayList<String> nameClient;
    private ArrayList<String> namePet;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                Client client = makeClient();
                clinic.addClient(0, client);
                System.out.println("Thread: "+this.getName()+" Client: "+client.getId()+
                        " Pet: "+client.getPet().getClass().getSimpleName()+" "+client.getPet().getName());
            } catch (IOException e) {
                System.out.println("Error " + this.getName());
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Index");
            }
        }
    }


    public synchronized Client makeClient() throws IOException {
        Client client;
        Pet pet = null;

        int clRand = (int) Math.round(Math.random() * (nameClient.size()-1));
        long ptRand = Math.round(Math.random());
        int ptNmRand = (int) Math.round(Math.random() * (namePet.size()-1));
        if (ptRand == 0) {
            pet = new Cat(new Animal(namePet.get(ptNmRand)));
        }
        if (ptRand == 1) {
            pet = new Dog(new Animal(namePet.get(ptNmRand)));
        }
        client = new Client(nameClient.get(clRand), pet);
        return client;
    }

    public WorkClinicConcurrent(String name, Clinic clinic) throws IOException{
        super(name);
        this.clinic = clinic;
        String s = System.getProperty("user.dir")+"\\src\\main\\files\\";
        BufferedReader clientsReader = new BufferedReader(new FileReader(s + "clients.txt"));
        BufferedReader petsReader = new BufferedReader(new FileReader(s + "petsname.txt"));
        nameClient = new ArrayList<String>();
        namePet = new ArrayList<String>();
        String s1 = "";
        while ((s1 = clientsReader.readLine())!=null){
            nameClient.add(s1);
        }
        while ((s1 = petsReader.readLine())!=null){
            namePet.add(s1);
        }
        clientsReader.close();
        petsReader.close();
    }
}
