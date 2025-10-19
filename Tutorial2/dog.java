public class dog {
    
    private String name;
    private int age;

    public dog (String name, int age) {
        this.name=name;
        this.age=age;
    }

    public void bark() {
        System.out.println(name + " is barking!");
    }

    public void birthday() {
        age++;
        System.out.println("Buddy is now " + age + " years old!");
    }

    public static void main (String [] args) {
        dog dog1 = new dog ("Buddy", 8);
        dog1.bark();
        dog1.birthday();
    }



}
