package lesson6;

/**
 * Created by Йотун on 09.01.2017.
 */
public class ClinicTest {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.addClient(0, new Client("Ivan", new Dog(new Animal("Rex"))));
        clinic.addClient(1, new Client("Vasya", new Cat(new Animal("Ublyudok"))));
        try {
            System.out.println(clinic.findNameClient("Ivan").getId());
        } catch (ClientNotFound e) {
            System.out.println("Client with parameter: " + e.getName() + " not found");
        }
        try {
            System.out.println(clinic.findNameClient("Pisya").getId());
        }
        catch (ClientNotFound e) {
            System.out.println("Client with parameter: " + e.getName() + " not found");
        }
        try{
            System.out.println(clinic.findByPetName("Pizdosya").getId());
        }
        catch (ClientNotFound e){
            System.out.println("Client with parameter: " + e.getName() + " not found");
        }
    }
}
