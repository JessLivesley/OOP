public class Student {
    
    private String name;
    private int studentId;
    private int age;
    private double gpa;


    public Student (String name, int studentId, int age, double gpa) {
        this.name=name;
        this.studentId=studentId;   
        this.age=age;
        this.gpa=gpa; 
    }


    public  void displayInfo(){
        System.out.println(name + "'s Student iD is : " + studentId + "\n" + name + "'s age is: " + age + "\n" + name + "'s GPA is: " + gpa + ".\n");
    }    

    public boolean isHonorStudent(){
        return gpa >= 3.5;
    }

    public boolean canGraduate(){
        return gpa >= 2.0;
    }

    public static void main (String [] args) {
    Student student1 = new Student ("Jess", 876565, 20, 3.9);
    Student student2 = new Student ("Rob", 756476, 24, 2.7);
    Student student3 = new Student ("Lola", 374934, 18, 3.0);

    student1.displayInfo();
    student2.displayInfo();
    student3.displayInfo();

    System.out.println("Is Jess an honor student? " +  student1.isHonorStudent() + ("\n"));
    System.out.println("Is Rob an honor student? " +  student2.isHonorStudent() + ("\n"));
    System.out.println("Is Lola an honor student? " +  student3.isHonorStudent() + ("\n"));

    System.out.println("Can Jess graduate? " + student1.canGraduate() + ("\n"));
    System.out.println("Can Rob graduate? " + student2.canGraduate() + ("\n"));
    System.out.println("Can Lola graduate? " + student3.canGraduate() + ("\n"));

 }
}

