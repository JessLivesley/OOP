import Task2.Dog;

public class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("The age can't be a negative.");
        }
    }

    public void displayInfo(){
        System.out.println("Name: " + name + ", Age: " +age);
    }

    //public abstract void makeSound();


}

class Dog extends Pet{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed=breed;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed=breed;
    }

    //public void displayInfo(){
    //    System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Breed: " + breed);
    //}

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Breed: " +breed);
    }

    //@Override
    //public void makeSound(){
        //System.out.println("Woof!Woof!");
    //}

    public static void main(String[] args) {
    Dog dog1 = new Dog ("Lola", 7, "Cocker Spaniel");


   dog1.displayInfo();
   //dog1.makeSound();

}

  
}

