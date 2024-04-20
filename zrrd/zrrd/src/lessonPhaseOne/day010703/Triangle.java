package lessonPhaseOne.day010703;

public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;
    String name = "TriangleName";

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String shapeName() {
        return name;
    }

    @Override
    public double callPerimeter() {
        return a + b + c;
    }
}
