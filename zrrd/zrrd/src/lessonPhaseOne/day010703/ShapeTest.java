package lessonPhaseOne.day010703;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Circle(3);
        System.out.println(shape.callPerimeter());
        System.out.println(shape.shapeName());

        Shape shape1 = new Triangle(1,2,3);
        System.out.println(shape1.callPerimeter());
        System.out.println(shape1.shapeName());
    }
}
