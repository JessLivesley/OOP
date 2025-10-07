import java.util.Scanner;

public class GradeCalc{
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numerical score (0-100): ");
        int score = scanner.nextInt();

        if (score < 0 || score > 100 ) {
            System.out.println("Error: Score must be between 0 and 100");
        } else {

            if (score >= 90){
                System.out.println("Grade A");
            } else if (score >= 80) {
                System.out.println("Grade B");
            } else if (score >= 70) {
                System.out.println("Grade C");
            } else if (score >=60) {
                System.out.println("Grade D"); 
            } else {
                System.out.println("Grade f");
            }
        }
        

        scanner.close();
    }
}
