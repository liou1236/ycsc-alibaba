package practice.first.three;

import practice.first.two.Computer;

import java.util.Collection;

public class UsbFlashDisk implements Usb{
    String data;

    @Override
    public void transfer(String data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        UsbFlashDisk usbFlashDisk = new UsbFlashDisk();
        computer.setMemoryUnit("data from computer");
        usbFlashDisk.transfer(computer.getMemoryUnit());
        System.out.println("uPan data:"+ usbFlashDisk.data);
    }
}
