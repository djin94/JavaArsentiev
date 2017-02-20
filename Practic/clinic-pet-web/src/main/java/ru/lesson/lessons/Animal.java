package ru.lesson.lessons;

/**
 * Created by Йотун on 09.01.2017.
 */
public class Animal implements Pet{
    /**
     * Name of the Animal
     */
    private String name;

    /**
     * Constructor
     * @param name
     */
    public Animal(final String name) {
        this.name = name;
    }

    /**
     * Getter of name
     */
    public String getName() {
        return name;
    }

    /**
     * Method of Pet
     * @param name
     */
    public void setName(final String name) {
        this.name=name;
    }
}
