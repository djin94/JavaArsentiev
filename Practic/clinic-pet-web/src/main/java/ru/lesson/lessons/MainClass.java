package ru.lesson.lessons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Йотун on 22.01.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        ArrayList<WorkClinicConcurrent> concurrences = new ArrayList<WorkClinicConcurrent>();
        Date st = new Date();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 10; i++) {
            try {
                concurrences.add(new WorkClinicConcurrent("#" + i, clinic));
                concurrences.get(i).start();
            }
            catch (IOException e){
                System.out.println("Error #"+i);
            }
        }
        while (clinic.countClients()<100){
            System.out.println("Number of clients: " + clinic.countClients());
        }
        for (WorkClinicConcurrent cl : concurrences)
            cl.interrupt();
        System.out.println("Number of clients: " + clinic.countClients());
        Date end = new Date();
        System.out.println("Time: " + (end.getTime()-st.getTime()));
    }
}
