package ru.lesson.lessons;

/**
 * Created by Йотун on 09.01.2017.
 */
public class Cat implements Pet {
    /**
     * Animal
     */
    private final Animal animal;
    /**
     * getName
     * @return
     */
    @Override
    public String getName() {
        return this.animal.getName();
    }
    /**
     * Constructor
     * @param animal
     */
    public Cat(final Animal animal) {
        this.animal = animal;
    }
    /**
     * Method of Pet
     */
    @Override
    public void setName(final String name) {
        this.animal.setName(name);
    }
}
