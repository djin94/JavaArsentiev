package lesson6;

/**
 * Created by Йотун on 09.01.2017.
 */
public class Dog implements Pet{
    /**
     * Animal
     */
    private final Animal animal;
    /**
     * Constructor
     * @param animal
     */
    public Dog(final Animal animal) {
        this.animal = animal;
    }
    /**
     * Return the name of Dog
     * @return
     */
    @Override
    public String getName() {
        return this.animal.getName();
    }
    /**
     * Method of Pet
     */
    @Override
    public void setName(final String name) {
        this.animal.setName(name);
    }
}
