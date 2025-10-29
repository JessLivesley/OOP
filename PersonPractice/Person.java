package PersonPractice;
public abstract class Person {
    private String name;
    private int age;

    public Person (String name,int age){
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
        System.out.println("The persons name is: " + getName() +".\nThe persons age is: " + getAge() +".");
    }

    public abstract String getRole();

}

class Student extends Person{

    private String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course=course;
    }
    
    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course=course;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("The students course is: " + getCourse() + ".");
    }

    @Override
    public String getRole(){
        return "Student";
    }

}

class Lecturer extends Person{

    private String subject;

    public Lecturer(String name, int age, String subject) {
        super(name, age);
        this.subject=subject;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject=subject;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("The lecturer teaches: " + getSubject() + ".");
    }

    @Override
    public String getRole(){
        return "Lecturer";
    }
    
}

class Main{
    public static void main(String[] args) {
        Student student1 = new Student("Jess",20,"Computer Science");
        Lecturer lecturer1 = new Lecturer("Dan",30,"Computer Science");

        student1.displayInfo();
        System.out.println("Role: " + student1.getRole());

        lecturer1.displayInfo();
        System.out.println("Role: " + lecturer1.getRole());

    }
}