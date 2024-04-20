package zrrd.com;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryForever;

import java.util.concurrent.TimeUnit;

public class SellTicket implements Runnable {
    private Integer count = 100;
    private InterProcessMutex lock;
    CuratorFramework client;
    //1、连接zookeeper
    public SellTicket(){
        RetryForever rp = new RetryForever(100);
        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.88.128:2181")
                .sessionTimeoutMs(60*1000)
                .retryPolicy(rp)
                .build();
        client.start();
        System.out.println("zookeeper连接成功");
        //2、初始化锁对象
        lock = new InterProcessMutex(client,"lock");
        System.out.println("分布式锁初始化成功");
    }
    @Override
    public void run() {

            //买票
            while (count >= 0) {
                try {
                    //加锁可以不带参数 可以带两个参数时间数量和单位
                    //如果超出时间 会自动解锁
                    lock.acquire(3, TimeUnit.SECONDS);
                    //执行会引起共享资源冲突代码
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + "正在售票,剩余" + (--count));
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

