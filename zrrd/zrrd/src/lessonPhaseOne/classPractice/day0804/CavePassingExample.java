package lessonPhaseOne.classPractice.day0804;

public class CavePassingExample {

        public static void main(String[] args) {
            final Object lock = new Object();

            for (int i = 1; i <= 10; i++) {
                final int person = i;
                Thread thread = new Thread(() -> {
                    synchronized (lock) {
                        try {
                            if (person > 1) {
                                lock.wait(); // 等待前一个人通知
                            }

                            System.out.println("Person " + person + " passed the cave.");

                            if (person < 10) {
                                lock.notify(); // 通知下一个人
                            } else {
                                System.out.println("All persons have passed the cave.");
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        }
    }


