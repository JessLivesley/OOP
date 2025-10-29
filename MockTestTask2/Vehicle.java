package MockTestTask2;
public abstract class Vehicle {
    private String brand;
    private int year;

    public Vehicle (String brand, int year){
        this.brand=brand;
        this.year=year;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year=year;
    }

    public void displayInfo(){
        System.out.println("The vehicles brand is: " + brand + ".\nThe vehicles year is: " +year + ".");
    }

    public abstract void serviceCost();

}

class Car extends Vehicle{

    private int numDoors;

    public Car(String brand, int year, int numDoors) {
        super(brand, year);
        this.numDoors=numDoors;
    }

    @Override
    public void serviceCost(){
       int serviceCost = 200;
       System.out.println("The service cost is: " +serviceCost+ ".");
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("The number of doors is: " + numDoors + ".");
    }
    
}

class Motorbike extends Vehicle{

    private int engineCC;

    public Motorbike(String brand, int year, int engineCC) {
        super(brand, year);
        this.engineCC=engineCC;
    }

    @Override
    public void serviceCost(){
       int serviceCost = 100;
       System.out.println("The service cost is: " +serviceCost+ ".");
    }
    
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("The engineCC is: " +engineCC + ".");
    }
}

class Main{

    public static void main(String[] args) {
        Car car1 = new Car ("BMW", 2020, 3);
        Motorbike motorbike1 = new Motorbike ("BMW", 2017 , 750);

        car1.serviceCost();
        car1.displayInfo();

        motorbike1.serviceCost();
        motorbike1.displayInfo();

    }
    


}