package Task2;
public abstract class Animal {
    
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void displayInfo(){
        System.out.println("The animals name is: " + getName() + ".\nThe animals age is: " + getAge() +".");
    }

    public abstract void makeSound();
}

class Dog extends Animal{

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed=breed;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed (String breed){
        this.breed=breed;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("The Dogs breed is: " +getBreed());
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!Woof!");
    }

    
}

class Cat extends Animal{

    private String colour;

    public Cat(String name, int age, String colour) {
        super(name, age);
        this.colour=colour;

    }

    public String getColour(){
        return colour;
    }

    public void setColour(String colour){
        this.colour=colour;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("The colour of the cat is: " + getColour());
    }

    @Override
    public void makeSound(){
        System.out.println("Meow!");
    }

}

class Main{
    public static void main(String[] args) {
        Dog dog1 = new Dog("Lola",7,"Cocker Spaniel");
        Cat cat1 = new Cat("Tia",6,"Grey");

        dog1.displayInfo();
        dog1.makeSound();

        cat1.displayInfo();
        cat1.makeSound();

    }
}