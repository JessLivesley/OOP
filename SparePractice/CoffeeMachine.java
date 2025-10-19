public class CoffeeMachine {
    
    private String brand;
    private int cupsMade;

    public CoffeeMachine (String brand){
        this.brand=brand;
        this.cupsMade=0;
    }

    public void makeCoffee(){
        System.out.println("Coffee made!");
        cupsMade++;
    }

    public  void printStatus(){
        System.out.println("The brand of the coffee is: " + brand);
        System.out.println(cupsMade + " cups of coffe have been made.");

    }

    public static void main(String[] args) {
        CoffeeMachine coffee1 = new CoffeeMachine ("Nestle");
        CoffeeMachine coffee2 = new CoffeeMachine ("Nestcafe");

        coffee1.printStatus();
        coffee2.printStatus();
        
        coffee1.makeCoffee();
        coffee2.makeCoffee();

        coffee1.printStatus();
        coffee2.printStatus();
    }
}
