package lessonPhaseOne.day100714;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestThrow {
    public static void main(String[] args) throws IOException {
        try{
            System.out.println("睡一会儿");
            throwException();
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("如果走进了。触发RuntimeException");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("如果走进了，是其他Exception");
//            throw new IOException();
        }
            System.out.println("睡醒了");


    }

    public static void throwException() throws FileNotFoundException {
//        throw new RuntimeException();
//        throw new IndexOutOfBoundsException();
//        throw new ClassCastException();
        throw new FileNotFoundException();

    }
}
