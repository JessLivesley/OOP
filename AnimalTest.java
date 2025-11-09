abstract class Animal {
    protected String name;
    protected int age;

    public Animal (String name, int age){
        this.name=name;
        this.age=age;

    }

    public void makeSound() {
    System.out.println(name + " makes a sound");
    }

    // Another method to override
    public void move() {
    System.out.println(name + " moves");
    }

    // Abstract method - MUST be overridden
    public abstract void eat();

    public final void sleep(){
        System.out.println( name + " is sleeping... ZZZ");
    }

    public void performActions() {
        System.out.println("---" + name + "'s Actions ---");
        makeSound();
        move();
        eat();
    }

}

class Dog extends Animal{
    

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
       this.breed=breed;
    }


    @Override
    public void makeSound(){
        System.out.println(name + " barks: Woof! Woof!");
    }

    @Override
    public void move(){
        System.out.println(name + " runs on four legs");
    }

    @Override
    public void eat(){
        System.out.println(name + " eats dog food from a bowl");
    }

    public void fetch(){
        System.out.println(name + " fetches the ball");

    }
    
}

class Bird extends Animal{

    private double wingSpan;

    public Bird(String name, int age, double wingSpan) {
        super(name, age);
        this.wingSpan=wingSpan;
    }

    @Override
    public void makeSound(){
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void move(){
        System.out.println("Birds fly through the air.\n" + name + " has a wing span of: " +wingSpan);
    }

    @Override
    public void eat(){
        System.out.println(name + " pecks at seeds and insects");
    }

    public void buildNest(){
        System.out.println(name  + " builds a nest in a tree");
    }
    
}

class Fish extends Animal{
    private String waterType;

    public Fish(String name, int age, String waterType) {
        super(name, age);
        this.waterType = waterType;
    }

    @Override
    public void makeSound(){
        System.out.println(name + " makes blub blub");
    }

    @Override
    public void move(){
        System.out.println(name + " swims in the " + waterType + " water");
    }

    @Override
    public void eat(){
        System.out.println(name + " nibbles on algae and flakes");
    }

    
    
}

public class AnimalTest {
    public static void main(String[] args) {
       

        Dog dog = new Dog("Buddy", 3, "Golden Retriever");

        Bird bird = new Bird ("Iweety", 1, 0.3);

        Fish fish = new Fish("Nemo", 2, "salt");

        System.out.println("=== Individual Animal Actions ===");

        dog. performActions();

        System.out.println();

        bird.performActions();

        System.out. println();

        fish.performActions();
    
    

        System.out.println(" \n=== Polymorphic Array ===");
        //THIS IS THE KEY TO POLYMORPHISM!
        // Array of Animal references, holding different animal types
        Animal[] animals = {dog, bird, fish};
        for (Animal animal : animals) {
        animal.makeSound(); // Each calls THEIR OWN version!
        animal.move () ;
        // Dynamic binding at runtime!
        System.out.println();

        }
    }

}