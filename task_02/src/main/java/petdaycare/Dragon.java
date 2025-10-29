package petdaycare;

// Write your code below!

public class Dragon extends Pet{

    private final int fireBreathIntensity;

    public Dragon(String name, int age, double baseFee, int fireBreathIntensity) {
        super(name, age, baseFee);
        if (fireBreathIntensity >= 1 && fireBreathIntensity <= 10) {
            this.fireBreathIntensity = fireBreathIntensity;
        } else {
            System.out.println("Invalid fire breath intensity. Setting to 1.");
            this.fireBreathIntensity = 1;
        }
    }

    public int getFireBreathIntensity() {
        return fireBreathIntensity;
    }


    @Override
    public double calculateDailyCost() {
        return getBaseFee() + (fireBreathIntensity * 50);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAAAR! 🔥");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Dragon");
        System.out.println("Fire Breath Intensity: " + fireBreathIntensity);
    }

   
}
