package petdaycare;

// Write your code below!

public class Unicorn extends Pet {

    private int glitterLevel;

    public Unicorn(String name, int age, double baseFee, int glitterLevel) {
        super(name, age, baseFee);
        if (glitterLevel >= 1 && glitterLevel <= 5) {
            this.glitterLevel = glitterLevel;
        } else {
            System.out.println("Invalid glitter level. Setting to 1.");
            this.glitterLevel = 1;
        }
    }

    public int getGlitterLevel(){
        return glitterLevel;
    }

    @Override
    public double calculateDailyCost() {
        return getBaseFee() + (glitterLevel * 30);
    }

    @Override
    public void makeSound() {
        System.out.println("Neigh... ✨sparkle sparkle✨");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Unicorn");
        System.out.println("Glitter Level: " + glitterLevel);
    }


}