package ru.lesson.lessons;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Йотун on 24.02.2017.
 */
public class WorkClinicConcurrentTest {
    @Test
    public void run() throws Exception {
        MainClass mainClass = new MainClass();
        mainClass.main(new String[3]);
    }

}