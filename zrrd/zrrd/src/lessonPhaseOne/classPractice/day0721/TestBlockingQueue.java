package lessonPhaseOne.classPractice.day0721;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestBlockingQueue {
    public static void main(String[] args) throws Exception{
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
//        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(Integer.MAX_VALUE);
        queue.put(1);
//        queue.put(2);
//        queue.put(3);
        System.out.println(queue.size());
        System.out.println(queue);
        queue.put(2);
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue);
    }
}
