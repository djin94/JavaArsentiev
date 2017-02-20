package ru.lesson.lessons;

/**
 * Created by Йотун on 09.01.2017.
 */
public class ClientNotFound extends Exception{
    private String name;

    public String getName() {
        return name;
    }

    public ClientNotFound(String name) {
        this.name = name;
    }
}
