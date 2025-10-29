package petdaycare;

// Write your code below!

public class NinjaCat extends Pet {

    private int stealthLevel;

    public NinjaCat(String name, int age, double baseFee, int stealthLevel) {
        super(name, age, baseFee);
        if (stealthLevel >= 1 && stealthLevel <= 10) {
            this.stealthLevel = stealthLevel;
        } else {
            System.out.println("Invalid stealth level. Setting to 1.");
            this.stealthLevel = 1;
        }
    }

    public int getStealthLevel(){
        return stealthLevel;
    }

    @Override
    public double calculateDailyCost() {
        double total = getBaseFee() - (stealthLevel * 10);
        return Math.max(total, 0); 
    }

    @Override
    public void makeSound() {
        System.out.println("...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Ninja Cat");
        System.out.println("Stealth Level: " + stealthLevel);
    }

}