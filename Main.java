import java.util.ArrayList;

interface Drawable {
    void draw();
}

abstract class Shape{
    private String colour;

    public Shape (String colour){
        this.colour=colour;
    }

    public abstract double getArea();

}

class Circle extends Shape implements Drawable{

    public double radius;

    public Circle(String colour, double radius) {
        super(colour);
        this.radius=radius;
    }

    @Override 
    public double getArea(){
        
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public void draw(){
        System.out.println("Drawing a Circle!");

    }

    public double getRadius(){
        return radius;
    }
}

class Rectangle extends Shape implements Drawable{

    private double width;
    private double height;

    public Rectangle(String colour, double width, double height) {
        super(colour);
        this.width=width;
        this.height=height;
    }

    @Override
    public void draw(){
        System.out.println("Drawing a Rectangle!");

    }

    @Override 
    public double getArea(){
        
        return width * height;
    }
    
}





public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle("Red", 5));
        shapes.add(new Rectangle("Blue", 4, 6));

        for (Shape s : shapes) {
            if (s instanceof Drawable) {
                ((Drawable) s).draw(); // interface method
            }
            System.out.println("Area: " + s.getArea());
            System.out.println();
        }
    }
}
