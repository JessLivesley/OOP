import java.util.ArrayList;

interface Drivable{
    void drive();
}

abstract class Vehicle {
    private String brand;

    public Vehicle(String brand){
        this.brand=brand;
    }

    public final String getBrand(){
        return brand;
    }

    public abstract void refuel();
}

class Car extends Vehicle implements Drivable{

    public Car(String brand) {
        super(brand);
        
    }
    @Override
    public void drive() {
       System.out.println("Driving the car!");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the car with Petrol.");

    }
    
}

class ElectricScooter extends Vehicle implements Drivable{

    public ElectricScooter(String brand) {
        super(brand);
        
    }

    @Override
    public void drive() {
        System.out.println("Driving the Scooter!");
    }

    @Override
    public void refuel() {
        System.out.println("Charging scooter battery");
    }
    
}

public class TestVehicle{

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota"));
        vehicles.add(new ElectricScooter("Xiaomi"));

        for (Vehicle v : vehicles) {
            System.out.println("Brand: " + v.getBrand());
            if (v instanceof Drivable) {
                ((Drivable) v).drive();
            }
            v.refuel();
            System.out.println();
        }
    }
}
