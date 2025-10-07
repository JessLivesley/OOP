import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentScores {

   
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) return 0;
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    public static int findHighest(ArrayList<Integer> scores) {
        return Collections.max(scores);
    }


    public static int findLowest(ArrayList<Integer> scores) {
        return Collections.min(scores);
    }


    public static int countAboveAverage(ArrayList<Integer> scores, double average) {
        int count = 0;
        for (int score : scores) {
            if (score > average) count++;
        }
        return count;
    }

    public static boolean searchScore(ArrayList<Integer> scores, int target) {
        return scores.contains(target);
    }

    public static void sortScores(ArrayList<Integer> scores) {
        Collections.sort(scores);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("Enter 10 student scores (0–100):");

        while (scores.size() < 10) {
            System.out.print("Enter score #" + (scores.size() + 1) + ": ");
            if (!scanner.hasNextInt()) {
                System.out.println(" Invalid input! Please enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }

            int score = scanner.nextInt();
            if (score < 0 || score > 100) {
                System.out.println("Please enter a score between 0 and 100.");
            } else {
                scores.add(score);
            }
        }

  
        double average = calculateAverage(scores);
        int highest = findHighest(scores);
        int lowest = findLowest(scores);
        int aboveAverage = countAboveAverage(scores, average);

        System.out.println("Scores entered: " + scores);
        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);
        System.out.println("Scores above average: " + aboveAverage);

        
        sortScores(scores);
        System.out.println("Sorted scores: " + scores);

        
        System.out.print("Enter a score to search for: ");
        int target = scanner.nextInt();
        if (searchScore(scores, target)) {
            System.out.println("✅The score " + target + " was found in the list!");
        } else {
            System.out.println(" The score " + target + " was not found.");
        }

        scanner.close();
    }
}
