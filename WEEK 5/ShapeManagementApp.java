abstract class Shape {
    private String color; 

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // Abstract methods
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape[color=" + color + "]";
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = (radius > 0) ? radius : 1;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[color=" + getColor() + ", radius=" + radius +
               ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = (width > 0) ? width : 1;
        this.height = (height > 0) ? height : 1;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle[color=" + getColor() + ", width=" + width +
               ", height=" + height + ", area=" + getArea() +
               ", perimeter=" + getPerimeter() + "]";
    }
}

class Square extends Shape {
    private double side;

    public Square(String color, double side) {
        super(color);
        this.side = (side > 0) ? side : 1;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square[color=" + getColor() + ", side=" + side +
               ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }
}

public class ShapeManagementApp {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle("Red", 3),
            new Rectangle("Blue", 4, 6),
            new Square("Green", 5),
            new Circle("Yellow", 2),
            new Rectangle("Black", 2, 8)
        };

        double totalArea = 0;
        Shape largest = shapes[0];

        for (Shape s : shapes) {
            System.out.println(s); 
            totalArea += s.getArea();

            if (s.getArea() > largest.getArea()) {
                largest = s;
            }
        }

        double averageArea = totalArea / shapes.length;
        System.out.println("\nTotal area = " + totalArea);
        System.out.println("Average area = " + averageArea);
        System.out.println("Shape with largest area = " + largest);
    }
}
