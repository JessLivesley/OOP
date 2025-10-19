import java.util.Scanner;

public class SumAndAv {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        double sum = 0;
        double number;

        double largest = Double.NEGATIVE_INFINITY;
        double smallest = Double.POSITIVE_INFINITY;

        System.out.println("Enter a numbers (enter -1 to stop):");

        while (true) {
            System.out.print("Enter a number: ");
            number = scanner.nextDouble();

            if (number == -1){
                break;
            }

            sum += number;
            count++;

            if (number > largest) {
                smallest = number;
            }

        }

        if (count == 0) {
            System.out.println("No numbers were entered.");
        } else {
            double average = sum / count;

            System.out.println("Count of numbers: " + count);
            System.out.println("Sum: "+ sum);
            System.out.println("Average: "+ average);
            System.out.println("Largest number: " + largest );
            System.out.println("Smallest number: " + smallest);

        }


        scanner.close();
    }

}