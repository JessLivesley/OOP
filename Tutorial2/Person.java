package Tutorial2;
import java.util.Scanner;

import PersonPractice.Person;

public class Person {

private String name;
private int age;
private String email;
private String socialSecurityNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        Person person = new Person();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name can't be empty!");
        } else {
            System.out.println("Valid name!");
        }

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (age >= 0 && age <= 150 ){
            System.out.println("Age is Valid!");
        } else {
            System.out.println("Age entered is invalid!");
        }
            
    
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        if (email != null && !email.trim().isEmpty() && email.contains("@") ){
            System.out.println("Email is Valid!");
        } else {
            System.out.println("Invalid input!");
        }

        System.out.print("Enter Social Security Number: ");
        String newssn = scanner.nextLine();
        person.setsocialSecurityNumber(newssn);

        System.out.println("Marked SSN: " + person.getsocialSecurityNumber());
      
        scanner.close();

    }

    public void setsocialSecurityNumber(String newssn) {
        if (newssn == null || newssn.trim().isEmpty()){
            System.out.println("SSN can't be empty");
            return;
        }

        if(newssn.length() != 9) {
            System.out.println("SSN must be 9 digits!");
            return;
        }
        this.socialSecurityNumber = newssn;
    }

    public String getsocialSecurityNumber(){
        if (socialSecurityNumber == null) {
            return "Not set";
        }
        String last4 = socialSecurityNumber.substring(socialSecurityNumber.length() - 4);
        return "*****" + last4; 
    }

        //scanner.close();

    

}
 