package lessonPhaseOne.day010703;

public class Computer {
    private Output output;
    public Computer(Output output){
        this.output = output;
    }
    public void print(){
        output.out();
    }
}
