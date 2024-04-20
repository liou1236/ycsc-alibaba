package lessonPhaseOne.day030705;

import java.io.IOException;

public class RuntimeTest {
    public static void main(String[] args) throws IOException {
//        Process process = null;
//        Runtime runtime = Runtime.getRuntime();
//        process = runtime.exec("notepad");
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        System.out.println("++++++++++++++++++++++");
        for (int i = 0;i < 1000;i++){
            new Object();
        }
        System.out.println(runtime.freeMemory());
        runtime.gc();
        System.out.println(runtime.freeMemory());
    }
}
