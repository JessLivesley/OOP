public class PrintUtility {
    public void print(int a){
        System.out.println("Value: " + a);
    }

    public double print(double a){
        return a;
    }

    public int array(int[] array){
        if (array == null || array.length == 0) {
            System.out.println();
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        System.out.println(sb.toString());
        return array.length;
    }

    public String print(){
        String s = "\"print in quotes\"";
        System.out.println(s);
        return s;
    }

    public void print(Object obj) {
        if (obj == null) {
            System.out.println("null");
        } else {
            System.out.println(obj.toString());
        }
    }

    public void print(int a, int b) {
        System.out.println(a + ":" + b);
    }

    public void print(boolean b) {
        if (b) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    public static void main(String[] args) {
        PrintUtility pu = new PrintUtility();
        pu.print(42);
        System.out.println(pu.print(3.14));
        System.out.println(java.util.Arrays.toString(new int[]{1, 2, 3, 4, 5}));
        pu.print("\"Hello World\"");
        System.out.print("Ratio: ");
        pu.print(3, 4);
        pu.print(true);
    }

}
