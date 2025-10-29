public class PeMain{

    private String name;
    private int age;

    public Main (String name, String species, int age) {
        this.name=name;
        this.species=species;
        this.age=age;
    }

    public void celebrateBirthday(){
        age++;
        System.out.println("Happy Birthday! " + name + "! You are now " + age +"!! \n");

    }

    public void printInfo(){
        System.out.println("Name: " + name + ", Species: " + species + ", Age : " + age + "\n");

    }

    public static void main(String[] args) {
        Pet pet1 = new Pet ("Lola","Cocker Spaniel",7);
        Pet pet2 = new Pet ("Rosie","Cocker spaniel", 8);

        pet1.printInfo();
        pet2.printInfo();

        pet2.celebrateBirthday();

        pet2.printInfo();

    }

}
