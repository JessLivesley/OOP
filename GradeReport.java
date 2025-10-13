import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + "," + grade;
    }

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        return new Student(parts[0], Double.parseDouble(parts[1]));
    }
}

public class GradeReport {
    private static final String DATA_FILE = "grades.txt";
    private static final String BACKUP_FILE = "grades_backup.txt";
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadData(); // load data at program start

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Grade Report System ---");
            System.out.println("1. Add student");
            System.out.println("2. View students");
            System.out.println("3. Save data");
            System.out.println("4. Backup data");
            System.out.println("5. Restore backup");
            System.out.println("6. Generate report");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewStudents();
                case 3 -> saveData();
                case 4 -> backupData();
                case 5 -> restoreBackup();
                case 6 -> generateReport();
                case 7 -> {
                    running = false;
                    System.out.println("👋 Exiting...");
                }
                default -> System.out.println("❌ Invalid option.");
            }
        }

        scanner.close();
    }

    // ✅ Add student
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter grade (0-100): ");
        double grade = scanner.nextDouble();
        scanner.nextLine();

        students.add(new Student(name, grade));
        System.out.println("✅ Student added.");
    }

    // ✅ View all students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student Grades ---");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println((i + 1) + ". " + s.name + " — " + df.format(s.grade));
        }
    }

    // ✅ Save data to file
    private static void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("💾 Data saved.");
        } catch (IOException e) {
            System.out.println("⚠️ Error saving data: " + e.getMessage());
        }
    }

    // ✅ Load data
    private static void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("No existing data found.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            students.clear();
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromString(line));
            }
            System.out.println("📥 Loaded " + students.size() + " students.");
        } catch (IOException e) {
            System.out.println("⚠️ Error loading data: " + e.getMessage());
        }
    }

    // ✅ Backup
    private static void backupData() {
        try {
            copyFile(new File(DATA_FILE), new File(BACKUP_FILE));
            System.out.println("📦 Backup created.");
        } catch (IOException e) {
            System.out.println("⚠️ Backup error: " + e.getMessage());
        }
    }

    // ✅ Restore
    private static void restoreBackup() {
        try {
            copyFile(new File(BACKUP_FILE), new File(DATA_FILE));
            loadData();
            System.out.println("♻️ Backup restored.");
        } catch (IOException e) {
            System.out.println("⚠️ Restore error: " + e.getMessage());
        }
    }

    // 🧰 Copy file
    private static void copyFile(File src, File dest) throws IOException {
        if (!src.exists()) return;
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    // 📊 Generate ASCII bar chart & stats
    private static void generateReport() {
        if (students.isEmpty()) {
            System.out.println("No data to report.");
            return;
        }

        // Collect grades
        List<Double> grades = new ArrayList<>();
        for (Student s : students) grades.add(s.grade);
        Collections.sort(grades);

        // Statistics
        double mean = calculateMean(grades);
        double median = calculateMedian(grades);
        double stdDev = calculateStandardDeviation(grades, mean);

        System.out.println("\n--- 📊 Grade Report ---");
        System.out.println("Number of students: " + students.size());
        System.out.println("Average (mean): " + df.format(mean));
        System.out.println("Median: " + df.format(median));
        System.out.println("Standard deviation: " + df.format(stdDev));

        // Grade distribution in buckets
        int[] buckets = new int[10]; // 0-9, 10-19, ... 90-100
        for (double g : grades) {
            int index = (int) Math.min(g / 10, 9);
            buckets[index]++;
        }

        System.out.println("\n--- 📈 Grade Distribution ---");
        for (int i = 0; i < buckets.length; i++) {
            int lower = i * 10;
            int upper = (i == 9) ? 100 : (i * 10 + 9);
            System.out.printf("%3d-%3d | %s (%d)%n", lower, upper, "*".repeat(buckets[i]), buckets[i]);
        }
    }

    // 🧮 Mean
    private static double calculateMean(List<Double> grades) {
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    // 🧮 Median
    private static double calculateMedian(List<Double> grades) {
        int n = grades.size();
        if (n % 2 == 0) {
            return (grades.get(n / 2 - 1) + grades.get(n / 2)) / 2.0;
        } else {
            return grades.get(n / 2);
        }
    }

    // 🧮 Standard Deviation
    private static double calculateStandardDeviation(List<Double> grades, double mean) {
        double sumSq = 0;
        for (double g : grades) {
            sumSq += Math.pow(g - mean, 2);
        }
        return Math.sqrt(sumSq / grades.size());
    }
}
