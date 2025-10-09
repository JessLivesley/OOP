import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {


    // ---------- Data Model ----------
    static class Student {
        private final int id;
        private final String name;
        private final ArrayList<Integer> scores = new ArrayList<>();

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int getId() { return id; }
        String getName() { return name; }
        List<Integer> getScores() { return Collections.unmodifiableList(scores); }

        void addScore(int score) { scores.add(score); }

        boolean hasScores() { return !scores.isEmpty(); }

        double average() {
            if (scores.isEmpty()) return Double.NaN;
            int sum = 0;
            for (int s : scores) sum += s;
            return (double) sum / scores.size();
        }
    }

    // ---------- App State ----------
    private static final java.util.Scanner SC = new java.util.Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readIntInRange("Choose an option (1-6): ", 1, 6);
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    enterScoresForStudent();
                    break;
                case 3:
                    calculateStudentAverage();
                    break;
                case 4:
                    displayClassStatistics();
                    break;
                case 5:
                    findTopPerformer();
                    break;
                case 6:
                    System.out.println("Goodbye! 👋");
                    running = false;
                    break;
            }
        }
        SC.close();
    }

    private static Object findTopPerformer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTopPerformer'");
    }

    private static Object displayClassStatistics() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayClassStatistics'");
    }

    private static Object calculateStudentAverage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateStudentAverage'");
    }

    private static int readIntInRange(String string, int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readIntInRange'");
    }

    // ---------- Menu ----------
    private static void printMenu() {
        System.out.println("\n===== Student Manager =====");
        System.out.println("1) Add new student");
        System.out.println("2) Enter scores for existing student");
        System.out.println("3) Calculate student average");
        System.out.println("4) Display class statistics");
        System.out.println("5) Find top performer");
        System.out.println("6) Exit");
    }

    // ---------- Features ----------
    private static void addNewStudent() {
        System.out.println("\n-- Add New Student --");
        int id = readPositiveInt("Enter unique student ID (positive integer): ");
        if (findStudentById(id) != null) {
            System.out.println("❌ ID already exists. Please choose a different ID.");
            return;
        }
        String name = readNonEmpty("Enter student name: ");
        students.add(new Student(id, name));
        System.out.println("✅ Added student: " + name + " (ID: " + id + ")");
    }

    private static String readNonEmpty(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readNonEmpty'");
    }

    private static Object findStudentById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findStudentById'");
    }

    private static int readPositiveInt(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readPositiveInt'");
    }

    private static void enterScoresForStudent() {
        System.out.println("\n-- Enter Scores --");
        if (students.isEmpty()) {
            System.out.println("No students yet. Add a student first.");
            return;
        }
        int id = readPositiveInt("Enter student ID: ");
        Student s = (Student) findStudentById(id);
        if (s == null) {
            System.out.println("❌ No student found with ID " + id);
            return;
        }

        System.out.println("Entering scores for " + s.getName() + " (ID: " + s.getId() + ")");
        System.out.println("Enter scores 0–100. Type -1 to stop.");
        while (true) {
            int score = readInt("Score (-1 to finish): ");
            if (score == -1) break;
            if (score < 0 || score > 100) {
                System.out.println(" Score must be between 0 and 100.");
                continue;
            }
                    s.addScore(score);
                    System.out.println(" Score added.");
                }
            }

    private static int readInt(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readInt'");
    }
}