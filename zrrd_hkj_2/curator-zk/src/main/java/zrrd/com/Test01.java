package zrrd.com;

public class Test01 {
    public static void main(String[] args) {
        SellTicket st =new SellTicket();
        Thread t1 = new Thread(st,"飞猪");
        Thread t2 = new Thread(st,"携程");
        Thread t3 = new Thread(st,"去哪");
        t1.start();
        t2.start();
        t3.start();
    }
}
