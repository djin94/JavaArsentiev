package ru.lesson.lessons;

/**
 * Created by Йотун on 09.01.2017.
 */
public class Client {
    /**
     * id(name) of the client
     */
    private String id;
    /**
     * pet of the cliient
     */
    private Pet pet;

    /**
     * Constructor
     * @param id
     * @param pet
     */
    public Client(final String id, final Pet pet) {
        this.id = id;
        this.pet = pet;
    }

    /**
     * Getter id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Pet's getter
     * @return
     */
    public Pet getPet() {
        return pet;
    }
    /**
     *Change name client
     * @param id
     */
    public void setId(final String id) {
        this.id = id;
    }
    /**
     * change name pet
     * @param name
     */
    public void setNamePet(final String name) {
        this.pet = pet;
    }

    /**
     * delete Pet
     */
    public void deletePet(){
        pet = null;
    }

    /**
     * make new pet
     * @param pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
