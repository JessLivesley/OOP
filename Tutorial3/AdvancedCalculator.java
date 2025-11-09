//package Tutorial3;
public class AdvancedCalculator {
    

    public int add(int a, int b) {
        System.out.println("Adding two integers");
        return a + b;

    }        

    public int add(int a, int b, int c){
        System.out.println("Adding three integers");
        return a + b + c;
    }

    public double add(double a, double b){
        System.out.println("Adding two doubles");
        return a + b;
    }

    public int add(int[] array) {
        System.out.println("Adding array of integers");
        int total = 0;
        for (int value : array) {
            total += value;
        }
        return total;
    }

    public String add(String a, String b){
        System.out.println("Concatenating strings");
        return a + b;
    }

        public static void main(String[] args) {
        AdvancedCalculator calc = new AdvancedCalculator();

        System.out.println("Result: " + calc.add(5, 3));
        System.out.println("Result: " + calc.add(5, 3, 2));
        System.out.println("Result: " + calc.add(5.5, 3.2));
        System.out.println("Result: " + calc.add(new int[]{1,2,3,4}));
        System.out.println("Result: " + calc.add("Hello", "World"));
    }
}


    
