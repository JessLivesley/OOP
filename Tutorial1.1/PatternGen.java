import java.util.Scanner;

public class PatternGen {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a number for the size of the pattern: ");
        int size = scanner.nextInt();

        System.out.println("Pattern A (Star Triangle): ");
        for (int i = 1; i <= size; i++) {
            for (int j =1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
    }
     
        System.out.println("Pattern B (Number Triangle)");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("j");
            }
            System.out.println();
        }

        scanner.close();
    }
}
