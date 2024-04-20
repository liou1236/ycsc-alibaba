package lessonPhaseOne.day010703;

public class OutputFactory {
    public Output getOutput(){
        return new Printer();
    }

    public static void main(String[] args) {
        OutputFactory factory = new OutputFactory();
        Computer computer = new Computer(factory.getOutput());
        computer.print();
//        Printer printer = new Printer();
//        printer.out();
    }
}
