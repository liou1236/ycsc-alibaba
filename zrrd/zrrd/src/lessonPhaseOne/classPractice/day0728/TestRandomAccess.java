package lessonPhaseOne.classPractice.day0728;

import java.io.RandomAccessFile;

public class TestRandomAccess {
    public static void main(String[] args) throws Exception{
        RandomAccessFile file = new RandomAccessFile("stream.txt","rw");
        file.seek(6);
        long pointer = file.getFilePointer();
        byte[] arr = new byte[1024];
        file.read(arr);
        long endPointer = file.getFilePointer();
        System.out.println(pointer + "->" + endPointer);
        System.out.println(new String(arr));
        file.close();
    }
}
