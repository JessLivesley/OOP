public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelCapacity;

    public Vehicle(String make, String model, int year, double fuelCapacity){
        this.make=make;
        this.model=model;
        this.year=year;
        this.fuelCapacity=fuelCapacity;
    }



    public void start() {
        System.out.println(year + " " + make + " " + model + " is starting...");
    }  
    public void stop() { 
        System.out.println(year + " " + make + " " + model + " is stopping...");
    }
    public abstract double getFuelEfficiency(); // To be overridden

    public abstract void displayInfo();
}

class Car extends Vehicle {

    private int passengerCapacity;

    public Car(String make, String model, int year, double fuelCapacity, int passengerCapacity) {
        super(make, model, year, fuelCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double getFuelEfficiency() {
        return 30.0;
    }

    public void openTrunk() {
        System.out.println("Opening the trunk of the car...");
    }

    @Override
    public void displayInfo() {
        //super.displayInfo();
        System.out.println("Type: Car, Passengers: " + passengerCapacity + ", Fuel Efficiency: " + getFuelEfficiency() + " km/l");
    }
}

class Truck extends Vehicle {
    private double cargoCapacity; // in tons

    public Truck(String make, String model, int year, double fuelCapacity, double cargoCapacity) {
        super(make, model, year, fuelCapacity);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double getFuelEfficiency() {
        // Trucks are less fuel efficient
        return 8.0; // km per litre
    }

    public void loadCargo(double tons) {
        System.out.println("Loading " + tons + " tons of cargo into the truck...");
    }

    @Override
    public void displayInfo() {
        //super.displayInfo();
        System.out.println("Type: Truck, Cargo Capacity: " + cargoCapacity + " tons, Fuel Efficiency: " + getFuelEfficiency() + " km/l");
    }
}

class Motorcycle extends Vehicle {
    private String licenseType; // e.g., A1, A2, A

    public Motorcycle(String make, String model, int year, double fuelCapacity, String licenseType) {
        super(make, model, year, fuelCapacity);
        this.licenseType = licenseType;
    }

    @Override
    public double getFuelEfficiency() {
        // Motorcycles are highly fuel efficient
        return 40.0; // km per litre
    }

    public void popWheelie() {
        System.out.println("Popping a wheelie! (For demonstration only — don’t try this at home!)");
    }

    @Override
    public void displayInfo() {
        //super.displayInfo();
        System.out.println("Type: Motorcycle, License Required: " + licenseType + ", Fuel Efficiency: " + getFuelEfficiency() + " km/l");
    }
}
class ElectricCar extends Car {
    private double batteryCapacity; // in kWh

    public ElectricCar(String make, String model, int year, double batteryCapacity, int passengerCapacity) {
        super(make, model, year, batteryCapacity, passengerCapacity);
        this.batteryCapacity = batteryCapacity;
    }

    // Override fuel efficiency to represent range per charge
    @Override
    public double getFuelEfficiency() {
        return 6.0; // km per kWh (example)
    }

    // Electric cars don't use fuel — override related behavior
    @Override
    public void start() {
        System.out.println(year + " " + make + " " + model + " powers on silently...");
    }

    public void chargeBattery() {
        System.out.println("Charging the battery... (" + batteryCapacity + " kWh capacity)");
    }

    @Override
    public void displayInfo() {
        //super.displayInfo();
        System.out.println("Type: Electric Car, Battery Capacity: " + batteryCapacity + " kWh, Efficiency: " + getFuelEfficiency() + " km/kWh");
    }
}

class VehicleTest {
    public static void main(String[] args) {
        // Create instances
        Car car = new Car("Toyota", "Corolla", 2022, 50, 5);
        Truck truck = new Truck("Volvo", "FH16", 2021, 300, 25);
        Motorcycle bike = new Motorcycle("Yamaha", "R7", 2023, 18, "A");
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2024, 75, 5);

        // Demonstrate inheritance and polymorphism
        Vehicle[] vehicles = {car, truck, bike, tesla};

        for (Vehicle v : vehicles) {
            v.start();
            v.displayInfo();
            v.stop();
            System.out.println();
        }

        // Demonstrate specific subclass methods
        car.openTrunk();
        truck.loadCargo(12.5);
        bike.popWheelie();
        tesla.chargeBattery();
    }
}