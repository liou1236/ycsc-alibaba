package practice.first.two;

import practice.first.one.Addition;
import practice.first.three.Usb;

public class Computer implements Usb {
    private Addition addition;
    String controlUnit;
    String arithmeticUnit;
    String memoryUnit;
    String inputDevice;
    String outputDevice;


    {
        this.addition = new Addition();
    }
    public Computer() {

    }

    public Computer(String controlUnit,String arithmeticUnit,
                    String memoryUnit,String inputDevice,
                    String outputDevice){
        this.arithmeticUnit = arithmeticUnit;
        this.controlUnit = controlUnit;
        this.inputDevice = inputDevice;
        this.outputDevice = outputDevice;
        this.memoryUnit = memoryUnit;

    }
    public void input(){
        System.out.println("input");
    }
    public void calculate(){
        System.out.println("calculate");
    }
    public void output(){
        System.out.println("output");
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.addition.twoSum(1,1);
        computer.input();
        computer.calculate();
        computer.output();

        computer = new Computer("控制器","运算器",
                "存储器","输入设备","输出设备");
        computer.addition.twoSum(1.0,1.0);
        System.out.println(computer.arithmeticUnit);

    }



    public String getMemoryUnit() {
        return memoryUnit;
    }

    public void setMemoryUnit(String memoryUnit) {
        this.memoryUnit = memoryUnit;
    }

    @Override
    public void transfer(String data) {
        this.memoryUnit = data;
    }
}
