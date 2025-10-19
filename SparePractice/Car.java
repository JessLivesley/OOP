public class Car {
    
    private String brand;
    private int speed;

    public Car (String brand, int speed) {
        this.brand=brand;
        this.speed=speed;

    }

    public void accelerate(){
        speed++;
    }

    public void printAccelerate(){
        System.out.println("The new speed is: " + speed);
    }

    public void printStatus(){
        System.out.println("The brand of the car is: " + brand);
        System.out.println("The current speed of the car: " + speed);

    }

    public static void main(String[] args) {
        Car car1 = new Car ("Audi", 30);

        car1.printStatus();

        car1.accelerate();

        car1.printAccelerate();

    }
}
