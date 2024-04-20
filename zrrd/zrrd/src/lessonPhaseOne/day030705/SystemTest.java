package lessonPhaseOne.day030705;

import java.util.Date;

public class SystemTest {
    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir"));
        for (int i =0;i < 1000;i++){
            System.out.println(i);
        }
        System.out.println(System.currentTimeMillis() - current);// 测试运行时间毫秒数
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date);
        System.exit(0);

        System.out.println(System.nanoTime());

        String str = new String("zhangsan");
        System.out.println(str);
        str = null;
        System.gc();
        System.out.println(str);

    }
}
