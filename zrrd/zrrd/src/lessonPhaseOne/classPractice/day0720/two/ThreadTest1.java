package lessonPhaseOne.classPractice.day0720.two;

public class ThreadTest1 {
    public static void main(String[] args) throws InterruptedException{
        for (int i = 1;i <= 100;i++){
            int result = i;
            if (i >= 1 && i <= 10){
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()
                                + " " + result);
                    }
                });
                t1.start();
            }
            if (i >= 11 && i <= 20){
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("2");
                    }
                });
            }
            if (i >= 21 && i <=30){

                Thread t3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("3");
                    }
                });
            }
            if (i >= 31 && i <=40){
                Thread t4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("1");
                    }
                });
            }
            if (i >= 41 && i <=50){
                Thread t5 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("2");
                    }
                });
            }
            if (i >= 51 && i <=60){
                Thread t6 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("3");
                    }
                });
            }
            if (i >= 61 && i <=70){
                Thread t7 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("1");
                    }
                });
            }
            if (i >= 71 && i <=80){

                Thread t8 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("2");
                    }
                });
            }
            if (i >= 81 && i <=90){
                Thread t9 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("3");
                    }
                });
            }
            if (i >= 91 && i <=100){
                Thread t10 = new Thread(new Runnable() {
                    @Override
                    public void run() {System.out.println();}
                });
            }





        }

    }
}
