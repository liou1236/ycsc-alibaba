package com.zrrd;

import com.zrrd.factory.ProductFactory;
import com.zrrd.pojo.Product;
import com.zrrd.service.Sale;
import com.zrrd.service.impl.SaleImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLOutput;

public class ProxyTest {
    @Test
    public void test1(){
        Sale sale = new SaleImpl();
        sale.saleProduct(222);
    }
    @Test
    public void test2(){
        Sale sale = new SaleImpl();
        //创建代理对象，参数一：类加载器 参数二：真实对象实现的所有接口  参数三：实现InvocationHandler接口的实现类对象
        Sale proxy =(Sale) Proxy.newProxyInstance(sale.getClass().getClassLoader(), sale.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ProductFactory productFactory = new ProductFactory();
                Product make = productFactory.make();
                double money = make.getPrice();
                System.out.println("money = " + money);

                double price = (double) args[0];
                System.out.println("price = " + price);

//                System.out.println(args);
                if (money > price) {
                    System.out.println("not");
                    return null;
                } else {
                    System.out.println("yes,赚了" + (-money+price) + "钱");
                    return make;
                }
            }

});
        proxy.saleProduct(2000);
    }
}
