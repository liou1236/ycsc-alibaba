package om.zrrd;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class Test01 {
    /*
    Param:
    connectString,要连接zookeeper的IP：端口的列表
    sessionTimeoutMs,(停止1分钟)会话过期时间
    connectionTimeoutMs,连接过期时间
    retryPolicy  重试策略
     */
    CuratorFramework client;

    @Before
    //@Test
    public void createClint() {
        RetryForever rp = new RetryForever(500);
        /*CuratorFramework client =
                CuratorFrameworkFactory.newClient("192.168.88.128:2181",60*1000,15*1000,rp);
                 System.out.println(client);  */
        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.88.129:2181")
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(rp)
                .namespace("test")
                .build();
        client.start();

    }
    /*
    创建节点 create
    1、基本创建 ： create().forPath("path")
    2、创建带数据的节点create().forPath("path","data")
    3、设置节点类型 默认为持久化
    4、创建多级节点 /app/p :
     */
    @Test
    public void createNode() throws Exception {
        String path = client.create().forPath("/app","haha".getBytes());
        System.out.println(path);
    }
    //临时节点类型：CreateMode.EPHEMERAL
    @Test
    public void createENode() throws Exception {
        String path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/app/p","haha".getBytes());
        System.out.println(path);
    }
    /*
    查询节点：
    1、get 查询数据：client.getData()
    2、ls 查询子节点：client.getChildren()
    3、ls -s 查询状态信息

     */
    @Test
    public void testData() throws Exception {
        List<String> strings = client.getChildren().forPath("/app");
        System.out.println(strings);
    }
    @Test
    public void getStat() throws Exception {
        Stat stat = new Stat();
        byte[] bytes = client.getData().storingStatIn(stat).forPath("/app");
        System.out.println(new String(bytes));
        long ctime = stat.getCtime();
        Date date = new Date(ctime);
        System.out.println(date);
        System.out.println(stat);
    }
    /*
    修改信息：client.setData()
     */
    @Test
    public void testSet() throws Exception {
        Stat stat = client.setData().forPath("/app", "heihei".getBytes());
        System.out.println(stat);
    }
    /*
    1、删除单个节点
    2、删除带有子节点的节点
    3、必须成功删除：为了防止网络抖动 本质就是重试
     */
    @Test
    public void testDelete() throws Exception {
        //1、删除单个节点
        client.delete().forPath("/app/p");
    }
    @Test
    public void testDelete2() throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath("/app/p");
    }
    @Test
    public void testDelete3() throws Exception {
        //必然删除成功 如果删除过程中由于网络波动没有删除成功 则会进行重试
        client.delete().guaranteed().forPath("/app/p");
    }
    @Test
    public void testDelete4() throws Exception {
        //4、回调
        client.delete().guaranteed().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println(event);
                //获取操作类型
                System.out.println(event.getType());
                System.out.println(event.getPath());
                //删除就没有数据
                System.out.println(event.getData());
            }
        }).forPath("/app");
    }
    @Test
    public void testNodeCache() throws Exception {
        //1、创建NodeCache(监听)对象 通过client客户端 监听指定节点
        NodeCache nodeCache = new NodeCache(client,"/app");
        //2、注册监听
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            //回调函数 当被监听节点发生变化的时候会触发回调函数
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点变化了");
                //获取修改节点后的数据
                ChildData currentData = nodeCache.getCurrentData();
                System.out.println(currentData);
                System.out.println(new String(currentData.getData()));
                System.out.println("监听的节点："+currentData.getPath());

            }
        });
        //开启监听，如果设置为true 则开启监听 加载缓冲数据
        nodeCache.start();
        while (true){

        }
    }
    public void test2(){
        InterProcessMutex lock = new InterProcessMutex(client,"/lock");
        try{
            //加锁
            lock.acquire();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                //解锁 要写finally 防止出现异常是无法解锁
                lock.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @After
    public void close(){
        client.close();
    }
}
