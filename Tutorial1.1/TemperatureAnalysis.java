public class TemperatureAnalysis {

    
    public static double calculateAverage(int[] temps) {
        int sum = 0;
        for (int t : temps) sum += t;
        return (double) sum / temps.length;
    }

   
    public static int findHighest(int[] temps) {
        int max = temps[0];
        for (int t : temps) {
            if (t > max) max = t;
        }
        return max;
    }

    
    public static int findLowest(int[] temps) {
        int min = temps[0];
        for (int t : temps) {
            if (t < min) min = t;
        }
        return min;
    }

    
    public static int countAboveAverage(int[] temps, double average) {
        int count = 0;
        for (int t : temps) {
            if (t > average) count++;
        }
        return count;
    }

 
    public static int countBelowAverage(int[] temps, double average) {
        int count = 0;
        for (int t : temps) {
            if (t < average) count++;
        }
        return count;
    }

  
    public static void displayChart(int[] temps) {
        System.out.println("Temperature Chart:");
        for (int i = 0; i < temps.length; i++) {
            System.out.print("Day " + (i + 1) + " (" + temps[i] + "°C): ");
            for (int j = 0; j < temps[i]; j += 2) { // each '*' = 2°C
                System.out.print("*");
            }
            System.out.println();
        }
    }

   
    public static void main(String[] args) {

        
        int[][] temperatures = {
            {20, 22, 19, 25, 27, 24, 21}, // Month 1
            {18, 16, 20, 22, 25, 23, 19}, // Month 2
            {15, 17, 20, 21, 23, 19, 16}  // Month 3
        };

        for (int month = 0; month < temperatures.length; month++) {
            int[] temps = temperatures[month];
            double avg = calculateAverage(temps);
            int high = findHighest(temps);
            int low = findLowest(temps);
            int above = countAboveAverage(temps, avg);
            int below = countBelowAverage(temps, avg);
            int range = high - low;

            System.out.println("Temperatures: " + java.util.Arrays.toString(temps));
            System.out.println("Average temperature: " + avg);
            System.out.println("Highest temperature: " + high);
            System.out.println("Lowest temperature: " + low);
            System.out.println("Temperature range: " + range);
            System.out.println("Days above average: " + above);
            System.out.println("Days below average: " + below);

            displayChart(temps);
        }
    }
}
