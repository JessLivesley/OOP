import java.util.Scanner;

public class CalculateRect{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rectangle length: ");
        double length = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter rectangle width: " );
        double width = Double.parseDouble(scanner.nextLine());

        double area = length * width;
        double perimeter = 2 * (length + width);

        int intLength = (int) length;
        int intWidth = (int) width;

        int intDivision = intLength / intWidth;
        double floatDivision =(double) intLength / intWidth;

        System.out.println("The Area of the rectangle is:  " + area);
        System.out.println("The Perimeter of the rectangle is: " + perimeter);
        System.out.println("Integer Division (" + intLength + "/" + intWidth + ") = " + intDivision);
        System.out.println("Floating-point Division (" + intLength + " /" + intWidth + ") = " + floatDivision);

        scanner.close();
    }       
}