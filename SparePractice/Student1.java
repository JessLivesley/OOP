public class Student1 {
    private String name;
    private int credits;
    private boolean fullTime;

    public Student1 (String name, int credits, boolean fullTime){
        this.name=name;
        this.credits=credits;
        this.fullTime=fullTime;
    }

    public void addCredits (int amount){
        System.out.println(name + " Credits have increased.");
        credits = credits + amount;
    }

    public void printStatus(){
        System.out.println("Name: " + name + ", Credits: " + credits + ", Full-time: " + fullTime );
    }

    public static void main(String[] args) {
        Student1 student1 = new Student1 ("Jess", 90, true);
        Student1 student2 = new Student1 ("Rob", 70, false);

        student1.printStatus();
        student2.printStatus();

        student2.addCredits(20);

        //student1.printStatus();
        student2.printStatus();

    }

}
