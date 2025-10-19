public class MathUtils {


    public static boolean isPrime(int number) {
        if (number <= 1) return false; // 0 and 1 are not prime
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false; // divisible by i -> not prime
        }
        return true;
    }

   
    public static long factorial(int number) {
        if (number < 0) {
            System.out.println("Error: factorial not defined for negative numbers.");
            return -1;
        }
        if (number == 0 || number == 1) return 1;

        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

   
    public static int gcd(int a, int b) {
        if (a == 0) return Math.abs(b);
        if (b == 0) return Math.abs(a);

        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

   
    public static int fibonacci(int n) {
        if (n < 0) {
            System.out.println("Error: Fibonacci not defined for negative numbers.");
            return -1;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

   
    public static void main(String[] args) {
        // Testing isPrime
        System.out.println("isPrime(2): " + isPrime(2));   // true
        System.out.println("isPrime(4): " + isPrime(4));   // false
        System.out.println("isPrime(17): " + isPrime(17)); // true
        System.out.println("isPrime(25): " + isPrime(25)); // false

        // Testing factorial
        System.out.println("\nfactorial(0): " + factorial(0)); // 1
        System.out.println("factorial(1): " + factorial(1)); // 1
        System.out.println("factorial(5): " + factorial(5)); // 120

        // Testing gcd
        System.out.println("\ngcd(12, 8): " + gcd(12, 8));   // 4
        System.out.println("gcd(17, 13): " + gcd(17, 13)); // 1

        // Testing fibonacci
        System.out.println("\nfibonacci(0): " + fibonacci(0)); // 0
        System.out.println("fibonacci(1): " + fibonacci(1)); // 1
        System.out.println("fibonacci(6): " + fibonacci(6)); // 8
    }
}
