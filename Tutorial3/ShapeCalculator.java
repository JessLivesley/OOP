public class ShapeCalculator {

    // Circle
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius; // π × r²
    }

    public static double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius; // 2 × π × r
    }

    // Rectangle
    public static double calculateArea(double width, double height) {
        return width * height;
    }

    public static double calculatePerimeter(double width, double height) {
        return 2 * (width + height);
    }

    
    public static double calculateArea(double base, double height, boolean isTriangle) {
        return (base * height) / 2.0;
    }

    public static double calculatePerimeter(double base, double height, boolean isTriangle) {
        
        double hypotenuse = Math.hypot(base, height);
        return base + height + hypotenuse;
    }

    
    public static double calculateArea(double side, boolean isSquare) {
        return side * side;
    }

    public static double calculatePerimeter(double side, boolean isSquare) {
        return 4 * side;
    }

    
    public static void display(double radius) {
        double area = calculateArea(radius);
        double perimeter = calculatePerimeter(radius);
        System.out.printf("Circle: radius=%.3f, area=%.3f, perimeter=%.3f%n", radius, area, perimeter);
    }

    public static void display(double width, double height) {
        double area = calculateArea(width, height);
        double perimeter = calculatePerimeter(width, height);
        System.out.printf("Rectangle: width=%.3f, height=%.3f, area=%.3f, perimeter=%.3f%n", width, height, area, perimeter);
    }

    public static void display(double base, double height, boolean isTriangle) {
        double area = calculateArea(base, height, true);
        double perimeter = calculatePerimeter(base, height, true);
        System.out.printf("Triangle (right-angled): base=%.3f, height=%.3f, area=%.3f, perimeter=%.3f%n", base, height, area, perimeter);
    }

    public static void display(double side, boolean isSquare, int unused) {
        
        double area = calculateArea(side, true);
        double perimeter = calculatePerimeter(side, true);
        System.out.printf("Square: side=%.3f, area=%.3f, perimeter=%.3f%n", side, area, perimeter);
    }

    
    public static void main(String[] args) {
        display(3.0);                        // circle r=3.0
        display(4.0, 5.0);                   // rectangle 4x5
        display(3.0, 4.0, true);             // triangle base=3 height=4 (right-angled)
        display(2.5, true, 0);               // square side=2.5
    }
}
