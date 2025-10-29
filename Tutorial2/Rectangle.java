package Tutorial2;
public class Rectangle {
    
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }

    public double getArea(){
        double area = width * height;
        return area;
    }

    public double getPerimeter(){
        double perimeter = 2 * (width + height);
        return perimeter;
    }

    public boolean isSquare(){
        return width == height;
    }

    public void scale(double factor){
        width = width * factor;
        height = height * factor;
    }

    public void scale(double widthFactor, double heightFactor){
        width = width * widthFactor;
        height = height * heightFactor;
    }

    public static Rectangle compareArea(Rectangle r1, Rectangle r2){
        if (r1 == null) return r2;
        if (r2 == null) return r1;
        if (r1.getArea() >= r2.getArea()) {
            return r1;
        } else {
            return r2;
        }
    }

    public String print(){
        return String.format("Rectangle [Width: %.2f, Height: %.2f, Area: %.2f, Perimeter: %.2f, Square: %b]",
                width, height, getArea(), getPerimeter(), isSquare());
    }
    

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(3, 3);

        System.out.println(r1.print());
        System.out.println(r2.print());

        Rectangle larger = Rectangle.compareArea(r1, r2);
        if (larger != null) {
            System.out.println("The rectangle with larger area is: " + larger.print());
        } else {
            System.out.println("Both rectangles have equal area.");
        }

        r1.scale(2);
        System.out.println("After scaling r1: " + r1.print());
    }

    


}
