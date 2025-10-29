package petdaycare;

/**
 * Use this class to run some checks on your own code
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🐾 QUIRKY PET DAYCARE 🐾\n");

        Dragon dragon = new Dragon("Smaug", 150, 250, 8);
        Unicorn unicorn = new Unicorn("Sparkles", 7, 100, 5);
        NinjaCat ninjaCat = new NinjaCat("Shadow", 3, 200, 9);

        double total = 0;

        
        dragon.displayInfo();
        double dCost = dragon.calculateDailyCost();
        System.out.println("Daily Cost: £" + dCost);
        System.out.print("*makes sound* ");
        dragon.makeSound();
        System.out.println();

        total += dCost;

        
        unicorn.displayInfo();
        double uCost = unicorn.calculateDailyCost();
        System.out.println("Daily Cost: £" + uCost);
        System.out.print("*makes sound* ");
        unicorn.makeSound();
        System.out.println();

        total += uCost;

        
        ninjaCat.displayInfo();
        double nCost = ninjaCat.calculateDailyCost();
        System.out.println("Daily Cost: £" + nCost);
        System.out.print("*makes sound* ");
        ninjaCat.makeSound();
        System.out.println();

        total += nCost;

        System.out.println("💰 Total Daily Revenue: £" + total);
    }




}
