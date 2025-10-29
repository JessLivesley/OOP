package Student;

public class Student {

    
    private String studentId;
    private String name;
    private int grade;
    private boolean isPassing;

    
    public Student(String studentId, String name, int grade) {
        this.studentId = studentId;
        this.name = name;

        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade. Setting to 0 by default.");
            this.grade = 0;
        }

        
        this.isPassing = (this.grade >= 50);
    }


    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public boolean isPassing() {
        return isPassing;
    }

    
    public void setGrade(int newGrade) {
        if (newGrade >= 0 && newGrade <= 100) {
            this.grade = newGrade;
            this.isPassing = (newGrade >= 50);
        } else {
            System.out.println("Error: Grade must be between 0 and 100. Grade not updated.");
        }
    }

    
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("Passing: " + (isPassing ? "Yes" : "No"));
    }

    
}
