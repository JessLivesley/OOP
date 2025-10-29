package petdaycare;

// write your code below!

public abstract class Pet {
    private String name;
    private int age;
    private double baseFee;

    public Pet(String name, int age, double baseFee){
        this.name=name;
        this.age=age;
        this.baseFee=baseFee;
    }

    public String getName() { 
        return name; 
    }
    public int getAge() { 
        return age; 
    }
    public double getBaseFee() { 
        return baseFee; 
    }

    public void displayInfo(){
        System.out.println("The pets name is: " +name +".\nThe pets age is: " +age);
    }

    public abstract double calculateDailyCost();

    public abstract void makeSound();

    



}