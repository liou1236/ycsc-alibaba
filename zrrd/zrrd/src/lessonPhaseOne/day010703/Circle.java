package lessonPhaseOne.day010703;

public class Circle extends Shape{
    private double r;
    String name = "Circle";

    public Circle(double r){
        this.r = r;
    }

    @Override
    public String shapeName() {
        return name;
    }

    @Override
    public double callPerimeter() {
        return 2 * Math.PI * r;
    }
}
