package lessonPhaseOne.day080712;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Object obj = queue.poll(); // 返回第一个并删除
        System.out.println(obj);
        System.out.println(queue);

        Object obj1 = queue.peek();
        System.out.println(obj1); // 返回第一个
        System.out.println(queue);

        System.out.println("==============");

        Deque deque = new LinkedList();// 双端队列
        deque.offer("1");
        deque.offer("2");
        deque.offer("3");
        System.out.println(deque);
        deque.offer("4");
        System.out.println(deque);

        Object obj2 = deque.poll();// 默认队首，pollFirst
        System.out.println(obj2);
        System.out.println(deque);
        deque.offer(obj2);
        System.out.println(deque);

        Object obj3 = deque.pollLast();
        System.out.println(obj3);
        System.out.println(deque);
        deque.offer(obj3);

        Object obj4 = deque.peekFirst();
        System.out.println(obj4);
        System.out.println(deque);

        deque.element();// 返回队首一个元素但不删除，移除前为空队列报异常
        deque.remove();
        // poll移除，空队列为null；peek不移除，空队列为null
        // 双端队列deque有上述的First和Last形式


    }
}
